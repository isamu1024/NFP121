package Rules.Command;

public class PrintCommand<R> extends Command<R> {

    @Override
    public R execute(R r) throws Exception {
        System.out.println(interpreter()+ " " + r.toString());
        return r;
    }

    @Override
    public String interpreter() {
        return "print";
    }
}
