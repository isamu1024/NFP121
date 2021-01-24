package Introspection.ExempleTP;

public class TestIntrospection extends junit.framework.TestCase {

    public void test_obtentionListe() {
        try {

            TableMethodesJavaLangMath t = TableMethodesJavaLangMath.getInstance();
            assertNotNull(t);
            String[] liste = t.listeDesMethodes();
            assertNotNull(liste);
            assertEquals(liste[0],"IEEEremainder(double, double)");
        } catch (Exception e) {
            fail("Oups" + e.getMessage());
        }
    }

    public void test_invocation() throws Exception{
        try{
            TableMethodesJavaLangMath table = TableMethodesJavaLangMath.getInstance();
            assertNotNull(table);
            assertEquals(table.invoquer("sqrt(double)",9.0),3.0,0.1);
        }catch(Exception e){
            fail("inattendue!!!");
        }
    }

    public void test_Continus() throws Exception{
        String[] listeDesMethodes;

        try {
            TableMethodesJavaLangMath table = TableMethodesJavaLangMath.getInstance();
            listeDesMethodes = table.listeDesMethodes();
            assertNotNull(listeDesMethodes);

            assertFalse("La methode toRadians ne doit pas etre presente", table.cetteMethodeEstPresente("toRadians(double, angdeg)"));
            assertTrue("La methode abs(double) doit etre prÃ©sente", table.cetteMethodeEstPresente("abs(double)"));

            assertTrue(table.cetteMethodeAttendUnSeulParametre("abs(double)"));
            assertFalse(table.cetteMethodeAttendUnSeulParametre("min(double, double)"));

            assertFalse(table.cetteMethodeAttendDeuxParametres("abs(double)"));
            assertTrue(table.cetteMethodeAttendDeuxParametres("min(double, double)"));

            double test = (table.invoquer("sqrt(double)",9.0));
            assertEquals("La table doit avoir 34 elements", 34, listeDesMethodes.length);

        }catch(Exception e){
            fail("inattendue!!!");
        }
    }

}
