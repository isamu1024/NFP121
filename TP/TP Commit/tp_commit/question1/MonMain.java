
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

            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            
            Cotisant a1 = new Contributeur("a1",100);
            g1.ajouter(a1);
            g1.ajouter(new Contributeur("b1",100));
            
            GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
            g2.ajouter(new Contributeur("a",100));
            g2.ajouter(new Contributeur("b",100));
            g2.ajouter(new Contributeur("c",100));
            
            g2.ajouter(g1);
            
            System.out.println(g2.nombreDeCotisants());
            System.out.println(g2.toString());
            
    
    }
    
}
