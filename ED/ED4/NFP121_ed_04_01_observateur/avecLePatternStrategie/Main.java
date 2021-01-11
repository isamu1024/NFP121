package avecLePatternStrategie;

import patternObservateur.Entier;

public class Main{

    public static void main(String[] args){
      Entier e = new Entier(1);
      Observateur obs = new Observateur();
      obs.setStrategie(new ConsoleAvecDatation());
      e.addObserver(obs);
      
      e.inc();
      

    }
}
