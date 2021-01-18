package Decorateur.ExempleTP;

/**
 *  Une boisson de base, héritant de la classe abstraite Beverage.
 */
public class Espresso extends Beverage {

    public Espresso(){
        super.description = "Espresso";
    }

    public double cost(){
        return 1.99;
    }
}
