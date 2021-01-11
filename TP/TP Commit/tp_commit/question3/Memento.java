package question3;

import question1.*;

import java.util.*;

public class Memento {
    // Note : Un usage du patron Memento,
    //        d’un premier visiteur pour la sauvegarde et
    //        d’un second pour la restitution du composite,
    //        représentent une solution possible.

    private GroupeDeContributeurs etats;

    public Memento(Cotisant c) {
        this.etats = new GroupeDeContributeurs("sauvegarde");
        VisiteurSauvegarde vs = new VisiteurSauvegarde();
        etats.ajouter(c.accepter(vs));
    }

    public void setState(Cotisant c) {
        VisiteurRestauration vr = new VisiteurRestauration(etats);
        c.accepter(vr);
    }
}