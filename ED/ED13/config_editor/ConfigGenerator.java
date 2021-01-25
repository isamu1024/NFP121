package config_editor;

import java.lang.reflect.*;
import java.util.*;
import java.io.*;
import java.nio.file.Paths;

/** <b>ConfigGenerator</b> est un outil d'aide � la g�n�ration des fichiers de configuration.<br>
 * Chaque mutateur(<i>setter</i>) est d�tect� et l'outil engendre les items attendus pour le<br>
 * fichier de configuration, un mutateur est une m�thode qui respecte les conventions habituelles :<br>
 *   public void <b>set</b>Xzzz(type elt){thix.xzzz=elt;} avec type xzzz; comme attribut.<br>
 * Soit : Commencer par <b>set</b>, avoir un seul param�tre et ne pas retourner de r�sultat (void)<br>
 * Les items engendr�s d�pendent du <i>formatter</i>, choisi. cf. setFormatter().<br>
 * Un num�ro de bean par fichier .class est attribu�, les valeurs des attributs doivent ensuite �tre<br>
 * renseign�es afin de produire un fichier de configuration avec les valeurs des attributs attendues<br><br>
 * Par d�faut, sont g�n�r�es, les valeurs par d�faut pour les types primitifs et leur "wrapper",<br>
 * ou bien une description textuelle, synth�tique de ce qui est attendu.<br>
 * <br>
 * Ci-dessous un usage possible :
 * <pre>
 *       IConfigGenerator configGenerator = new ConfigGenerator();
 *       configGenerator.setBeanNumber(1);
 *       Formatter formatter = new PropertiesFormatter();
 *       configGenerator.setFormatter(formatter);
 *       configGenerator.analyze("syntaxe_exemples/");  
 *       System.out.println(configGenerator.getFormatter().get());
 * </pre><br>
 * Ci-dessous un extrait de ce qui est g�n�r�, il ne reste qu'� renseigner les valeurs des attributs :
 * <pre>
 * bean.id.1=a
 * a.class=syntaxe_exemples.A
 * a.property.1=f   <i>un mutateur setF(float f)</i>
 * a.property.1.param.1=<i><b>0.0F</b> par d�faut 0.0F pour un attribut de type float</i> 
 * a.property.2=tab <i>un mutateur setTab(int[] t)</i>
 * a.property.2.param.1=<i><b>an_array_0</b> une table d'entiers est attendue </i> 
 * ...
 * bean.id.7=listeDeTables
 * listeDeTables.class=syntaxe_exemples.ListeDeTables
 * listeDeTables.property.1=table  <i>un mutateur setTable(Table t)</i>
 * listeDeTables.property.1.param.1=<i><b>a_Table_bean</b> une table,un bean est attendu</i> 
 * listeDeTables.property.2=tables <i>un mutateur setTables(Table[] t)</i>
 * listeDeTables.property.2.param.1=<i><b>an_array_a_Table_bean</b> une table de tables/bean est attendue</i> 
 * </pre>
 * Un autre exemple, en utilisant femtoContainer, l'outil d'aide est un bean.<br>
 * <pre>
 *    ApplicationContext ctx = Factory.createApplicationContext("./config_editor/config.txt");
 *    IConfigGenerator configGenerator = ctx.getBean("configGenerator1");
 *    configGenerator.analyze();
 *    System.out.println(configGenerator.getFormatter().get());
 * </pre>
 * Un extrait du fichier de config.txt (cr�� avec cet outil...)
 * <pre>
 * bean.id.1=configGenerator1
 * configGenerator1.class=config_editor.ConfigGenerator
 * configGenerator1.property.1=beanName
 * configGenerator1.property.1.param.1=generator
 * configGenerator1.property.2=beanPrefixName
 * configGenerator1.property.2.param.1=test_
 * configGenerator1.property.3=beanNumber
 * configGenerator1.property.3.param.1=1
 * configGenerator1.property.4=formatter
 * configGenerator1.property.4.param.1=propertiesFormatter1
 * configGenerator1.property.5=beanClassFileName
 * configGenerator1.property.5.param.1=config_editor.ConfigGenerator
 * 
 * bean.id.2=propertiesFormatter1
 * propertiesFormatter1.class=config_editor.PropertiesFormatter
 * </pre>
 * <br>
 * @see config_editor.ConfigGeneratorTests.java
 * @see config_editor.ConfigGeneratorMainTests.java
 * @version 1.0, Mars 2019
 * @author jean-michel Douin
 */

public class  ConfigGenerator implements IConfigGenerator{

    
    private static final boolean T = false; //true;
    
    private int    beanNumber;       // le num�ro du bean
    private String beanPrefixName;   // un pr�fixe �ventuel du nom du bean
    private String beanName;         // le nom du bean
    private String beanClassFileName;// la classe associ�e � ce bean
    private Formatter formatter;     // le format de sortie choisi
    private boolean withComment;
    
    public ConfigGenerator(){
      this(1,"","bean_object","java.lang.Object");
    }

    public ConfigGenerator(int beanNumber, String beanPrefixName, String beanName, String beanClassName){
        setBeanNumber(beanNumber);
        setBeanPrefixName(beanPrefixName);
        setBeanName(beanName);
        setBeanClassFileName(this.getClass().getPackage().getName()+File.separator);
        this.formatter = new PropertiesFormatter();
    }

    public void setBeanPrefixName(String beanPrefixName){
        this.beanPrefixName = beanPrefixName;
    }
    
    public void setBeanClassFileName(String beanClassFileName){
        this.beanClassFileName = beanClassFileName;
    }
    
    public void setBeanName(String beanName){
        this.beanName = Character.toLowerCase(beanName.charAt(0)) + beanName.substring(1);
    }

    public void setFormatter(Formatter formatter){
        this.formatter = formatter;
    }

    public Formatter getFormatter(){
        return this.formatter;
    }

    public String getBeanName(){
        return this.beanName;
    }
    
    public String getBeanClassFileName(){
        return this.beanClassFileName;
    }
    
    public String getBeanPrefixName(){
        return this.beanPrefixName;
    }

    public void setBeanNumber(int beanNumber){
        this.beanNumber = beanNumber;
    }

    public int getBeanNumber(){
        return this.beanNumber;
    }

    private String getCompleteBeanName(){
        return getBeanPrefixName() + getBeanName();
    }
    
    public void setComment(boolean comment){
        this.withComment = comment;
    }

    private ConfigGenerator analyzeBeanClassFileName(String beanClassFileName) throws Exception{
        try {
            Class<?> cl = Class.forName(beanClassFileName,true,Thread.currentThread().getContextClassLoader());
            if(T)System.out.println(cl.getName() + " analyze...");
            
            if(withComment){
                formatter.newCommentLine();
                formatter.newComment("  bean: \"" + getCompleteBeanName() + "\", prefix: " + getBeanPrefixName());
                formatter.newLine();
                formatter.newComment("  " + beanClassFileName + " = container.getBean(\"" + getCompleteBeanName() + "\");");
                formatter.newLine();
                formatter.newComment("");
            }
            

            if(T)System.out.println("beanName: \"" + getCompleteBeanName() + "\", class: "+ this.beanClassFileName);

            formatter.newLine(); 
            String completeBeanName = getCompleteBeanName();
            formatter.newBeanId(beanNumber,completeBeanName);
            formatter.newLine(); 
            if(withComment)formatter.newComment(" class: "+ beanClassFileName);
            if(withComment)formatter.newLine();
            
            String currentColor = formatter.getColor();
            formatter.setColor("#00FF00"); // green
            formatter.newBeanClass(completeBeanName, cl.getName());
            formatter.setColor(currentColor);
            formatter.newLine();
            
            int number = 1;
            for(Method m : cl.getDeclaredMethods()){
                String setter = m.getName();
                if(setter.startsWith("set") && m.getParameterTypes().length==1){
                    if(T)System.out.println("setter : " + setter + "(" + m.getParameterTypes()[0].getSimpleName() + ")");
                    String name = setter.substring(3);
                    String propertyName = Character.toLowerCase(name.charAt(0)) + name.substring(1);
                    if(withComment)formatter.newComment("setter : " + setter + "(" + m.getParameterTypes()[0].getSimpleName() + ")");
                    if(withComment)formatter.newLine();
                    
                    currentColor = formatter.getColor();
                    formatter.setColor("#0000FF"); // blue
                    formatter.newBeanPropertyKey(number, completeBeanName, propertyName);
                    formatter.newLine();
                    formatter.setColor(currentColor);
                    
                    currentColor = formatter.getColor();
                    formatter.setColor("#FF0000"); // red
                    formatter.newBeanPropertyValue(number, completeBeanName,propertyName,getDefault(m.getParameterTypes()[0]));
                    formatter.setColor(currentColor);
                    if(withComment)formatter.newText(" <--"); 
                    formatter.newLine();
                    number++;
                }
            }
            if(withComment)formatter.newCommentLine();
            formatter.newLine();
            setBeanNumber(getBeanNumber()+1);

        }catch (Exception e) {
            // e.printStackTrace();
            // System.out.println("exception: " + e.getMessage());
            throw e;
        }
        return this;
    }

     public ConfigGenerator analyze(String pathOrFileName, FilenameFilter filter) throws Exception{
        File directory = new File(pathOrFileName);
        StringBuffer sb = new StringBuffer();
        formatter.newCommentLine();
        formatter.newComment(" Configuration g�n�r�e par "+getClass().getName()+", "+getFormatter().getClass().getSimpleName());

        if(directory.isDirectory()){
            File[] files=directory.listFiles(filter);
            for(File file : files){
                String fileName = file.getName().substring(0,file.getName().length()-(".class".length()));
                if(T)System.out.println("analyze file: "+ directory.getPath()+File.separator+ fileName);

                String path = Paths.get(directory.getPath()).normalize().toString() + File.separator + fileName;
                if(T)System.out.println("path: " + path);
                setBeanName(fileName);
                String beanClassFileName = path.replace(File.separator,".");
                if(T)System.out.println("analyzeBeanClassFileName: "+beanClassFileName);
                setBeanClassFileName(beanClassFileName);
                this.analyzeBeanClassFileName(beanClassFileName);
            }
        }else{
            // String beanName = directory.getName().substring(0,directory.getName().length());
            // setBeanName(beanName);
            setBeanClassFileName(pathOrFileName);
            return analyzeBeanClassFileName(pathOrFileName);
        }
        return this;
    }

    private static FilenameFilter filterClassFile;
    static{
      filterClassFile= new FilenameFilter() {
                        public boolean accept(File dir, String name) {
                            return name.endsWith(".class") && 
                            !name.contains("$"); // pas de classes internes par d�faut...
                        }};
    }
    
                        
    public ConfigGenerator analyze(String pathOrFileName) throws Exception{
        return analyze(pathOrFileName,filterClassFile);
    }
    
    public ConfigGenerator analyze() throws Exception{
        return analyze(getBeanClassFileName(), filterClassFile);
    }
            
    private String getDefault(Class<?> cl){    
        if(map.get(cl)!=null) return map.get(cl);
        if(cl.isArray())return "an_array_"+getDefault(cl.getComponentType());
        return "a_" + cl.getSimpleName()+"_bean";
    }

    private static Map<Class<?>,String> map;
    static{
        map = new HashMap<>();
        map.put(Integer.class,"0");
        map.put(byte.class, "0");
        map.put(Byte.class, "0");
        map.put(short.class, "0");
        map.put(Short.class, "0");
        map.put(int.class, "0");
        map.put(Integer.class, "0");
        map.put(long.class, "0L");
        map.put(Long.class, "0L");
        map.put(float.class, "0.0F");
        map.put(Float.class, "0.0F");
        map.put(double.class, "0.0");
        map.put(Double.class, "0.0");
        map.put(boolean.class, "false");
        map.put(Boolean.class, "false");      
        map.put(char.class, "a_char");
        map.put(Character.class,"a_char");
        map.put(Class.class,"a_Class");
        map.put(String.class,"a_String");
        map.put(String[].class,"an_array_String");
        map.put(Object.class,"an_Object");
        map.put(Object[].class,"an_array_Object");
    }


}
