

public class InvokerTest extends junit.framework.TestCase{
 
  public void testInvokerIncDec(){
    Entier e = new Entier(5);
    Command inc = new IncCommand(e);
    Command dec = new DecCommand(e);
    SetValeurCommand set = new SetValeurCommand(e);
     
    Invoker invoker = Invoker.getInstance();
    invoker.addCommande("inc", inc);
    invoker.addCommande("dec", dec);
    invoker.addCommande("set", set);

    try{
      assertEquals(5, e.getValeur());
      invoker.executeCommande("inc");
      assertEquals(6, e.getValeur());
      invoker.executeCommande("inc");
      assertEquals(7, e.getValeur());
      
      set.setValeur(Integer.MAX_VALUE);
      invoker.executeCommande("set");
      assertEquals(Integer.MAX_VALUE, e.getValeur());
    }catch(Exception exc){
      fail("aucune exception n'est attendue ???");
    }
  }
  
  
  public void testInvokerException(){
    Entier e = new Entier(Integer.MAX_VALUE);
    Command inc = new IncCommand(e);
    Command dec = new DecCommand(e);
    SetValeurCommand set = new SetValeurCommand(e);
    Invoker invoker =Invoker.getInstance();
    invoker.addCommande("inc", inc);
    invoker.addCommande("dec", dec);
    invoker.addCommande("set", set);

     

    try{
      assertEquals(Integer.MAX_VALUE, e.getValeur());
      invoker.executeCommande("inc");
      fail("une exception est attendue ???");
    }catch(Exception exc){
      assertEquals(Integer.MAX_VALUE, e.getValeur());
    }
    try{
      set.setValeur(Integer.MIN_VALUE);
      invoker.executeCommande("dec");;
      fail("une exception est attendue ???");
    }catch(Exception exc){
      assertEquals(Integer.MIN_VALUE, e.getValeur());
    }
  }
}
