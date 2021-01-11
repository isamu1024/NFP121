package heritage_pre_post_pour_discussion;

public class A {
  
  protected int valeurAvant;
  
  protected boolean pre_inc(int a){
    return a >= 10;
  }
  
  protected boolean post_inc(int res){
    return res == valeurAvant+1 ; //&& res > 10; // trop restrictif 
                                 // pour les sous classes futures
  }
   
  public int inc(int a){
    this.valeurAvant = a ;
    assert this.pre_inc(a): " pre_inc failed";
    int res = a+1;
    assert this.post_inc(res): " pre_inc failed";
    return res;
  }
  

  
}
