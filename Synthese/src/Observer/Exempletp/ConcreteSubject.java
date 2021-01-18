package Observer.Exempletp;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Repris de TP4 Question 1
 */
public class ConcreteSubject extends Observable {
    private ArrayList<String> list;

    public ConcreteSubject(){
        list = new ArrayList<>();
    }

    public void insert(String name){
        // modification effective de la liste
        list.add(name);
        setChanged(); // l’état de cette liste a changé
        notifyObservers(name); // les observateurs sont prévenus
    }

    public String toString(){
        return list.toString();
    }
}
