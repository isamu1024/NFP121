package facade;


import java.util.*;
import container.*;

public class FacadeTests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{
        try{
            ApplicationContext ctx = Factory.createApplicationContext("./facade/README.TXT");
            FacadeI facade = ctx.getBean("facade1");
            facade.methode1();
            facade.methode2();
        }catch(Exception e){
            fail("FacadeTests exception ?: " + e.getMessage());
        }

    }
}

