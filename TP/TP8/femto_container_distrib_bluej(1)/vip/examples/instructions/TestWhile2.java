package vip.examples.instructions;


import java.util.concurrent.atomic.*;
import vip.instructions.*;
import container.*;
import java.util.*;

public class TestWhile2{
    public static void main(String[] args){
        // en java
        Collection<Integer> l1 = new ArrayList<>();
        int valeur = 0;
        Ajout<Integer> instruction = new Ajout<Integer>();
        while(l1.size()<10){
            instruction.setElement(valeur++);
            l1 = instruction.execute(l1);
        }
        System.out.println("l1 : " + l1.toString());
        
        // avec vip
        ApplicationContext ctx = null;
        ctx = container.Factory.createApplicationContext("./vip/examples/instructions/README.TXT");
       
        While<Collection<Integer>> whil = ctx.getBean("while_list");
        l1 = new ArrayList<>();
        l1 = whil.execute(l1);  // peu pratique, l'élément à ajouter n'est pas accessible
        System.out.println("l1 avec vip : " + l1.toString());

        // Sequence<AtomicInteger> seq = ctx.getBean("seq");
        // i = seq.execute(i);
        // System.out.println("i : " + i.get());
        
        // i.set(0);
        // While<AtomicInteger> while_while = ctx.getBean("while_while");
        // i = while_while.execute(i);
        // System.out.println("i : " + i.get());
    }
}
