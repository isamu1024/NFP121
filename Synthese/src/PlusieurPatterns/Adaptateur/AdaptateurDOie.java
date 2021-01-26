package PlusieurPatterns.Adaptateur;

import PlusieurPatterns.Cancaneur;
import PlusieurPatterns.Oie;

/**
 * Notre simulateur s’attend à voir des interfaces Cancaneur. Comme
 * les oies ne cancanent pas (elles cacardent), nous pouvons utiliser
 * un adaptateur pour adapter une oie à un canard.
 */
public class AdaptateurDOie implements Cancaneur {
    Oie oie;

    public AdaptateurDOie(Oie oie) {
        this.oie = oie;
    }

    public void cancaner() {
        oie.cacarder();
    }
}
