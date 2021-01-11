package question4;


public class VisiteurStringAvecSoustraction extends VisiteurString{

  public String visite(Soustraction a){
    return "(" + a.getOp1().accepter(this) + " - " + a.getOp2().accepter(this) + ")";
  }
  
}
