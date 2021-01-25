package observer;

import java.util.Observable;
import java.util.Observer;

public class Nombre extends Observable {
    
    private int valeur;
    
    public int getValeur() {
     return this.valeur;   
    }
    
    public String toString() {
        return "<Nombre " + this.valeur + ">";
    }
    
    public void setObserver (Observer obs) {
        addObserver(obs);
    }
    
    public void setValeur(int valeur) {
        this.valeur = valeur;
        setChanged();
        notifyObservers(this);
    }
   
}
