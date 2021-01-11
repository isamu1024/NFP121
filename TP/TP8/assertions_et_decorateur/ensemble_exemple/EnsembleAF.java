package ensemble_exemple;

import java.util.Set;
import java.lang.reflect.*;

public class EnsembleAF extends Decorateur{
  
  
  
  public EnsembleAF( CollectionI c){
    super(c);
  }
 
  public void ajouter(int i){
    Set<Integer> set = (Set<Integer>)super.af(); 
    assert set != null : " ajouter af invalide !";
    set.add(i);
    super.ajouter(i);
    assert super.af().equals(set) : " ajouter af invalide !";   
  }
  public void ajouter(CollectionI c){
    Set<Integer> set = (Set<Integer>)super.af(); 
    assert set != null : " ajouter af invalide !";
    for(int i : c) set.add(i);
    super.ajouter(c);
    assert super.af().equals(set) : " ajouter af invalide !";  
  }
  public void retirer(int i){
    Set<Integer> set = (Set<Integer>)super.af(); 
    assert set != null : " retirer af invalide !";
    set.remove(i);
    super.retirer(i);
    assert super.af().equals(set) : " retirer af invalide !";
  }
  public boolean contient(int i){
    Set<Integer> set = (Set<Integer>)super.af(); 
    assert set != null : " contient af invalide !";
    boolean res = super.contient(i);
    boolean res2 = set.contains(i);   
    assert res==res2 : " contient  invalide !";   
    return res;
  }
  public int taille(){
    Set<Integer> set = (Set<Integer>)super.af(); 
    assert set != null : " contient af invalide !";  
    int nombre = super.taille();
    int nombre2 = set.size();
    assert nombre==nombre2 : " contient af invalide !";
    return nombre;
  }
  public boolean equals(Object o){
    Set<Integer> set  = (Set<Integer>)super.af();
    Set<Integer> set2 = (Set<Integer>)((CollectionI)o).af();
    assert set != null && set2 != null : " contient af invalide !";
    boolean res  = super.equals(o);
    boolean res2 = set.equals(set2);
    assert res == res2 : " repOk invalide !";
    return res;
  }
  public int hashCode(){
    //assert super.repOk() : " repOk invalide !";      
    int res = super.hashCode();
    //assert super.repOk() : " repOk invalide !";
    return res;
  }
  public Object af(){ 
    //assert super.repOk() : " repOk invalide !";    
    Object res = super.af();
    //assert super.repOk() : " repOk invalide !"; 
    return res;
  }
}
