package Decorateur.ExempleCours;

public class Demo {

    public static void main(String[] args) {
        TexteI t = new I(new B(new Texte("A decorer")));
        System.out.println(t.toHTML());

        // Autre exemple avec la notion d'interface commune.
        Texte t1 = new Texte("Texte seul");
        TexteDecore tDeco = new I(t1);
        System.out.println(t1.toHTML());
        System.out.println(tDeco.toHTML());
    }
}
