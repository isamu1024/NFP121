package patternObservateur;


import java.util.Observer;
import java.util.Observable;

public class ObservateurEntier implements Observer{
 
  public void update(Observable source, Object arg){
    System.out.println(source + "update !!! " + arg);
  }
}
