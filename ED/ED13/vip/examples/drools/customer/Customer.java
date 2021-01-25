package vip.examples.drools.customer;

// https://www.baeldung.com/drools-excel
//    Individual customers with greater than 3 years get 15% discount
//    Individual customers with less than 3 years get 5% discount
//    All business customers get 20% discount

public class Customer {
    public final static String INDIVIDUAL = "INDIVIDUAL";
    public final static String BUSINESS = "BUSINESS";
    
    //private CustomerType type; non supporté par vip ?
    private String type; 
    private int years;
    private int discount;
    
    public Customer(String type, int years){
    
        this.type = type;
        this.years = years;
    }
 
    public Customer(){}
    //public CustomerType getType(){return this.type;}
    public String getType(){return this.type;}
 
    public void setYears( int years){
        this.years = years;
    }
    public int getYears(){ return this.years;}
    
    public void setDiscount( int discount){
        this.discount = discount;
    }
    public int getDiscount(){ return this.discount;}
    
    
    public enum CustomerType {
        INDIVIDUAL,
        BUSINESS;
        
    }
}