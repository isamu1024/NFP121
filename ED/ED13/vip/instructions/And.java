package vip.instructions;

public class And<M> extends Logical<M>{

  public boolean isSatisfied(M memory){
    return condition1.isSatisfied(memory) && condition2.isSatisfied(memory);
  }
  

}
