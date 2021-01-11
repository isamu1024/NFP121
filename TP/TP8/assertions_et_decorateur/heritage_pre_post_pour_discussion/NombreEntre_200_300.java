package heritage_pre_post_pour_discussion;



public class NombreEntre_200_300 extends NombreEntre_1_100{
      private final String  TAG = this.getClass().getSimpleName();

   protected boolean pre_setValeur(int i){
     return i>=200 && i <=300;
   }
   
   protected boolean post_setValeur(int i){
     return getValeur() <= 600;
   }
   

  public void setValeurLiskov(int i){
     assert !(super.pre_setValeur(i)) | this.pre_setValeur(i)  : " pre setValeur  " + TAG + " failed !!" ; // Liskov
     super.setValeurLiskov(i);
     assert !(super.pre_setValeur(i) & this.post_setValeur(i)) | super.post_setValeur(i): " post setValeur " + TAG + "  failed !!" ; // Liskov
  }  
  
  public void setValeurEiffel(int i){
     assert super.pre_setValeur(i) | this.pre_setValeur(i) : " pre setValeur  " + TAG + " failed !!" ; // Eiffel
     super.setValeurEiffel(i);
     assert super.post_setValeur(i) & this.post_setValeur(i): " post setValeur  " + TAG + " failed !!" ; // Eiffel
   }
}
