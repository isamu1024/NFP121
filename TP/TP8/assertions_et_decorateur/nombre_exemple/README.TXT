package nombre_exemple;



public class NombrePrePost extends NombreDecorateur{
  protected boolean post_NombrePrePost(){
    return true;
  }
    
  public NombrePrePost(NombreI nombre){
    super(nombre);
    assert post_NombrePrePost();
  }
  
    
  
  private int valeurAvant;
  
  protected boolean pre_setValeur(int valeur){
    return true;
  }
  protected boolean post_setValeur(Exception cause, int valeur){
    return (cause == null && super.getValeur()==valeur) ||  
           (cause != null && cause instanceof RuntimeException && 
            super.getValeur()==valeurAvant);
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
    return (cause == null && super.getValeur()==valeurAvant+1) ||  
           (cause != null && cause instanceof RuntimeException && 
            super.getValeur()==valeurAvant);
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
    return (cause == null && super.getValeur()==valeurAvant-1) ||  
           (cause != null && cause instanceof RuntimeException && 
            super.getValeur()==valeurAvant);
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
  
  public int getValeur(){
    assert super.repOk():" pre invariant getValeur ???";
    int res = super.getValeur();
    assert super.repOk():" post invariant getValeur ???";
    return res;
  }
  
  public int getMin(){ return super.getMin();}
  public int getMax(){ return super.getMax();}
  public Integer af(){ return (Integer)super.af();}
  public boolean repOk(){return super.repOk();}
}
