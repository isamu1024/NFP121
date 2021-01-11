package question4;


public class VisiteurString extends Visiteur<String>{

  public String visite(Nombre n){
    return Integer.toString(n.getValeur());
  }
  
}