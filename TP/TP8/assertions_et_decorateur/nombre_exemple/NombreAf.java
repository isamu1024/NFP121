package nombre_exemple;


public class NombreAf extends NombreDecorateur{
  public NombreAf(NombreI nombre){
    super(nombre);
  }
  
  public void setValeur(int valeur){
    super.setValeur(valeur);
    assert super.getValeur() == super.af().intValue():" af setValeur ???";
  }
  public void inc(){
    Integer i = super.af();
    super.inc();
    Integer i1 = Integer.valueOf(i.intValue()+1);
    assert super.getValeur() == i1.intValue() : " af inc ???";
  }
  public void dec(){
   Integer i = super.af();
    super.dec();
    Integer i1 = Integer.valueOf(i.intValue()-1);
    assert super.getValeur() == i1.intValue() : " af dec ???";  
  }
  
  public int getValeur(){
    Integer i = super.af();
    int res = super.getValeur();
    assert res == i.intValue() : " af getValeur ???";
    return res;
  }
  
  public int getMin(){ return super.getMin();}
  public int getMax(){ return super.getMax();}
  public Integer af(){ return (Integer)super.af();}
  public boolean repOk(){return super.repOk();}
}
