package pile_exemple;

import java.util.Stack;
import java.util.EmptyStackException;
public class PileAf<T> extends Decorateur<T>{
    
    public PileAf(PileI<T> pile){
        super(pile);
        //assert ??? : " af invalide !";
    }

    
    public void empiler(T t) throws PilePleineException{
        Stack<T> stk = super.af();
        try{
            pile.empiler(t);
            stk.push(t);
        }catch(Exception e){
            assert e instanceof PilePleineException;
        }
        assert pile.af().equals(stk) : " af invalide !";
    }

    public T depiler() throws PileVideException{
        Stack<T> stk = super.af();
        T t = null, t1 = null;
        try{
          t1 = stk.pop();
          t = super.depiler();
          assert (t==null && t1==null) || t.equals(t1);
        }catch(Exception e){
            assert e instanceof EmptyStackException:"L'exception EmptyStackException devrait être levée !";;
            try{
                t = super.depiler();
                assert false : "L'exception PileVideException devrait être levée !";
            }catch(Exception e1){
                assert e1 instanceof PileVideException;
            }
        }
        assert pile.af().equals(stk) : " af invalide !";
        
        return t;
    }

    public T sommet()throws PileVideException{
       Stack<T> stk = super.af();
        T t = null, t1 = null;
        try{
          t1 = stk.peek();
          t = super.sommet();
          assert (t==null && t1==null) || t.equals(t1);
        }catch(Exception e){
            assert e instanceof EmptyStackException:"L'exception EmptyStackException devrait être levée !";;
            try{
                t = super.sommet();
                assert false : "L'exception PileVideException devrait être levée !";
            }catch(Exception e1){
                assert e1 instanceof PileVideException;
                assert pile.af().equals(stk) : " af invalide !";
                throw e1;
            }
        }
        assert pile.af().equals(stk) : " af invalide !";
        
        return t;
    }

    public boolean estVide(){
        Stack<T> stk = super.af();
        boolean b1 = stk.isEmpty();
        boolean b  = super.estVide();
        assert pile.af().equals(stk) : " af invalide !";
        assert (b==b1);
        return b;
    }

    public boolean estPleine(){
        //boolean t1 = stk.isFull(); // n'existe pas dans l'abstrait
        boolean t  = super.estPleine();
        assert pile.af().equals(super.af()) : " af invalide !";
        return t;
    }

    public int taille(){
        Stack<T> stk = super.af();
        int t1 = stk.size();
        int t  = super.taille();
        assert pile.af().equals(stk) : " af invalide !";
        assert (t==t1);
        return t;
    }
    
   
}