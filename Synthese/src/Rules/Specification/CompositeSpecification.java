package Rules.Specification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class CompositeSpecification<T> extends Specification<T> implements Iterable<Specification<T>> {

    private final List<Specification<T>> specifications;

    public CompositeSpecification() {
        this.specifications = new ArrayList<>();
    }

    public CompositeSpecification<T> add(Specification<T> spec) {
        this.specifications.add(spec);
        return this;
    }

    public Iterator<Specification<T>> iterator() {
        return this.specifications.iterator();
    }

    public String interpreter() {
        StringBuilder stb = new StringBuilder();
        stb.append("(");
        Iterator<Specification<T>> it = this.iterator();

        while (it.hasNext()) {
            stb.append(it.next().interpreter());
            if (it.hasNext()){
                stb.append(", ");
            }
        }

        stb.append(")");

        return stb.toString();
    }
}



