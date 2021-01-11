package question1;

/**
 * Décrivez votre classe MonMain ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MonMain
{
    public static void main(String[] args){
        Ensemble<Integer> e1 = new Ensemble<Integer>();
        Ensemble<Integer> e2 = new Ensemble<Integer>();

        e1.add(1);
        e1.add(2);
        e1.add(3);
        e1.add(4);

        e2.add(5);
        e2.add(6);

        System.out.println(e1);
        System.out.println(e1.union(e2));
        System.out.println(e1);

    }
}
