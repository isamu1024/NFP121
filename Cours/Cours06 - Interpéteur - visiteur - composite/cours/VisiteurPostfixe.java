public class VisiteurPostfixe extends Visiteur<String>
{
    public String visite(Nombre n){
    return Integer.toString(n.getValeur());
    }

    public String visite(Addition a){
    return ("(" + a.getOp1().accepter(this) + "," + a.getOp2().accepter(this) + ")+");
    }
    
    

}