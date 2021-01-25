package vip.examples.list;


import vip.rules.IRule;
import vip.rules.Invoker;
import container.ApplicationContext;

import java.util.List;
import java.util.ArrayList;

public class ListTests extends junit.framework.TestCase{
 
    public void testRulesVip() throws Exception{
        ApplicationContext ctx = null;
        ctx = container.Factory.createApplicationContext("./vip/examples/list/README.TXT");

        // IRule<Entier,List<Entier>> rule = ctx.getBean("ajout");
        ArrayList<Entier> liste = new ArrayList<>();
        // rule.execute(new Entier(33),liste);rule.execute(new Entier(22),liste);
        // System.out.println("liste: " + liste);
        
        Invoker<Entier,ArrayList<Entier>> rules = ctx.getBean("invocateur");
        System.out.println("rules:\n" + rules.getRule());
        
        liste = rules.execute(new Entier(10),liste);
        System.out.println("liste: " + liste);
        
        
        
        
    }
    
}
