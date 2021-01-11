import java.util.*;

public abstract class AbstractCollection<E> implements Collection<E>
{
    public int taille(){
        int compteur = 0;
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()){
            iterator.next(); // on passe au prochain
            compteur++;
        }

        // Autre écriture
        // for (E e : this){
        //    compteur++;
        //}

        return compteur;

    }

    public boolean ajouter(Collection<E> e){

        boolean modifie = false;
        Iterator<E> iterator = e.iterator();

        while(iterator.hasNext()) {
            if (ajouter(iterator.next()))
                modifie = true;

        }

        return modifie;
    }

    public boolean retirer(E e){
        assert e != null; // On gere le cas null

        boolean modifie = false;
        Iterator<E> iterator = this.iterator();

        while(iterator.hasNext()) {
            if (iterator.next().equals(e)){
                iterator.remove();
                modifie = true;
            }
        }

        return modifie;
    }

    public abstract boolean ajouter(E e);

    public abstract Iterator<E> iterator();
}
