package vip.rules;

import java.lang.reflect.*;

public class RuleReflection<C,R> implements IRule<C,R>{
    private static boolean T = false;
    protected ICondition<?> instanceCondition=null;
    protected ICommand<?,?>   instanceCommand=null;

    public void setCondition(String condition){
        try{
            Class<?> classCondition = Class.forName(condition, true, Thread.currentThread().getContextClassLoader());
            instanceCondition = (ICondition<?>)classCondition.newInstance();
        }catch(Exception e){
            if(T)System.out.println("exception setCondition:");
            e.printStackTrace();
        }
    }

    public ICondition<?> getCondition(){ return instanceCondition;}

    public void setCommand(String command){
        try{
            Class<?> classCommand = Class.forName(command, true, Thread.currentThread().getContextClassLoader());
            instanceCommand = (ICommand<?,?>) classCommand.newInstance();
        }catch(Exception e){
            if(T)System.out.println("exception setCommand:");
            e.printStackTrace();
        }
    }

    public ICommand<?,?> getCommand(){ return instanceCommand;}

    @Override
    public R execute(C context,R result){
        Method mCondition=null, mCommand=null;
        try{
            if(instanceCondition!=null)
                mCondition = instanceCondition.getClass().getDeclaredMethod("isSatisfied",context.getClass());
            if(instanceCommand!=null)
                mCommand = instanceCommand.getClass().getDeclaredMethod("execute",result.getClass());

            // condition.isSatisfied(context)
            boolean condition = instanceCondition!=null;
            condition &= (boolean)mCondition.invoke(instanceCondition,context);
            if(condition || instanceCondition==null){
                //return operation.executer(entite,resultat);
                return (R)mCommand.invoke(instanceCommand,context,result);
            }

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        return result;
    }

    static{
        String str = System.getProperties().getProperty("trace","false");
        T = Boolean.parseBoolean(str);
    }
}
