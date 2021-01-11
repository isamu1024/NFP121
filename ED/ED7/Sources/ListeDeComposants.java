

public class ListeDeComposants extends Composite {
    
    public ListeDeComposants (String nom) {
        super(nom);
    }
    
    public String interpreter() {
        String st = "Liste:"+this.getNom()+"[";
        for(Composant c : this) {
            st += c.interpreter();
        }
        st += "]";
        return st;
    }
   
    public <T> T accepter(Visiteur<T> visiteur) {
        return visiteur.visite(this);
    } 
    
}
