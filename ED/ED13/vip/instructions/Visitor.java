package vip.instructions;

import java.lang.reflect.Method;


public abstract class Visitor<T>{
    public <M> T visit(Condition<M> condition){
      return execute(condition);
    }
    public <M> T visit(Instruction<M> instruction){
      return execute(instruction);
    }
    // cf. NFP121 cours 7 diapositive 50
    private T execute(Object object){
      Class<?> cl = this.getClass();
      while(cl != Object.class){
          try{
            Method m = cl.getDeclaredMethod("visit",object.getClass());
            //System.out.println("visit(" + instruction.getClass().getSimpleName());
            return (T)m.invoke(this, object);
          }catch(Exception e){
              cl = cl.getSuperclass();
          }
      }
      return null;
    }
    
  
}
