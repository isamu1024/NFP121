package ensemble_exemple;

import java.util.*;

public class EnsembleOrdonneAF extends EnsembleAF{
  
  public EnsembleOrdonneAF( CollectionI c){
    super(c);
  }
   @Override
  public void ajouter(int i){
    assert isSorted(this) : " ajouter af invalide !";
    super.ajouter(i);
    assert isSorted(this) : " ajouter af invalide !";   
  }
  public void ajouter(CollectionI c){
    assert isSorted(this) : " ajouter af invalide !";
    super.ajouter(c);
    assert isSorted(this) : " ajouter af invalide !";  
  }
  public void retirer(int i){
    assert isSorted(this) : " retirer af invalide !";
    super.retirer(i);
    assert isSorted(this) : " retirer af invalide !";
  }
  public boolean contient(int i){
    assert isSorted(this) : " contient af invalide !";
    boolean res = super.contient(i);
    assert isSorted(this) : " contient  invalide !";   
    return res;
  }
  public int taille(){
    assert isSorted(this) : " contient af invalide !";  
    int nombre = super.taille();
    assert isSorted(this) : " contient af invalide !";
    return nombre;
  }
  public boolean equals(Object o){
    assert isSorted(this) : " contient af invalide !";
    boolean res  = super.equals(o);
    assert isSorted(this) : " repOk invalide !";
    return res;
  }
  public int hashCode(){
    assert isSorted(this) : " hashCode af invalide !";      
    int res = super.hashCode();
    assert isSorted(this) : " repOk invalide !";
    return res;
  }
  public Object af(){ 
    //assert super.repOk() : " repOk invalide !";    
    Object res = super.af();
    //assert super.repOk() : " repOk invalide !"; 
    return res;
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
