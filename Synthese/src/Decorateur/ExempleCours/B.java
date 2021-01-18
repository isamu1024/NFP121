package Decorateur.ExempleCours;

/**
 *  Un exemple de décorateur
 */
public class B extends TexteDecore {

    public B(TexteI unTexte) {
        super(unTexte);
    }

    public String toHTML() {
        return "<B>" + super.toHTML() + "</B>"; // Appel de la méthode générale, décorée
    }

}
