package operations;

// T = objet sur lequel on fait l'opération 
// E =  résultat de l'opération
public interface Operation<T,E>{
  
  public void execute(T t,E e);

    
}
