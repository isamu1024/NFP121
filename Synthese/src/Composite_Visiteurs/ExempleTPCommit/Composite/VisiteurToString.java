package Composite_Visiteurs.ExempleTPCommit.Composite;

public class VisiteurToString implements Visiteur<String>{

    public String visite(Contributeur cpt){
        return "<Contributeur : (" + cpt.getNom() + ", " + cpt.getSolde() + ")>";
    }

    public String visite(GroupeDeContributeurs grp){
        String res = "<Groupe " + grp.getNom() + " : (";
        for (Cotisant c : grp)
            res = res + c.accepter(this);
        return res + ">";
    }
}
