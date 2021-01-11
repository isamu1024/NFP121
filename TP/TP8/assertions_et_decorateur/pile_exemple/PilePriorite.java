package pile_exemple;

import java.util.*;

public class PilePriorite<T extends Comparable<T>> extends Pile2<T>{
    public PilePriorite(){
        super();
    }

    public  PilePriorite(int capacite){
        super(capacite);
    }

    public void empiler(T t) throws PilePleineException{
        super.empiler(t);
        Collections.sort(stk);
    }

    public boolean repOk(){
        return super.repOk() && isOrdered(super.stk);
    }
    
    // https://stackoverflow.com/questions/8931341/java-a-way-to-find-out-whether-collection-is-ordered-or-not
    public static <T extends Comparable<T>> boolean isOrdered(Iterable<T> list) {
        Iterator<T> i = list.iterator();
        if (i.hasNext()) {
            T previous = i.next();
            while (i.hasNext()) {
                T current = i.next();
                if (previous.compareTo(current) > 0)
                    return false;
                previous = current;
            }
        }
        return true;
    }
}
