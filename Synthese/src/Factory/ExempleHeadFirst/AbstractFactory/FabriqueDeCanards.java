package Factory.ExempleHeadFirst.AbstractFactory;

import Factory.ExempleHeadFirst.*;

/**
 * FabriqueDeCanards étend
 * la fabrique abstraite.
 * Chaque méthode crée un produit : un type
 * particulier de Cancaneur. Le simulateur ne
 * connaît pas le produit réel – il sait seulement
 * qu’il reçoit un Cancaneur.
 */
public class FabriqueDeCanards extends FabriqueDeCanardsAbstraite {
    public Cancaneur creerColvert() {
        return new Colvert();
    }
    public Cancaneur creerMandarin() {
        return new Mandarin();
    }
    public Cancaneur creerAppelant() {
        return new Appelant();
    }
    public Cancaneur creerCanardEnPlastique() {
        return new CanardEnPlastique();
    }
}