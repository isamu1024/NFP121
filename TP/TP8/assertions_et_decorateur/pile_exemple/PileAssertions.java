package pile_exemple;

public class PileAssertions<T> extends Decorateur<T>{

    public PileAssertions(PileI<T> pile){
        super(pile);
    }

    private PileI<T> creerUneCopie(PileI<T> p) {
        try{
            if(p.estVide()){
                PileI<?> pile = new Fabrique<>().creer(p.capacite());
                return (PileI<T>)pile;  
            }else{
                T element = pile.depiler();
                PileI<T> p1 = creerUneCopie(pile);
                p1.empiler(element);
                p.empiler(element);
                return p1;
            }
        }catch(Exception e){
            assert false: "Une exception ne devrait pas être levée ici " + e.getMessage();
            return null;
        }

    }

    public void empiler(T t) throws PilePleineException{
        PileI<T> pileOld = null;
        Exception cause = null;

        pileOld = creerUneCopie(pile);
        assert pileOld.equals(pile);
        try{
            super.empiler(t);
        }catch(Exception e){
            cause = e;
            throw e;
        }finally{
            try{
                assert (pileOld.estPleine() && pileOld.equals(pile) && cause instanceof PilePleineException) ||
                (!pileOld.estPleine() && (pile.sommet()==t) && cause==null);
            }catch(PileVideException e){
                assert false: "Une exception ne devrait pas être levée ici " + e.getMessage();
            }
        }

    }

    public T depiler() throws PileVideException{
        PileI<T> pileOld = null;
        T t = null;
        Exception cause = null;

        pileOld = creerUneCopie(pile);
        assert pileOld.equals(pile);
        try{
            t = super.depiler();
        }catch(Exception e){
            cause=e;
            throw e;
        }finally{
            assert (pileOld.estVide() && pileOld.equals(pile) && (cause instanceof PileVideException)) ||
            (!pileOld.estVide() && (t==pileOld.sommet()));
        }

        return t;
    }

    public T sommet()throws PileVideException{
        assert pile.repOk() : " repOk invalide !";
        T t = super.sommet();
        assert pile.repOk() : " repOk invalide !";
        return t;
    }

    public boolean estVide(){
        assert pile.repOk() : " repOk invalide !";
        boolean res = super.estVide();
        assert pile.repOk() : " repOk invalide !";
        return res;
    }

    public boolean estPleine(){
        assert pile.repOk() : " repOk invalide !";
        boolean res = super.estPleine();
        assert pile.repOk() : " repOk invalide !";
        return res;
    }

    public int taille(){
        assert pile.repOk() : " repOk invalide !";
        int res = super.taille();
        assert pile.repOk() : " repOk invalide !";
        return res;
    }

}
