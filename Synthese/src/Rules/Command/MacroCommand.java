package Rules.Command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MacroCommand<R> extends Command<R> implements Iterable<Command<R>>{

    List<Command<R>> commands;

    public MacroCommand(){
        this.commands = new ArrayList<>();
    }

    @Override
    public R execute(R r) throws Exception {

        for (Command<R> command :this.commands)
           r = command.execute(r);

        return r;
    }

    public MacroCommand<R> add(Command<R> command){
        this.commands.add(command);
        return this;
    }

    @Override
    public String interpreter() {
        StringBuilder stb = new StringBuilder();
        stb.append("(");
        Iterator<Command<R>> it = this.iterator();
        while(it.hasNext()){
            stb.append(it.next().interpreter());
            if (it.hasNext())
                stb.append(" -> ");
        }
        stb.append(")");
        return stb.toString();
    }

    @Override
    public Iterator<Command<R>> iterator() {
        return this.commands.iterator();
    }
}
