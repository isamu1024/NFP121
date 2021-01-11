
/**
 * Décrivez votre classe Memento ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Memento
{

    private int valeur;

    public Memento(Entier e){

        this.valeur = e.getValeur();
    }

    public int getSavedState(){

        return this.valeur;
    }

}
