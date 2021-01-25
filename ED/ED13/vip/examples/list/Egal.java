package vip.examples.list;

import vip.rules.ICondition;

public class Egal<E> implements ICondition<E>{
    private E elt;
    public void setElt(E elt){
        this.elt = elt;
    }
    public boolean isSatisfied(E e){
        return e.equals(elt);
    }
    public String toString(){
        return "Egal/1";
    }
}
