package ensemble_exemple;

 

import java.util.TreeSet;
import java.util.SortedSet;
import java.util.Collections;
import java.util.Iterator;

public class EnsembleOrdonne extends Ensemble {

  public EnsembleOrdonne(){
    super();
  }
  public void ajouter(int i){
    super.ajouter(i);
    Collections.sort(super.liste);
  }
  public void ajouter(CollectionI c){
    for(int i : c) 
      this.ajouter(i);
  }

  public boolean repOk(){
    return super.repOk() && isSorted(super.liste);
  }
  public SortedSet<Integer> af(){
    return new TreeSet<Integer>(super.liste);
  }
  
   // http://stackoverflow.com/questions/3047051/how-to-determine-if-a-list-is-sorted-in-java
  private static <T extends Comparable<? super T>> 
                       boolean isSorted(Iterable<T> iterable) {
    Iterator<T> iter = iterable.iterator();
    if (!iter.hasNext()) {
        return true;
    }
    T t = iter.next();
    while (iter.hasNext()) {
        T t2 = iter.next();
        if (t.compareTo(t2) > 0) {
            return false;
        }
        t = t2;
    }
    return true;
  }
}
