package Rules.Rule;

public abstract class Visitor<T> {
    public abstract <E,R> T visit(ClusterRules<E,R> cluster);
    public abstract <E,R> T visit(Rule<E,R> rule);
}
