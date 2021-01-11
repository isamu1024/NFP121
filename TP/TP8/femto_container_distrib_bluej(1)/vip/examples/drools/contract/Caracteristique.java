package vip.examples.drools.contract;

public class Caracteristique {
    private int numDossier;
    private String nom;
    private int valeur;
     
    public Caracteristique(){}
    public Caracteristique(int numDossier, String nom, int valeur) {
        super();
        this.numDossier = numDossier;
        this.nom = nom;
        this.valeur = valeur;
    }
//getters and setters …
    
    public int getNumDossier(){ return numDossier;}
    public String getNom(){ return nom;}
    public int getValeur(){ return valeur;}
    public String toString(){
        return "<" + numDossier + "," + nom + "," + valeur + ">";
    }
}