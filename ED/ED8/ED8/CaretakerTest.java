import java.util.*;

public class CaretakerTest extends junit.framework.TestCase{
 
	public void testSauvegardeRestitution(){
	  Caretaker gardien = new Caretaker();
	  Entier e = new Entier(5);
	  assertEquals(5, e.getValeur());
	  gardien.setMemento(e.saveToMemento());
	  e.inc();
	  assertEquals(6, e.getValeur());
	  gardien.setMemento(e.saveToMemento());
	  e.inc();
	  assertEquals(7, e.getValeur());
	  e.restoreFromMemento(gardien.getMemento());
	  assertEquals(6, e.getValeur());
	  e.restoreFromMemento(gardien.getMemento());
	  assertEquals(5, e.getValeur());
	  try{
	    e.restoreFromMemento(gardien.getMemento());
	    fail("pas de sauvegarde et une restitution ???"); 
	  }catch(Exception exc){
	   assertTrue( exc instanceof EmptyStackException);
	  }
	}
	
	public void testExceptionRestitution(){
	  Caretaker gardien = new Caretaker();
		Entier e = new Entier(5);
	  try{
	    gardien.setMemento(e.saveToMemento());
	    e.setValeur(Integer.MAX_VALUE);
	    gardien.setMemento(e.saveToMemento());
	    e.inc();
	    gardien.forget();
	  }catch(Exception exc){
	    e.restoreFromMemento(gardien.getMemento());
	    assertEquals(Integer.MAX_VALUE, e.getValeur());
	  }
	  e.restoreFromMemento(gardien.getMemento());
	  assertEquals(5, e.getValeur());
	}
}