package question1;

public class TestSer extends junit.framework.TestCase {

    public void testSerObject() {

        IProgr p = new AST_SOM_F(10);
        try {
            JAVASerialiseDeserialise.serialjava(p, "question1\\testSerObject.ser");
        } catch (Exception e){
            System.out.println("Une erreur dans la sauvegarde est surevenue" + e.getMessage());
        }

    }

}
