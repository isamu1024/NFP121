public interface Collection<E> extends Iterable<E>
{

    boolean ajouter(E e);
    
    boolean ajouter(Collection<E> e);
    
    int taille();
    
    boolean retirer(E e);
    
}
