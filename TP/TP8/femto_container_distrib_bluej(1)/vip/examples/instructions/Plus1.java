package vip.examples.instructions;

import vip.instructions.*;
public class Plus1 extends Instruction<Element<Integer>>{
    
    private Element<Integer> element;
    
    public void setElement(Element<Integer> element){
        this.element = element;
    }

    @Override
    public Element<Integer> execute(Element<Integer> elt){
        element.setValue(elt.getValue()+element.getValue());
        return element;
    }
}
