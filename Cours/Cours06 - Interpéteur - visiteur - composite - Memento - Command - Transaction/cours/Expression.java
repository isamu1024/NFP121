import java.util.*;

public abstract class Expression {

    //public abstract void interpreter(Stack<Integer> stk);
    public abstract <T> T accepter(Visiteur<T> v);
    
};