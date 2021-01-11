package question4;


public class VisiteurEvaluation extends Visiteur<Integer>{
    
    public int visite(Nombre n){
    return n.getValeur();
  }

  public int visite(Addition a){
    return a.getOp1().accepter(this) + a.getOp2().accepter(this);
  }
  
  public int visite(Soustraction a){
    return a.getOp1().accepter(this) - a.getOp2().accepter(this);
  }
  
}
