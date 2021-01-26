package Rules.Specification;

public class False<E> extends Specification<E> {


    @Override
    public boolean isSatisfiedBy(E e) {
        return false;
    }

    @Override
    public String interpreter() {
        return "FALSE";
    }
}
