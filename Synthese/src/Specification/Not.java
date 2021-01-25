package Specification;

public class Not<E> extends Specification<E> {

    protected Specification<E> spec;

    public Not(Specification<E> spec){
        this.spec = spec;
    }

    public Not(){}

    public void setSpec(Specification<E> spec){
        this.spec = spec;
    }

    public Specification<E> getSpec(){
        return this.spec;
    }

    @Override
    public boolean isSatisfiedBy(E e) {
        return !this.spec.isSatisfiedBy(e);
    }

    @Override
    public String interpreter() {
        return "not(" + spec + ")";
    }
}
