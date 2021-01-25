package commands;

import conditions.*;
import operations.*;

public class Command<T,R>{
    
   protected Condition<T>   condition;
   protected Operation<T,R> operation;
   protected Command<T,R>   exception;
   
   public void setCondition(Condition<T> condition){
       this.condition = condition;
   }
   public void setOperation(Operation<T,R> operation){
       this.operation = operation;
   }
   public void setException(Command<T,R> exception){
       this.exception = exception;
   }
   
   public void execute(T t,R r){
       try{
           if(condition!=null && condition.estSatisfaite(t)){
               operation.execute(t,r);
           }
       }catch(RuntimeException e){
           if(exception!=null) exception.execute(t,r);
           throw e;
        }
   }
   
   public void undo(){
   }
}
