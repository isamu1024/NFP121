package vip.rules;


public class False implements ICondition<Object>{
  
  public boolean isSatisfied(Object context){
     return false;
  }
  public String toString(){return "false";}
}