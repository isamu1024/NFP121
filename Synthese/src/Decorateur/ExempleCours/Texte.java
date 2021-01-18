package Decorateur.ExempleCours;

public class Texte implements TexteI{
    private String texte;

    public Texte(String texte){
        this.texte = texte;
    }
    public String toHTML(){
        return this.texte;
    }
}
