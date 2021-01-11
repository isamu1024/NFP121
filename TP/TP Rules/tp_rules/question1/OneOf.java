package question1;


public class OneOf<E> extends CompositeSpecification<E>{
  
    public boolean isSatisfiedBy(E e){
        boolean result = false;
        
        for (SpecificationI<E> spec : super.specifications)
            if (spec.isSatisfiedBy(e))
                return true;
        
        return result;
    }
    
    public String toString(){
        return "oneOf" + super.toString();
    }
}