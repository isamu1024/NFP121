package ensemble_exemple;

 

import java.util.*;

public class TestEnsembleOrdonne extends TestEnsemble{
    @Override
  protected void setUp(){
    
     this.e = new EnsembleOrdonnePrePost(new EnsembleOrdonneRepOk(new EnsembleOrdonneAF(new EnsembleOrdonne())));
     this.e1 = new EnsembleOrdonnePrePost(new EnsembleOrdonneRepOk(new EnsembleOrdonneAF(new EnsembleOrdonne())));   
    
//      this.e = new EnsembleOrdonnePrePost(new EnsembleOrdonne());
//      this.e1 = new EnsembleOrdonnePrePost(new EnsembleOrdonne());

//     this.e = new EnsembleOrdonneRepOk(new EnsembleOrdonne());
//     this.e1 = new EnsembleOrdonneRepOk(new EnsembleOrdonne());
//     this.e = new EnsembleOrdonneAF(new EnsembleOrdonne());
//     this.e1 = new EnsembleOrdonneAF(new EnsembleOrdonne());
//

//     this.e = new EnsembleOrdonne();
//     this.e1 = new EnsembleOrdonne();
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
  
  @Override
  public void testIterator(){
		e.ajouter(3);e.ajouter(4);e.ajouter(2);
		List<Integer> liste = new ArrayList<>();
		for(int i : e){
		  liste.add(i);
		}
		assertEquals(3, e.taille());
		assertEquals(3, liste.size());
		
		assertEquals(new Integer(2),liste.get(0));
		assertEquals(new Integer(3),liste.get(1));
		assertEquals(new Integer(4),liste.get(2));
	}
}
