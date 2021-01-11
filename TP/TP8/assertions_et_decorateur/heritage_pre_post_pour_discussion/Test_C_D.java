package heritage_pre_post_pour_discussion;

// article : http://www.ccs.neu.edu/racket/pubs/fse01-flf.pdf

public class Test_C_D extends junit.framework.TestCase{
 

    public void testProgramWrittenByBill(){
      D d = new D();
      try{
        d.set(5);
        
        d.get();
      }catch(AssertionError a){
        fail("pas d'erreur selon l'article ...");
      }
    }
    
    public void testProgramWrittenByBill2(){
      D d = new D();
      try{
        d.set(12);
        
        d.get();
      }catch(AssertionError a){
        fail("pas d'erreur selon l'article ...");
      }
    }
    
    
 
 
	
}
