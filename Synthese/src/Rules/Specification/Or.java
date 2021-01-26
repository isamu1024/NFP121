package Rules.Specification;

public class Or<T> extends CompositeSpecification<T>{

    @Override
    public boolean isSatisfiedBy(T t) {
        boolean res = false;

        for (Specification<T> spec : this)
            res |= spec.isSatisfiedBy(t);

        return res;
    }

    @Override
    public String interpreter(){
        return "or" + super.interpreter();
    }
}
