package Rules.Specification;

public class OnlyOne<T> extends CompositeSpecification<T> {

    @Override
    public boolean isSatisfiedBy(T t) {
        int res = 0;
        for (Specification<T> spec : this) {
            if (spec.isSatisfiedBy(t))
                res++;
        }
        return res == 1;
    }

    @Override
    public String interpreter(){
        return "or" + super.interpreter();
    }
}
