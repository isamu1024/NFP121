
/**
 * I est une décoration d'un texte brut
 */

public class I extends TexteDecore
{

    /**
     * Constructeur d'objets de classe B
     */
    public I(TexteI unTexte)
    {
        super(unTexte); // Voir classe abstraite
    }

    public String toHtml(){
        return "<I>" + super.toHtml()+ "<I>"; // La décoration
    }

}