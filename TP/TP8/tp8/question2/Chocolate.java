package question2;

/**
 * extrait de http://www.oreilly.com/catalog/hfdesignpat/
 */
public  class Chocolate  extends Beverage {

    public Chocolate() {
        super.description = "Chocolate";
    }

    public double cost() {
        return 2.10;
    }

}

