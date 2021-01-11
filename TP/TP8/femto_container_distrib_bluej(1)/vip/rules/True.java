package vip.rules;


public class True implements ICondition<Object>{
  
  public boolean isSatisfied(Object context){
     return true;
  }
  public String toString(){return "true";}
}
