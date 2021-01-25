package vip.rules;

public class Rule<C,R> implements IRule<C,R> {
    private static boolean T = false;//true;
    private ICondition<C> condition;
    private ICommand<C,R>   command;

    public void setCondition(ICondition<C> condition){
        this.condition = condition;
    }

    public ICondition<C> getCondition(){return this.condition;}

    public void setCommand(ICommand<C,R> command){
        this.command = command;
    }

    public ICommand<C,R> getCommand(){return this.command;} 

    public R execute(C context,R result){
        assert command!=null;
        if(T)System.out.println("condition.isSatisfied(context): " + (condition==null?"null":condition.isSatisfied(context)));
        if ((condition==null || condition.isSatisfied(context)) && (command!=null)){
            result = command.execute(context,result);
            if(T)System.out.println("result: " + result);
        }
        return result;
    }

    static{
        String str = System.getProperties().getProperty("trace","false");
        T = Boolean.parseBoolean(str);
    }
    
    public String toString(){
        return "if("+getCondition()+")then("+getCommand()+");";
    }
}
