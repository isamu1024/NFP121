package ensemble_exemple;

import java.util.*;

public class Ensemble implements CollectionI {
  protected List<Integer> liste;
  
  public Ensemble(){
    this.liste = new ArrayList<Integer>();
  }
  
  public void ajouter(int i){
    if(!contient(i)) liste.add(i);
  }
  public void ajouter(CollectionI e){
    for(int i : e)
      ajouter(i);
  }
  public void retirer(int i){
    liste.remove(new Integer(i));
  }
  public int taille(){
    return liste.size();
  }
  public boolean contient(int i){
    return liste.contains(i);
  }

  public Iterator<Integer> iterator(){
    return liste.iterator();
  }

  public String toString(){
    return liste.toString();
  }
  
  public boolean equals(Object o){
    if(!(o instanceof CollectionI)) return false;
    CollectionI c = (CollectionI)o;
    if(this.taille()!=c.taille())return false;
    for(int i : this)
      if(!(c.contient(i)))return false;
    
    return true;
  }
  public int hashCode(){
    return this.af().hashCode();
  }
  public  Set<Integer> af(){ 
    return new HashSet<Integer>(this.liste);
  }
 
  public boolean repOk(){
    // pas de doublons
      int[] t = new int[taille()];
      int index = 0;
      for(Integer i : this){
        t[index] = i;
        index++;
      }
      for ( int i=0; i<t.length; i++ ) 
        for ( int j=i+1; j<t.length; j++ )
          if ( t[i] == t[j] )
            return false;
            
      return true;

  }
  

}
