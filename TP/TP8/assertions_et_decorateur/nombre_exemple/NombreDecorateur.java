package nombre_exemple;


public abstract class NombreDecorateur implements NombreI{
  private NombreI nombre;
  
  public NombreDecorateur(NombreI nombre){
    this.nombre = nombre;
  }

  public void setValeur(int valeur){
    nombre.setValeur(valeur);
  }
  public void inc(){
    nombre.inc();
  }
  public void dec(){
    nombre.dec();
  }
  
  public int getValeur(){
      return nombre.getValeur();
    }
  public int getMin(){
      return nombre.getMin();
    }
  public int getMax(){
      return nombre.getMax();
    }
  
  public Integer af(){
    return (Integer)nombre.af();
  }
  public boolean repOk(){
    return nombre.repOk();
  }
}
