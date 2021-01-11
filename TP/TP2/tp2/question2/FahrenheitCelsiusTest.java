package question2;

import org.junit.Test;

/**
 * Classe-test FahrenheitCelsiusTest.
 *
 * @author (votre nom)
 * @version (un numï¿½ro de version ou une date)
 *
 *          Les classes-test sont documentï¿½es ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basï¿½es sur le document ï¿½ 2002 Robert A. Ballance intitulï¿½
 *          ï¿½JUnit: Unit Testing Frameworkï¿½.
 *
 *          Les objets Test (et TestSuite) sont associï¿½s aux classes ï¿½ tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          mï¿½me paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque mï¿½thode Test ï¿½
 *          exï¿½cuter. Il peut y avoir plus d'une mï¿½thode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ dï¿½couvrira
 *          automatiquement (par introspection) les mï¿½thodes Test de votre
 *          classe Test et gï¿½nï¿½rera la TestSuite consï¿½quente. Chaque appel d'une
 *          mï¿½thode Test sera prï¿½cï¿½dï¿½ d'un appel de setUp(), qui rï¿½alise les
 *          engagements, et suivi d'un appel ï¿½ tearDown(), qui les dï¿½truit.
 */
public class FahrenheitCelsiusTest extends junit.framework.TestCase {
    // Dï¿½finissez ici les variables d'instance nï¿½cessaires ï¿½ vos engagements;
    // Vous pouvez ï¿½galement les saisir automatiquement du prï¿½sentoir
    // ï¿½ l'aide du menu contextuel "Prï¿½sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du prï¿½sentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Constructeur de la classe-test FahrenheitCelsiusTest
     */
    public FahrenheitCelsiusTest() {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements

    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Libï¿½rez ici les ressources engagï¿½es par setUp()
    }

    public void test_fahrenheitEnCelsius() {
        assertEquals("    0 °F -> -17.7 °C ? ", -17.7, question1.FahrenheitCelsius.fahrenheitEnCelsius(0), 0.1);
        assertEquals("  100 °F -> 37.7 °C ? ", 37.7, question1.FahrenheitCelsius.fahrenheitEnCelsius(100), 0.1);
        assertEquals(" 2000 °F -> 1093.3 °C ?", 1093.3, question1.FahrenheitCelsius.fahrenheitEnCelsius(2000), 0.1);
        assertEquals("   54 °F -> 12.2 °C ?", 12.2, question1.FahrenheitCelsius.fahrenheitEnCelsius(54), 0.1);
        assertEquals("1000°F -> 537,8°C ?", 537.8, question1.FahrenheitCelsius.fahrenheitEnCelsius(1000), 0.1);

    }

    public void test_lgPartieDecimale() {
        float result =  question1.FahrenheitCelsius.fahrenheitEnCelsius(54);
        String stringResult = Float.toString(result);
        String decimal = stringResult.substring(stringResult.lastIndexOf('.')+1, stringResult.length());

        assertTrue(decimal.length() == 1);

    }

    public void test_separateur(){
        float result =  question1.FahrenheitCelsius.fahrenheitEnCelsius(54);
        String stringResult = Float.toString(result);
        int[] n = stringResult.chars().filter(x -> x == '.').toArray();

        assertEquals("",1, n.length); 
    }

    public void test_exceptionDansConsole() throws Exception{

        String[] out = mainExec("question2.FahrenheitCelsius",new String[]{"ZZ"});
        assertTrue(out[0].contains("error : For input string:"));
    }

    public void test_typeOfException() throws Exception{
        
        try{ question2.FahrenheitCelsius.main(new String[]{"Z"});
        }
        catch (Exception e){ 
            assertTrue(e instanceof NumberFormatException);
        }
    }

    /** Obtention de l'affichage produit par l'exécution de la méthode main d'une classe.
     * @param className le nom de la classe
     * @param args les arguments de la ligne de commande
     * @return le texte en tableau de lignes
     * @throws une exception est levée si la classe est inconnue
     */
    public static String[] mainExec(String className, String[] args)throws Exception{
        java.io.PrintStream out = System.out;
        String[] consoleOut = null; // ou new String[]{""};
        try{
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.PrintStream ps = new java.io.PrintStream(baos);
            Class<?> c = Class.forName(className);
            System.setOut(ps);
            c.getMethod("main",String[].class).invoke(null, new  Object[]{args});
            consoleOut = baos.toString().split(System.getProperty("line.separator"));
        }finally{
            System.setOut(out);
        }
        return consoleOut;
    }
}

