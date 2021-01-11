package question2;

import question1.*;

public class TestsDuVisiteurBoolToJava extends junit.framework.TestCase {

    protected Contexte m;
    protected VisiteurExpressionBooleenne<String> vbs;

    public void setUp() {
        m = new Memoire();
        vbs = new VisiteurBoolToJava(new VisiteurInfixe(m));
    }

    public void testVisiteurBoolString() {
        assertEquals("true", new Vrai().accepter(vbs));
        assertEquals("false", new Faux().accepter(vbs));
        assertEquals("(5 > 8)", new Sup(new Constante(5), new Constante(8)).accepter(vbs));
        assertEquals("((5 + 3) == 8)", new Egal(new Addition(new Constante(5), new Constante(3)), new Constante(8)).accepter(vbs));
        assertEquals("(i < j)", new Inf(new Variable(m, "i"), new Variable(m, "j")).accepter(vbs));
        assertEquals("(i < (j + 1))",
            new Inf(new Variable(m, "i"),
                new Addition(new Variable(m, "j"), new Constante(1))).accepter(vbs));
        assertEquals("((i > j) || (i < j))",
            new Ou(new Sup(new Variable(m, "i"), new Variable(m, "j")),
                new Inf(new Variable(m, "i"), new Variable(m, "j"))).accepter(vbs));
        assertEquals("((i > j) && (i < j))",
            new Et(new Sup(new Variable(m, "i"), new Variable(m, "j")),
                new Inf(new Variable(m, "i"), new Variable(m, "j"))).accepter(vbs));
    }

    public void testVisiteurBoolToJava(){

        Vrai vrai = new Vrai();
        assertEquals("true", vrai.accepter(vbs));

        Faux faux = new Faux();
        assertEquals("false", faux.accepter(vbs));

        Non non = new Non(vrai);
        assertEquals("!(true)", non.accepter(vbs) );

        Variable a  = new Variable(m,"a",10);
        Variable b = new Variable(m, "b", 5);

        Sup sup = new Sup(a, b);
        assertEquals("(a > b)", sup.accepter(vbs));

        Egal egal = new Egal(a, b);
        assertEquals("(a == b)", egal.accepter(vbs));

        Inf inf = new Inf(a, b);
        assertEquals( "(a < b)", inf.accepter(vbs));

        Ou ou = new Ou(vrai, faux);
        assertEquals("(true || false)", ou.accepter(vbs));

        Et et = new Et(vrai, non);
        assertEquals("(true && !(true))", et.accepter(vbs));

    }
}
