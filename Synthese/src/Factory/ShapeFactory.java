package Factory;


/**
 * La "fabrique"
 */
public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType == null)
            return null;

        if (shapeType.equals("Cercle"))
            return new Circle();

        else if (shapeType.equals("Rectangle"))
            return new Rectangle();

        else if (shapeType.equals("Carre"))
            return new Square();

        return null;
    }

}
