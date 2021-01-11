package question2;
import java.util.*;

/**
 * Décrivez votre classe MonMain ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MonMain
{
    public static void main(String[] args){

        // Pour vérification en cours de rédaction du TP et écriture classe de test
        
        List<String> liste = question2.Chapitre2CoreJava2.listeDesMots();

        Map<String, Integer> table = question2.Chapitre2CoreJava2.occurrencesDesMots(liste);

        Iterator it = table.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}
