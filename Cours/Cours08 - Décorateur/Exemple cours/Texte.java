
public class Texte implements TexteI
{
    private String texte;
    public Texte( String texte){
        this.texte = texte;
    }

    public String toHtml(){
        return this.texte; // Le texte non décoré ne retourne que le texte brut
    }

}
