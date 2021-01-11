package heritage_pre_post_pour_discussion;


public class NombreEntre_1_100 implements NombreI{
    private int valeur;
    private final String  TAG = this.getClass().getSimpleName();
    
    private int valeurAvant;
    
   protected boolean pre_setValeur(int i){
     return i>=1 && i <=100;
   }
   
   protected boolean post_setValeur(int i){
     return getValeur()==i*2; // && getValeur() <= 200; 
                              // trop restrictif pour un héritage futur ...
   }
   
   
  public void setValeurEiffel(int i){
    this.valeurAvant = this.valeur;
    assert this.pre_setValeur(i) : " pre setValeur " + TAG + " failed !!" ;
    this.valeur = i*2;
    assert this.post_setValeur(i): " post setValeur " + TAG + " failed !!" ;
  }
  
  public void setValeurLiskov(int i){
    this.valeurAvant = this.valeur;
    assert this.pre_setValeur(i): " pre setValeur " + TAG + " failed !!";
    this.valeur = i*2;
    assert this.post_setValeur(i) : " post setValeur " + TAG + " failed !!" ;
  }    
   
  public int getValeur(){
    return valeur;
  }
}
