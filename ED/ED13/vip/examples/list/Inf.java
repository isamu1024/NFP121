package vip.examples.list;

import vip.rules.ICondition;

public class Inf <E extends Comparable<E>> implements ICondition<E>{
    private static final boolean T = false;
    private E elt;
    public void setElt(E elt){ this.elt = elt;}
    
    public boolean isSatisfied(E e){
        if(T) System.out.println("isSatisfied.Inf: " + elt + " < " + e + ": "+ (elt.compareTo(e)<0));
        return elt.compareTo(e)<0;
    }
    public String toString(){
        return "Inf/1";
    }
}
