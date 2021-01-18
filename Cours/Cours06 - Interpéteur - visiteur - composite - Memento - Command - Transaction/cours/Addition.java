import java.util.*;

public class Addition extends Binaire
{
    public Addition(Expression op1, Expression op2){
        super(op1,op2); 
    }


    // public String interpreter(){
    // return "(" + op1.interpreter() + " , " + op2.interpreter() + ")+";
    // }

    // public void interpreter(Stack<Integer> stk){

    // op1.interpreter(stk);
    // op2.interpreter(stk);
    // stk.push(stk.pop() + stk.pop());

    // }

    public <T> T accepter(Visiteur<T> v){
        return v.visite(this);

    }
}
