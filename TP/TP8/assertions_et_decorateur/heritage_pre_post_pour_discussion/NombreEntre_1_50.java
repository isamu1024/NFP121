package heritage_pre_post_pour_discussion;

/** Liskov page 176
 * pre_super ==> pre_this
 * pre_super && post_this ==> post_super
 * 
 * Eiffel, 
 *  The precondition can only become weaker than in the inherited contract.
 *  The postcondition can only become stronger than in the inherited contract. 
 */


public class NombreEntre_1_50 extends NombreEntre_1_100{
      private final String  TAG = this.getClass().getSimpleName();

   protected boolean pre_setValeur(int i){
     return i>=1 && i <=50;
   }
   
   protected boolean post_setValeur(int i){
     return getValeur() <= 100;
   }
   

  public void setValeurLiskov(int i){
     assert !(super.pre_setValeur(i)) | this.pre_setValeur(i) : " pre setValeur " + TAG + " failed !!" ; // Liskov
     super.setValeurLiskov(i);
     assert !(super.pre_setValeur(i) & this.post_setValeur(i)) | super.post_setValeur(i) : " post setValeur  " + TAG + " failed !!" ; // Liskov
  }  
  
  public void setValeurEiffel(int i){
     assert super.pre_setValeur(i) | this.pre_setValeur(i) : " pre setValeur  " + TAG + " failed !!"; // Eiffel
     super.setValeurEiffel(i);
     assert super.post_setValeur(i) & this.post_setValeur(i) : " post setValeur " + TAG + "  failed !!" ; // Eiffel
   }
}
