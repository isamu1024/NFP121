package question4;

public class Nombre extends Expression{
  private int valeur;
  public Nombre(int valeur){
    this.valeur = valeur;
  }
  public int getValeur(){
    return valeur;
  }
}