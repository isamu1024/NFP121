package avecLePatternStrategie;

import java.util.Observer;
import java.util.Observable;
public class Observateur implements Observer{
    private Strategie strategie;
    
    public Observateur(){
        this.strategie = new Console();
    }
    
    public void setStrategie(Strategie strategie){
      this.strategie = strategie;
    }

    public void update(Observable source, Object args){
        this.strategie.action(source, args);
    }
}
