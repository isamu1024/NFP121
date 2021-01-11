package ensemble_exemple;



import java.util.*;
import java.lang.reflect.*;

public class TestEnsemble extends junit.framework.TestCase{
  protected CollectionI e,e1;
  
  @Override
  protected void setUp(){
        this.e  = new EnsemblePrePost(new EnsembleRepOk(new EnsembleAF(new Ensemble())));
        this.e1 = new EnsemblePrePost(new EnsembleRepOk(new EnsembleAF(new Ensemble())));   
    
//    this.e = new EnsemblePrePost(new Ensemble());
//    this.e1 = new EnsemblePrePost(new Ensemble());

//     this.e = new EnsembleRepOk(new Ensemble());
//     this.e1 = new EnsembleRepOk(new Ensemble());
//     this.e = new EnsembleAF( new Ensemble());
//     this.e1 = new EnsembleAF( new Ensemble());

//     this.e = new Ensemble();
//     this.e1 = new Ensemble();
  }

  public void testAjouter(){
		e.ajouter(3);
		assertTrue(e.contient(3));
		assertEquals(1, e.taille());
		e.ajouter(3);
		assertEquals(1, e.taille());
	  assertTrue(e.contient(3));
	  e.ajouter(2);
	  assertEquals(2, e.taille());
	  assertTrue(e.contient(2));
  }
  
  public void testAjouterBis(){
	  e.ajouter(1);e.ajouter(3);e.ajouter(4);e.ajouter(2);
	  assertEquals(4,e.taille());
	  e1.ajouter(4);e1.ajouter(2);e1.ajouter(3);
	  assertEquals(3,e1.taille());
	  e.ajouter(e1);
	  assertEquals(4,e.taille());
	  e1.ajouter(44);e1.ajouter(22);e1.ajouter(33);
	  e.ajouter(e1);
	  assertEquals(7,e.taille());
	 }
	

	public void testRetirer(){
		e.ajouter(3);
		assertTrue(e.contient(3));
		e.retirer(3);
		assertFalse(e.contient(3));
	}
	
	public void testTaille(){
		e.ajouter(3);
		assertEquals(1,e.taille());
		e.retirer(3);
		assertEquals(0,e.taille());
		e.ajouter(4);
		assertEquals(1,e.taille());
		e.ajouter(5);
		assertEquals(2,e.taille());
	}
	
	public void testEquals(){
	  e.ajouter(3);e.ajouter(4);e.ajouter(2);
	  e1.ajouter(4);e1.ajouter(2);e1.ajouter(3);
	  assertTrue(e.equals(e1));
	  assertEquals(e.hashCode(),e1.hashCode());
	  assertTrue(e1.equals(e));
	  e1.ajouter(5);
	  assertFalse(e.equals(e1));
	 }
	  
	public void testIterator(){
		e.ajouter(3);e.ajouter(4);e.ajouter(2);
		List<Integer> liste = new ArrayList<>();
		for(int i : e){
		  liste.add(i);
		}
		assertEquals(3, e.taille());
		assertEquals(3, liste.size());
		assertTrue(liste.contains(3));
		assertTrue(liste.contains(2));
		assertTrue(liste.contains(4));

	}
	
}

