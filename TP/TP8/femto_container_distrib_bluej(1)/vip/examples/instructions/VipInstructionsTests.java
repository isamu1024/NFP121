package vip.examples.instructions;

import java.util.concurrent.atomic.AtomicInteger;
import vip.instructions.*;
import container.ApplicationContext;

public class VipInstructionsTests extends junit.framework.TestCase{

    public void testRulesVip() throws Exception{
        ApplicationContext ctx = null;
        ctx = container.Factory.createApplicationContext("./vip/examples/instructions/README.TXT");

        While<AtomicInteger> whil = ctx.getBean("while"); // whil est un bean
        AtomicInteger i = ctx.getBean("i");
        // i=0; while(i<10)i=i+2
        i = whil.execute(i);
        // i == 10
        assertEquals(10,i.get());

        // 
        Sequence<AtomicInteger> seq = ctx.getBean("seq");
        // i=i+2;i=i+2
        i = seq.execute(i);
        // i == 14
        assertEquals(14,i.get());

        While<AtomicInteger> while_while = ctx.getBean("while_while"); // 
        i.set(-2);
        // i=0; while(i<10)i=i+2
        i = while_while.execute(i);
        // i == 10
        assertEquals(10,i.get());
    }

}

