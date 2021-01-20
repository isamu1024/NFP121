package Composite_Visiteurs.ExempleTPCommit.Composite;

/**
 * Extrait du TPCommit
 * Comme précédemment la classe abstraite est la base du composite
 */
public abstract class Cotisant {

    protected String nom;
    protected Cotisant parent;

    public Cotisant(String nom, Cotisant parent) {
        this.nom = nom;
        this.parent = parent;
    }

    /**
     * Constructeur "incomplet" appelle le constructeur "complet"
     *
     * @param nom le nom du cotisant
     */
    public Cotisant(String nom) {
        this(nom, null);
    }

    public abstract void debit(int somme) throws SoldeDebiteurException;

    public abstract void credit(int somme);

    public abstract int getSolde();

    public abstract int nombreDeCotisants();

    public String getNom() {
        return nom;
    }

    public boolean equals(Object o) {
        return nom.equals(((Cotisant) o).nom);
    }

    public void setParent(Cotisant parent) {
        this.parent = parent;
    }

    public Cotisant getParent(){
        return this.parent;
    }

    public abstract <T> T accepter(Visiteur<T> visiteur);
}
