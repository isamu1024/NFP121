package vip.rules;


import java.util.*;

public abstract class Conditions<C> implements ICondition<C>{
    protected List<ICondition<C>> children;

    public Conditions(){
        this.children = new ArrayList<>();
    }

    public void setCondition(ICondition<C> condition){
        this.children.add(condition);
    }

    public void setConditions(ICondition<C>[] conditions){
        this.children.addAll(Arrays.asList(conditions));
    }
    
    public abstract boolean isSatisfied(C context);
    
    public String toString(){return children.toString();}
}
