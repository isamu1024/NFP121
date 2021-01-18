package Decorateur.ExempleTP;

public class Demo {

    public static void main(String[] args) {
        Beverage chocolatLait = new Milk( new Chocolate()) ;
        System.out.println(chocolatLait.cost());
        System.out.println(chocolatLait.getDescription());
    }
}
