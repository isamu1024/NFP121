package question1;

import java.lang.reflect.*;
import java.util.*;

public class Question1{

    public static void main(String[] args) {
        try{
            Class<?> cl = Class.forName(args[0]);
            // https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html#forName(java.lang.String)
            List<Method> l = null;
            l = obtenirLesMethodesPubliquesLocalesEtHeritees(cl);
            afficher("MethodesPubliquesLocalesEtHeritees",l);

            l = obtenirToutesLesMethodesAccessiblesDeCetteClasse(cl);
            afficher("ToutesLesMethodesAccessiblesDeCetteClasse",l);

            l = obtenirLesMethodesPubliquesRedefiniesLocalement(cl);
            afficher("LesMethodesPubliquesRedefiniesLocalement",l);

        }catch(ExceptionInInitializerError e){
            System.out.println("Exception: the initialization provoked by this method fails");
        }catch(LinkageError e){
            System.out.println("Exception: the linkage fails");
        }catch(ClassNotFoundException e){
            System.out.println("Exception: the class cannot be located");
        }
    }

    private static void afficher(String titre, List<Method> list){
        System.out.println(titre);
        for( Method m : list){
            System.out.println(m.toGenericString());
        }
        System.out.println();
    }

    public static List<Method> obtenirLesMethodesPubliquesLocalesEtHeritees(Class<?> cl){
        return Arrays.asList(cl.getMethods());
    }

    public static List<Method> obtenirToutesLesMethodesAccessiblesDeCetteClasse(Class<?> cl){
        return Arrays.asList(cl.getDeclaredMethods());
    }

    public static List<Method> obtenirLesMethodesPubliquesRedefiniesLocalement(Class<?> cl) {
        List<Method> listLocalMethods = obtenirToutesLesMethodesAccessiblesDeCetteClasse(cl);
        List<Method> listMethodsSuper = obtenirLesMethodesPubliquesLocalesEtHeritees(cl.getSuperclass());
        List<Method> ListReturn = new ArrayList<>();
        for(Method m : listLocalMethods) {
            if(m.getModifiers()==Modifier.PUBLIC) {
         // if(Modifier.isPublic(m.getModifiers())){       
                
          // Modifier.isPublic(m.getModifiers()) était en fait une mauvaise suggestion :
          // Regardez le retour des modifiers en décommentant et allez voir le lien 
          // https://stackoverflow.com/questions/55352244/whats-the-4161-modifier-mean-in-java-lang-reflect-method
		  // et le lien 
		  // https://javax0.wordpress.com/2014/02/26/syntethic-and-bridge-methods/
            
                if(contient(listMethodsSuper,m)) {
          //          if(m.getReturnType()==Entier.class || m.getReturnType()==EntierPositif.class)
          //              System.out.println("modifiers for "+m.getReturnType().getName()+" "+m.getName()+" : "+m.getModifiers());
                    ListReturn.add(m);
                }
            }
        }
        return ListReturn;
    }

    // ------- methodes non vérifiées --------

    private static boolean contient(List<Method> list, Method m){
        for( Method ms : list){
            if ((ms.getName().equals(m.getName())) && // meme nom
                // modifier compatible ? a voir
                //(m.getModifiers()==Modifier.PUBLIC) &&
            sameParameterType(ms,m) && // meme parametres
            sameReturnTypeWithCovariance(ms,m) // meme type de retour incluant la covariance
                //(ms.getReturnType()==m.getReturnType())
            )
                return true;
        }
        return false;
    }

  
    private static boolean sameParameterType(Method me, Method m){
        Class<?>[] paramsMe = me.getParameterTypes();
        Class<?>[] paramsM  = m.getParameterTypes();
        if(paramsMe.length != paramsM.length) return false;
        for(int i = 0; i< paramsMe.length; i++){
            if(paramsMe[i] !=  paramsM[i]) return false;
        }
        return true;
    }

    private static boolean sameReturnTypeWithCovariance(Method ms, Method m){
        Class<?> cl = m.getReturnType();
        Class<?> superCl = ms.getReturnType();
        if(superCl==cl)
            return true;
        while(cl != null) {
            cl = cl.getSuperclass();
            if(superCl==cl)
                return true;
        }
        return false;
    }

    private static boolean sameReturnType(Method ms, Method m){
        return ms.getReturnType() == m.getReturnType();
    }

    // ------- methodes pour les tests --------
    public boolean equals(Object obj){
        return false;
    }

    public int hashCode(){
        return 0;
    }

    @Override
    public Object clone(){
        return null;
    }

    // ------- methodes utilitaires, cf. dont certaines sont extraites du web --------
    private static String methodName(){
        // http://stackoverflow.com/questions/4065518/java-how-to-get-the-caller-function-name
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        return e.getMethodName();
    }
}