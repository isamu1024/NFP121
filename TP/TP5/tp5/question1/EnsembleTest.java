package question1;

public class EnsembleTest extends junit.framework.TestCase {

    public void testAdd(){
        question1.Ensemble<Integer> e1, e3;

        e1 = new question1.Ensemble<Integer>();

        // test de l'ajout d'un objet

        assertEquals(true, e1.add(2));
        assertEquals(1, e1.size());

        // test elt deja present dans la collection
        assertFalse(e1.add(2));

        // creation d'un nouvelle collection pour addAll()
        e3 = new question1.Ensemble<Integer>();
        e3.add(3); e3.add(4);

        // test de l'insertion de la collection
        assertTrue(e1.addAll(e3));
        assertEquals(3,e1.size());

        // test de l'echec d'un nouvel ajout de la collection
        assertFalse(e1.addAll(e3));
        assertEquals(3,e1.size());

        // test de contains()
        assertTrue(e1.contains(2));
        assertTrue(e1.containsAll(e3));

    }

    public void testUnion() {
        question1.Ensemble<Integer> e1, e2;

        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.union(e2);

        assertEquals(3, union.size());
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }

    public void testDiff() {
        question1.Ensemble<String> e1, e2;

        e1 = new question1.Ensemble<String>();
        assertEquals(true, e1.add("aaa"));
        assertEquals(true, e1.add("bbb"));

        e2 = new question1.Ensemble<String>();
        assertEquals(true, e2.add("aaa"));
        assertEquals(true, e2.add("ccc"));

        question1.Ensemble<String> diff = e1.diff(e2);

        assertEquals(1, diff.size());
        assertTrue(diff.contains("bbb"));
        assertFalse(diff.contains("aaa"));
        assertFalse(diff.contains("ccc"));
    }

    public void testInter() {
        question1.Ensemble<String> e1, e2;

        e1 = new question1.Ensemble<String>();
        assertEquals(true, e1.add("aaa"));
        assertEquals(true, e1.add("bbb"));

        e2 = new question1.Ensemble<String>();
        assertEquals(true, e2.add("aaa"));
        assertEquals(true, e2.add("ccc"));

        question1.Ensemble<String> inter = e1.inter(e2);

        assertEquals(1, inter.size());
        assertTrue(inter.contains("aaa"));
        assertFalse(inter.contains("bbb"));
        assertFalse(inter.contains("ccc"));
    }
    
    public void testDiffSym() {
        question1.Ensemble<String> e1, e2;

        e1 = new question1.Ensemble<String>();
        assertEquals(true, e1.add("aaa"));
        assertEquals(true, e1.add("bbb"));

        e2 = new question1.Ensemble<String>();
        assertEquals(true, e2.add("aaa"));
        assertEquals(true, e2.add("ccc"));

        question1.Ensemble<String> diffSym = e1.diffSym(e2);

        assertEquals(2, diffSym.size());
        assertTrue(diffSym.contains("bbb"));
        assertTrue(diffSym.contains("ccc"));
        assertFalse(diffSym.contains("aaa"));
    }

}
