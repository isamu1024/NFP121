package observer;

import conditions.Condition;

public class ConditionEstPair implements Condition<Nombre> {
    
    @Override
    public boolean estSatisfaite(Nombre n) {
        return n.getValeur()%2 == 0;
    }
   
}
