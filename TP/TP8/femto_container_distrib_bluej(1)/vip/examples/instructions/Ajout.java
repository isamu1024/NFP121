package vip.examples.instructions;

import vip.instructions.*;
import container.*;
import java.util.Collection;

public class Ajout<T extends Integer> extends Instruction<Collection<T>>{
    private T element;
    public void setElement(T element){this.element = element;}
    @Override
    public Collection<T> execute(Collection<T> list){
        list.add(element);
        return list;
    }
}
