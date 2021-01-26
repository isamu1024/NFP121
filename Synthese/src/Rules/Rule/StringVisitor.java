package Rules.Rule;

public class StringVisitor extends Visitor<String> {

    private int tab = 0;

    @Override
    public <E, R> String visit(ClusterRules<E, R> cluster) {
        String str = cluster.getName() + "\n";
        tab++;
        for (RuleI<E,R> rule : cluster) {
            str += "\t".repeat(tab);
            str += rule.accept(this);
        }
        tab--;
        return str;
    }

    @Override
    public <E, R> String visit(Rule<E, R> rule) {
        return "(" + rule.getSpecification().interpreter()+")" + "(" + rule.getCommand().interpreter()+");\n";
    }
}
