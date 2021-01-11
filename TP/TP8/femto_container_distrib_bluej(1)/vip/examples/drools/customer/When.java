package vip.examples.drools.customer;

import vip.rules.ICondition;

public class When implements ICondition<Customer>{
    private final static boolean T = false;
//    private Customer.CustomerType type; 
//    public void setType(Customer.CustomerType type){
    private String type; 
    public void setType(String type){
        this.type = type;
    }
    public boolean isSatisfied(Customer customer){
        //return customer.getType().equals(Customer.CustomerType.INDIVIDUAL);
        if(T) System.out.println("When.isSatisfied: " + customer.getType() +"=="+type);
        return customer.getType().equals(type);
    }
  
}
