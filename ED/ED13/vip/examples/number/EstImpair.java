package vip.examples.number;


import vip.rules.ICondition;

public class EstImpair implements ICondition<Integer>{
 
    public boolean isSatisfied(Integer i){
      return (i%2)!=0;
    }
}
