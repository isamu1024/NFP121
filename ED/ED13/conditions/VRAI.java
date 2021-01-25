package conditions;


public class VRAI<T> implements Condition<T>{
   public boolean estSatisfaite(T t){
       return true;
    }
}
