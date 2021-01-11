package pile_exemple;

public class PilePrePost<T> extends Decorateur<T>{

    public PilePrePost(PileI<T> pile){
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
        return true;
    }

    protected boolean post_empiler(T t){
        try{
            return (pre_pile.estPleine() && pre_pile.equals(pile) && cause instanceof PilePleineException) ||
            (!pre_pile.estPleine() && (pile.sommet()==t) && cause==null);
        }catch(PileVideException e){
            assert false: "Une exception ne devrait pas être levée ici " + e.getMessage();
            return false;
        }

    }

    public void empiler(T t) throws PilePleineException{

        assert pre_empiler() : "pre-assertion empiler en échec" ;
        try{
            super.empiler(t);
        }catch(Exception e){
            cause = e;
            throw e;
        }finally{
            assert post_empiler(t): "post-assertion empiler en échec" ;;
        }

    }

    protected boolean pre_depiler(){
        pre();
        return true;
    }

    protected boolean post_depiler(T t){
        try{
            return (pre_pile.estVide() && pre_pile.equals(pile) && (cause instanceof PileVideException)) ||
            (!pre_pile.estVide() && (t==pre_pile.sommet()));
        }catch(PileVideException e){
            assert false: "Une exception ne devrait pas être levée ici " + e.getMessage();
            return false;
        }
    }

    public T depiler() throws PileVideException{
        T t = null;
        assert pre_depiler() : "pre-assertion empiler en échec" ;
        try{
            t = super.depiler();
        }catch(Exception e){
            cause=e;
            throw e;
        }finally{
            assert post_depiler(t) : "post-assertion depiler en échec" ;
        }

        return t;
    }

    protected boolean pre_sommet(){
        pre();
        return true;
    }

    protected boolean post_sommet(T t){
        try{
            return 
            (pre_pile.estVide() && pre_pile.equals(pile) && (cause instanceof PileVideException)) ||
            (!pre_pile.estVide() && pre_pile.equals(pile) && (t==pre_pile.sommet()));
        }catch(PileVideException e){
            assert false: "Une exception ne devrait pas être levée ici " + e.getMessage();
            return false;
        }
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

    protected boolean pre_estVide(){
        pre();
        return true;
    }

    protected boolean post_estVide(boolean result){
        return pre_pile.equals(pile) && (cause ==null) && 
        ((result==true && pre_pile.taille()==0) || (result==false && pre_pile.taille()>=1));

    }

    public boolean estVide(){
        assert pre_estVide() : "pre-assertion estVide en échec" ;
        boolean result = false;
        try{
            result = super.estVide();
        }catch(Exception e){
            cause = e;
        }finally{
            assert post_estVide(result) : "post-assertion estVide en échec" ;
        }
        return result;
    }

    protected boolean pre_estPleine(){
        pre();
        return true;
    }

    protected boolean post_estPleine(boolean result){
        return 
        (pre_pile.equals(pile)) &&
          ((result==true && pre_pile.taille()==capacite()) || 
           (result==false && pre_pile.taille()<capacite()));

    }

    public boolean estPleine(){
        assert pre_estPleine() : "pre-assertion estPleine en échec" ;
        boolean result = false;
        result = super.estPleine();
        assert post_estPleine(result) : "post-assertion estPleine en échec";
        return result;
    }

    protected boolean pre_taille(){
        pre();
        return true;
    }

    protected boolean post_taille(int result){
        return pre_pile.equals(pile) && (cause ==null) && (result>=0);
    }

    public int taille(){
        assert pre_taille() : "pre-assertion taille en échec" ;
        int result = -1;
        try{
            result = super.taille();
        }catch(Exception e){
            cause = e;
        }finally{
            assert post_taille(result) : "post-assertion taille en échec" ;
        }
        return result;
    }

}
