package question2;

import question1.*;

public class TestsDuVisiteurBoolEvaluation extends junit.framework.TestCase {

    protected Contexte m;
    protected VisiteurExpressionBooleenne<Boolean> veb;

    public void setUp() {
        m = new Memoire();
        veb = new VisiteurBoolEvaluation(new VisiteurEvaluation(m));
    }

    public void testVisiteurBoolEvaluation() {

        assertTrue(new Vrai().accepter(veb));
        assertFalse(new Faux().accepter(veb));
        assertTrue(new Sup(new Constante(5), new Constante(3)).accepter(veb));

        Vrai vrai = new Vrai();
        Faux faux = new Faux();
        Non non = new Non(vrai);
        Ou ou = new Ou(faux, non);
        Ou ou2 = new Ou(vrai, faux);
        Et et = new Et(vrai, vrai);

        Variable a = new Variable(m, "a", 10);
        Variable b = new Variable(m, "b", 5);
        
        Sup sup = new Sup(a , b);
        Egal egal = new Egal(a , b);
        Inf inf = new Inf(a , b );
        
        assertTrue(vrai.accepter(veb));
        assertFalse(faux.accepter(veb));
        assertFalse(non.accepter(veb));
        assertFalse(ou.accepter(veb));
        assertTrue(ou2.accepter(veb));
        assertTrue(et.accepter(veb));
        assertTrue(sup.accepter(veb));
        assertFalse(inf.accepter(veb));
        
        m.ecrire("a",4);
        
        assertFalse(sup.accepter(veb));
        assertTrue(inf.accepter(veb));
        
        assertFalse(egal.accepter(veb));
        
        m.ecrire("a", 5);
        
        assertTrue(egal.accepter(veb));	
        
        
    }
}
