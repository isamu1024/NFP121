package conditions;

public class FAUX<T> implements Condition<T>{
   public boolean estSatisfaite(T t){
       return false;
    }
}