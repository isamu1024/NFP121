import java.util.*;

public class Nombre extends Expression
{

    private int valeur;

    public Nombre(int valeur)
    {
        this.valeur = valeur;
    }

    public <T> T accepter(Visiteur<T> v){
    
        return v.visite(this);
    }
    
    public int getValeur(){
        return valeur;
    }
    
    
}
