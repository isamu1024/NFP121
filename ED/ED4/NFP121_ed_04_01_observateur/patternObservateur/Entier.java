package patternObservateur;

import java.util.Observable;

public class Entier extends Observable{
  private int valeur;

  public Entier(int valeur){
    this.valeur = valeur;
  }
  
  public void inc(){
    this.valeur++;
    setChanged();
    notifyObservers(valeur);
  }
  public void dec(){
    this.valeur--;
    setChanged();
    notifyObservers(valeur);
  }
  
  public int getValeur(){return this.valeur;}
  public void setValeur(int valeur){
    this.valeur = valeur;
    setChanged();
    notifyObservers(valeur);
  }

  public String toString(){
    return Integer.toString(this.valeur);
  }
  
  public String toString(int base){
    return Integer.toString(this.valeur, base);
  }
  
//   public boolean equals(Entier e){
//     return this.valeur == e.valeur;
//   }
  
  public boolean equals(Object obj){
    if(obj instanceof Entier){
      Entier e = (Entier) obj;
      return this.valeur == e.valeur;
    }
    return false;
  }
  
  public int hashCode(){
    return this.valeur;
  }
  
  public static Entier parseEntier(String s) throws NumberFormatException{
//     try{
      int valeur = Integer.parseInt(s);
      return new Entier(valeur);
//     }catch(NumberFormatException e){
//       throw e;
//     }
  }
}
