package avecLePatternStrategie;

import java.util.Observer;
import java.util.Observable;

public abstract class Strategie{ // implements Observer{

  public abstract void action(Observable source, Object arg);

}
