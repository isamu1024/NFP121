package nombre_exemple;


public class NombreTest extends junit.framework.TestCase{
  private NombreI n;
  
  protected void setUp(){
    this.n = new NombrePrePost(new NombreAf(new NombreRepOk(new Nombre(0,4))));
    //this.n = new NombreAf(new NombreRepOk(new Nombre(0,4)));
    //this.n = new NombreRepOk(new Nombre(0,4));
    //this.n = new NombrePrePost(new Nombre(0,4));
  }
  
  public void testNombrePrePost(){
    this.n = new NombrePrePost(null);
  }
  
 public void testNombre(){
   assertEquals(0, n.getMin());   
   assertEquals(4, n.getMax());
   assertTrue(n.repOk());
   assertEquals(0, n.getValeur());
   assertEquals(0, ((Integer)n.af()).intValue());
   n.inc();
   assertEquals(1, n.getValeur());
   n.inc();n.inc();n.inc();
   assertEquals(4, n.getValeur());
   try{
     n.inc();
     fail(" une exception est attendue ");
   }catch(Exception e){
     assertTrue( e instanceof RuntimeException);
   }
   n.dec();
   assertEquals(3, n.getValeur());
   n.dec();n.dec();n.dec();
   try{
     n.dec();
     fail(" une exception est attendue ");
   }catch(Exception e){
     assertTrue( e instanceof RuntimeException);
   }
   assertEquals(0, n.getValeur());
   n.setValeur(3);
   assertEquals(3, n.getValeur());
   try{
     n.setValeur(n.getMax()+1);
     fail(" une exception est attendue ");
   }catch(Exception e){
     assertTrue( e instanceof RuntimeException);
   }   
  }
  
  
  
  public void testConstructeur(){
    try{
      Nombre n = new Nombre(4,0);
      fail(" une exception est attendue ");
    }catch(Exception e){
      assertTrue( e instanceof RuntimeException);
    }
    try{
      Nombre n = new Nombre(4,4);
      fail(" une exception est attendue ");
    }catch(Exception e){
      assertTrue( e instanceof RuntimeException);
    }
    
    try{
      Nombre n = new Nombre(0,-4);
      fail(" une exception est attendue ");
    }catch(Exception e){
      assertTrue( e instanceof RuntimeException);
    }
  }
  
  
}
