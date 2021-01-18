package Decorateur.ExempleCours;

/**
 * Classe Abstraite qui sert de base aux décorateurs
 */
public abstract class TexteDecore implements TexteI {
    private TexteI unTexte;

    public TexteDecore(TexteI unTexte){
        this.unTexte = unTexte;
    }

    public String toHTML(){
        return unTexte.toHTML();
    }
}
