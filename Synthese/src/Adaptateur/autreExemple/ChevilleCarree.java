package Adaptateur.autreExemple;

public class ChevilleCarree {
    private double cote;

    public ChevilleCarree(double cote){
        this.cote = cote;
    }

    public double getCote(){
        return this.cote;
    }

    public double getCarre(){
        double resultat;
        resultat = Math.pow(this.cote,2);
        return resultat;
    }
}
