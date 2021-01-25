package vip.examples.number;

import java.util.concurrent.atomic.AtomicInteger;

import vip.rules.IRule;
import vip.rules.Invoker;
import container.ApplicationContext;

public class NumberTests extends junit.framework.TestCase{
 
    public void testRulesVip() throws Exception{
        ApplicationContext ctx = null;
        ctx = container.Factory.createApplicationContext("./vip/examples/number/README.TXT");

        IRule<Integer,AtomicInteger> rules = ctx.getBean("rules");
        AtomicInteger i = new AtomicInteger(0);
        i = rules.execute(0,i);
        //System.out.println("i: " + i.get());
        //  si pair alors r = r + 10
        assertEquals(10, i.get());
        i = rules.execute(i.get(),i);
        assertEquals(20, i.get());
        
        //  si impair(1) alors r = r + 100
        i = new AtomicInteger(0);
        i = rules.execute(1,i);
        assertEquals(100, i.get());
        
        IRule<Integer,AtomicInteger> rule = ctx.getBean("ruleReflection");
        i = new AtomicInteger(0);
        i = rules.execute(1,i);
        //  si impair(1) alors r = r + 100
        assertEquals(100, i.get());  
    }
    
    public void testInvokerVip() throws Exception{
        ApplicationContext ctx = null;
        ctx = container.Factory.createApplicationContext("./vip/examples/number/README.TXT");

        Invoker<Integer,AtomicInteger> invoker = ctx.getBean("invoker");
        AtomicInteger i = new AtomicInteger(0);
        i = invoker.execute(0,i);
        //System.out.println("i: " + i.get());
        //  si pair alors r = r + 10
        assertEquals(10, i.get());
        i = invoker.execute(i.get(),i);
        assertEquals(20, i.get());
        
        //  si impair(1) alors r = r + 100
        i = new AtomicInteger(0);
        i = invoker.execute(1,i);
        assertEquals(100, i.get());
        
        
        invoker.execute(1,i);
        assertEquals(200, i.get());
        
        AtomicInteger i1 = invoker.undo();
        assertEquals(100, i1.get());
        i1 = invoker.undo();
        assertEquals(0, i1.get());
        i1 = invoker.undo();
        assertEquals(10, i1.get());
        i1 = invoker.undo();
        assertEquals(0, i1.get());
        i1 = invoker.undo();
        assertEquals(null, i1);
    }
    
        public void testToStringVip() throws Exception{
        ApplicationContext ctx = null;
        ctx = container.Factory.createApplicationContext("./vip/examples/number/README.TXT");

        IRule<Integer,AtomicInteger> rules = ctx.getBean("rules");
        System.out.println("rules: \n" + rules);
        
 
    }
    
}
