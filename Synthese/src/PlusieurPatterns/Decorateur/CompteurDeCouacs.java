package PlusieurPatterns.Decorateur;

import PlusieurPatterns.Cancaneur;

/**
 * Nous allons faire le bonheur de ces cancanologues et leur
 * permettre de compter des couacs.
 * Comment ? Attribuons aux canards un nouveau comportement (la
 * capacité de compter) en les enveloppant dans un objet décorateur. Il
 * n’y aura absolument rien à changer dans le code de Canard.
 */
public class CompteurDeCouacs implements Cancaneur {
    static int nombreDeCouacs;  // Et comme nous comptons TOUS les couacs, nous utilisons une variable statique pour les mémoriser.
    Cancaneur canard; //Nous avons une variable d’instance pour le cancaneur que nous décorons.

    public CompteurDeCouacs(Cancaneur canard) {
        this.canard = canard;
    }

    /**
     * Nous ajoutons une autre méthode au
     * décorateur. Cette méthode statique
     * se contente de retourner le nombre de
     * couacs émis par tous les Cancaneurs.
     *
     * @return le nombre de couacs
     */
    public static int getCouacs() {
        return nombreDeCouacs;
    }

    /**
     * Quand cancaner() est appelée, nous déléguons
     * l’appel au Cancaneur que nous décorons…
     * ... puis nous incrémentons le nombre de couacs.
     */
    public void cancaner() {
        canard.cancaner();
        nombreDeCouacs++;
    }
}
