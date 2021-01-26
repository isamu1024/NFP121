package Rules.Command;

public class MacroCommandException<R> extends MacroCommand<R> {

    Command<R> command = null;

    public MacroCommandException(){
        super();
    }

    public void setExceptionCmd(Command<R> command) {
        this.command = command;
    }

    @Override
    public R execute(R r) throws Exception{
        try {
            r = super.execute(r);
        } catch (Exception e) {
            return command.execute(r);
        }
        return r;
    }
}
