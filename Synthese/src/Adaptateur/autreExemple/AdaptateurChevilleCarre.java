package Adaptateur.autreExemple;

public class AdaptateurChevilleCarre extends ChevilleRonde {
    private ChevilleCarree cheville;

    public AdaptateurChevilleCarre(ChevilleCarree cheville){
        this.cheville = cheville;
    }

    @Override
    public double getRayon() {
        double resultat;
        resultat = (Math.sqrt(Math.pow((this.cheville.getCote() /2),2)*2));
        return resultat;
    }
}
