public class Entier {

    private int valeur;
    
    public Entier(int valeur){
    this.valeur = valeur;
    }
    
    public void dec(){
    this.valeur--;
    }
    
    public static Entier parseEntier(String s) throws NumberFormatException {
    
        int valeur = Integer.parseInt(s);
        return new Entier(valeur);
       
    }
    
    public void inc(){
    this.valeur++;
    }
    
    public int getValeur() {
    return this.valeur;
    }
    
    public void setValue(){
    this.valeur = valeur; 
    }
    
    
    public boolean equals(Entier e){
        if (e != null)
            return this.valeur == e.getValeur();
        return false;
    }
    
    @Override
    public boolean equals(Object o){
      if(o instanceof Entier){
        return this.valeur == ((Entier)o).getValeur();
      }
      return false;
    }
    
    @Override
    public int hashCode() {
        Integer i = new Integer(valeur);
        assert valeur == i.hashCode();
        return this.valeur;
    }
    
    @Override
    public String toString(){
        return Integer.toString(this.valeur);
    }
    
  
    public String toString(int base){
        return Integer.toString(this.valeur, base);
    }
    
    
}