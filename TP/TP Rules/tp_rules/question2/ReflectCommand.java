package question2;

import java.lang.reflect.*;


public class ReflectCommand<E, R> extends Command<E, R>   {
    protected CommandI<E, R> instanceCommand = null;

    public void setCommand(String command) throws Exception {
        try {
            Class<?> c = Class.forName(command);
            this.instanceCommand = (CommandI<E, R>) c.newInstance();
            super.setCommand(this.instanceCommand);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    public R execute(E entity, R result) throws Exception {
        if (instanceCommand == null)
            throw new RuntimeException();

        Method mCommand = null;
        try {

            for (Method method : instanceCommand.getClass().getMethods()) {
                if (method.getName().equals("execute") && method.getParameterTypes().length == 2) {
                             mCommand = method;
                }
            }
            if (mCommand == null)
                throw new NoSuchMethodException();

                 result = (R) mCommand.invoke(this.instanceCommand, entity, result);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return result;
    }
}
