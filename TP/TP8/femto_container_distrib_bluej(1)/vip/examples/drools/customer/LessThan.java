package vip.examples.drools.customer;

import vip.rules.ICondition;
public class LessThan implements ICondition<Customer>{
    private int value; 
    public void setValue(int value){
        this.value = value;
    }
    public boolean isSatisfied(Customer customer){
        return customer.getYears()<value;
    }
  
}