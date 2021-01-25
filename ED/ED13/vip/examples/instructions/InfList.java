package vip.examples.instructions;

import vip.instructions.*;
import java.util.*;

public class InfList<T> extends Condition<Collection<T>>{

    private int operand;
    public void setOperand(int operand){
        this.operand= operand;
    }
    @Override
    public boolean isSatisfied(Collection<T> c){
        return c.size()<operand;
    }
}