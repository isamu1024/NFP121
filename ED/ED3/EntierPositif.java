
/**
 * Décrivez votre classe EntierPositif ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class EntierPositif extends Entier
{

    public EntierPositif(int valeur){
        super(valeur);

        if (valeur < 0) 
            throw new EntierPositifException("constructeur en défaut");

    }

    public void dec(){
        if (this.getValeur() == 0)
            throw new EntierPositifException("dec en defaut");
        super.dec();
    }

    
    public void inc(){

        if(getValeur()==Integer.MAX_VALUE)
            throw new EntierPositifException("inc en defaut");

        super.inc();
    }

    public void setValeur(int valeur){

        if (valeur < 0) 
            throw new EntierPositifException("setValeur en défaut");
            
        super.setValeur(valeur);
    }

}
