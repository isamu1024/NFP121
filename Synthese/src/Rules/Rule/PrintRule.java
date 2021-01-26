package Rules.Rule;

import Rules.Command.Command;
import Rules.Command.PrintCommand;
import Rules.Specification.Specification;
import Rules.Specification.True;

public class PrintRule<E,R> extends Rule<E,R> {

    public PrintRule() {
        super(new True<>(), new PrintCommand<>());
    }
}
