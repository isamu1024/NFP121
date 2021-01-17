package question4;


import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class Question4Test extends junit.framework.TestCase{


  // public void testVisiteurNombre(){
    // Expression n = new Nombre(33);
    // Visiteur<String> v = new VisiteurString();
    // assertEquals("33", n.accepter(v));
  // }
  
  // public void testVisiteurAddition(){
    // Expression a = new Addition(new Nombre(33),new Nombre(2));
    
    // Visiteur<String> v = new VisiteurStringAvecAddition();
    // assertEquals("(33 + 2)", a.accepter(v));
  // }
  
  // public void testVisiteurSoustraction(){
    // Expression a = new Soustraction(new Nombre(33),new Nombre(2));
    
    // Visiteur<String> v = new VisiteurStringAvecSoustraction();
    // assertEquals("(33 - 2)", a.accepter(v));
  // }Visi
  
  public void testVisiteurEvaluation(){
      Expression a = new Addition(new Nombre(33),new Nombre(2));
      Expression b = new Soustraction(new Nombre(18),new Nombre(11));
      Expression c = new Soustraction(a,b);
      Expression d = new Soustraction(new Addition(a,b), c);
      Visiteur<Integer> v = new VisiteurEvaluation();
      assertTrue(35 == a.accepter(v));
      assertTrue(7 == b.accepter(v));
      assertTrue(28 == c.accepter(v));
      assertTrue(14 == d.accepter(v));
   
    }

  
}