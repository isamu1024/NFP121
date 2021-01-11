package vip.examples.number;

import vip.rules.ICommand;
import java.util.concurrent.atomic.AtomicInteger;

public class Inc implements ICommand<Integer,AtomicInteger>{
    private int increment;
    public void setIncrement(int increment){
        this.increment = increment;
    }
    
    public AtomicInteger execute(Integer unused,AtomicInteger i){
        i.set(i.get()+increment);
        return i;
    }
    
    public String toString(){
        return "Inc/1";
    }
}