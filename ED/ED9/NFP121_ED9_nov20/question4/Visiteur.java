package question4;


import java.lang.reflect.*;

public abstract class Visiteur<T>{
    
  public T visite(Expression expr){
      
    Class<?> cl = this.getClass();
    int cpt=0;
    
    while(cl != Object.class){
        cpt++;
    try{
      Method m = cl.getDeclaredMethod("visite",expr.getClass());
      System.out.println(cl.getSimpleName()+" : "+cpt);
      return (T)m.invoke(this, expr);
    }catch(Exception e){
      cl = cl.getSuperclass();
    }
   }
   throw new UnsupportedOperationException();
  }
  
}