package Rules.Rule;

import Rules.Command.Command;
import Rules.Specification.Specification;

public class Rule<E,R> implements RuleI<E,R>{
    protected Specification<E> specification;
    protected Command<R> command;

    public Rule(Specification<E> specification, Command<R> command){
        this.specification = specification;
        this.command = command;
    }

    public Rule(){};

    public void setSpecification(Specification<E> specification) {
        this.specification = specification;
    }

    public void setCommand(Command<R> command) {
        this.command = command;
    }

    @Override
    public Specification<E> getSpecification() {
        return specification;
    }

    @Override
    public Command<R> getCommand() {
        return command;
    }

    public R execute(E e, R r) throws Exception{
        if (specification.isSatisfiedBy(e))
            return command.execute(r);
        return r;
    }

    public <T> T accept(Visitor<T> visitor){
        return visitor.visit(this);
    }
}
