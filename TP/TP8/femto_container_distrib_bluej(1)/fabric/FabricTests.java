package fabric;


import java.util.*;
import container.*;

public class FabricTests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{
       ApplicationContext ctx = Factory.createApplicationContext("./fabric/README.TXT");

       Fabrique<StringBuffer> fabrique1 = ctx.getBean("fabrique1");
       StringBuffer sb1 = fabrique1.creer();
        
       Fabrique<Collection<Integer>> fabrique2 = ctx.getBean("fabrique2");
       Collection<Integer> c1 = fabrique2.creer();
       c1.add(33);c1.add(11);
       assertEquals(2,c1.size()); 
       assertTrue(c1.contains(33) && c1.contains(11)); 
    }
    
    public void testSansInjection(){
       Fabrique<StringBuffer> fabrique1 = new Fabrique<>();
       StringBuffer sb = new StringBuffer();
       fabrique1.setProduct(sb);
       StringBuffer sb1 = fabrique1.creer();
       assertSame(sb,sb1);
       
       Fabrique<Collection<Integer>> fabrique2 = new Fabrique<>();
       Collection<Integer> c = new TreeSet<>();
       fabrique2.setProduct(c);
       
       Collection<Integer> c1 = fabrique2.creer();
       
    }
  

}


