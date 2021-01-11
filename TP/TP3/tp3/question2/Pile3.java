package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Iterator;
import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author Alexandre Moro
 * @version 19/10/2020
 */

public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if (taille <= 0)
            v = new Vector<Object>(CAPACITE_PAR_DEFAUT);
        else
            v = new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        if (this.estPleine())
            throw new PilePleineException();
        else
            v.add(o);
    }

    public Object depiler() throws PileVideException {
        if (v.isEmpty())
            throw new PileVideException();
        return v.remove(v.size() - 1);
    }

    public Object sommet() throws PileVideException {
        if (this.estVide())
            throw new PileVideException();
        return v.lastElement();
    }

    public int taille() {
        return v.size();
    }

    public int capacite() {
        return v.capacity();
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return v.size() == v.capacity();
    }

    public String toString() {

        String s = "[";
        for (int i = taille() - 1; i >= 0; i--) {
            s += v.get(i).toString();
            if (i != 0)
                s += ", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {

        if (o instanceof Pile3) {
            Pile3 p = (Pile3) o;

            Iterator<Object> it = v.iterator();
            Iterator<Object> ito = p.v.iterator();

            boolean memeTaille = (p.taille() == this.taille());
            boolean memeCapacite = (p.capacite() == this.capacite());
            boolean sontVide = (p.estVide() && this.estVide());

            if (!memeTaille || !memeCapacite)
                return false;

            if (!sontVide) {

                while (it.hasNext()) {
                    if (it.next().hashCode() != ito.next().hashCode())
                        return false;
                }

                return true;
            }
            if (sontVide) {
                return true;
            }
            return false;
        }

        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
