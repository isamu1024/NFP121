package vip.examples.instructions;

import java.util.concurrent.atomic.*;
import vip.instructions.*;
import container.*;

public class TestWhile{
    public static void main(String[] args){
        // en java
        AtomicInteger i1 = new AtomicInteger();
        Inc inc = new Inc();
        inc.setOperand(2);
        while(i1.get()<10){
            i1 = inc.execute(i1);
        }
        System.out.println("i1 : " + i1.get());

        // avec vip 
        ApplicationContext ctx = null;
        ctx = container.Factory.createApplicationContext("./vip/examples/instructions/README.TXT");

        While<AtomicInteger> whil = ctx.getBean("while");
        AtomicInteger i = ctx.getBean("i");
        i = whil.execute(i);
        System.out.println("i : " + i.get());
        System.out.println(whil.accept(new VisitorString()));

        Sequence<AtomicInteger> seq = ctx.getBean("seq");
        i = seq.execute(i);
        System.out.println("i : " + i.get());
        System.out.println(seq.accept(new VisitorString()));

        i.set(0);
        While<AtomicInteger> while_while = ctx.getBean("while_while");
        i = while_while.execute(i);
        System.out.println("i : " + i.get());

        System.out.println(while_while.accept(new VisitorString()));
    }
}
