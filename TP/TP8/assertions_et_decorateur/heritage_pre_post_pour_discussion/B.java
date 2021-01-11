package heritage_pre_post_pour_discussion;


public class B extends A{
    
  protected boolean pre_inc(int a){
    return a >= 0;
  }
  
  protected boolean post_inc(int res){
    return res > 0 && res == valeurAvant+1; 
  }
   
  public int inc(int a){
    valeurAvant = a;
    assert !super.pre_inc(a) || this.pre_inc(a) : " pre_inc failed";
    //assert super.pre_inc(a) || this.pre_inc(a);
    int res = a+1;
    //assert this.post_inc(res) && super.post_inc(res);
    assert !(this.post_inc(res) && super.pre_inc(a)) || super.post_inc(res): " pre_inc failed";
    return res;
  }
  
  private static boolean implies(boolean p, boolean q){
    // p ==> q  
    return !p || q;
  }
  
}