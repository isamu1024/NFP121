package ensemble_exemple;

 

import java.util.*;

public class EnsembleOrdonnePrePost extends EnsemblePrePost{

  protected boolean pre_ajouter(int i){
    return true;
  }
  protected boolean post_ajouter(int i){
    return estOrdonne();
  }
  
  public void ajouter(int i){
    // Eiffel, cofoja, etc ...
    assert super.pre_ajouter(i) | this.pre_ajouter(i);
    // pre_super ==> pre_sub   // page 176 Liskov 
    assert !super.pre_ajouter(i) | this.pre_ajouter(i) : "pre assertion ajouter invalide !";
    super.ajouter(i);
    // (pre_super && post_sub) ==> post_super Liskov
    assert !(super.pre_ajouter(i) & this.post_ajouter(i)) | super.post_ajouter(i) : "post assertion ajouter invalide !";
    // Eiffel
    assert this.post_ajouter(i) & super.post_ajouter(i) : "post assertion ajouter invalide !";
  }
  
  
  public EnsembleOrdonnePrePost( CollectionI c){
    super(c==c?pre_EnsembleOrdonnePrePost(c):null);
    assert c.repOk() : " repOk invalide !!!";
  }
  
  protected static CollectionI pre_EnsembleOrdonnePrePost( CollectionI c){
    assert pre_EnsemblePrePost(c)==c && c!= null : "pre assertion constructeur invalide !";
    return c;
  }
  
  protected boolean pre_ajouter(Collection c){
    return true;
  }
  protected boolean post_ajouter(CollectionI c){
    System.out.println("c : " +super.toString());
    return estOrdonne();
  }
  
  public void ajouter(CollectionI c){
    // Eiffel, cofoja, etc ...
    assert super.pre_ajouter(c) | this.pre_ajouter(c);
    // pre_super ==> post_sub   // page 176 Liskov 
    assert !super.pre_ajouter(c) | this.pre_ajouter(c) : "pre assertion ajouter invalide !";
    super.ajouter(c);
    // (pre_super && post_sub) ==> post_super Liskov   
    assert !(super.pre_ajouter(c) & this.post_ajouter(c)) | super.post_ajouter(c) : "post assertion ajouter invalide !";
    // Eiffel
    assert this.post_ajouter(c) & super.post_ajouter(c) : "post assertion ajouter invalide !";
  }
  
  
  protected boolean pre_retirer(int i){
    return true;
  }
  protected boolean post_retirer(int i){
    return estOrdonne();
  }
  
  public void retirer(int i){
    assert pre_retirer(i) | super.pre_retirer(i): "pre assertion retirer invalide !";
    assert !pre_retirer(i) | super.pre_retirer(i): "pre assertion retirer invalide !";
    super.retirer(i);
    // // (pre_super && post_sub) ==> post_super
    assert !(super.pre_retirer(i) & post_retirer(i)) | super.post_retirer(i);
    
    assert post_retirer(i) & super.post_retirer(i);

  }
  
  
  

  private boolean estOrdonne(){
    List<Integer> liste = new ArrayList<Integer>();
    Iterator<Integer> it = super.iterator();
    while(it.hasNext()){
      liste.add(it.next());
    }
    return isSorted(liste);
  }
  
  public boolean isCollectionSorted(List<Integer> list) {
    List<Integer> copy = new ArrayList<Integer>(list);
    Collections.sort(copy);
    return copy.equals(list);
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