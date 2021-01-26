package Rules.Specification;

public class None<T> extends CompositeSpecification<T>{

    @Override
    public boolean isSatisfiedBy(T t) {
        int res = 0;
        for (Specification spec : this){
            if (spec.isSatisfiedBy(t))
                res++;
            break;
        }
        return res == 0;
    }
}
