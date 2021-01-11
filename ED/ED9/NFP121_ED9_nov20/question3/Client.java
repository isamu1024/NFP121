package question3;


public class Client{

    public static void main(String[] args) throws Exception{
      //String nomDuFichier = "config.props";
      String nomDuFichier = "question3/README.TXT"; // accès direct depuis bluej, icône document en haut à gauche
      Prise prise = (Prise)Configuration.genererAdaptateur(nomDuFichier);
      prise.peritel();
      
    }
}