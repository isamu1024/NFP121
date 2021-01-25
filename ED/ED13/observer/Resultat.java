package observer;


public class Resultat {
   
    private int valeur;
    
    public int getValeur() {
     return this.valeur;   
    }
    
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
    public String toString() {
        return Integer.toString(valeur);
    }
}
