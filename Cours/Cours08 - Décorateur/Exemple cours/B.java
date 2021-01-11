
/**
 * B est une décoration d'un texte brut
 */

public class B extends TexteDecore
{

    /**
     * Constructeur d'objets de classe B
     */
    public B(TexteI unTexte)
    {
        super(unTexte); // Voir classe abstraite
    }

    public String toHtml(){
        return "<b>" + super.toHtml()+ "<b>"; // La décoration
    }

}
