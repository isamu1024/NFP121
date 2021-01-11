package pile_exemple;


public class Main{
 
    public static void test1() throws Exception{
        System.out.println("Tests d'une instance de " + new Fabrique<Integer>().creer().getClass().getSimpleName());
        PileI<Integer> pile = new PileRepOk<>(new Fabrique<Integer>().creer());
        operations(pile);
        pile = new PileAf<>(new Fabrique<Integer>().creer());
        operations(pile);
        pile = new PileAf<>(new PileRepOk<>(new Fabrique<Integer>().creer()));
        operations(pile);
        pile = new PileAf<>(new PileRepOk<>(new PilePrePost<>(new Fabrique<Integer>().creer())));
        operations(pile);
        pile = new PileAf<>(new PileRepOk<>(new PilePrioritePrePost<>(new Fabrique<Integer>().creer())));
        operations(pile);
        
    }
    
    
    private static void operations(PileI<Integer> pile) throws Exception{
        int element = 1;
        while(!pile.estPleine()){
            pile.empiler(element);
            assert element==pile.sommet();
            element++;
        }
        while(!pile.estVide()){
            element = pile.depiler();
        }        
    }
}
