package question4;


public class VisiteurStringAvecAddition extends VisiteurString{

  public String visite(Addition a){
    return "(" + a.getOp1().accepter(this) + " + " + a.getOp2().accepter(this) + ")";
  }
  
}