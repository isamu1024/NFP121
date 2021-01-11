package question3;

import java.lang.reflect.Method;

import java.util.Set;

public class Introspection{

  
	public static Set<Method> getHeritees(String nomDeLaClasse) throws ClassNotFoundException{
// à compléter
// à compléter
// à compléter
// à compléter
// à compléter
// à compléter
// à compléter
// à compléter
    return /* à modifier */null;
  }
  
  
  
 public static void main(String[] args) throws ClassNotFoundException{
   
    for(Method m : Introspection.getHeritees("java.util.AbstractCollection")){
      System.out.println(m);
    }
  }
  
}