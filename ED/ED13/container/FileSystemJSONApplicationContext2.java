package container;


import javax.json.*;
// import javax.json.stream.*;
// import javax.json.stream.JsonParser;
// import javax.json.spi.*;

import java.lang.reflect.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;

/**
 * femtoContainer est un conteneur de beans adapté au cours NFP121, écrit par jm Douin.
 * Injection de dépendances par mutateur.
 * Dans cette classe, le fichier de configuration est de type "json".
 * @author Stéphane Bruyère, d'après jm Douin "FileSystemPropsApplicationContext".
 * @version 19 janvier 2018
 */
public class FileSystemJSONApplicationContext2 extends AbstractApplicationContext{
    private static boolean T = true;
    private JsonArray config;

    public FileSystemJSONApplicationContext2(){
        super();
    }

    public void setFileName(String fileName){
        try{
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);
            initialize(inputStream);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public FileSystemJSONApplicationContext2(InputStream inputStream){
        super();
        initialize(inputStream);
    }

    private void initialize(InputStream inputStream){
        try{
            this.config = Json.createReader(inputStream).readArray();
            boolean verboseInConfig=false;
            for(int i=0;i<config.size();i++) {
                if (config.getJsonObject(i).containsKey("verbose")) {
                    verboseInConfig = true;
                    this.T=config.getJsonObject(i).getBoolean("verbose");
                    break;
                }
            }
            if(!verboseInConfig)
                System.out.println("\nverbose absent du fichier de config.");

            System.out.println("\nVerbose : "+this.T);   

            verifyJsonObj(); // vérification du contenu, des propriétés, etc...
            analyzeJsonObj();// injections par mutateurs

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /** Quelques vérifications du fichier de properties, 
     * loin d'être exaustives...
     */
    private void verifyJsonObj() throws RuntimeException{
        if(T)System.out.print("verifyJsonObj : ");
        for(int i=0;i<config.size();i++) {
            try {
                config.getJsonObject(i).getString("id");
            } catch (NullPointerException e) {
                if (! config.getJsonObject(i).containsKey("verbose"))
                    throw new RuntimeException("id."+i+" est absente ???");
            }
            try {
                config.getJsonObject(i).getString("class");
            } catch (NullPointerException e) {
                if (! config.getJsonObject(i).containsKey("verbose"))
                    throw new RuntimeException("id."+i+" présent, mais pas sa classe ???");
            }
            int indexProperty = 1;
            String propertyName = null;
            try {
                propertyName = config.getJsonObject(i).getString("property."+indexProperty);
            } catch (NullPointerException npe) {}
            while(propertyName != null) {
                if( ! config.getJsonObject(i).containsKey("property."+indexProperty+".param.1"))
                    throw new RuntimeException("id."+i+" : property présent, mais pas property."
                        +indexProperty+".param.1");
                indexProperty++;
                try {
                    propertyName = config.getJsonObject(i).getString("property."+indexProperty);
                } catch (NullPointerException npe) {
                    propertyName = null;
                }
            }
            if(T)System.out.print(".");
        }
        if(T)System.out.println("ok");
    }

    private void analyzeJsonObj() throws RuntimeException{
        try{
            for(int i=0;i<config.size();i++) {
                if (! config.getJsonObject(i).containsKey("verbose")) {
                    String id = config.getJsonObject(i).getString("id");
                    String className = config.getJsonObject(i).getString("class");
                    if(className==null)throw new RuntimeException("id présent, mais pas de class");
                    if(T)System.out.println("className: " + className);
                    Class<?> beanClass = null;
                    try{
                        beanClass = Class.forName(className);
                    }catch(ClassNotFoundException e){
                        try{ // en fonction du classLoader courant
                            beanClass = Class.forName(className, true,
                                Thread.currentThread().getContextClassLoader());
                        }catch(ClassNotFoundException exc){
                            throw new RuntimeException(className + " ClassNotFoundException");
                        }
                    }
                    beans.put(id,beanClass.newInstance()); // creation de tous les beans
                    if(T)System.out.println("id: " + id + ", creation de : " + beanClass.getSimpleName()); 
                }
            }            

            for(int i=0;i<config.size();i++) {
                if (! config.getJsonObject(i).containsKey("verbose")) {
                    String idBean = config.getJsonObject(i).getString("id");
                    if(T)System.out.println("appels des mutateurs de "+idBean+" :");
                    initializeJsonBean(idBean);
                }
            }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /** Initialisation des attributs numérotés de 1 à N.
     * Les mutateurs sont exécutés.
     */
    private void initializeJsonBean(String id){
        int indexProperty = 1;
        boolean hasNextProperty = true;
        Object bean = beans.get(id);
        int rangBean=0;
        String propertyName = null;
        Object propertyId = null;
        for(int i=0;i<config.size();i++) {
            if (! config.getJsonObject(i).containsKey("verbose")) {
                if(config.getJsonObject(i).getString("id").equals(id)) {
                    rangBean=i;
                    break;
                }
            }
        }
        try {
            propertyName = config.getJsonObject(rangBean).getString("property."+indexProperty);
        } catch (NullPointerException e) {}

        while(bean!=null && propertyName!=null){
            try { 
                // un setter(mutateur) ne peut avoir qu'un seul paramètre, soit .param.1
                try {
                    propertyId = config.getJsonObject(rangBean).getString("property."
                        + indexProperty+".param.1");
                } catch (ClassCastException cce) {
                    try {
                        if(config.getJsonObject(rangBean).getJsonNumber("property."
                            + indexProperty+".param.1").toString().contains("."))
                            propertyId = config.getJsonObject(rangBean).getJsonNumber("property."
                                + indexProperty+".param.1").doubleValue();
                        else
                            propertyId = config.getJsonObject(rangBean).getInt("property."
                                + indexProperty+".param.1");
                    }catch (ClassCastException cce3) { 
                        try {
                            propertyId = config.getJsonObject(rangBean).getJsonArray("property."
                                + indexProperty+".param.1");
                        } catch (ClassCastException cce4) {
                            if(config.getJsonObject(rangBean).isNull("property."
                                + indexProperty +".param.1"))
                                propertyId=null;
                            else if(config.getJsonObject(rangBean).getBoolean("property."
                                + indexProperty+".param.1"))
                                propertyId=true;
                            else if(! config.getJsonObject(rangBean).getBoolean("property."
                                + indexProperty+".param.1"))
                                propertyId=false;
                        }
                    }
                }
                try{
                    // conversion habituelle, 1ère lettre de l'attribut en Majuscule
                    Object arg=null;
                    String prop = Character.toUpperCase(propertyName.charAt(0))
                        + propertyName.substring(1);
                    // setProperty(???) est recherchée
                    Method setter  = findMethod(id, "set"+prop, propertyName);
                    // le type attendu (???) est issu du setter:
                    Class<?> classExpected = setter.getParameterTypes()[0];
                    try {
                        if(propertyId.getClass() == String.class)
                            arg = beans.get(propertyId); // arg != null, c'est un bean existant
                    } catch (NullPointerException npe) {}
                    if(classExpected.isArray() || arg==null){ 
                        // arg==null, ce ne peut être qu'une constante ou un tableau
                        if(T)System.out.println("\t"+id+"\t\tset"+prop  + "(" + propertyId + ")");
                        arg = newInstance(classExpected, propertyId);      
                    }else{
                        if(T)System.out.println("\t"+id+"\t\tset"+prop  + "(" + arg + ")");
                    }
                    // exécution du setter
                    if(arg != null) setter.invoke(bean, arg);
                }catch(Exception e){
                    if(T)e.printStackTrace();
                    System.err.println("Exception " + e.getMessage() + ", id= " + id + 
                        ".property."+indexProperty+ "." + propertyName);                    
                }
                indexProperty++;
                try {
                    propertyName = config.getJsonObject(rangBean).getString("property."+indexProperty);
                } catch(NullPointerException npe) {
                    propertyName=null;
                }
            }catch(Exception e){
                if(T)e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    private Method findMethod(String id, String methodName, String propertyName){
        Class<?> propertyClass = null;
        Class<?> cl = beans.get(id).getClass();
        while(cl!=Object.class && propertyClass==null){
            try{
                // cet attribut est-il déclaré dans cette classe ?
                Field f = cl.getDeclaredField(propertyName);
                propertyClass = f.getType(); 
            }catch(Exception e){
            }finally{
                // remontée de l'arbre d'héritage à la recherche de cet attribut
                cl = cl.getSuperclass(); 
            }
        }
        // si propertyClass == null, 
        //   il n'y a pas d'attribut avec ce nom mais le setter est en place, 
        //   une délégation par exemple...
        if(T && propertyClass==null)
            System.out.println("\t"+id+"\t"+propertyName + " n'existe pas ???");
        try{
            return beans.get(id).getClass().getMethod(methodName,propertyClass); 
        }catch(Exception e){
            // ici, un setter mais pas d'attribut i.e. propertyClass==null
            // attention si plusieurs méthodes avec le même nom, peu probable pour un setter
            for(Method m : beans.get(id).getClass().getMethods()){
                if(m.getName().equals(methodName)){    // même nom
                    if((m.getParameterTypes().length==1))// un setter a une arité de 1
                        return m;
                }
            }
        }
        return null;
    }

    // nouvelle instance de l'objet à injecter, objet issu d'une constante
    // une constante en 8 types primitifs possibles et leur wrapper
    // Les tableaux dont les éléments sont des beans ou "wrapper" sont possibles 

    /** Obtention d'une nouvelle instance à injecter.
     * @param cl la classe de l'attribut
     * @param str la valeur extraite du fichier de configuration
     */
    private Object newInstance(Class<?> cl, Object obj){
        try{
            if(obj==null) return null; // constante null
            String str = ""+obj;
            if(str.endsWith(".class")) // une instance de la classe Class
                return Class.forName(str.substring(0, str.length()-6), 
                    true, 
                    Thread.currentThread().getContextClassLoader()).getClass();
            if(cl.isArray()) return parseArray(cl, obj);
            // c'est donc une constante, alors appel de Type.parseType(String.class)
            return map.get(cl).invoke(null,str);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private Object parseArray(Class<?> cl, Object obj) throws Exception{
        Class<?> elementClass = cl.getComponentType();
        JsonArray jsa = (JsonArray)obj;
        Object[] t = jsa.toArray();
        if( elementClass == Object.class) {                                     
            try {
                for (int i=0; i< jsa.size(); i++) { 
                    if(jsa.getJsonNumber(i).toString().contains("."))
                        elementClass=Double.class;
                }
                if( elementClass == Object.class)
                    elementClass=Integer.class;         
                for (int i=0; i< t.length; i++) { 
                    if(elementClass==Integer.class)
                        t[i] = jsa.getInt(i);
                    else if (elementClass==Double.class)
                        t[i] = jsa.getJsonNumber(i).doubleValue();
                }
            } catch (ClassCastException cce) {
                try {
                    for (int i=0; i< jsa.size(); i++) { 
                        jsa.getBoolean(i);    
                    }
                    elementClass=Boolean.class; 
                    for (int i=0; i< t.length; i++) { 
                        t[i] = jsa.getBoolean(i);
                    }
                } catch (ClassCastException cce2) {
                    try {
                        boolean chr=true;
                        for (int i=0; i< jsa.size(); i++) {
                            if(jsa.getString(i).length() != 1)
                                chr = false;
                        }
                        if(chr)
                            elementClass=Character.class;
                        else 
                            elementClass=String.class;
                        for (int i=0; i< t.length; i++) { 
                            if (chr)
                                t[i] = jsa.getString(i).charAt(0);
                            else  
                                t[i] = jsa.getString(i);
                        }
                    } catch (ClassCastException cce3) {}               
                }                 
            }
        }
        Object tab = Array.newInstance(elementClass, t.length);
        for(int i=0;i<t.length;i++){ 
            if(t[i].toString().startsWith("\"") && t[i].toString().endsWith("\"")) {
                t[i]=t[i].toString().substring(1, t[i].toString().length()-1);
            }
            Object elt = beans.get(""+t[i]);    
            if(elt==null) { // ce n'est pas un bean du conteneur
                // appel du parse associé au type de cette constante
                elt = newInstance(elementClass, t[i]);
            }
            Array.set(tab, i, elt);
        }
        return tab;
    }

    private static char parseChar(String str){
        return str.charAt(0);
    } 

    private static String parseString(String str){
        return new String(str);
    }

    private static Object parseObject(String str){
        System.err.println("parseObject est appelé ??? Attention String par défaut");
        return new String(str);
    }

    private static Map<Class<?>, Method> map;
    static{
        try{
            map = new HashMap<Class<?>, Method>();
            map.put(byte.class, Byte.class.getMethod("parseByte",String.class));
            map.put(Byte.class, Byte.class.getMethod("parseByte",String.class));
            map.put(short.class, Short.class.getMethod("parseShort",String.class));
            map.put(Short.class, Short.class.getMethod("parseShort",String.class));
            map.put(int.class, Integer.class.getMethod("parseInt",String.class));
            map.put(Integer.class, Integer.class.getMethod("parseInt",String.class));
            map.put(long.class, Long.class.getMethod("parseLong",String.class));
            map.put(Long.class, Long.class.getMethod("parseLong",String.class));
            map.put(float.class, Float.class.getMethod("parseFloat",String.class));
            map.put(Float.class, Float.class.getMethod("parseFloat",String.class));
            map.put(double.class, Double.class.getMethod("parseDouble",String.class));
            map.put(Double.class, Double.class.getMethod("parseDouble",String.class));
            map.put(boolean.class, Boolean.class.getMethod("parseBoolean",String.class));
            map.put(Boolean.class, Boolean.class.getMethod("parseBoolean",String.class));      
            // Cas particulier, implémentées dans cette classe
            map.put(char.class, FileSystemJSONApplicationContext2.class.
                getDeclaredMethod("parseChar",String.class));
            map.put(Character.class, FileSystemJSONApplicationContext2.class.
                getDeclaredMethod("parseChar",String.class));
            map.put(String.class, FileSystemJSONApplicationContext2.class.
                getDeclaredMethod("parseString",String.class));

            // Cas qui n'a pas de sens, retourne une String par défaut
            map.put(Object.class, FileSystemJSONApplicationContext2.class.
                getDeclaredMethod("parseObject",String.class));      

        }catch(Exception e){
            e.printStackTrace(); // peu probable, mais au cas où
        }
    }

}
