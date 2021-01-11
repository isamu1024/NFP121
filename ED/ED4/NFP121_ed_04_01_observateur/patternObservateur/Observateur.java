package patternObservateur;
import java.util.Observer;
import java.util.Observable;

public class Observateur extends ObservateurEntier implements Observer{
  private String selecteur;
  
  public Observateur(String selecteur){
    this.selecteur = selecteur;
  }
  public void update(Observable source, Object arg){
    if (arg instanceof String){
      String str = (String)arg;
      if(selecteur.equals(str)){
        System.out.println(selecteur + " détécté");
      }
    }
  }
}

