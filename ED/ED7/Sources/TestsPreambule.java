
public class TestsPreambule extends junit.framework.TestCase{

    public void testCompositeBoucleRecursiveInfinie() throws Exception {
        Noeud n1 = new Noeud("n1");
        Noeud n2 = new Noeud("n2");
        Noeud n3 = new Noeud("n3");
        ListeDeComposants l1 = new ListeDeComposants("l1");
        l1.ajouter(n1).ajouter(n2).ajouter(n3);
        try {
            l1.ajouter(l1);
            fail("l1 peut être ajouté à l1 ???");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("boucle récursive infinie :this enfant de this"));
        }
        ListeDeComposants l2 = new ListeDeComposants("l2");
        ListeDeComposants l3 = new ListeDeComposants("l3");
        ListeDeComposants l4 = new ListeDeComposants("l4");
        ListeDeComposants l5 = new ListeDeComposants("l5");
        Noeud n31 = new Noeud("n31");
        Noeud n32 = new Noeud("n32");
        Noeud n21 = new Noeud("n21");
        l3.ajouter(n31).ajouter(n32);
        l3.ajouter(l4);
        l4.ajouter(l5);
        l2.ajouter(l3).ajouter(n21);
        l5.ajouter(l1);
        try {
            l1.ajouter(l2);
            fail("l2 (l2->l3->l4->l5->l1) peut être ajouté à l1 ???");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("boucle récursive infinie dans le lignage"));
        }
    }

    public void testCompositeNombreDeNoeuds()  throws Exception{
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

    public void testCompositeInterpreter()  throws Exception{
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

    public void testCompositeGetParent() throws Exception{
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

    public void testCompositeInterpreterEtVisiteur() throws Exception{
        Noeud n1 = new Noeud("n1");
        Noeud n2 = new Noeud("n2");
        Noeud n3 = new Noeud("n3");
        ListeDeComposants l1 = new ListeDeComposants("l1");
        l1.ajouter(n1).ajouter(n2).ajouter(n3);
        assertEquals("Liste:l1[Noeud:<n1>Noeud:<n2>Noeud:<n3>]",l1.interpreter());
        Visiteur<String> visiteur = new VisiteurString();
        assertEquals(l1.accepter(visiteur), l1.interpreter());

        ListeDeComposants l11 = new ListeDeComposants("l11");
        Noeud n11 = new Noeud("n11");
        l11.ajouter(n11);
        l1.ajouter(l11);
        assertEquals("Liste:l1[Noeud:<n1>Noeud:<n2>Noeud:<n3>Liste:l11[Noeud:<n11>]]",l1.interpreter());
        assertEquals(l1.accepter(visiteur), l1.interpreter());
    }

    public void testCompositeVisiteurAvecTabulations() throws Exception{
        Noeud n1 = new Noeud("n1");
        Noeud n2 = new Noeud("n2");
        Noeud n3 = new Noeud("n3");
        Noeud n4 = new Noeud("n4");
        ListeDeComposants l1 = new ListeDeComposants("l1");
        l1.ajouter(n1).ajouter(n2).ajouter(n3);

        ListeDeComposants l2 = new ListeDeComposants("l2");
        ListeDeComposants l3 = new ListeDeComposants("l3");
        
        Noeud n31 = new Noeud("n31");
        Noeud n32 = new Noeud("n32");
        Noeud n21 = new Noeud("n21");
        
        l3.ajouter(n31).ajouter(n32);
        l2.ajouter(l3).ajouter(n21);
        
        ListeDeComposants l4 = new ListeDeComposants("l4");
        Noeud n41 = new Noeud("n41");
        l4.ajouter(n41);
        l1.ajouter(l2).ajouter(l4).ajouter(n4);
        String res = l1.accepter(new VisiteurStringAvecTabulations());
        System.out.println(res);
        assertTrue(res.startsWith("Liste:l1" + "\n" +
                "\tNoeud:<n1>"+ "\n" +
                "\tNoeud:<n2>"+ "\n" +
                "\tNoeud:<n3>"+ "\n" +
                "\tListe:l2" + "\n" +
                "\t\tListe:l3" + "\n"+
                "\t\t\tNoeud:<n31>"+ "\n" +
                "\t\t\tNoeud:<n32>"+ "\n" +
                "\t\tNoeud:<n21>"+ "\n"));
    }
    
      public void testVisiteurCompositeValide()  throws Exception{
        Noeud n1 = new Noeud("n1");
        Noeud n2 = new Noeud("n2");
        Noeud n3 = new Noeud("n3");
        ListeDeComposants l1 = new ListeDeComposants("l1");
        l1.ajouter(n1).ajouter(n2).ajouter(n3);
        assertEquals("Liste:l1[Noeud:<n1>Noeud:<n2>Noeud:<n3>]",l1.interpreter());
        Visiteur<Boolean> visiteur = new VisiteurCompositeValide();
        assertTrue(l1.accepter(visiteur));
       
        ListeDeComposants l11 = new ListeDeComposants("l11");
        Noeud n11 = new Noeud("n11");
        l11.ajouter(n11);
        l1.ajouter(l11);
        visiteur = new VisiteurCompositeValide();
        assertTrue(l1.accepter(visiteur));
       
        ListeDeComposants l12 = new ListeDeComposants("n2");
        l12.ajouter(new Noeud("l1"));
        l1.ajouter(l12);
        visiteur = new VisiteurCompositeValide();
        assertTrue(l1.accepter(visiteur));
       
        l11.ajouter(new Noeud("n2"));
        assertEquals(6, l1.nombreDeNoeuds());
        visiteur = new VisiteurCompositeValide();
        assertFalse(l1.accepter(visiteur));
       
        ListeDeComposants l2 = new ListeDeComposants("l2");
        ListeDeComposants l22 = new ListeDeComposants("l22");
        visiteur = new VisiteurCompositeValide();
        assertFalse(l2.accepter(visiteur));
    }
}