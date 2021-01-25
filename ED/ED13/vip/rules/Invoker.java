package vip.rules;

import java.util.Stack;
import java.io.*;

public class Invoker<C,R extends Serializable> implements IRule<C,R>{
    private final static boolean T = false;

    private IRule<C,R>   rule;
    private boolean undo = false;
    private Stack<byte[]> stk; 

    public Invoker(){
        this.stk = new Stack<byte[]>();
    }

    public void setRule(IRule<C,R> rule){
        this.rule = rule;
    }

    public void setUndo(boolean allowed){
        this.undo = allowed;
    }

    public IRule<C,R> getRule(){
        return this.rule;
    } 

    public R execute(C context,R result){
        if(undo)save(result);
        return rule.execute(context,result);
    }

    public R undo(){
        return restore();
    }

    private void save(Serializable result){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try{
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeObject(result);
            stk.push(bos.toByteArray());
            if(T)System.out.println("invoker.save: " + result + ", index: " + stk.size());
            bos.close();
            out.close();
        }catch(Exception e){
            //throw new RuntimeException("save: " + e.getMessage() + " " + result);
            e.printStackTrace();
        }
    }

    private R restore(){
        R result = null;
        try{
            if(!stk.isEmpty()){
                byte[] contenu = stk.pop();
                ByteArrayInputStream bis = new ByteArrayInputStream(contenu);
                ObjectInput in = new ObjectInputStream(bis);
                result = (R) in.readObject();
                if(T)System.out.println("invoker.restore: " + result);
                bis.close();
                in.close();
            }
        }catch(Exception e){
            //throw new RuntimeException("restore: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}

