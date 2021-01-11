package question2;

public class BeetSugarTest extends junit.framework.TestCase {

    private question2.Beverage choco;
    private question2.Beverage espresso;


    public void setUp() {
        choco = new question2.BeetSugar(new question2.Chocolate());
        espresso = new question2.BeetSugar(new question2.Espresso());
    }

    public void testChocolateWithBeetSugar() {
        assertEquals(2.2, choco.cost(), 0.1);
    }

    public void testEspressoWithBeetSugar() {
        assertEquals(2.09, espresso.cost(), 0.1);
    }


    public void testToString() {
        Beverage b = new BeetSugar(new Whip(new Mocha(new Soy(new HouseBlend()))));
        assertEquals("House Blend Coffee, Soy, Mocha, Whip, Beet Sugar $1.4400000000000002", b.toString());
    }


}
