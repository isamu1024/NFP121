package conditions;



public class UneConditionEstSatisfaite<T> extends MacroCondition<T>{
 
    public boolean estSatisfaite(T t){
        for(Condition<T> condition : conditions){
            if(condition.estSatisfaite(t)) return true;
        }
        return false;
    }
}
