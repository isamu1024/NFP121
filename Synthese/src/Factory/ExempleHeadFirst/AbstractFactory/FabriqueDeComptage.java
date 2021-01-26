package Factory.ExempleHeadFirst.AbstractFactory;

import Factory.ExempleHeadFirst.*;
import Factory.ExempleHeadFirst.Decorateur.CompteurDeCouacs;

/**
 * Maintenant, créons la fabrique dont nous avons vraiment besoin,
 * la FabriqueDeComptage :
 */
public class FabriqueDeComptage extends FabriqueDeCanardsAbstraite {
    public Cancaneur creerColvert() {
        return new CompteurDeCouacs(new Colvert());
    }
    public Cancaneur creerMandarin() {
        return new CompteurDeCouacs(new Mandarin());
    }
    public Cancaneur creerAppelant() {
        return new CompteurDeCouacs(new Appelant());
    }
    public Cancaneur creerCanardEnPlastique() {
        return new CompteurDeCouacs(new CanardEnPlastique());
    }
}