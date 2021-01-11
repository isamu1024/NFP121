

public class Entier {
  private int valeur;

  public Entier(int valeur){this.valeur = valeur;}
  
  public void inc(){this.valeur++;}
  public void dec(){this.valeur--;}
  
  public int getValeur(){return this.valeur;}
  public void setValeur(int valeur){this.valeur = valeur;}

  public String toString(){return Integer.toString(this.valeur);}
  
  public String toString(int base){return Integer.toString(this.valeur, base);}
  
  public boolean equals(Object obj){
    if(obj instanceof Entier){
      Entier e = (Entier) obj;
      return this.valeur == e.valeur;
    }
    return false;
  }
  
  public int hashCode(){return this.valeur;}

  public boolean repOk(){return true;}

  public Integer af(){return new Integer(getValeur());}
  
  public static Entier parseEntier(String s) throws NumberFormatException{
//     try{
      int valeur = Integer.parseInt(s);
      return new Entier(valeur);
//     }catch(NumberFormatException e){
//       throw e;
//     }
  }
}
