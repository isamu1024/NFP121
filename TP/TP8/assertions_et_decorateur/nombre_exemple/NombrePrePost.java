package nombre_exemple;



public class NombrePrePost extends NombreDecorateur{
  protected boolean post_NombrePrePost(){
    return true;
  }
    
  public NombrePrePost(NombreI nombre){
    super(nombre==nombre?pre_NombrePrePost(nombre):null);
    assert post_NombrePrePost();
  }
  
  protected static NombreI pre_NombrePrePost(NombreI nombre){
    assert nombre!=null && nombre.getMax() >= nombre.getMin() : "pre assertion NombrePrePost invalide ???";
    // utile ?, une exception aurait dû être levée avant l'appel du décorateur
    return nombre;
  }
  
  
  private int valeurAvant;
  
  protected boolean pre_setValeur(int valeur){
    return true;
  }
  protected boolean post_setValeur(Exception cause, int valeur){
    return true;
  }
  
  public void setValeur(int valeur){
    valeurAvant = super.getValeur();
    assert pre_setValeur(valeur): " pre assertion setValeur ???";
    Exception cause = null;
    try{
      super.setValeur(valeur);
    }catch(Exception e){
      cause = e;
      throw e;
    }finally{
      assert post_setValeur(cause,valeur):" post assertion setValeur ???";
    }
  }
  
  protected boolean pre_inc(){
    return true;
  }
  protected boolean post_inc(Exception cause){
    return true;
  }
  public void inc(){
    valeurAvant = super.getValeur();
    assert pre_inc(): " pre assertion inc ???";
    Exception cause = null;
    try{
      super.inc();
    }catch(Exception e){
      cause = e;
      throw e;
    }finally{
      assert post_inc(cause):" post assertion dec ???";
    }
  }
  
  protected boolean pre_dec(){
    return true;
  }
  protected boolean post_dec(Exception cause){
    return true;
  }
  public void dec(){
    valeurAvant = super.getValeur();
    assert pre_dec(): " pre assertion dec ???";
    Exception cause = null;
    try{
      super.dec();
    }catch(Exception e){
      cause = e;
      throw e;
    }finally{
      assert post_dec(cause):" post assertion dec ???";
    }
  }
  
  protected boolean pre_getValeur(){
    return true;
  }
  protected boolean post_getValeur(){
    return true;
  }
  public int getValeur(){
    assert pre_getValeur() :" pre assertion getValeur ???";
    int res = super.getValeur();
    assert post_getValeur():" post assertion getValeur ???";
    return res;
  }
  
  public int getMin(){ return super.getMin();}
  public int getMax(){ return super.getMax();}
  public Integer af(){ return (Integer)super.af();}
  public boolean repOk(){return super.repOk();}
}
