package Persistance.ExempleTPCommit;

import Composite_Visiteurs.ExempleTPCommit.Composite.Contributeur;
import Composite_Visiteurs.ExempleTPCommit.Composite.Cotisant;
import Composite_Visiteurs.ExempleTPCommit.Composite.GroupeDeContributeurs;
import Composite_Visiteurs.ExempleTPCommit.Composite.Visiteur;
import org.jdom.*;

/**
 * Exemple d'utilisation d'un visiteur pour générer un fichier XML d'une structre composite
 */
public class VisiteurToXML implements Visiteur<Element> {

    public VisiteurToXML(){}

    @Override
    public Element visite(Contributeur c) {
        Element elt = new Element("contributeur");
        elt.setAttribute("nom", c.getNom());
        elt.setAttribute("solde", Integer.toString(c.getSolde()));
        return elt;
    }

    @Override
    public Element visite(GroupeDeContributeurs g) {
        Element elt = new Element("groupe");
        elt.setAttribute("nom", g.getNom());
        elt.setAttribute("solde", Integer.toString(g.getSolde()));

        for (Cotisant c : g.getChildren()){
            elt.addContent(c.accepter(this));
        }
        return elt;
    }
}
