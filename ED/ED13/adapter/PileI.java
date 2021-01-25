package adapter;



public interface PileI<E>{
    
  public void empiler(E elt);
  public E depiler();
  
  public boolean estVide();
  
}
