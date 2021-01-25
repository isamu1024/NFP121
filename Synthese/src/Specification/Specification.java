package Specification;

/**
 * La classe abstraite Specification.
 * * @param <T> L'entité métier, immutable, sur laquelle porte la condition.
 */
public abstract class Specification<T> {

    /**
     * La condition à satisfaire.
     * * @param t le paramètre de la méthode
     */
    public abstract boolean isSatisfiedBy(T t);

    /**
     * Patron interpreter.
     * * @return une représentation textuelle de la condition/specification
     */
    public abstract String interpreter();
}

