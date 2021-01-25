package Specification;

public class True<E> extends Specification<E>{

    @Override
    public boolean isSatisfiedBy(E e) {
        return true;
    }

    @Override
    public String interpreter() {
        return "True";
    }
}
