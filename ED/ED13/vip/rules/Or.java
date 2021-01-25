package vip.rules;

public class Or<C> extends Conditions<C>{
    
    @Override
    public boolean isSatisfied(C context){
        boolean res = false;
        for(ICondition<C> condition : children){
            if(condition.isSatisfied(context)) return true;
        }
        return res;
    }
  public String toString(){return "or("+super.toString()+")";}
}