import java.util.*;

public class VisiteurPile extends Visiteur<Integer>
{
    private Stack<Integer> stk;
    
    public VisiteurPile(Stack<Integer> stk){
     this.stk = stk;
    }
    
    
    public Integer visite(Nombre n){
        stk.push(n.getValeur());
    return stk.peek();
    }

    public Integer visite(Addition a){
    a.getOp1().accepter(this);
    a.getOp2().accepter(this);
    stk.push(stk.pop() + stk.pop());
    
    return stk.peek();
    }
    
    

}