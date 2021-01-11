package question2;

import question1.Contributeur;
import question1.Cotisant;
import question1.GroupeDeContributeurs;
import question1.Visiteur;

import java.util.List;

public class CompositeValide implements Visiteur<Boolean> {
    // Le solde de chaque contributeur doit être supérieur ou égal à une valeur
    // et il n’existe pas de groupe n’ayant pas de contributeurs.
    private final int valeur;


    public CompositeValide(int valeur) {
        this.valeur = valeur;
    }

    public Boolean visite(Contributeur c) {
        return c.solde() >= this.valeur;
    }

    public Boolean visite(GroupeDeContributeurs g) {
        boolean result = !g.getChildren().isEmpty();

        for (Cotisant c : g.getChildren())
            result &= c.accepter(this);

        return result;
    }
}