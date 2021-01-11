
/**
 * Décrivez votre classe PolygoneRégulier ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class PolygoneRegulier
{
   private int longueurDuCote;
   private int nombreDeCote;
   
   public PolygoneRegulier(int longueur, int nbc){
       this.longueurDuCote = longueur;
       this.nombreDeCote = nbc;
   }
   
   public int surface(){
    return (int) (1/4.0 * nombreDeCote * Math.pow(longueurDuCote, 2.0) * cotg (Math.PI / nombreDeCote));
    }
    
    private static double cotg (double x) {
    return Math.cos(x) / Math.sin(x);
    }
   
   public int getLongueurDuCote(){
       return longueurDuCote;
    }
    
   public int getNombreDeCote(){
       return nombreDeCote;
    }
    
   public void setLongueurDuCote(int longueur){
    this.longueurDuCote = longueur;
    }
    
    public void setNombreDeCotes(int nbC) {
    this.nombreDeCote = nbC;
    }
   
}
