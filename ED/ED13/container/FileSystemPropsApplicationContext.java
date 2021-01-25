package container;

import java.util.*;
import java.io.*;
import java.net.URL;
import java.lang.reflect.*;


/**
 * <b>femtoContainer</b> Un conteneur de beans r�alis� pour le cours NFP121, http://jfod.cnam.fr/NFP121/.
 * <br>Injection de d�pendances par mutateur.<br>
 * Le fichier de configuration est de type "Properties".<br>
 * Les beans de ce conteneur respectent les conventions d'�criture habituelles des beans<br>
 * <br><br>
 * Les propri�t�s de chaque bean sont :<br>
 * <pre>
 * bean.id.<i>N</i>=<i><b>nom</b>, l'identifiant unique du bean</i>
 * <i><b>nom</b></i>.class=<i>le nom de la classe</i>
 * <i><b>nom</b></i>.property.1=<i>le nom de l'attribut</i>
 * <i><b>nom</b></i>.property.1.param.1=<i>une constante, ou l'identifiant d'un bean</i>
 * <i><b>nom</b></i>.property.2=<i>le nom de l'attribut</i>
 * <i><b>nom</b></i>.property.2.param.1=<i>une constante, ou l'identifiant d'un bean</i>
 * </pre>
 * Avec N[1..K], N �tant un nombre entier.<br>
 * Ces nombres doivent former une suite croissante avec un incr�ment de 1<br><br>
 * Les param�tres des attributs sont des constantes issues des 8 types primitifs ou bien <br>
 *   la constante null ou encore un nom de classe (avec le suffixe ".class").<br>
 * Un param�tre comme une table de constantes ou d'identifiants de beans est autoris�.<br>
 * Chaque �l�ment de la table est s�par� par une espace
 * 
 * <br><br>
 * 
 * Exemple : une table<br>
 * <pre>
 * bean.id.1=table
 * <i># Cr�ation par le conteneur de new question1.Table();</i>
 * table.class=question1.Table
 * <i># Ex�cution par le conteneur de setListe(listeArray);</i>
 * table.property.1=liste
 * table.property.1.param.1=listeArray
 * <i># Ex�cution par le conteneur de setCapacite(4);</i>
 * table.property.2=capacite
 * table.property.2.param.1=4
 * <i># Ex�cution par le conteneur de setInit(new []{2,55,6,1});</i>
 * table.property.3=init
 * table.property.3.param.1=2 55 6 1
 * # 
 * bean.id.2=listeArray
 * listeArray.class=java.util.ArrayList
 * 
 * Utilisation en java depuis l'applicatif:<br>
 * ApplicationContext ctx = Factory.createApplicationContext("./exemples/README.TXT");
 * Table t = ctx.getBean("table");

 * # cf. le cours NFP121, le conteneur effectue ces instructions en interne
 * List listeArray = new java.util.ArrayList();
 * question1.Table t = new question1.Table();
 * t.setListe(listeArray);
 * t.setCapacite(4);
 * t.setInit(new int[]{2,55,6,1});
 * 
 * assert t == ctxt.getBean("table");
 * </pre>
 * 
 * @author jean-michel Douin
 * @version 09 Juillet 2019
 * @see java.util.Properties, container.Factory, container.AbstractApplicationContext
 */
public class FileSystemPropsApplicationContext extends AbstractApplicationContext{
    /** Trace pour le mode verbeux. */
    private  static boolean T = false; // T comme Trace,
    // ou verbose=true dans le fichier de configuration
    // ou -Dverbose=true depuis la ligne de commandes
    /** Les propri�t�s issues du fichier de configuration */
    private Properties props;

    public FileSystemPropsApplicationContext(){
        super();
    }

    /** Initialisation des beans � partir d'un nom de fichier.
     * @param fileName le nom complet du fichier
     * @exception RuntimeException en cas d'�chec(s)
     */
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
    
    /** Initialisation des beans  � partir d'une URL.
     * @param url l'URL du fichier
     * @exception RuntimeException en cas d'�chec(s)
     */
    public void setUrl(String url){
        try{
            InputStream inputStream = new URL(url).openStream();
            initialize(inputStream);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

     /** Initialisation des beans � partir d'un flux.
     * @param inputStream le flux en entr�e
     * @exception RuntimeException en cas d'�chec(s)
     */
    public FileSystemPropsApplicationContext(InputStream inputStream){
        super();
        initialize(inputStream);
    }

    /** Initialisation de la table des beans � partir d'un fichier de configuration.
     * @param inputStream le flux en entr�e
     */
    private void initialize(InputStream inputStream){
        Properties propsSystem = System.getProperties();
        
        // la propri�t� verbose issue de la configuration
        String verbose = propsSystem.getProperty("verbose","false");
        try{
            T = T || Boolean.parseBoolean(verbose);
        }catch(Exception e){
        }

        this.props = new Properties();
        try{
            props.load(inputStream); // chargement des propri�t�s
            try{
                // le param�tre global verbose est prioritaire sur le local
                T = T || Boolean.parseBoolean(props.getProperty("verbose","false"));
            }catch(Exception e){
            }
            verifyProperties(); // v�rification du contenu, des propri�t�s, suite croissante, etc...
            analyzeProperties();// injections par mutateurs
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /** Quelques v�rifications du fichier de properties, 
     * loin d'�tre exaustives...
     */
    private void verifyProperties() throws RuntimeException{
        try{
            if(T)System.out.print("verifyProperties.");
            List<Object> cles = new ArrayList<Object>(props.keySet());
            Properties properties = new Properties(props); // copie par pr�vention
            String premier = properties.getProperty("bean.id.1");
            if(premier==null) throw new RuntimeException("bean.id.1 est absent ???");
            int indexBean=1;
            int somme = 0;
            String id = properties.getProperty("bean.id." +indexBean); // de 1 � N
            while(id!=null){

                String className = properties.getProperty(id+".class");
                if(className==null) throw new RuntimeException("id pr�sent, mais pas "+id+".class");

                int indexProperty = 1; 
                String propertyName = properties.getProperty(id+".property."+indexProperty);
                while(propertyName!=null){
                    if(propertyName.length()==0)throw new RuntimeException(id+".property."+indexProperty + " ne peut-�tre vide");
                    String propertyId = properties.getProperty(id+".property."+indexProperty+".param.1");
                    if(propertyId==null)throw new RuntimeException("property pr�sent, mais pas "+id+".property."+indexProperty+".param.1");
                    indexProperty++;
                    propertyName = properties.getProperty(id+".property."+indexProperty); 
                }
                somme = somme + indexBean;
                cles.remove("bean.id." +indexBean);
                indexBean++;
                id = properties.getProperty("bean.id." +indexBean);
                if(T)System.out.print(".");
            }

            indexBean--;
            // est-ce bien une suite croissante ?
            int s = (indexBean*(indexBean+1))/2;// somme des n premiers nombres
            if(s!=somme)throw new RuntimeException("Les *.id.N, ne forment pas une suite croissante ...");
            // cas des clefs restantes
            for(Object c : cles){
                if(((String)c).contains("bean.id")) //il reste (au moins) une clef
                    throw new RuntimeException("les id, ne forment pas une suite croissante ...");
            }
            if(T)System.out.println("ok");
        }catch(RuntimeException e){
            if(T)System.out.println("failed: " + e.getMessage());
            throw e;
        }
    }

    /** Cr�ation des beans, puis ex�cution des mutateurs.
     * Les mutateurs peuvent ne pas possder l'attribut associ�
     */
    private void analyzeProperties() throws RuntimeException{
        if(T)System.out.println("analyzeProperties");
        List<String> beanIdList =new ArrayList<String>();
        try{
            int indexBean=1;
            String id = props.getProperty("bean.id." +indexBean);
            while(id!=null){ 
                beanIdList.add("bean.id." +indexBean);
                String className = props.getProperty(id+".class");
                if(className==null)throw new RuntimeException("id pr�sent, mais pas de "+id+".class");
                if(T)System.out.println("className: " + className);
                Class<?> beanClass = null;
                try{
                    beanClass = Class.forName(className);
                }catch(ClassNotFoundException e){
                    try{ // en fonction du classLoader courant
                        beanClass = Class.forName(className, true, Thread.currentThread().getContextClassLoader());
                    }catch(ClassNotFoundException exc){
                        throw new RuntimeException(className + " ClassNotFoundException");
                    }
                }
                beans.put(id,beanClass.newInstance()); // creation de tous les beans
                if(T)System.out.println("id: " + id + ", creation de : " + beanClass.getSimpleName());
                indexBean++;
                id = props.getProperty("bean.id." +indexBean);
            }

            // Intialisation dans l'ordre alphab�tique des noms des beans...
            // for(String idBean : beans.keySet()){
            //   if(T)System.out.println(idBean +  ", appels des mutateurs:");
            // initializePropertiesBean(idBean);
            // }

            // Initialisation dans l'ordre des num�ros des beans
            // note: un bean peut avoir comme attribut un bean pr�alablement initalis�
            //       donc attention � l'ordre dans ce fichier
            for(String idNumber : beanIdList){
                String idBean = props.getProperty(idNumber);
                if(T)System.out.println("id: " +idNumber + ", " + idBean +  ", appels des mutateurs:");
                initializePropertiesBean(idBean);
            }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /** Initialisation des attributs num�rot�s de 1 � N.
     * Les mutateurs sont ex�cut�s par introspection.
     */
    private void initializePropertiesBean(String id){
        int indexProperty = 1;
        boolean hasNextProperty = true;
        Object bean = beans.get(id);
        String propertyName = props.getProperty(id+".property."+indexProperty);
        while(bean!=null && propertyName!=null){
            try{
                // un setter(mutateur) ne peut avoir qu'un seul param�tre, soit .param.1
                String propertyId = props.getProperty(id+".property."+indexProperty+".param.1");
                try{
                    // conversion habituelle, 1�re lettre de l'attribut en Majuscule
                    // private type property;
                    String prop = Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
                    // setProperty(???) est recherch�e (concat�nation avec "set")
                    Method setter  = findMethod(id, "set"+prop, propertyName);
                    // le type attendu (???) est issu de la d�claration du setter
                    Class<?> classExpected = setter.getParameterTypes()[0];

                    Object arg = beans.get(propertyId); // si arg != null, c'est un bean existant
                    if(classExpected.isArray() || arg==null){ 
                        // si arg==null, ce ne peut �tre qu'une constante ou bien c'est un tableau
                        if(T)System.out.println("\t"+id+"\t\tset"+prop  + "(" + propertyId + ")");
                        // cr�ation de l'unique param�tre du mutateur
                        arg = newInstance(classExpected, propertyId);
                    }else{
                        if(T)System.out.println("\t"+id+"\t\tset"+prop  + "(" + arg + ")");
                    }
                    // ex�cution du setter
                    setter.invoke(bean, arg);
                }catch(Exception e){
                    if(T)e.printStackTrace();
                    //throw new RuntimeException(e.getMessage());
                    System.err.println("Exception " + e.getMessage() + ", id= " + id + ".property."+indexProperty+ "." + propertyName);
                }
                indexProperty++;
                propertyName = props.getProperty(id+".property."+indexProperty);
            }catch(Exception e){
                if(T)e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    /** Recherche de la "bonne" m�thode avec �ventuellement une remont�e dans l'arbre d'h�ritage.
     * 
     */
    private Method findMethod(String id, String methodName, String propertyName){
        Class<?> propertyClass = null;
        Class<?> cl = beans.get(id).getClass();
        while(cl!=Object.class && propertyClass==null){
            try{
                // cet attribut est-il d�clar� dans cette classe ?
                Field f = cl.getDeclaredField(propertyName);
                propertyClass = f.getType(); 
            }catch(Exception e){
            }finally{
                // remont�e de l'arbre d'h�ritage � la recherche de cet attribut
                cl = cl.getSuperclass(); 
            }
        }
        // si propertyClass == null, 
        //   il n'y a pas d'attribut avec ce nom mais le setter est en place, et est ex�cut�
        //   une d�l�gation par exemple...
        if(T && propertyClass==null)
            System.out.println("\t"+id+"\tinfo: l'attribut "+propertyName + " n'existe pas.");
        try{
            return beans.get(id).getClass().getMethod(methodName,propertyClass); 
        }catch(Exception e){
            // ici, un setter mais pas d'attribut i.e. propertyClass==null
            int number = 0;
            // attention si plusieurs m�thodes avec le m�me nom, 
            // ce cas n'est pas pr�vu et peu probable pour un setter mais...
            for(Method m : beans.get(id).getClass().getMethods()){
                if(m.getName().equals(methodName)){
                    number++;
                }
            }
            if(T && number>1){ // au cas o�
                System.out.print("\t"+id+"\tinfo: "+propertyName + " plusieurs setter identiques ???, une red�finition ?\n");
                System.out.println("\t\tcf. classe: " + beans.get(id).getClass().getName()); 
            }
            for(Method m : beans.get(id).getClass().getMethods()){
                if(m.getName().equals(methodName)){      // m�me nom
                    if((m.getParameterTypes().length==1))// un setter a une arit� de 1
                        return m; // 
                }
            }
        }
        return null;
    }

    // nouvelle instance de l'objet � injecter, objet issu d'une constante
    // une constante en 8 types primitifs possibles et leur wrapper
    // Les tableaux dont les �l�ments sont des beans ou des "wrapper" sont possibles 

    /** Obtention d'une nouvelle instance � injecter.
     * @param cl la classe de l'attribut
     * @param str la valeur extraite du fichier de configuration
     */
    private Object newInstance(Class<?> cl, String str){
        try{
            if(str.equals("null")) return null; // la constante null

            if(str.endsWith(".class")) // suffixe .class, une instance de la classe Class
                return Class.forName(str.substring(0, str.length()-6), 
                    true, 
                    Thread.currentThread().getContextClassLoader());

            if(cl.isArray()) return parseArray(cl, str); // c'est un tableau

            // c'est donc une constante, alors appel de Type.parseType(String.class)
            return map.get(cl).invoke(null,str);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
   
    /** Analyse du fihcier de configuration pour un tableau.
     * @param cl le tableau
     * @param str la liste des �l�ments de la table, le s�parateur est un espace
     */
    private Object parseArray(Class<?> cl, String str) throws Exception{
        Class<?> elementClass = cl.getComponentType();
        String[] t = str.split(" "); // le s�parateur est un espace
        // un tableau est cr��, les �l�ments sont affect�s
        Object tab = Array.newInstance(elementClass, t.length);
        for(int i=0;i<t.length;i++){
            Object elt = beans.get(t[i]);
            if(elt==null) { // ce n'est pas un bean du conteneur
                // alors appel du parse associ� au type de cette constante
                elt = newInstance(elementClass, t[i]);
            }
            Array.set(tab, i, elt);
        }
        return tab;
    }

    /* Utilitaire cr�� pour le type primitif char. */
    private static char parseChar(String str){
        return str.charAt(0);
    } 

    /* Utilitaire cr�� pour une instance de type String. */
    private static String parseString(String str){
        if(str.startsWith("\"") && str.endsWith("\"")){
           str = str.split("\"")[1];
        } 
        return new String(str);
    }

    /* Utilitaire cr�� pour une instance de type Object, ne devrait pas se produire. */
    private static Object parseObject(String str){
        System.err.println("parseObject est appel� ??? Attention String par d�faut");
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
            // Cas particulier, impl�ment�es dans cette classe
            map.put(char.class, FileSystemPropsApplicationContext.class.
                getDeclaredMethod("parseChar",String.class));
            map.put(Character.class, FileSystemPropsApplicationContext.class.
                getDeclaredMethod("parseChar",String.class));
            map.put(String.class, FileSystemPropsApplicationContext.class.
                getDeclaredMethod("parseString",String.class));

            // Cas qui n'a pas de sens, retourne une String par d�faut
            map.put(Object.class, FileSystemPropsApplicationContext.class.
                getDeclaredMethod("parseObject",String.class));      

        }catch(Exception e){
            e.printStackTrace(); // peu probable, mais au cas o�
        }
    }

}
