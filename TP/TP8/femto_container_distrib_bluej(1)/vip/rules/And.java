package vip.rules;

public class And<C> extends Conditions<C>{

    @Override
    public boolean isSatisfied(C context){
        boolean res = true;
        for(ICondition<C> condition : children){
            res = res && condition.isSatisfied(context);
        }
        return res;
    }
    public String toString(){return "and("+super.toString()+")";}
}