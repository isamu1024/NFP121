package vip.rules;


import java.util.*;
public class Rules<C,R> implements IRule<C,R>{
   protected List<IRule<C,R>> children;
   
    public Rules(){
        this.children = new ArrayList<>();
    }
    public void setRule(IRule<C,R> rule){
        this.children.add(rule);
    }
    public void setRules(IRule<C,R>[] rules){
        this.children.addAll(Arrays.asList(rules));
    }

   public R execute(C context, R result){
       for(IRule<C,R> rule : children){
          result = rule.execute(context, result);
        }
        return result;
    }
    
    public String toString(){
      StringBuffer res = new StringBuffer();
      for(IRule<C,R> rule : children){
          res.append(rule.toString());
          res.append("\n");
      }  
      return res.toString();
    }
}