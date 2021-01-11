package vip.rules;

public class Not<C> implements ICondition<C>{
    protected ICondition<C> condition;
    
    public void setCondition(ICondition<C> condition){
        this.condition = condition;
    }
    @Override
    public boolean isSatisfied(C context){
        return !condition.isSatisfied(context);
    }
    public String toString(){return "not("+condition+")";}
}