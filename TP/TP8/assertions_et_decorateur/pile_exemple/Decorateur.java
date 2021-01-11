package pile_exemple;

public abstract class Decorateur<T> implements PileI<T>{
    protected PileI<T> pile;

    public Decorateur(PileI<T> pile){
        this.pile=pile;
    }

    public void empiler(T t) throws PilePleineException{
        pile.empiler(t);
    }

    public T depiler() throws PileVideException{
        return pile.depiler();
    }

    public T sommet()throws PileVideException{
        return pile.sommet();
    }

    public boolean estVide(){
        return pile.estVide();
    }

    public boolean estPleine(){
        return pile.estPleine();
    }

    public int taille(){
        return pile.taille();
    }

    public int capacite(){
        return pile.capacite();
    }

    public boolean repOk(){
        return pile.repOk();
    }

    public <A> A af(){
        return pile.af();
    }
}
