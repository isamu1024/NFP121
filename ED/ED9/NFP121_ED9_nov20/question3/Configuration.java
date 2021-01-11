package question3;

import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public class Configuration{
  
  public static Object genererAdaptateur(String nomDuFichier) throws Exception{
    Properties props = new Properties();
    props.load(new FileInputStream(new File(nomDuFichier)));

    // lecture de la valeur associée à la propriété classe_adaptateur
    String adaptateurClassName = props.getProperty("classe_adaptateur");
    String adaptateeClassName = props.getProperty("classe_a_adapter");
    String consParamClassName = props.getProperty("classe_param_cons");
    
    Class<?> clAdaptateur = Class.forName(adaptateurClassName);
    Class<?> clAdaptee = Class.forName(adaptateeClassName);
    Class<?> clConsParam = Class.forName(consParamClassName);
    
    Constructor cons = clAdaptateur.getConstructor(clConsParam);
    
    return cons.newInstance(clAdaptee.newInstance());
  }
}