package question2;


public class Main {
    
    public static void main (String[] args) throws Exception{
        String classe = "question1.Question1";
        String param = "question1.EntierPositif";
        String[] str = execStatic(classe,param);
        for(String s : str) {
            System.out.println(s);
        }
        
    }
    
    /** Obtention de l'affichage produit par l'exécution de la méthode main d'une classe.
   * @param className le nom de la classe
   * @param args les arguments de la ligne de commande
   * @return le texte en tableau de lignes
   * @throws une exception est levée si la classe est inconnue
   */
  public static String[] execStatic(String className, String ... args) throws Exception{
    java.io.PrintStream out = System.out;
    String[] consoleOut = null; // ou new String[]{""};
    try{
      java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
      java.io.PrintStream ps = new java.io.PrintStream(baos);
      Class<?> c = Class.forName(className);
      System.setOut(ps);
      c.getMethod("main",String[].class).invoke(null, new Object[]{args});
      consoleOut = baos.toString().split(System.getProperty("line.separator"));
    }finally{
      System.setOut(out);
    }
    return consoleOut;
  }
    
}
