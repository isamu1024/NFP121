import java.util.*;

public class VisiteurInst extends Visiteur<String>
{
    // private Stack<Integer> stk;

    // public VisiteurPile(Stack<Integer> stk){
    // this.stk = stk;
    // }

    public String visite(Nombre n){
        // stk.push(n.getValeur());
        return "empiler(" + n.getValeur() + ");\n";
    }

    public String visite(Addition a){
        return a.getOp1().accepter(this) +
               a.getOp2().accepter(this) + 
               "add;\n";
    }


}