package Composite_Visiteurs.ExempleTPCommit.Composite;


public class Contributeur extends Cotisant {

    private int solde;

    public Contributeur(String nom, int somme) {
        super(nom);
        this.affecterSolde(somme);
    }

    public int getSolde() {
        return this.solde;
    }

    public int nombreDeCotisants() {
        return 1;
    }

    public void debit(int somme) throws SoldeDebiteurException {
        if (somme < 0)
            throw new RuntimeException("Nombre négatif");
        if (this.solde - somme < 0)
            throw new SoldeDebiteurException();

        this.solde -= somme;
    }

    public void credit(int somme) {
        if (somme < 0)
            throw new RuntimeException("Nombre négatif");
        this.solde += somme;
    }

    public void affecterSolde(int somme) {
        if (somme < 0)
            throw new RuntimeException("nombre négatif");
        try{
            debit(this.getSolde());
            credit(somme);
            // mode élégant ...
        }catch(SoldeDebiteurException sde){
            // exception peu probable
            this.solde = somme; // mode efficace ...
        }
    }

    public <T> T accepter(Visiteur<T> visiteur){
        return visiteur.visite(this);
    }

    public String toString(){
        return "<Contributeur : " +this.nom + " , " + this.solde + ">";
    }

}
