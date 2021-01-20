package Composite_Visiteurs.ExempleTP;

public abstract class Expression {

    public <T> T accepter(Visiteur<T> v){
        return  v.visite(this);
    }

}
