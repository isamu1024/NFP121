package question2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MacroCommand<E,R> extends CompositeCommand<E,R>{

    public R execute(E e, R r) throws Exception{
        R result = null;

        for (CommandI command : super.commands) {
            result = (R) command.execute(e, r);
            r = result;
        }

        return result;
    }

}
