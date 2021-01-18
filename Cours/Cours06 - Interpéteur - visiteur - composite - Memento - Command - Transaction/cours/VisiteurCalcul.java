
public class VisiteurCalcul extends Visiteur<Integer>
{
    public Integer visite(Nombre n){
    return n.getValeur();
    }

    public Integer visite(Addition a){
    return a.getOp1().accepter(this) + a.getOp2().accepter(this);
    }
    
    

}
