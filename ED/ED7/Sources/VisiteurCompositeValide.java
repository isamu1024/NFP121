import java.util.Set;
import java.util.HashSet;

public class VisiteurCompositeValide extends Visiteur<Boolean> {
    
    Set<String> noeuds;
    Set<String> listes;
    
    public VisiteurCompositeValide() {
        this.noeuds = new HashSet<>();
        this.listes = new HashSet<>();
    }
  
     public Boolean visite(Noeud n){ 
      return noeuds.add(n.getNom());
    }
  
  public Boolean visite(ListeDeComposants l){
      // OK si le nom n'est pas déjà présent dans la liste ET si la liste de composants n'est pas vide
      boolean result = listes.add(l.getNom()) && l.nombreDeNoeuds()>0;
      // puis on vérifie en profondeur
      for(Composant c : l) {
          result &= c.accepter(this);
        }
        return result;
    }
    
}
