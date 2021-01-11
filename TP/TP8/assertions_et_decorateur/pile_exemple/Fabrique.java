package pile_exemple;


public class Fabrique<T extends Comparable<T>> implements FabriqueI<PileI<T>>{ 
   public PileI<T> creer(){
       //return new Pile4<>(); // ok
       //return new Pile2<>();
       return new PilePriorite<T>();
    }
    public PileI<T> creer(int capacite){
       //return new Pile4<>(capacite);
       //return new Pile2<>(capacite);
       return new PilePriorite<>(capacite);
    }
}
