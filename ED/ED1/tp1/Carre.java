
/**
 * D�crivez votre classe Classe ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class Carre extends PolygoneRegulier
{
    // variables d'instance - remplacez l'exemple qui suit par le v�tre
    private int x;

    /**
     * Constructeur d'objets de classe Classe
     */
    public Carre(int LongueurDeCote)
    {
        super(LongueurDeCote, 4);
    }
    
    @Override
    public int surface(){
    return this.getLongueurDuCote() * this.getLongueurDuCote();
    }
    
    @Override
    public void setNombreDeCotes(int nbC) {
        this.setNombreDeCotes(4);
    }
    
    
    
}
