package PlusieurPatterns;

import PlusieurPatterns.AbstractFactory.FabriqueDeCanardsAbstraite;
import PlusieurPatterns.AbstractFactory.FabriqueDeComptage;
import PlusieurPatterns.Adaptateur.AdaptateurDOie;
import PlusieurPatterns.Composite.Troupe;
import PlusieurPatterns.Decorateur.CompteurDeCouacs;


public class SimulateurDeCanards {

    public static void main(String[] args) {
        SimulateurDeCanards simulateur = new SimulateurDeCanards();
        FabriqueDeCanardsAbstraite fabriqueDeCanards = new FabriqueDeComptage();
        simulateur.simuler(fabriqueDeCanards);
    }

    void simuler(FabriqueDeCanardsAbstraite fabriqueDeCanards) {
        Cancaneur mandarin = fabriqueDeCanards.creerMandarin();
        Cancaneur appelant = fabriqueDeCanards.creerAppelant();
        Cancaneur canardEnPlastique = fabriqueDeCanards.creerCanardEnPlastique();
        Cancaneur canardOie = new AdaptateurDOie(new Oie());
        System.out.println("\nSimulateur de canards : avec Composite - Troupes");
        Troupe troupeDeCanards = new Troupe();
        troupeDeCanards.add(mandarin);
        troupeDeCanards.add(appelant);
        troupeDeCanards.add(canardEnPlastique);
        troupeDeCanards.add(canardOie);
        Troupe troupeDeColverts = new Troupe();
        Cancaneur colvertUn = fabriqueDeCanards.creerColvert();
        Cancaneur colvertDeux = fabriqueDeCanards.creerColvert();
        Cancaneur colvertTrois = fabriqueDeCanards.creerColvert();
        Cancaneur colvertQuatre = fabriqueDeCanards.creerColvert();
        troupeDeColverts.add(colvertUn);
        troupeDeColverts.add(colvertDeux);
        troupeDeColverts.add(colvertTrois);
        troupeDeColverts.add(colvertQuatre);
        troupeDeCanards.add(troupeDeColverts);
        System.out.println("\nSimulateur de canards : Toute la troupe");
        simuler(troupeDeCanards);
        System.out.println("\nSimulateur de canards : Troupe de colverts");
        simuler(troupeDeColverts);
        System.out.println("\nNous avons compté " +
                CompteurDeCouacs.getCouacs() + " couacs");
    }

    void simuler(Cancaneur canard) {
        canard.cancaner();
    }
}
