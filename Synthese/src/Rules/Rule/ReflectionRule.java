package Rules.Rule;

import Rules.Command.Command;
import Rules.Specification.Specification;

import java.lang.reflect.Method;

public class ReflectionRule<E, R> extends Rule<E, R> {

    public void setSpecification(String spec) {
        try {
            Class<?> cl = Class.forName(spec);
            Specification<E> s = (Specification<E>) cl.getDeclaredConstructor().newInstance();
            super.specification = s;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCommand(String cmd) {
        try {
            Class<?> cl = Class.forName(cmd);
            Command<R> c = (Command<R>) cl.getDeclaredConstructor().newInstance();
            super.command = c;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public R execute(E e, R r) throws Exception {
        Method specificationMethod = null;
        Method commandMethod = null;

        if (this.specification != null)
            specificationMethod = this.specification.getClass().getDeclaredMethod("isSatisfiedBy", e.getClass());
        if (this.command != null)
            commandMethod = this.command.getClass().getDeclaredMethod("execute", e.getClass());
        if( (boolean) specificationMethod.invoke(this.specification, e));
         return (R) commandMethod.invoke(this.command, r);
    }

}
