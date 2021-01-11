public class Entier {
    private int valeur;
    
    
    public Entier(int valeur){
        this.valeur = valeur;
    }

    public void inc(){
        if(valeur==Integer.MAX_VALUE)
            throw new RuntimeException("MAX_VALUE atteinte...");
        this.valeur++;
    }

    public void dec(){
        if(valeur==Integer.MIN_VALUE) 
            throw new RuntimeException("MIN_VALUE atteinte...");
        this.valeur--;
    }

    public void setValeur(int valeur){

        this.valeur = valeur;
    }

    public Memento saveToMemento() { 

        return new Memento(this);
    }

    public void restoreFromMemento(Memento m) {

        this.valeur = m.getSavedState();
    }

    public int getValeur(){

        return this.valeur;
    }

    public String toString(){

        return "<Entier:" + valeur +">";

    }
}