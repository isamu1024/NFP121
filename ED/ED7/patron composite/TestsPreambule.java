public class TestsPreambule extends junit.framework.TestCase{

    public void testCompositeNombreDeNoeuds(){
        Noeud n1 = new Noeud("n1");
        Noeud n2 = new Noeud("n2");
        Noeud n3 = new Noeud("n3");
        assertEquals(1, n1.nombreDeNoeuds());
        ListeDeComposants l1 = new ListeDeComposants("l1");
        l1.ajouter(n1).ajouter(n2).ajouter(n3);
        assertEquals(3, l1.nombreDeNoeuds());

        ListeDeComposants l11 = new ListeDeComposants("l11");
        Noeud n11 = new Noeud("n11");
        l11.ajouter(n11);
        l1.ajouter(l11);
        assertEquals(4, l1.nombreDeNoeuds());
    }

    public void testCompositeInterpreter(){
        Noeud n1 = new Noeud("n1");
        Noeud n2 = new Noeud("n2");
        Noeud n3 = new Noeud("n3");
        ListeDeComposants l1 = new ListeDeComposants("l1");
        l1.ajouter(n1).ajouter(n2).ajouter(n3);
        assertEquals("Liste:l1[Noeud:<n1>Noeud:<n2>Noeud:<n3>]",l1.interpreter());

        ListeDeComposants l11 = new ListeDeComposants("l11");
        Noeud n11 = new Noeud("n11");
        l11.ajouter(n11);
        l1.ajouter(l11);
        assertEquals("Liste:l1[Noeud:<n1>Noeud:<n2>Noeud:<n3>Liste:l11[Noeud:<n11>]]",l1.interpreter());
    }

    public void testCompositeGetParent(){
        Noeud n1 = new Noeud("n1");
        Noeud n2 = new Noeud("n2");
        Noeud n3 = new Noeud("n3");
        assertEquals(null, n1.getParent());
        ListeDeComposants l1 = new ListeDeComposants("l1");
        l1.ajouter(n1).ajouter(n2).ajouter(n3);
        assertEquals(l1, n1.getParent());
        assertEquals(l1, n2.getParent());
        assertEquals(l1, n3.getParent());

        ListeDeComposants l11 = new ListeDeComposants("l11");
        Noeud n11 = new Noeud("n11");
        l11.ajouter(n11);
        l1.ajouter(l11);
        assertEquals(l1, l11.getParent());
        assertEquals(l11, n11.getParent());
        System.out.println(n11.getParent().getParent().interpreter());
        assertEquals(l1, n11.getParent().getParent());
    }
}