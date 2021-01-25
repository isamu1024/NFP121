package adapter;

import java.util.Collection;
import java.util.Iterator;

public class Adaptateur<E> implements PileI<E>{
    
   private Collection<E> collection;

    public Adaptateur(Collection<E> collection){
      this.collection = collection;
    }
    
    public Adaptateur(){}
    public void setCollection(Collection<E> collection){
      this.collection = collection;
    }

    public void empiler(E elt){
        collection.add(elt);
    }
    
    public E depiler(){
        if(estVide()) throw new RuntimeException("Pile vide, depiler...");
        Iterator<E> it = collection.iterator();
        while(it.hasNext()){
            E elt = it.next();
            if(!it.hasNext()){
                it.remove();
                return elt;
            }
        }
        return null; // unreachable ...
    }
    
    public boolean estVide(){
        return !collection.iterator().hasNext();
    }
}
