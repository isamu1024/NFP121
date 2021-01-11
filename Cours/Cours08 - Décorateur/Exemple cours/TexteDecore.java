
public abstract class TexteDecore implements TexteI
{
    private TexteI unTexte; // affecté à la création de la classe abstraite

    public TexteDecore(TexteI unTexte){
        this.unTexte = unTexte;
    }

    public String toHtml(){
        return unTexte.toHtml(); // aucune décoration
    }
}
