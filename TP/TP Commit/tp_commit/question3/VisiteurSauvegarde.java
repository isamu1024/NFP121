package question3;

import question1.Contributeur;
import question1.Cotisant;
import question1.GroupeDeContributeurs;
import question1.Visiteur;


public class VisiteurSauvegarde implements Visiteur<Cotisant> {

    @Override
    public Cotisant visite(Contributeur c) {

        return new Contributeur(c.nom(), c.solde());
    }

    @Override
    public Cotisant visite(GroupeDeContributeurs g) {
        GroupeDeContributeurs gSave = new GroupeDeContributeurs(g.nom());
        for (Cotisant c : g.getChildren())
            gSave.ajouter(c.accepter(this));

        return gSave;
    }
}
