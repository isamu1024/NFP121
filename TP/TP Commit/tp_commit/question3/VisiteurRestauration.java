package question3;

import question1.Contributeur;
import question1.Cotisant;
import question1.GroupeDeContributeurs;
import question1.Visiteur;

import java.util.List;

public class VisiteurRestauration implements Visiteur<Void> {

    private final GroupeDeContributeurs sauvegarde;

    public VisiteurRestauration(GroupeDeContributeurs sauvegarde) {
        this.sauvegarde = sauvegarde;

    }

    @Override
    public Void visite(Contributeur c) {

        for (Cotisant cotisant : sauvegarde) {
            if (cotisant.equals(c))
                c.affecterSolde(cotisant.solde());
        }

        return null;

    }

    @Override
    public Void visite(GroupeDeContributeurs g) {
        for (Cotisant c : g.getChildren())
            c.accepter(this);

        return null;
    }
}
