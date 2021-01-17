package Composite;

public class VisiteurString extends Visiteur<String>{

    public String visite(Nombre n){
        return Integer.toString(n.getValeur());
    }

    public String visite(Addition a){
        return ("(" + a.getOp1().accepter(this) + " + " + a.getOp2().accepter(this) + ")");
    }

    public String visite(Soustraction s){
        return ("(" + s.getOp1().accepter(this) + " - " + s.getOp2().accepter(this) + ")");
    }

}
