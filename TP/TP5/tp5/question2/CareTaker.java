package question2;

import java.util.Stack;
import java.util.EmptyStackException;


public class CareTaker extends Exception
{
    
    private Stack etats = new Stack();
    
    public void addMemento(Object m){
    
        etats.push(m);
        
    }
    
    public int getSize(){
    
        return etats.size();
    
    }
    
    public Object getMemento(){
    
        Object o;
        
        try {
        
            o = etats.pop();
            
        } catch (EmptyStackException e) {
            
            o = null;
        }
        
        return o;
        
    }
    

}
