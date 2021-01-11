package question3;
import java.util.Stack;

public class Gardien{

    private Stack<Memento> mementoStk;
    
    public Gardien(){

        this.mementoStk = new Stack<>();
    }
    public Memento getMemento() {

        return this.mementoStk.pop();
    }
    
    public void setMemento(Memento memento){

        this.mementoStk.push(memento);
    }
  }