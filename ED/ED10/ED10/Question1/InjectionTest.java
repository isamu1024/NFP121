package Question1;


import java.util.*;

public class InjectionTest extends junit.framework.TestCase{

    public void testTableArrayList() throws Exception{
        Collection<Integer> c = new ArrayList<Integer>();
        Table<Integer> table = new Table<Integer>();
        table.setCapacite(4);
        table.setListe(c);

        table.ajouter(4);table.ajouter(2);table.ajouter(3);table.ajouter(1);
        assertEquals("[4, 2, 3, 1]",table.toString());
        try{
            table.ajouter(5);
            fail("Une exception doit être levée, la capacité de la table est atteinte...");
        }catch(Exception e){
        }
    }

    public void testTableSet()throws Exception{
        Collection<Integer> c = new TreeSet<Integer>();
        Table<Integer> table = new Table<Integer>();
        table.setCapacite(4);
        table.setListe(c);

        table.ajouter(4);table.ajouter(2);table.ajouter(2);table.ajouter(1);
        assertEquals("[1, 2, 4]",table.toString());
        table.ajouter(3);
        assertEquals("[1, 2, 3, 4]",table.toString());

    }	    
}