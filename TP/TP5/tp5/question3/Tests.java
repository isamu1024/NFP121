package question3;

import java.util.Set;

public class Tests extends junit.framework.TestCase {

    public void test1(question3.Factory< ? extends Set<Integer>> f) throws Exception {
        Set<Integer> set = f.create();

        for (int i = 20; i > 0; i--)
            set.add(i);
    }

    public void testCreation() {
        try {
            test1(new TreeSetFactory<Integer>());
            test1(new HashSetFactory<Integer>());
        } catch (NoSuchMethodError e) {
            fail("NoSuchMethodError : " + e.getMessage());
        } catch (Exception e) {
            fail(" exception inattendue : " + e.getMessage());
        }
    }

    public void test_TreeSetFactory(){
        try{
            question3.TreeSetFactory<Integer> treeSetF1 = new question3.TreeSetFactory<Integer>();
            java.util.Set<Integer> ts = treeSetF1.create();
            assertNotNull("appel de create retourne null ???", ts);
            assertEquals(" un TreeSet est attendu ???", ts.getClass().getName(), "java.util.TreeSet");
            assertEquals(true, ts.add(5));
            assertEquals(true, ts.add(3));
            assertEquals(false, ts.add(3));
            assertEquals("[3, 5]", ts.toString());
        }catch(NoSuchMethodError e){
            fail(" exception : " + e.getMessage());
        }catch(NoClassDefFoundError e){
            fail(" exception : " + e.getMessage());
        }catch(Exception e){
            fail(" exception inattendue : " + e.getMessage());
        }
    }

    public void test_HashMap(){
        try {
            question3.HashSetFactory<Integer> HashSetF1 = new question3.HashSetFactory<Integer>();
            java.util.Set<Integer> hs = HashSetF1.create();
            assertNotNull("appel de create retourne null ???", hs);
            assertEquals(" un hashSet est attendu ???", hs.getClass().getName(), "java.util.HashSet");
            assertEquals(true, hs.add(5));
            assertEquals(true, hs.add(3));
            assertEquals(false, hs.add(3)); // comme TreeSet, si l'element est déjà present il ne sera pas ajoutés
            assertEquals("[3, 5]", hs.toString());

        }catch(NoSuchMethodError e){
            fail(" exception : " + e.getMessage());
        }catch(NoClassDefFoundError e){
            fail(" exception : " + e.getMessage());
        }catch(Exception e){
            fail(" exception inattendue : " + e.getMessage());
        }
    }

    public void test_ajoutNull(){

        question3.HashSetFactory<Integer> HashSetF1 = new question3.HashSetFactory<Integer>();
        java.util.Set<Integer> hs = HashSetF1.create();

        question3.TreeSetFactory<Integer> treeSetF1 = new question3.TreeSetFactory<Integer>();
        java.util.Set<Integer> ts = treeSetF1.create();

        assertEquals("L'ajout d'un objet null est autorisé",true, hs.add(null));

        try{ts.add(null);
            fail("NullPointerException");
        } catch (NullPointerException e) {
            // "Une exception aurait du être levee"
        }

    }

    
    // suite erreur que je ne comprenais pas, test du source 
    public void test_HashSetFactory()
    {
        try{
            question3.HashSetFactory<Integer> hashSetF1 = new question3.HashSetFactory<Integer>();
            java.util.Set<Integer> hs = hashSetF1.create();
            assertNotNull("appel de create retourne null ???",hs);
            assertEquals(" un HashSet est attendu ???", hs.getClass().getName(), "java.util.HashSet");
            assertEquals(true, hs.add(5));
            assertEquals("toString curieux ?", "[5]", hs.toString());
            assertTrue("appel de add, ne retourne pas true (qui est attendu) ???", hs.add(3));
            assertFalse("appel de add, ne retourne pas false ???",hs.add(5));
            assertTrue("appel de contains, ne retourne pas true ???",hs.contains(3));
            assertTrue("appel de contains, ne retourne pas true ???",hs.contains(5));
            assertFalse("appel de contains, ne retourne pas false ???",hs.contains(33));
            assertFalse("appel de contains, ne retourne pas false, qui est attendu ???", hs.contains(55));
        }catch(NoSuchMethodError e){
            fail(" exception : " + e.getMessage());
        }
    }
}
