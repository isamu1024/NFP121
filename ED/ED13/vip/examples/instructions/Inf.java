package vip.examples.instructions;

import vip.instructions.*;

public class Inf extends Condition<Element<Integer>>{
    private Element<Integer> element;
    public void setElement(Element<Integer> element){
        this.element = element;
    }

    @Override
    public boolean isSatisfied(Element<Integer> e){
        return e.getValue()<element.getValue();
    }
}