package pile_exemple;


public interface PileI<T> extends Cloneable{
    public final static int CAPACITE_PAR_DEFAUT=6;
    
    public void empiler(T t) throws PilePleineException;
    public T depiler() throws PileVideException;
    public T sommet()throws PileVideException;
    
    public boolean estVide();
    public boolean estPleine();
    public int taille();
    public int capacite();
    
    //cf. Liskov
    public boolean repOk(); // invariant de classe
    public <A> A af();      // A comme Abstrait
    
}
