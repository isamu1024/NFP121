package heritage_pre_post_pour_discussion;

// article : http://www.ccs.neu.edu/racket/pubs/fse01-flf.pdf

public class D extends C{
 
  
  protected boolean pre_set(int a){
    return a > 10;
  }
   
  public void set(int a){
    assert super.pre_set(a) || this.pre_set(a) : " pre_set  || failed"; // Eiffel en erreur
    assert !super.pre_set(a) || this.pre_set(a): " pre_set pre_super --> pre_this";// Liskov ok

    this.val = a;
  }
  
  protected boolean post_get(){
    return val > 10;
  }
  
   public int get(){
     int res = this.val;
     assert this.post_get() && super.post_get(): " post_get && failed"; // &&
     assert !(true && this.post_get()) || super.post_get() : " post_get pre_super && this.post --> super.post failed"; // &&
     return res;
  }
  
}
