package question2;

public class MacroCommandException<E, R> extends CompositeCommand<E, R> {
    private CommandI<E, R> exception;

    public void setException(CommandI<E, R> exception) {
        this.exception = exception;
    }

    public R execute(E e, R r) throws Exception {
        R result = null;

        try {
            for (CommandI command : super.commands) {
                result = (R) command.execute(e, r);
                r = result;
            }
        } catch (Exception exc) {
            if (exception != null)
                return exception.execute(e, r);
        }

        return result;
    }

}
