package heritage_pre_post_pour_discussion;

// article : http://www.ccs.neu.edu/racket/pubs/fse01-flf.pdf

public class Test_A_B extends junit.framework.TestCase{
 

    public void testInc(){
      A a = new B();
      try{
        int res = a.inc(12);
      }catch(AssertionError ae){
        fail("une violation des pre_post conditions n'est pas attendue ???");
      }
    }
    
    public void testInc2(){
      A a = new B();
      try{
        int res = a.inc(8);      
      }catch(AssertionError ae){
        fail(ae.getMessage());
      }
    }
    
    public void testInc3(){
      A a = new A();
      try{
        int res = a.inc(8);      
      }catch(AssertionError ae){
        fail(ae.getMessage());
      }
    }
    
    public void testInc4(){
      A a = new B();
      try{
        int res = a.inc(0);      
      }catch(AssertionError ae){
        fail(ae.getMessage());
      }
    }
    
 
	
}
