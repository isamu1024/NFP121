package question1;

public class Entier{
 
  private int valeur;
  
  public Entier(int valeur){
    this.valeur = valeur;
  }
  
  public void setValeur(int valeur){
    this.valeur = valeur;
  }
  
  public void inc(int inc){
    this.valeur = valeur + inc;
  }
  
  private void plus(int v){
    this.valeur = this.valeur + v;
  }
  
  public Entier copie(){
    return new Entier(getValeur());
  }
  
  public int getValeur(){
    return this.valeur;
  }
  
  public String toString(){
    return Integer.toString(valeur);
  }
  public String toString(int base){
    return Integer.toString(valeur,base);
  }
  
  int plus1(){
    return valeur+1;
  }
  protected int moins1(){
    return valeur-1;
  }
  
}