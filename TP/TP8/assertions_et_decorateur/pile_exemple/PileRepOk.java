package pile_exemple;


public class PileRepOk<T> extends Decorateur<T>{
    public PileRepOk(PileI<T> pile){
        super(pile);
        assert super.pile.repOk() : " repOk invalide !";
    }

    
    public void empiler(T t) throws PilePleineException{
        assert pile.repOk() : " repOk invalide !";
        pile.empiler(t);
        assert pile.repOk() : " repOk invalide !";
    }

    public T depiler() throws PileVideException{
        assert pile.repOk() : " repOk invalide !";
        T t = super.depiler();
        assert pile.repOk() : " repOk invalide !";
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
