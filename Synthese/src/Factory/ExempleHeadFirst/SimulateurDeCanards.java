package Factory.ExempleHeadFirst;

import Factory.ExempleHeadFirst.AbstractFactory.FabriqueDeCanardsAbstraite;
import Factory.ExempleHeadFirst.AbstractFactory.FabriqueDeComptage;
import Factory.ExempleHeadFirst.Adaptateur.AdaptateurDOie;
import Factory.ExempleHeadFirst.Decorateur.CompteurDeCouacs;

public class SimulateurDeCanards {
    /**
     * Nous créons d’abord la
     * fabrique que nous allons
     * transmettre dans la
     * méthode simuler().
     * @param args
     */
    public static void main(String[] args) {
        SimulateurDeCanards simulateur = new SimulateurDeCanards();
        FabriqueDeCanardsAbstraite fabriqueDeCanards = new FabriqueDeComptage();
        simulateur.simuler(fabriqueDeCanards);
    }

    /**
     * La méthode simuler() accepte
     * FabriqueDeCanardsAbstraite
     * et l’utilise pour créer des canards au
     * lieu de les instancier directement.
     * @param fabriqueDeCanards la fabrique magique des canards
     */
    void simuler(FabriqueDeCanardsAbstraite fabriqueDeCanards) {
        Cancaneur colvert = fabriqueDeCanards.creerColvert();
        Cancaneur mandarin = fabriqueDeCanards.creerMandarin();
        Cancaneur appelant = fabriqueDeCanards.creerAppelant();
        Cancaneur canardEnPlastique = fabriqueDeCanards.creerCanardEnPlastique();
        Cancaneur canardOie = new AdaptateurDOie(new Oie());
        System.out.println("\nSimulateur de canards : avec Fabrique abstraite");
        simuler(colvert);
        simuler(mandarin);
        simuler(appelant);
        simuler(canardEnPlastique);
        simuler(canardOie);
        System.out.println("Nous avons compté " +
                CompteurDeCouacs.getCouacs() + "couacs");
    }

    void simuler(Cancaneur canard) {
        canard.cancaner();
    }
}