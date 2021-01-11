package ensemble_exemple;


import java.util.*;

public class TestEnsembleOrdonneAF extends junit.framework.TestCase{
  protected EnsembleOrdonne e,e1;
  
  @Override
  protected void setUp(){
    this.e = new EnsembleOrdonne();
    this.e1 = new EnsembleOrdonne(); 
  }
    
  public void testAjouter(){
    SortedSet<Integer> set = e.af();
		e.ajouter(3); set.add(3);
	  assertEquals(e.af(),set);
		e.ajouter(3); set.add(3);
    assertEquals(e.af(),set);
		e.ajouter(4); set.add(4);
    assertEquals(e.af(),set);
  }
  
  public void testAjouterBis(){
    SortedSet<Integer> set = e.af();
	  e.ajouter(1);e.ajouter(3);e.ajouter(4);e.ajouter(2);
	  set.add(1);  set.add(3);  set.add(4);  set.add(2);
	  assertEquals(e.af(),set);
	  e1.ajouter(4);e1.ajouter(2);e1.ajouter(3);
	  assertEquals(4,e.taille()); assertEquals(4,e.af().size());
	  e.ajouter(e1);
	  assertEquals(4,e.taille()); assertEquals(4,e.af().size());
	  e1.ajouter(44);e1.ajouter(22);e1.ajouter(33);
	  e.ajouter(e1);
	  assertEquals(7,e.taille()); assertEquals(7,e.af().size());
	 }
	

	public void testRetirer(){
		e.ajouter(3); 
		assertTrue(e.contient(3)); assertTrue(e.af().contains(3));
    SortedSet<Integer> set = e.af();
		e.retirer(3);
		set.remove(3);
		assertFalse(e.contient(3)); assertFalse(e.af().contains(3));
	}
	
	public void testTaille(){
		e.ajouter(3);
		assertEquals(1,e.taille()); assertEquals(1, e.af().size());
		e.retirer(3);
		assertEquals(0,e.taille()); assertEquals(0, e.af().size());
	}
	
	public void testEquals(){
	  e.ajouter(3);e.ajouter(4);e.ajouter(2);
	  e1.ajouter(4);e1.ajouter(2);e1.ajouter(3);
	  assertTrue(e.equals(e1)); assertTrue(e.af().equals(e1.af()));
	  assertEquals(e.hashCode(),e1.hashCode());
	  assertEquals(e.af().hashCode(),e1.af().hashCode());	  
	  assertTrue(e1.equals(e)); assertTrue(e1.af().equals(e1.af()));
	  e1.ajouter(5);
	  assertFalse(e.equals(e1)); assertFalse(e.af().equals(e1.af())); 
	 }
	  
	public void testIterator(){
		e.ajouter(3);e.ajouter(4);e.ajouter(2);
		List<Integer> liste = new ArrayList<>();
		for(int i : e){
		  liste.add(i);
		}
		List<Integer> liste2 = new ArrayList<>();
		for(int i : e.af()){
		  liste2.add(i);
		}
		assertEquals(3, e.taille());   assertEquals(3, e.af().size());
		assertEquals(3, liste.size()); assertEquals(liste.size(), liste2.size());
		assertEquals(liste.get(0), liste2.get(0)); 
		assertEquals(liste.get(1), liste2.get(1));
		assertEquals(liste.get(2), liste2.get(2));

	}
	
}

