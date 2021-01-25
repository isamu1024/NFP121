package vip.rules;

import java.util.*;

public class Commands<E,R> implements ICommand<E,R>{
    protected List<ICommand<E,R>> children;

    public Commands(){
        this.children = new ArrayList<>();
    }
    public void setCommand(ICommand<E,R> command){
        this.children.add(command);
    }
    public void setCommands(ICommand<E,R>[] commands){
        this.children.addAll(Arrays.asList(commands));
    }

    public R execute(E entity,R result){
        for(ICommand<E,R> command : children){
            result = command.execute(entity, result);
        }
        return result;
    }
    
    public String toString(){
      StringBuffer res = new StringBuffer();
      for(ICommand<E,R> command  : children){
          res.append(command.toString());
          res.append("\n");
      }  
      return res.toString();
    }
}
