
/**
 * Décrivez votre classe PolygoneRegulier ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class PolygoneRegulier
{
    private int nombreDeCotes;
    private int longueurDuCote;
    
    public PolygoneRegulier(int nombreDeCote, int longueurDuCote){
        this.nombreDeCotes = nombreDeCotes;
        this.longueurDuCote = longueurDuCote;
    }
    
    
    public int surface(){
        return (int)(1/4.0 * nombreDeCotes * Math.pow(longueurDuCote,2.0) *
        cotg(Math.PI / nombreDeCotes));
    }

    private static double cotg(double x){
        return Math.cos(x)/Math.sin(x);
    }
}
