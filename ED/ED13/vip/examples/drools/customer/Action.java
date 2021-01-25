package vip.examples.drools.customer;

import vip.rules.ICommand;
public class Action implements ICommand<Customer,Customer>{
    private static final boolean T = true; // false
    private int discount;
    public void setDiscount(int discount){
        this.discount = discount;
    }
    public Customer execute(Customer c, Customer customer){
        if(T) System.out.println("Action.execute: customer.setDiscount("+discount+");");
        customer.setDiscount(discount);
        return customer;
    }
        
}
