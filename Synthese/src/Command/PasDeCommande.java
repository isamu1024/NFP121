package Command;

/**
 * L’objet PasDeCommande est un exemple d’objet null. Un objet null est
 * utile quand il n’y a pas d’objet significatif à retourner mais que vous ne
 * voulez pas laisser au client la responsabilité de gérer null.
 */
public class PasDeCommande implements Commande{
    public void executer(){}
}
