package Composite_Visiteurs.ExempleTP;

public class VisiteurEvaluation  extends  Visiteur<Integer>{

    public int visite(Nombre n){
        return n.getValeur();
    }

    public int visite(Addition a){
        return a.getOp1().accepter(this) + a.getOp2().accepter(this);
    }

    public int visite(Soustraction s){
        return s.getOp1().accepter(this) - s.getOp2().accepter(this);
    }

}
