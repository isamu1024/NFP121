package vip.instructions;


public abstract class Logical<M> extends Condition<M>{
  protected Condition<M> condition1;
  protected Condition<M> condition2;
  
  public void setCondition1(Condition<M> condition1){
      this.condition1 = condition1;
  }
  
  public void setCondition2(Condition<M> condition2){
      this.condition2 = condition2;
  }
  
}
