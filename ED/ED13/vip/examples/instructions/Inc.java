package vip.examples.instructions;

import java.util.concurrent.atomic.*;
import vip.instructions.*;

public class Inc extends Instruction<AtomicInteger>{
    private static final boolean T = false; //true;
    protected int operand;
    public void setOperand(int operand){
        assert operand>0:"the parameter inc must be greater than zero";
        this.operand= operand;
    }
    @Override
    public AtomicInteger execute(AtomicInteger i){
        if(T)System.out.print("i avant, operand : " +i + ", " + operand);
        i.addAndGet(operand);
        if(T)System.out.print("i apres : " +i);
        return i;
    }
}
