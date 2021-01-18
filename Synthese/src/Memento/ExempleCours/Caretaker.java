package Memento.ExempleCours;

import java.util.Stack;

/**
 * Illustration simple d'un gardien, stockant plusieurs mementos
 */
public class Caretaker {

    private Stack<NotePad.Memento> mementoStack;

    public Caretaker(){
        this.mementoStack = new Stack<>();
    }

    public NotePad.Memento getMemento(){
        return mementoStack.pop();
    }

    public void setMemento(NotePad.Memento memento){
        mementoStack.push(memento);
    }

}
