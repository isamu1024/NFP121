package question2;

import question1.*;

import java.util.Set;
import java.util.TreeSet;

public class SansDoublon implements Visiteur<Boolean> {

    Set<String> doublons = new TreeSet<>();

    public Boolean visite(Contributeur c) {
        return doublons.add(c.nom());
    }

    public Boolean visite(GroupeDeContributeurs g) {

        boolean result = doublons.add(g.nom()) ;

        for (Cotisant c : g.getChildren())
            result &= c.accepter(this);

        return result;
    }
}