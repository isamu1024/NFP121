public class EntierTest extends junit.framework.TestCase{
 
	public void testSauvegardeRestitution(){
	  Entier e = new Entier(5);
	  assertEquals(5, e.getValeur());
	  Memento memento = e.saveToMemento();
	  e.inc();
	  assertEquals(6, e.getValeur());
	  e.restoreFromMemento(memento);
	  assertEquals(5, e.getValeur());
	}
	
	public void testBorneMin(){
	  Entier e = new Entier(Integer.MIN_VALUE);
	  e.inc();
	  e.dec();
	  try{
	    e.dec();
	  }catch(Exception exc){
	    assertTrue(exc instanceof RuntimeException);
	  }
	}

	public void testBorneMax(){
	  Entier e = new Entier(Integer.MAX_VALUE);
	  e.dec();
	  e.inc();
	  try{
	    e.inc();
	  }catch(Exception exc){
	    assertTrue(exc instanceof RuntimeException);
	  }
	}
}