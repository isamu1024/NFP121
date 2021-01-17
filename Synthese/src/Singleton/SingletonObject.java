package Singleton;

/**
 * Ce pattern s'assure qu'un et un seul objet de ce type est instancié.
 * La classe dispose d'un constructeur privé, et dipose d'une variable d'instance statique stockant l'objet lui même une fois créé.
 * Cet variable est accessible même si l'objet n'est pas instancié.
 */
public class SingletonObject {

    // instanciation de l'objet.
    private static SingletonObject instance;
    public String id;

    // Constructeur privé empêchant le "new"
    private SingletonObject(String value){
        this.id = value;
    };

    // Récupération de l'instance unique
    public static SingletonObject getInstance(String value){
        if (instance == null)
            instance = new SingletonObject(value);
        return instance;
    }

    // Un message de l'instance
    public void getId(){
        System.out.println("ID : " + this.id);
    }

}
