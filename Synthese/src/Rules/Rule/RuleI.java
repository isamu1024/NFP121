package Rules.Rule;

import Rules.Command.Command;
import Rules.Specification.Specification;

public interface RuleI<E,R> {
    /**
     * Exécution d'une règle de type if/then/else.
     * @param e l'entité sur laquelle porte la condition
     * @param r la donnée transmise
     * @return si la condition n'est pas satisfaite la donnée transmise est retournée,
     * sinon le résultat de l'exécution de la commande est retourné.
     * */

    public R execute(E e, R r) throws Exception;

    /**
     * Acceptation d'un visiteur
     * @param visitor le type de visite
     * @return le résultat de la visite
     */

    public <T> T accept(Visitor<T> visitor);

    // accesseurs
    public Specification<E> getSpecification();
    public Command<R> getCommand();
}
