public abstract class Composant{
    private String nom;
    private Composant parent;

    public Composant(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public abstract int nombreDeNoeuds();

    public abstract String interpreter();

    public abstract <T> T accepter(Visiteur<T> visiteur);

    public Composant getParent(){
        return this.parent;
    }

    public void setParent(Composant parent){
        this.parent = parent;
    }

    //...
}