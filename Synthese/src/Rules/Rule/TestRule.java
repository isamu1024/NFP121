package Rules.Rule;

import Rules.Command.MacroCommand;
import Rules.Specification.Specification;

public class TestRule extends junit.framework.TestCase {

    public void testSimpleAvecDesEntiers() throws Exception {
        Specification<Integer> inf = new EstInferieur(4);
        MacroCommand<Integer> plus2 = new MacroCommand<>();
        plus2.add(new Inc()).add(new Inc());
        Rule<Integer, Integer> rule = new Rule<>(inf, plus2);
        System.out.println("rule:" + rule.accept(new StringVisitor()));
        assertEquals("(estInferieur_a_4)((inc -> inc));\n", rule.accept(new StringVisitor()));
        PrintRule<Integer, Integer> print = new PrintRule<>();
        System.out.println("print: " + print.accept(new StringVisitor()));
        assertEquals("(true)(print);\n", print.accept(new StringVisitor()));
        Integer res = 0, x = 3;
        res = rule.execute(x, res);       // [res==0,x==3]if inf(x,4) res = plus2.execute(res);
        assertEquals(Integer.valueOf(2),res);   // [res==2]
        Integer res1 = rule.execute(5,res); // [x==5]if inf(x,4) res1 = plus2.execute(res);
        assertEquals(Integer.valueOf(2), res1); // [res==2]
        ClusterRules<Integer,Integer> cluster = new ClusterRules<>("cluster1");
        cluster.add(rule).add(rule).add(rule);
        Integer res2 = cluster.execute(2,0);
        assertEquals(Integer.valueOf(6),res2);
        ClusterRules<Integer,Integer> cluster2 = new ClusterRules<>("cluster2");
        cluster2.add(rule).add(print).add(rule).add(print);
        cluster.add(cluster2);
        res2 = cluster.execute(2,0);
        assertEquals(Integer.valueOf(10), res2);
        System.out.println(cluster.accept(new StringVisitor()));
    }

    public void testReflectionRule() throws Exception {
        ReflectionRule<Integer, Integer> rule = new ReflectionRule<>();
        rule.setSpecification("Rules.Rule.EstInferieur");
        EstInferieur inf = (EstInferieur) rule.getSpecification();
        inf.setValeur(4);
        rule.setCommand("Rules.Rule.Inc");
        Integer i = rule.execute(0, 5);
        assertEquals(Integer.valueOf(6), i);
    }

}
