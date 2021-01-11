package pile_exemple;

import java.util.*;

public class PilePrioritePrePost<T extends Comparable<T>> extends PilePrePost<T>{

    public PilePrioritePrePost(PileI<T> pile){
        super(pile);
    }

    private PileI<T> clone(PileI<T> p) {
        try{
            if(p.estVide()){
                PileI<?> pile = new Fabrique<>().creer(p.capacite());
                return (PileI<T>)pile; 
            }else{
                T element = pile.depiler();
                PileI<T> p1 = clone(pile);
                p1.empiler(element);
                p.empiler(element);
                return p1;
            }
        }catch(Exception e){
            assert false: "Une exception ne devrait pas être levée ici " + e.getMessage();
            return null;
        }
    }

    /* Vecteur d'état, nécessaire aux pré-post assertions, noms à revoir */
    private PileI<T> pre_pile;
    private Exception cause;
    private void pre(){ /* initialisation du vecteur */
        this.pre_pile = clone(pile);
        cause = null;
    }

    protected boolean pre_empiler(){
        pre();
        // pre_super ==> pre_sub, !(pre_super) || pre_sub Liskov  
        //return !super.pre_empiler() || true;
        // pre_super || pre_sub Eiffel
        return super.pre_empiler() || true;
    }

    protected boolean post_empiler(T t){
        PileI<T> post_pile = clone(pile);
        return super.post_empiler(t) && true;
    }

    public void empiler(T t) throws PilePleineException{

        assert pre_empiler() : "pre-assertion empiler en échec" ;
        try{
            pile.empiler(t);
        }catch(Exception e){
            cause = e;
            throw e;
        }finally{
            assert post_empiler(t): "post-assertion empiler en échec" ;;
        }
    }

    protected boolean pre_sommet(){
        pre();
        return super.pre_sommet() || true;
    }

    protected boolean post_sommet(T t){
        PileI<T> post_pile = clone(pile);
        return super.post_sommet(t) && max(post_pile).equals(t);
    }

    private static <T extends Comparable<T>> T max (PileI<T> pile){
        List<T> liste = new ArrayList<>();
        while(!pile.estVide()){
            try{
                liste.add(pile.depiler());
            }catch(PileVideException e){}
        }
        return Collections.max(liste);
    }
    public T sommet()throws PileVideException{
        assert pre_sommet() : "pre-assertion sommet en échec" ;
        T t = null;
        try{
            t = super.sommet();
        }catch(PileVideException e){
            cause = e;
            throw e;
        }finally{
            assert post_sommet(t) : "post-assertion sommet en échec" ;
        }
        return t;
    }
}
