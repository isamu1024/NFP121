package Observer.ExempleTP;

import java.util.Observer;
import java.util.Observable;
import java.util.Stack;

public class ConcreteObserver implements Observer {
    private Stack<Observable> senders;
    private Stack<Object> arguments;

    public ConcreteObserver(){
        senders = new Stack<>();
        arguments = new Stack<>();
    }

    public void update(Observable observable, Object arg){
        senders.push(observable);
        arguments.push(arg);
    }

    public Stack<Observable> getSenders(){
        return senders;
    }

    public Stack<Object> getArguments(){
        return arguments;
    }

}
