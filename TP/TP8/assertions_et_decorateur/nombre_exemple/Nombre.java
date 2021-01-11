package nombre_exemple;

public class Nombre implements NombreI {
  private int valeur;
  private final int min;
  private final int max;
  
  public Nombre(int min, int max){
    if(min>=max) throw new RuntimeException(" min >= max");
    this.valeur=min;
    this.min = min;
    this.max = max;
  }
  public void setValeur(int valeur){
    if((valeur<min || valeur>max)) throw new RuntimeException("valeur<min || valeur>max");
    this.valeur = valeur;
  }
  public void inc(){
    if(valeur==max)throw new RuntimeException("inc: valeur == max");
    this.valeur++;
  }
  public void dec(){
    if(valeur==min)throw new RuntimeException("dec: valeur == min");
    this.valeur--;
  }
  
  public int getValeur(){return this.valeur;}
  public int getMin(){ return this.min;}
  public int getMax(){ return this.max;}
  
  public Integer af(){
    return new Integer(valeur);
  }
  public boolean repOk(){
    return this.valeur>=min && this.valeur<=max;
  }
}