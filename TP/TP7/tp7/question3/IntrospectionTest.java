package question3;

import javax.swing.*;
import java.util.Set;
import java.lang.reflect.Method;


public class IntrospectionTest extends junit.framework.TestCase{
 

	public void test1(){
 	  try{

		question3.Introspection intro = new question3.Introspection();
		java.util.Set<Method> set = intro.getHeritees("java.util.Vector");
		assertNotNull(set);
		assertEquals(7, set.size());

     }catch(ClassNotFoundException e){
       fail("exception innattendue !");
     }
	}
	
	public void test_java_util_Object(){
	  try{
  		question3.Introspection intro = new question3.Introspection();
  		java.util.Set<Method> set = Introspection.getHeritees("java.lang.Object");
  		assertNotNull(set);
  	  assertEquals(true, set.isEmpty());
    }catch(ClassNotFoundException e){
      fail("exception innattendue !");
    }
	}
	

}

