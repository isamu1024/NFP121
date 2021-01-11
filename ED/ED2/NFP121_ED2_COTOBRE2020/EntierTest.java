public class EntierTest extends junit.framework.TestCase{
 
  public void testEquals(){
    Entier e = new Entier(3);
    Entier e1 = new Entier(2);
    
    assertFalse(e.equals(e1)); // assertNotEquals n'existe pas
    e1.inc();
    assertEquals(e,e1);
    assertEquals("deux objets égaux ==> leur hashCode sont égaux", e.hashCode(),e1.hashCode());
    
    assertFalse(e.equals(null));
    
    Entier e2 = new Entier(5);
    assertEquals(e2,e2);
    assertEquals(new Entier(7),new Entier(7));
    assertEquals(new Entier(7).hashCode(),new Entier(7).hashCode());
  }
  
  public void testParseEntier(){
    Entier e = Entier.parseEntier("3");
    assertEquals(new Entier(3),e);
    try{
      Entier e1 = Entier.parseEntier("3x");
    }catch(Exception exc){
      assertTrue(exc instanceof NumberFormatException);
    }
  }
}