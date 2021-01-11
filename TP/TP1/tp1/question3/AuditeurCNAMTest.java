package question3;

/**
 * Classe-test AuditeurCNAMTest.
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
public class AuditeurCNAMTest extends junit.framework.TestCase {
    // Dï¿½finissez ici les variables d'instance nï¿½cessaires ï¿½ vos engagements;
    // Vous pouvez ï¿½galement les saisir automatiquement du prï¿½sentoir
    // ï¿½ l'aide du menu contextuel "Prï¿½sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du prï¿½sentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Constructeur de la classe-test AuditeurCNAMTest.
     */
    public AuditeurCNAMTest() {
    }

    /**
     * Met en place les engagements.
     * 
     * Mï¿½thode appelï¿½e avant chaque appel de mï¿½thode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
    }

    /**
     * Supprime les engagements
     * 
     * Mï¿½thode appelï¿½e aprï¿½s chaque appel de mï¿½thode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Libï¿½rez ici les ressources engagï¿½es par setUp()
    }

    /*
     * Il ne vous reste plus qu'ï¿½ dï¿½finir une ou plusieurs mï¿½thodes de test. Ces
     * mï¿½thodes doivent vï¿½rifier les rï¿½sultats attendus ï¿½ l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient dï¿½buter par
     * "test". Vous pouvez ï¿½baucher le corps grace au menu contextuel
     * "Enregistrer une mï¿½thode de test".
     */

    /** Un test de la mï¿½thode toString(). */
    public void test_toString() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("Dupont", "paul", "03-1234");
        assertEquals("Dupont paul login : dupont_p", auditeur1.toString());
    }

    public void test_nom_court() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("paul", "pierre", "12345");
        assertEquals("paul", auditeur1.nom());
        assertEquals("pierre", auditeur1.prenom());
        assertEquals("paul_p", auditeur1.login());
    }

    public void test_nom_court_bis() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("thon", "germon", "12345");
        assertEquals("Mr thon germon", "thon", auditeur1.nom());
        assertEquals("Mr thon germon", "germon", auditeur1.prenom());
        assertEquals("Mr thon germon", "thon_g", auditeur1.login());
    }

    public void test_nom_avec_particule() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("le Thon", "alban", "12345");
        assertEquals("Mr le Thon albacore ", "le Thon", auditeur1.nom());
        assertEquals("Mr le Thon albacore ", "alban", auditeur1.prenom());
        assertEquals(" matricule ?", "12345", auditeur1.matricule());
        assertEquals(" login ? ", "le_tho_a", auditeur1.login());
    }

    public void test_nom_compose() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("Ton-Ton", "max", "12345");
        assertEquals("Mr Ton-Ton max ", "Ton-Ton", auditeur1.nom());
        assertEquals("Mr Ton-Ton max ", "max", auditeur1.prenom());
        assertEquals("Mr Ton-Ton max ", "ton_to_m", auditeur1.login());
    }

    public void test_nom_court_avec_particule() {

        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("Te-Te", "max", "12345");
        assertEquals("Mr Te-Te max ", "Te-Te", auditeur1.nom());
        assertEquals("Mr Te-Te max ", "max", auditeur1.prenom());
        assertEquals("nom court avec particules ? ", "te_te_m", auditeur1.login());
    }

    public void test_nom_avec_accent() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("Chloé",
                "chloé", "12345");
        assertEquals("Mme Chloé chloé ", "Chloé", auditeur1.nom());
        assertEquals("Mme Chloé chloé ", "chloé", auditeur1.prenom());
        assertEquals(" nom avec accent (é devient e) ? ", "chloe_c",
            auditeur1.login());
    }

    public void test_nom_avec_accent_bis() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("Bernard", "tapissé", "123455678910");
        assertEquals(" nom avec accent (é devient e) ? ", "bernar_t", auditeur1.login());
    }
    
    public void test_matricule(){
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("Emmanuel","Macron","21121977");
        assertEquals(" matricule ?" , "21121977",auditeur1.matricule());
    }


    public void testTestDeLaDerniereChance()
    {
        question3.AuditeurCNAM Manu = new question3.AuditeurCNAM("Macron", "Emmanuel", "21121977");
        assertEquals("macron_e", Manu.login());
    }

    public void testTestEqualObject()
    {
        question3.AuditeurCNAM bool = new question3.AuditeurCNAM("Nom", "Prenom", "123456");
        assertEquals(true, bool.equals(bool));
    }

    public void testBool()
    {
        question3.AuditeurCNAM auditeur3 = new question3.AuditeurCNAM("bool", "Boulot", "123456");
        assertEquals(true, auditeur3.equals(auditeur3));
    }
}






