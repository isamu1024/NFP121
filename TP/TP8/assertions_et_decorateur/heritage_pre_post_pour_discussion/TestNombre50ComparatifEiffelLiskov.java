package heritage_pre_post_pour_discussion;

public class TestNombre50ComparatifEiffelLiskov extends junit.framework.TestCase{
 
  public void failed(String message){
    System.out.println(message);
  }
  
  public void testSetValeur_50_Nombre_200_300(){
    NombreI n = new NombreEntre_200_300();
    try{
      n.setValeurLiskov(50);
    }catch(AssertionError e){
      try{
        n.setValeurEiffel(50);
        failed("Eiffel/Liskov donnent un résultat différent ");
      }catch(AssertionError e1){
        return;
      }
    }
    try{
      n.setValeurEiffel(50);
    }catch(AssertionError e2){
      fail("Eiffel/Liskov donnent un résultat différent ");
    }
  }
  
  public void testSetValeur_50_Nombre_1_300(){
    NombreI n = new NombreEntre_1_300();
    try{
      n.setValeurLiskov(50);
    }catch(AssertionError e){
      try{
        n.setValeurEiffel(50);
        failed("Eiffel/Liskov donnent un résultat différent ");
      }catch(AssertionError e1){
         return;
      }
    }
    try{
      n.setValeurEiffel(50);
    }catch(AssertionError e2){
      fail("Eiffel/Liskov donnent un résultat différent ");
    }
  }
  
 
  public void testSetValeur_50_Nombre_1_50(){
    NombreI n = new NombreEntre_1_50();
    try{
      n.setValeurLiskov(50);
    }catch(AssertionError e){
      try{
        n.setValeurEiffel(50);
        failed("Eiffel/Liskov donnent un résultat différent ");
      }catch(AssertionError e1){
         return;
      }
    }
    try{
      n.setValeurEiffel(50);
    }catch(AssertionError e2){
      fail("Eiffel/Liskov donnent un résultat différent ");
    }
  }
  
  
  public void testSetValeur_50_Nombre_1_100(){
    NombreI n = new NombreEntre_1_100();
    try{
      n.setValeurLiskov(50);
    }catch(AssertionError e){
      try{
        n.setValeurEiffel(50);
        failed("Eiffel/Liskov donnent un résultat différent ");
      }catch(AssertionError e1){
         return;
      }
    }
    try{
      n.setValeurEiffel(50);
    }catch(AssertionError e2){
      fail("Eiffel/Liskov donnent un résultat différent ");
    }
  }
  
  
  
}
