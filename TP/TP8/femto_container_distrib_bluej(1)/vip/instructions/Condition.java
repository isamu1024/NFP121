package vip.instructions;

public abstract class Condition<M>{
 
  public abstract boolean isSatisfied(M memory);
  
    public <T> T accept(Visitor<T> visitor){
      return visitor.visit(this);
    }

}
