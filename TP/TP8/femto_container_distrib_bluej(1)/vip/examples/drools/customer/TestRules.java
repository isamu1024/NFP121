package vip.examples.drools.customer;



import container.*;
import vip.rules.*;
import vip.examples.drools.customer.Customer.CustomerType;

// System.out.println("https://www.baeldung.com/drools-excel");
public class TestRules  extends junit.framework.TestCase{
    private  ApplicationContext container =null;
    @Override
    public void setUp() {
        container = Factory.createApplicationContext("./vip/examples/drools/customer/README.TXT");
     }
    
    public void
      testGiveIndividualLongStanding_whenFireRule_thenCorrectDiscount() 
        throws Exception {
        //ApplicationContext container = Factory.createApplicationContext("./vip/examples/drools/customer/README.TXT");
        Customer customer = new Customer(Customer.INDIVIDUAL, 5);
        
        IRule rules = container.getBean("rules");
        rules.execute(customer, customer); // customer mutable ici
        assertEquals(customer.getDiscount(), 15);
    }
    

    public void testGiveIndvidualRecent_whenFireRule_thenCorrectDiscount() 
      throws Exception {
        Customer customer = new Customer(Customer.INDIVIDUAL, 1);
        // kSession.insert(customer);
        // kSession.fireAllRules();
         IRule rules = container.getBean("rules");
        rules.execute(customer, customer); 
        assertEquals(customer.getDiscount(), 5);
    }
 

    public void testGiveBusinessAny_whenFireRule_thenCorrectDiscount() 
        throws Exception {
        Customer customer = new Customer(Customer.BUSINESS, 0);
        // kSession.insert(customer);
        // kSession.fireAllRules();
         IRule rules = container.getBean("rules");
        rules.execute(customer, customer); 
        assertEquals(customer.getDiscount(), 20);
    }
 
}

