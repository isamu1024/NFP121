package avecLePatternStrategie;


import java.util.Observable;

public class Console extends Strategie{
 
  public void action(Observable source, Object arg){
    System.out.println("source: " + source + " ," + arg);
  }

}
