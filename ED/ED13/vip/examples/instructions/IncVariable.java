package vip.examples.instructions;

import vip.instructions.*;

public class IncVariable extends Instruction<Variable>{
    private static final boolean T = false; //true;

    @Override
    public Variable execute(Variable v){
        if(T)System.out.print("v avant, operand : " + v );
        v.setValue(v.getValue()+1);
        if(T)System.out.print("v apres : " + v);
        return v;
    }
}
