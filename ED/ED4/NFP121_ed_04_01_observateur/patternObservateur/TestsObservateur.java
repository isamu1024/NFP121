package patternObservateur;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
public class TestsObservateur extends junit.framework.TestCase{
 
  private static class ObservateurTest implements Observer{

    public static class Notification{
      protected Object arg;
      protected Observable source;
      Notification(Observable source, Object arg){
        this.source = source;
        this.arg = arg;
      }
    }
    
    private Stack<Notification> stk;
    
    public ObservateurTest(){
      this.stk = new Stack<Notification>();
    }
    public void update(Observable src, Object arg){
      stk.push(new Notification(src,arg));
    }
    public Notification getNotification(){
      return stk.peek();
    }
    public Notification lastNotification(){
      return stk.pop();
    }
    public boolean isEmpty(){
      return stk.isEmpty();
    }
    public void reset(){
      stk.clear();
    }

  }
  
  public void testUnEntierUnObservateur(){
    Entier e = new Entier(1);
    ObservateurTest obs = new ObservateurTest();
    assertTrue(obs.isEmpty());
    e.addObserver(obs);
    assertTrue(obs.isEmpty());
    e.inc();
    assertFalse("pas de notifications ???", obs.isEmpty());
    ObservateurTest.Notification notification = obs.lastNotification();
    assertEquals("la source est-elle correcte ???",e,notification.source);
    assertEquals("l'argument est-il correct ???",2,notification.arg);
    obs.reset();
    
    e.dec();
    e.setValeur(33);
    assertFalse("pas de notifications ???", obs.isEmpty());
    notification = obs.lastNotification();
    assertEquals("la source est-elle correcte ???",e,notification.source);
    assertEquals("l'argument est-il correct ???",33,notification.arg);

    assertFalse("pas de notifications ???", obs.isEmpty());
    notification = obs.lastNotification();
    assertEquals("la source est-elle correcte ???",e,notification.source);
    assertEquals("l'argument est-il correct ???",1,notification.arg);
    assertTrue("pas de notifications ???", obs.isEmpty());

  }
  

  
}
