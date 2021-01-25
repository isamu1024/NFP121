package vip.examples.instructions;

import java.util.concurrent.atomic.AtomicInteger;
import vip.instructions.*;
import container.ApplicationContext;

public class VipInstructionsTestsBis extends junit.framework.TestCase{

    public void testInstructionsVip() throws Exception{
        ApplicationContext ctx = null;
        ctx = container.Factory.createApplicationContext("./vip/examples/instructions/README.TXT");

        While<Variable> whil = ctx.getBean("while_v");

        Variable v = new Variable();
        v.setValue(5);
// bean.id.8=inf_v
// inf_v.class=vip.examples.instructions.Inf
// inf_v.property.1=element
// inf_v.property.1.param.1=v10

// bean.id.9=v10
// v10.class=vip.examples.instructions.Variable
// v10.property.1=value
// v10.property.1.param.1=10

// bean.id.10=inc_v
// inc_v.class=vip.examples.instructions.Plus1
// inc_v.property.1=element
// inc_v.property.1.param.1=v10

// bean.id.11=while_v
// while_v.class=vip.instructions.While
// while_v.property.1=condition
// while_v.property.1.param.1=inf_v
// while_v.property.2=instruction
// while_v.property.2.param.1=inc_v
        Variable r = whil.execute(v); // à valider...
        //System.out.println("r: " + r);
        assertEquals(15,r.getValue().intValue());
    }
    
    
    public void testInstructionsVipBis() throws Exception{
        ApplicationContext ctx = null;
        ctx = container.Factory.createApplicationContext("./vip/examples/instructions/README.TXT");

        Memory m = new Memory();
        Variable v = new Variable();
        v.setValue(5);
        m.set("v",v);
        Plus1_Memory inc = ctx.getBean("inc_m");
        inc.setElement("v");
        System.out.println("memory: " + m);
        Memory m1 = inc.execute(m);
        assertEquals(6,m1.get("v").getValue());
        System.out.println("memory: " + m1);
    }
}
