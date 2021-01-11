package question1;

public class OnlyOne<E> extends CompositeSpecification<E>{
    
    
  
    public boolean isSatisfiedBy(E e){
        boolean result = false;
        int count = 0;
        
        for (SpecificationI<E> spec : super.specifications)
            if (spec.isSatisfiedBy(e) == true)
                count++;
        
        return count == 1;
    }
    
    public String toString(){
        return "onlyOne" + super.toString();
    }
}