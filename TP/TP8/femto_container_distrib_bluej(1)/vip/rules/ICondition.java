package vip.rules;


public interface ICondition<C>{
 
  public boolean isSatisfied(C context);
}