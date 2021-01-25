package conditions;


public abstract class MacroCondition<T> implements Condition<T>{
  protected Condition<T>[] conditions;

   public void setConditions(Condition<T>[] conditions){
     this.conditions = conditions;
    }
    
}
