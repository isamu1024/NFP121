package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T> {
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacitÃ© de la pile */
    private int capacite;

    /**
     * Création d'une pile.
     * 
     * @param taille la "taille maximale" de la pile, doit Ã¨tre > 0
     */
    public Pile2(int taille) {
        if (taille <= 0)
            this.capacite = CAPACITE_PAR_DEFAUT;
        else
            this.capacite = taille;

        stk = new Stack<T>();

    }

    public Pile2() {
        this(0);
    }

    @Override
    public void empiler(T o) throws PilePleineException {
        if (stk.size() == this.capacite)
            throw new PilePleineException();
        this.stk.push(o);
    }

    @Override
    public T depiler() throws PileVideException {
        if (stk.size() == 0)
            throw new PileVideException();
        return stk.pop();
    }

    @Override
    public T sommet() throws PileVideException {
        if (stk.size() == 0)
            throw new PileVideException();
        return stk.peek();
    }

    @Override
    public int capacite() {
        return this.capacite;
    }

    @Override
    public int taille() {
        return stk.size();
    }

    @Override
    public boolean estVide() {
        return stk.empty();
    }

    @Override
    public boolean estPleine() {
        return stk.size() == this.capacite;
    }

    public String toString() {
        String s = "[";
        for (int i = taille() - 1; i >= 0; i--) {
            s += stk.get(i).toString();
            if (i != 0)
                s += ", ";
        }
        return s + "]";
    }

}