package Rules.Rule;

import Rules.Command.Command;

public class Inc extends Command<Integer> {

    public Inc() {}

    public Integer execute(Integer i){
        return i + 1;
    }

    public String interpreter(){
        return "inc";
    }
}