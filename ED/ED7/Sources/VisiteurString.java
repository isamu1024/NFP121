

public class VisiteurString extends Visiteur<String> {
    
  public String visite(Noeud n){ 
      return "Noeud:<"+n.getNom()+">";
    }
  
  public String visite(ListeDeComposants l){
      String st = "Liste:"+l.getNom()+"[";
        for(Composant c : l) {
            st += c.accepter(this);
        }
        st += "]";
        return st;
    }
}
