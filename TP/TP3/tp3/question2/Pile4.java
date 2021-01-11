package question2;

import question1.PilePleineException;
import question1.PileVideException;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon maillon;
    /** la capacit� de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque �l�ment de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {

        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Cr�ation d'une pile.
     * 
     * @param taille la taille de la pile, la taille doit ètre > 0
     */

    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        maillon = null;
        capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        maillon = new Maillon(o, maillon);
        nombre++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        Maillon current = maillon;
        maillon = maillon.suivant();
        nombre--;
        return current.element();
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return maillon.element();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return nombre == 0;
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return capacite == nombre;
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la représentation
     * en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {

        String s = "[";

        Maillon tampon = maillon;

        while (tampon != null) {
            s += tampon.element().toString();
            if (tampon.suivant() != null)
                s += ", ";
            tampon = tampon.suivant();
        }

        return s + "]";
    }

    // public boolean equals(Object o) {
        // if (o instanceof PileI) {
            // PileI p = (PileI) o;
            // return this.capacite() == p.capacite()
            // && this.hashCode() == p.hashCode();
        // } else
            // return false;
    // }

    public boolean equals(Object o) {
        if (o instanceof Pile4) {
            Pile4 p = (Pile4) o;

            boolean memeTaille = (p.taille() == this.taille());
            boolean memeCapacite = (p.capacite() == this.capacite());
            boolean sontVide = (p.estVide() && this.estVide());

            if (!memeTaille || !memeCapacite)
                return false;

            if (!sontVide) {

                Maillon tampon = maillon;
                Maillon tamponP = p.maillon;

                while (tampon != null) {
                    if (tampon.element().hashCode() != tamponP.element().hashCode())
                        return false;
                    tampon = tampon.suivant();
                    tamponP = tamponP.suivant();
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

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}