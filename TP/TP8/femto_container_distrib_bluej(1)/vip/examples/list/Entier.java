package vip.examples.list;


public class Entier implements Comparable<Entier>,java.io.Serializable{
    private int valeur;
    
    public Entier(){}
    public Entier(int valeur){
        this.valeur = valeur;
    }
    public void setValeur(int valeur){
        this.valeur = valeur;
    }
    
    public boolean equals(Object o){
      if(o instanceof Entier){
          Entier e = (Entier)o;
          return e.valeur==valeur;
      }
      return false;
    }
    public String toString(){
        return Integer.toString(this.valeur);
    }
    public int hashCode(){return this.hashCode();}
    
    public int compareTo(Entier e){
        return new Integer(valeur).compareTo(e.valeur);
    }
    
}
