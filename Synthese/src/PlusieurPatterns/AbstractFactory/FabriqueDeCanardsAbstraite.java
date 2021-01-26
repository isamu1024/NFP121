package PlusieurPatterns.AbstractFactory;

import PlusieurPatterns.Cancaneur;

/**
 * Un peu de contrôle qualité nous permettrait d’être certains que nos
 * canards sont bien enveloppés. Nous allons construire une fabrique
 * uniquement destinée à les créer. Comme la fabrique devra produire une
 * famille de produits composée de différents types de canards, nous allons
 * employer le pattern Fabrique abstraite.
 */
public abstract class FabriqueDeCanardsAbstraite {
    public abstract Cancaneur creerColvert();
    public abstract Cancaneur creerMandarin();
    public abstract Cancaneur creerAppelant();
    public abstract Cancaneur creerCanardEnPlastique();
}
