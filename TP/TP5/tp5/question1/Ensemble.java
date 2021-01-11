package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {
        // Ã  compléter pour la question1-1
        if (this.contains(t))
            return false;
        else {
            return this.table.add(t);
        }
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        // utilisation de la methode addAll() de la classe abstraite AbstractSet<T>
        Ensemble<T> e1 = new Ensemble<T>();
        
        e1.addAll(this);

        e1.addAll(e);

        return e1;
    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
        // utilisation de la methode retainAll() de la classe abstraite AbstractSet<T>
        Ensemble<T> e1 = new Ensemble<T>();
        e1.addAll(this);

        e1.retainAll(e);

        return e1;
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        // utilisation de la methode retainAll() de la classe abstraite AbstractSet<T>
        Ensemble<T> e1 = new Ensemble<T>();
        e1.addAll(this);

        e1.removeAll(e);

        return e1;
    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) {
        // il s'agit en fait de l'union - l'intersection

        return (this.union(e).diff(this.inter(e)));
    }

}
