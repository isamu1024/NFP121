package adapter;

import java.util.*;
import container.*;

public class AdapterTests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{

        ApplicationContext ctx = Factory.createApplicationContext("./adapter/README.TXT");

        // pile1 et son adaptateur défini dans le fichier de configuration
        PileI<Integer> pile1 = ctx.getBean("pile1");
        testPile(pile1);
        PileI<Integer> pile2 = ctx.getBean("pile2");
        testPile(pile2);
        
        // la pile créée est ici définie dans le fichier de configuration
        Fabrique<PileI<Integer>> fabrique = ctx.getBean("fabrique");
        PileI<Integer> pile = fabrique.creer();
        testPile(pile);

    }
    
    public void testSansInjection(){
        PileI<Integer> pile1 = new Adaptateur(new ArrayList<>());
        testPile(pile1);
        
        PileI<Integer> pile2 = new Adaptateur(new LinkedList<>());
        testPile(pile2);
        
        Fabrique<PileI<Integer>> fabrique = new Fabrique();
        fabrique.setInstance(pile1);
        PileI<Integer> pile = fabrique.creer();
        testPile(pile);
    }
    
    
    
    public void testPile(PileI<Integer> pile){
        assertTrue(pile.estVide());
        pile.empiler(3);
        assertFalse(pile.estVide());
        pile.empiler(4);
        assertFalse(pile.estVide());
        assertEquals(4,pile.depiler().intValue());
        assertFalse(pile.estVide());
        assertEquals(3,pile.depiler().intValue());
        assertTrue(pile.estVide());
    }
  

}


