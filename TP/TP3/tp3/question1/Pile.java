package question1;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer par votre classe Pile .
 * 
 * @author Alexandre Moro
 * @version 13/10/2020
 */

public class Pile {

    // D�finition d'une constante
    public final static int TAILLE_PAR_DEFAUT = 5;

    // le type de zone[] devient Object[]
    private Object[] zone;
    private int ptr;

    /**
     * Reprise de la m�thode fournie mais remplacement du type contenu dans le tableau zone[]
     */
    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    // Changement du type renvoy� par la m�thode empiler()
    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    // changement du type renvoy� par la m�thode depiler()
    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[this.ptr];
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }
    
    public String toString(Object o){
    
        return o.toString();
        
    }
    
    // Remplacement de (Integer.toString(zone[i])) par la m�thode
    // toString de l'objet contenu à l'index r�f�renc� de zone[]
    
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
}