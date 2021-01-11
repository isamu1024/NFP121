import java.util.Stack;

public class Caretaker{
  
    private Stack<Memento> mementos;
    
  public Caretaker(){

      mementos = new Stack<Memento>();
      
  }
  
  public Memento getMemento(){
    return this.mementos.pop();
  }

  public void setMemento(Memento memento){
    
      this.mementos.push(memento);
      
  }
  
  public void forget(){
      
  }
}