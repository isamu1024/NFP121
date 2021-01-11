package question1;

public class All<E> extends CompositeSpecification<E>{

    public boolean isSatisfiedBy(E e){
        boolean result = true;
        
        for (SpecificationI<E> spec : super.specifications)
            result &= spec.isSatisfiedBy(e);
        
        return result;
    }

    public String toString(){
        return "all" + super.toString();
    }
}