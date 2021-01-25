package vip.instructions;

public class Not<M> extends Condition<M>{
  protected Condition<M> condition;
  
  public void setCondition(Condition<M> condition){
      this.condition = condition;
  }
  
  public boolean isSatisfied(M memory){
    return !(condition.isSatisfied(memory));
  }

}
