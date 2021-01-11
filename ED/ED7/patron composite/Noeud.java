
/**
 * Décrivez votre classe Noeud ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Noeud extends Composant
{
    public Noeud(String nom){
        super(nom);
    }

    public int nombreDeNoeuds() {
        
        return 1;
    }

    public String interpreter() {

        return "Noeud:<" + this.getNom() + ">";

    }

    public <T> T accepter(Visiteur<T> visiteur) {

        return visiteur.visite(this);

    }

}
