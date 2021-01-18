package Decorateur.ExempleTP;

/**
 * La classe de base pour les décorateurs
 */
public abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage; // l'objet Beverage qui sera décoré

    public CondimentDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription();
    }

    public double cost(){
        return beverage.cost();
    }

    public String toString(){
        return this.getDescription() + " $" + cost();
    }

}
