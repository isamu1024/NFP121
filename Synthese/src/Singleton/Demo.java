package Singleton;

public class Demo {
    public static void main(String[] args) {

        // Recupération de l'instance unique
        SingletonObject object = SingletonObject.getInstance("1");

        // Affiche d'une méthode de l'instance
        object.getId();
        // ID : 1

        SingletonObject object1 = SingletonObject.getInstance("2");
        object1.getId();
        // ID : 1 -> une seule instance possible
    }
}
