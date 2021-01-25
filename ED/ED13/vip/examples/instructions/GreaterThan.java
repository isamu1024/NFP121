package vip.examples.instructions;
import java.util.concurrent.atomic.*;
import vip.instructions.*;

public class GreaterThan extends Condition<AtomicInteger>{
    private static final boolean T = false; //true;
    private int operand;
    public void setOperand(int operand){
        this.operand= operand;
    }
    @Override
    public boolean isSatisfied(AtomicInteger i){
        if(T)System.out.println("i.get()>operand: "+ i.get() + " < " + operand);
        return i.get()>operand;
    }
}