package Decorateur.ExempleTP;

public abstract class Beverage {

    String description = "Unknown";

    public String getDescription(){
        return description;
    }

    public abstract double cost();

    public String toString(){
        return this.description + " $" + this.cost();
    }

}
