package question1;

public class TestsACompleter extends junit.framework.TestCase{
    private Memoire m;
    private Variable i,j;
    private VisiteurExpression<Integer> ve;
    private VisiteurExpression<String>  vp,vi;

    public void setUp(){
        m  = new Memoire();
        i  = new Variable(m,"i",3);
        j = new Variable(m,"j",5);
        ve = new VisiteurEvaluation( m);
        vi = new VisiteurInfixe( m);
        vp = new VisiteurPostfixe( m);
        assertNotNull(i);assertNotNull(j);
        assertNotNull(ve);assertNotNull(vp);assertNotNull(vi);
    }

    public void testUneAddition(){
        Expression expr = new Addition(new Constante(3), new Constante(2));
        assertEquals(" 3+2 != 5 ?, curieux ",5,expr.accepter(ve).intValue());
    }

    public void testMultiplication(){
        Variable c  = new Variable(m,"c",5);
        Variable d = new Variable(m, "d", 4);

        Expression expr = new Multiplication(c, d);
        assertEquals(" 5*4 != 20 ?, curieux ",20,expr.accepter(ve).intValue());

    }

    public void testSoustraction(){
        Expression expr = new Soustraction(new Constante(5), new Constante(4));
        assertEquals(" 5 - 4 != 1 ?, curieux ",1,expr.accepter(ve).intValue());

        Expression expr2 = new Soustraction(new Constante(4), new Constante(5));
        assertEquals(" 4 - 5 != -1 ?, curieux ",-1,expr2.accepter(ve).intValue());

    }

    public void testDivision(){
        Variable a  = new Variable(m,"a",10);
        Variable b = new Variable(m, "b", 5);

        Expression expr = new Division(a, b);
        assertEquals(" 10 / 5 != 2 ?, curieux ",2,expr.accepter(ve).intValue());

        try{
            new Division(i,new Constante(0)).accepter(ve);
            fail("division par zéro ? possible ");
        }catch(ArithmeticException ae){
        }
    }

    public void testVisiteurInfixe(){

        try{

            Expression expr = new Addition(new Constante(3), new Constante(2));
            assertEquals("(3 + 2)", expr.accepter(vi));
            expr = new Addition(expr, new Constante(2));

            assertEquals("((3 + 2) + 2)", expr.accepter(vi));
            assertEquals("{i=3, j=5}", m.toString());
            expr = new Soustraction(expr, expr);
            assertEquals("(((3 + 2) + 2) - ((3 + 2) + 2))", expr.accepter(vi));

            expr = new Division(new Constante(3), new Constante(2));
            assertEquals("(3 / 2)", expr.accepter(vi));

            expr = new Multiplication(new Constante(3), new Constante(2));
            assertEquals("(3 * 2)", expr.accepter(vi));

        }catch(Exception e){
            fail(" exception inattendue ???" + e.getClass().getName() + e.getMessage());
        }
    }

    public void testVisiteurPostfixe(){
        try{
            Expression expr = new Addition(new Constante(3), new Constante(2));
            assertEquals("(3,2)+", expr.accepter(vp));

            expr = new Addition(expr, new Constante(2));
            assertEquals("((3,2)+,2)+", expr.accepter(vp));
            assertEquals("{i=3, j=5}",m.toString());

            expr = new Soustraction(expr, expr);
            assertEquals("(((3,2)+,2)+,((3,2)+,2)+)-", expr.accepter(vp));

            expr = new Division(new Constante(3), new Constante(2));
            assertEquals("(3,2)/", expr.accepter(vp));

            expr = new Multiplication(new Constante(3), new Constante(2));
            assertEquals("(3,2)*", expr.accepter(vp));

        }catch(Exception e){
            fail(" exception inattendue ???" + e.getClass().getName() + e.getMessage());
        }
    }

}
