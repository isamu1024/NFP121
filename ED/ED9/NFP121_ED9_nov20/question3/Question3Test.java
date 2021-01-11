package question3;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class Question3Test extends junit.framework.TestCase{
  
  public static class PriseFactice implements Plug{
    private static int nombre;
    public void RCA(){
       nombre++;
    }
    public static int getNombre(){
      return nombre;
    }
    
    public static void reset() {
        nombre=0;
    }
  }
  
  public void testNouvellePriseRCA(){
    try{
      PrintWriter writer = new PrintWriter("question3/configTest.txt", "UTF-8");
      writer.println("classe_adaptateur=question3.Adaptateur");
      writer.println("classe_a_adapter=question3.Question3Test$PriseFactice");
      writer.println("classe_param_cons=question3.Plug");
      writer.close();
    }catch (Exception e) {
      fail(e.getMessage());
    }
    try{
      Prise prise = (Prise)Configuration.genererAdaptateur("question3/configTest.txt");
      assertNotNull(prise);
      prise.peritel();
      prise.peritel();
      assertEquals(2, PriseFactice.getNombre());
      PriseFactice.reset();
    }catch(Exception e) {
      fail(e.getMessage());
    }
  }
}