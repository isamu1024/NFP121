package vip.examples.number;

import vip.rules.ICondition;

public class EstPair implements ICondition<Integer>{
 
    public boolean isSatisfied(Integer i){
      return (i%2)==0;
    }
}
