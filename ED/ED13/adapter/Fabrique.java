package adapter;


public class Fabrique<T>{
   private T instance;
   
   public void setInstance(T t){ this.instance = t;}
   
   public T creer(){
       return this.instance;
   }
}
