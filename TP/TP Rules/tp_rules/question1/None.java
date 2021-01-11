package question1;

import java.util.*;

public class None<E> extends CompositeSpecification<E>{

    List<SpecificationI<E>> specList ;

    public None(){
        specList = new ArrayList<>();
    }

    /**
     * Return true if none of the rules are satisfied, false if at least one of them is satisfied
     * @param e Element
     * @return
     */
    @Override
    public boolean isSatisfiedBy(E e){

        allSpecInList(super.specifications.iterator());

        for (SpecificationI<E> spec : specList){
            if (spec.isSatisfiedBy(e))
                return false;
        }

        return true;
    }

    public String toString(){
        return "none" + super.toString();
    }

    /**
     * Flatten all nested list into a single one
     * add to the Instance list
     * @param i an iterotor from a List
     */
    private void allSpecInList(Iterator<SpecificationI<E>> i){
        SpecificationI<E> s = null;
        while (i.hasNext()) {
            s = i.next();
            if (s instanceof CompositeSpecification)
                allSpecInList(((CompositeSpecification<E>) s).specifications.iterator());
            else
                specList.add(s);
        }
    }
}