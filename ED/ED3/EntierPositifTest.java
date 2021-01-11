public class EntierPositifTest extends junit.framework.TestCase{

  public void testConstructeurEntierPositif(){
    Entier e = null;
    try{
      e = new EntierPositif(-3);
      fail("une exception est attendue, appel du constructeur avec un nombre négatif");
    }catch(Throwable exc){
      assertEquals("constructeur en défaut", exc.getMessage());
    }
    try{
      e = new EntierPositif(3);
      assertEquals(3, e.getValeur());
    }catch(Throwable exc){
      fail("une exception n'est pas attendue ici");
    }
  }
  
  public void testIncEntierPositif(){
    Entier e = new EntierPositif(Integer.MAX_VALUE);
    try{
      e.inc();
      fail("une exception est attendue");
    }catch(Throwable exc){
      assertEquals("inc en défaut", exc.getMessage());
    }
    try{
      e = new EntierPositif(3);
      e.inc();
      assertEquals(4, e.getValeur());
    }catch(Throwable exc){
      fail("une exception n'est pas attendue ici");
    }
  }
  
  public void testDecEntierPositif(){
    Entier e = new EntierPositif(0);
    try{
      e.dec();
      fail("une exception est attendue");
    }catch(Throwable exc){
      assertEquals("dec en défaut", exc.getMessage());
    }
    e = new EntierPositif(3);
    try{
      e.dec();
      assertEquals(2, e.getValeur());
    }catch(Throwable exc){
      fail("une exception n'est pas attendue ici");
    }
  }
  
  public void testSetValeurEntierPositif(){
    Entier e = new EntierPositif(0);
    try{
      e.setValeur(-5);
      fail("une exception est attendue");
    }catch(Throwable exc){
      assertEquals("setValeur en défaut", exc.getMessage());
    }
    e = new EntierPositif(3);
    try{
      e.setValeur(2);
      assertEquals(2, e.getValeur());
    }catch(Throwable exc){
      fail("une exception n'est pas attendue ici");
    }
  }
}