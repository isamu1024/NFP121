package nombre_exemple;



public class NombreRepOk extends NombreDecorateur{
  public NombreRepOk(NombreI nombre){
    super(nombre);
    assert super.repOk();
  }
  
  public void setValeur(int valeur){
    assert super.repOk():" pre invariant setValeur ???";
    super.setValeur(valeur);
    assert super.repOk():" post invariant setValeur ???";
  }
  public void inc(){
    assert super.repOk():" pre invariant inc ???";
    super.inc();
    assert super.repOk():" post invariant inc ???";
  }
  public void dec(){
    assert super.repOk():" pre invariant dec ???";
    super.dec();
    assert super.repOk():" post invariant dec ???";
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
