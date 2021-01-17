package Factory;

public class Demo {

    public static void main(String[] args) {

        //init de la factory
        ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("Cercle");
        shape1.draw();
        // output : Factory --> cercle

        Shape shape2 = factory.getShape("Rectangle");
        shape2.draw();
        // output : Factory --> Rectangle

        Shape shape3 = factory.getShape("Carre");
        shape3.draw();
        //Output : Factory --> carre

    }
}
