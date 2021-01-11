package vip.examples.instructions;

import vip.instructions.*;

public class Plus1_Memory extends Instruction<Memory>{
    private String name;
    
    public void setElement(String name){
        this.name = name;
    }

    @Override
    public Memory execute(Memory m){
        Element<Integer> elt = m.get(name);
        elt.setValue(elt.getValue()+1);
        m.set(name, elt);
        return m;
    }
}