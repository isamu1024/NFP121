package question2;
import java.util.*;

/**
 * D�crivez votre classe MonMain ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class MonMain
{
    public static void main(String[] args){

        // Pour v�rification en cours de r�daction du TP et �criture classe de test
        
        List<String> liste = question2.Chapitre2CoreJava2.listeDesMots();

        Map<String, Integer> table = question2.Chapitre2CoreJava2.occurrencesDesMots(liste);

        Iterator it = table.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}
