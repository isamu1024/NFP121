package heritage_pre_post_pour_discussion;



public class TestNombre400 extends junit.framework.TestCase{
 

  public void testSetValeurLiskov_Nombre_200_300(){
    NombreI n = new NombreEntre_200_300();
    n.setValeurLiskov(400);
  }
  
  public void testSetValeurEiffel_Nombre_200_300(){
    NombreI n = new NombreEntre_200_300();
    n.setValeurEiffel(400);
  }
  
  public void testSetValeurLiskov_Nombre_1_300(){
    NombreI n = new NombreEntre_1_300();
    n.setValeurLiskov(400);
  }
  
  public void testSetValeurEiffel_Nombre_1_300(){
    NombreI n = new NombreEntre_1_300();
    n.setValeurEiffel(400);
  }
  
  public void testSetValeurLiskov_Nombre_1_50(){
    NombreI n = new NombreEntre_1_50();
    n.setValeurLiskov(400);
  }
  
  public void testSetValeurEiffel_Nombre_1_50(){
    NombreI n = new NombreEntre_1_50();
    n.setValeurEiffel(400);
  }
  
   public void testSetValeurLiskov_Nombre_1_100(){
    NombreI n = new NombreEntre_1_100();
    n.setValeurLiskov(400);
  }
  
  public void testSetValeurEiffel_Nombre_1_100(){
    NombreI n = new NombreEntre_1_100();
    n.setValeurEiffel(400);
  }
  
 
	
}
