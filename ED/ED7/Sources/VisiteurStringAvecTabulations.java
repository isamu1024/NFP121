

public class VisiteurStringAvecTabulations extends Visiteur<String> {
  
     public String visite(Noeud n){ 
      return "Noeud:<"+n.getNom()+">";
    }
  
  public String visite(ListeDeComposants l){
      String st = "Liste:"+l.getNom()+"\n";
        for(Composant c : l) {
            Composant parent = c.getParent();
            while(parent != null) {
                st += "\t";
                parent = parent.getParent();
            }
            if(c instanceof Noeud)
                st += c.accepter(this)+"\n";
            else
                st += c.accepter(this);
        }
        return st;
    }
    
}
