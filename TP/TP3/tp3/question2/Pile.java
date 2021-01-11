package question2;
import java.util.Iterator;
import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author Alexandre Moro
 * @version 22/10/2020
 */
public class Pile implements PileI {

    // zone[] est maintenant de type déclare Object[]
    private Object[] zone;
    private int ptr;

    // si la taille est inférieure ou égale Ã  0 on appelle la constante CAPACITE_PAR_DEFAUT
    public Pile(int taille) {

        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;

        this.zone = new Object[taille];
        this.ptr = 0;

    }
 
    public Pile() {
        this(0);
    }

    // On empile désormais des "Object" au lieu de int
    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    // Idem pour depiler() qui retourne un "Object" au lieu d'un int
    public Object depiler() throws PileVideException {

        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[this.ptr];

    }

    /**
     * Retourne retourne le sommet de la pile (sans dÃ©piler).
     * Index du sommet = (ptr - 1) ou la fonction taille() -1
     */

    public Object sommet() throws PileVideException  {
        if (estVide())
            throw new PileVideException();
        return zone[this.taille()-1];
    }

    /**
     * Retourne le nombre maximal d'Ã©lÃ©ments que l'on peut empiler.
     */
    public int capacite() {
        // Ã  compléter
        return zone.length;
    }

    /**
     * Retourne le nombre d'Ã©lï¿½ments prÃ©sents dans cette pile
     */

    public int taille() {
        return ptr;
    }

    public boolean estVide() {
        return taille() == 0 ? true : false;
    }

    public boolean estPleine() {
        return taille() == capacite() ? true : false;
    }

    public boolean equals(Object o) {

        if (o instanceof Pile) {
            Pile p = (Pile)o; 

            boolean memeTaille = (p.taille() == this.taille());
            boolean memeCapacite = (p.capacite() == this.capacite());
            boolean sontVide = (p.estVide() && this.estVide());

            if( !memeTaille || !memeCapacite )
                return false;

            if (!sontVide) {
                
                for (int i = 0; i < taille(); i++) {
                    if (this.atIndex(i).hashCode() == p.atIndex(i).hashCode() == false)
                        return false;
                }
                
                return true;

            }

            if (sontVide) {
                return true;
            }

        } 
        return false;
    }
    
    // fonction fournie
    // String, for example, overrides the hashCode implementation in Object to return a hash of some 
    // or all of the characters making up the String. This allows two String objects with the same characters 
    // in the same order to return the same hash value. Dimension uses the hashCode method provided by Object
    public int hashCode() {
        return toString().hashCode();
    }
    
    public Object atIndex(int index) {
    return this.zone[index];
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append((zone[i]).toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
    public Iterator<Object> iterator() {
        return new pileIterator();
    }
    
    
    public class pileIterator implements Iterator<Object> {
    
        private int index = 0;
        
        public boolean hasNext() {
            return index < taille();
        }
        
        public Object next(){
            
            Object o = zone[index];
            index++;
            return o;
        }
    
    }
    
}