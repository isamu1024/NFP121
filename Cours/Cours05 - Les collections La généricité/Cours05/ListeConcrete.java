import java.util.*;


public class ListeConcrete<E> extends AbstractCollection<E>
{

    private Stack<E> stack;
    
    public ListeConcrete(){
        stack = new Stack<E>();
        
    } 
    
    public boolean ajouter(E e){
        stack.push(e);
        return true;
    }
    
    public Iterator<E> iterator(){
        return stack.iterator();
    }

}
