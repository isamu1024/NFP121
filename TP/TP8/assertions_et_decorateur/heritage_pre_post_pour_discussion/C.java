package heritage_pre_post_pour_discussion;

// article : http://www.ccs.neu.edu/racket/pubs/fse01-flf.pdf

public class C {
  
  protected int val;
  
  protected boolean pre_set(int a){
    return a > 0;
  }
   
  public void set(int a){
    assert this.pre_set(a): " pre_set failed";
    this.val = a;
  }
  
  protected boolean post_get(){
    return val > 0;
  }
  
   public int get(){
     int res = val;
     assert this.post_get(): " post_get failed";
     return res;
  }
  
}
