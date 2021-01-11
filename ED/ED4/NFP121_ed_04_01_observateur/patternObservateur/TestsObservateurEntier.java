package patternObservateur;

import java.util.Observable;
import java.util.Observer;

public class TestsObservateurEntier extends junit.framework.TestCase{
 
  private class ObservateurTest extends ObservateurEntier { //implements Observer{
    private int notifications;
    private Observable source;
    
    public ObservateurTest(Observable src){
      this.source = src;
    }
    public void update(Observable src, Object arg){
      super.update(src,arg);
      notifications++;
    }
    public int getNotifications(){
      int nombre = notifications;
      notifications =0;
      return nombre;
    }
    public Observable getSource(){
      return source;
    }
  }
  
  public void testUnEntierUnObservateurTest(){
    Entier e = new Entier(1);
    ObservateurTest obs = new ObservateurTest(e);
    e.addObserver(obs);
    e.inc();
    assertEquals("inc() n'engendre pas de notifications ???", 1, obs.getNotifications());
    e.dec();
    assertEquals("dec() n'engendre pas de notifications ???",1, obs.getNotifications());
    e.setValeur(e.getValeur()+1);
    assertEquals("setValeur() n'engendre pas de notifications ???",1, obs.getNotifications());
    e.inc();e.inc();
    assertEquals(2, obs.getNotifications());
  }
  
  public void testUnEntierDeuxObservateurTests(){
    Entier e = new Entier(1);
    ObservateurTest o1 = new ObservateurTest(e);
    e.addObserver(o1);
    ObservateurTest o2 = new ObservateurTest(e);
    e.addObserver(o2);
    e.inc();
    assertEquals("inc() n'engendre pas de notifications ???", 1, o1.getNotifications());
    assertEquals("inc() n'engendre pas de notifications ???", 1, o2.getNotifications());
    e.dec();
    assertEquals("dec() n'engendre pas de notifications ???",1, o1.getNotifications());
    assertEquals("dec() n'engendre pas de notifications ???",1, o2.getNotifications());
    e.setValeur(e.getValeur()+1);
    assertEquals("setValeur() n'engendre pas de notifications ???",1, o1.getNotifications());
    assertEquals("setValeur() n'engendre pas de notifications ???",1, o2.getNotifications());
    e.inc();e.inc();
    assertEquals(2, o1.getNotifications());
    assertEquals(2, o2.getNotifications());
  }
  
  public void testDeuxEntiersUnObservateurTest(){
    Entier e1 = new Entier(1);
    Entier e2 = new Entier(1);
    ObservateurTest obs = new ObservateurTest(e1);
    e1.addObserver(obs);
    e2.addObserver(obs);
    e1.inc();e2.inc();
    assertEquals("inc() n'engendre pas de notifications ???", 2, obs.getNotifications());
    e1.dec();
    assertEquals("dec() n'engendre pas de notifications ???",1, obs.getNotifications());
    e2.setValeur(e2.getValeur()+1);
    assertEquals("setValeur() n'engendre pas de notifications ???",1, obs.getNotifications());
    e1.inc();e2.inc();
    assertEquals(2, obs.getNotifications());
  }
  
   public void testInterrogationEntier(){
    Entier e = new Entier(1);
    ObservateurTest obs = new ObservateurTest(e);
    e.addObserver(obs);
    int v = e.getValeur();
    assertTrue("getValeur() engendre (au moins)une notification ???", 0==obs.getNotifications());
    String s = e.toString();
    assertTrue("toString() engendre (au moins)une notification ???", 0==obs.getNotifications());
 
  }
  
}
