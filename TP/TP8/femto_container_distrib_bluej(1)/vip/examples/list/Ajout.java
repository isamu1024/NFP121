package vip.examples.list;

import vip.rules.ICommand;
import java.util.List;

public class Ajout<E> implements ICommand<E, List<E>>{
  
    @Override
    public List<E> execute(E elt, List<E> list){
        list.add(elt);
        return list;
    }
    public String toString(){
        return "(Ajout/1)";
    }
}
