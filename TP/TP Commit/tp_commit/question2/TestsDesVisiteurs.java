package question2;

import java.util.*;

import question1.*;

public class TestsDesVisiteurs extends junit.framework.TestCase {

    public void testACompleter() {
//        fail(" cette méthode de tests, est à compléter, appels des trois visiteurs....");
    }


    public void testCompositeValide() {
        try {
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));

            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g.ajouter(g1);
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));

            g1.ajouter(new Contributeur("c", 100));
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(100)));
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(150)));

        } catch (Exception e) {
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testTroisContributeursUnGroupe() {
        try {
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a", 100));
            g.ajouter(new Contributeur("g_b", 200));
            g.ajouter(new Contributeur("g_c", 300));
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
            assertEquals(" Revoyez DébitMaximal !!!", Integer.valueOf(100), g.accepter(new DebitMaximal()));
            assertTrue(" Ce composite est valide, revoyez CompositeValide et/ou DebitMaximal!!!", g.accepter(new CompositeValide(g.accepter(new DebitMaximal()))));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g.ajouter(g1);
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g1.accepter(new CompositeValide(10)));
        } catch (Exception e) {
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testUnContributeurUnGroupeAvecLeMemeNom() {
        try {
            GroupeDeContributeurs g = new GroupeDeContributeurs("g_a");
            g.ajouter(new Contributeur("g_a", 100));
            g.ajouter(new Contributeur("g_b", 200));
            g.ajouter(new Contributeur("g_c", 300));
            g.ajouter(new Contributeur("g_d", 80));
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(10)));
            assertFalse(" Ce composite a au moins un doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
        } catch (Exception e) {
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testUnContributeurDeuxGroupesAvecLeMemeNom() {
        try {
            GroupeDeContributeurs g = new GroupeDeContributeurs("g_a");
            g.ajouter(new Contributeur("a", 100));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g_a");
            g1.ajouter(new Contributeur("b", 200));
            g.ajouter(g1);
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(10)));
            assertFalse(" Ce composite a au moins un doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
        } catch (Exception e) {
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testVisiteurDebitMaximal() {

        GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
        g1.ajouter(new Contributeur("a", 100));
        g1.ajouter(new Contributeur("b", 50));
        g1.ajouter(new Contributeur("c", 300));
        DebitMaximal dMax = new DebitMaximal();
        assertEquals("Le montant max devrait être 50", Integer.valueOf(50), g1.accepter(dMax));
        g1.ajouter(new Contributeur("d", 10));
        assertEquals("Le montant max devrait être 10", Integer.valueOf(10), g1.accepter(dMax));
        GroupeDeContributeurs g2 = new GroupeDeContributeurs("g1");
        g2.ajouter(new Contributeur("d", 400));
        g2.ajouter(g1);
        assertEquals("Le montant max devrait être 10", Integer.valueOf(10), g2.accepter(dMax));
        g2.ajouter(new Contributeur("e", 3));
        assertEquals("Le montant max devrait être 3", Integer.valueOf(3), g2.accepter(dMax));

    }

    public void testDoublons(){

        GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
        Cotisant c1 = new Contributeur("c1", 100);

        SansDoublon sd = new SansDoublon();

        assertTrue(g1.accepter(sd));
        assertTrue(c1.accepter(sd));

        Cotisant g1_bis = new GroupeDeContributeurs("g1");
        g1.ajouter(g1_bis);
        assertFalse(g1.accepter(sd));

        GroupeDeContributeurs c1_bis = new GroupeDeContributeurs("c1");
        c1_bis.ajouter(c1);
        assertFalse(c1_bis.accepter(sd));

    }
}

