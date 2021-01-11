package pile_exemple;

import java.util.Stack;
import java.util.List; // cf. af
import java.util.ArrayList;

public class Pile2<T> implements PileI<T>{
  /** par délégation : utilisation de la class Stack */
  protected Stack<T> stk;
  /** la capcité de la pile */
  protected int   capacite;
  
  /** Création d'une pile.
   * @param taille la taille de la pile, la taille doit être > 0
   */
  public Pile2(int taille){
    if(taille<=0) taille = CAPACITE_PAR_DEFAUT;
    this.stk = new Stack<>();
    this.capacite = taille;
  }

  public Pile2(){
    this(PileI.CAPACITE_PAR_DEFAUT);
  }
  

  public void empiler(T t) throws PilePleineException{
    if(estPleine()) throw new PilePleineException();
    stk.push(t);
  }
  

  public T depiler() throws PileVideException{
    if(estVide())  throw new PileVideException();
    return stk.pop();
  }


  public T sommet() throws PileVideException{
    if(estVide())  throw new PileVideException();
     return stk.peek();
  }
  
  /** Effectue un test de l'état de la pile.
   * @return vrai si la pile est vide, faux autrement
   */
  public boolean estVide(){
    return stk.empty();
  }

  /** Effectue un test de l'état de la pile.
   * @return vrai si la pile est pleine, faux autrement
   */   
  public boolean estPleine(){
    return capacite == stk.size();
  }
  
  /** Retourne une représentation en String d'une pile, 
   * contenant la représentation en String de chaque élément.
   * @return une représentation en String d'une pile
   */ 
  public String toString(){
    String s = "[";
    for(int i = stk.size()-1; i>=0;i--){
      s = s + stk.elementAt(i);
      if(i>0) s = s+ ", ";
    }
    return s + "]";

  }
  

  public int capacite(){
    return this.capacite;
  }
  
  public int taille(){
    return this.stk.size();
  }
  
  public boolean equals(Object o){
    if (o instanceof Pile2){
      Pile2 p = (Pile2)o;
      if(p.taille()==this.taille()  && p.capacite() == this.capacite()){
        for(int i = stk.size()-1; i>=0;i--)
          if(!stk.elementAt(i).equals(p.stk.elementAt(i))) return false;
        return true;
      }
    }
    return false;
  }
  
  
  public int hashCode(){
    return toString().hashCode();
  }
  

  public Stack<T> af(){
      Stack<T> stack = new Stack<>();
      for(T t : new ArrayList<>(stk)){
          stack.push(t);
        }
      return stack;
  }
    
  public boolean repOk(){
    return (taille()>=0 && taille()<=capacite());
  }
}