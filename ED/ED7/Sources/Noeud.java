
public class Noeud extends Composant {
    
    public Noeud(String nom) {
        super(nom);
    }
    
    public int nombreDeNoeuds() {
        return 1;
    }
    
    public String interpreter() {
        return "Noeud:<"+this.getNom()+">";
    }
   
    public <T> T accepter(Visiteur<T> visiteur) {
        return visiteur.visite(this);
    }
  
}
