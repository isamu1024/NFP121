package conditions;


public class ToutesLesConditionsSontSatisfaites<T> extends MacroCondition<T>{
   public boolean estSatisfaite(T t){
      if (conditions!=null && conditions.length==0) return false;// 
       
     for(Condition<T> condition : conditions){
       if(!condition.estSatisfaite(t)) return false;
     }
     
     return true;
    }
}
