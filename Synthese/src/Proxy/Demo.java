package Proxy;

/**
 * https://fr.wikibooks.org/wiki/Patrons_de_conception/Proxy
 * Un proxy est une classe se substituant à une autre classe.
 * Par convention et simplicité, le proxy implémente la même interface que la classe à laquelle il se substitue.
 * L'utilisation de ce proxy ajoute une indirection à l'utilisation de la classe à substituer.
 * Le proxy sert à gérer l'accès à un objet, il agit comme un intermédiaire entre la classe utilisatrice et l'objet.
 */

public class Demo {
    public static void main(String[] args) {

        Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        Image image2 = new ProxyImage("HiRes_10MB_Photo2");
        Image image3 = new ProxyImage("HiRes_10MB_Photo3");

        image1.displayImage(); // chargement nécessaire
        image2.displayImage(); // chargement nécessaire
        image1.displayImage(); // pas de chargement nécessaire, déjà fait
        // la troisième image ne sera jamais chargée : pas de temps gaspillé

    }
}
