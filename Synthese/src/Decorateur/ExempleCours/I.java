package Decorateur.ExempleCours;

public class I extends TexteDecore {

    public I(TexteI unTexte){
        super(unTexte);
    }

    public String toHTML(){
        return "<I>" + super.toHTML() + "</I>";
    }

}
