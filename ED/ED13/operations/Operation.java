package operations;

// T = objet sur lequel on fait l'op�ration 
// E =  r�sultat de l'op�ration
public interface Operation<T,E>{
  
  public void execute(T t,E e);

    
}
