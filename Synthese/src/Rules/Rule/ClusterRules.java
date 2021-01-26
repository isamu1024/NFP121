package Rules.Rule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClusterRules<E,R> extends Rule<E,R> implements Iterable<RuleI<E,R>> {
    private String name;
    private List<RuleI<E,R>> rules;


    public ClusterRules(String name) {
        this.name = name;
        this.rules = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    public ClusterRules<E, R> add(RuleI<E, R> rule) {
        this.rules.add(rule);
        return this;
    }

    public Iterator<RuleI<E, R>> iterator() {
        return this.rules.iterator();
    }

    public R execute(E e, R r) throws Exception {
        for (RuleI<E,R> rule : this.rules) {
            r = rule.execute(e, r);
        }
        return r;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}