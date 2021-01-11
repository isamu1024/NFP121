package ensemble_exemple;



import java.util.Iterator;

public abstract class Decorateur implements CollectionI{
  private CollectionI c; // le décoré
  
  public Decorateur( CollectionI c){
    this.c = c;
  }
  public void ajouter(int i){
    c.ajouter(i);
  }
  public void ajouter(CollectionI cl){
    c.ajouter(cl);
  }
  public void retirer(int i){
    c.retirer(i);
  }
  public boolean contient(int i){
    return c.contient(i);
  }
  public int taille(){
    return c.taille();
  }

  public Iterator<Integer> iterator(){
    return c.iterator();
  }
  
  public boolean equals(Object o){
    return c.equals(o);
  }
  public String toString(){
    return c.toString();
  }
  
  public int hashCode(){
    return c.hashCode();
  }
  public boolean repOk(){
    return c.repOk();
  }

  public Object af(){
    return c.af();
  }
}
