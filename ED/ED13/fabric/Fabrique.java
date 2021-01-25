package fabric;


//public class Fabrique<P extends Product>{
public class Fabrique<P extends Object>{
   private P product;
   
   public void setProduct(P product){ 
       this.product = product;
    }
   
   public P creer(){
       return this.product;
   }
}