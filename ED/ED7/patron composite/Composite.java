import java.util.*;

public abstract class Composite extends Composant implements Iterable<Composant>{

    private List<Composant> composants;

    public Composite(String nom){
        super(nom);
        this.composant = new ArrayList<>();
    }

    public Composite ajouter(Composant composant) throws Exception{
        {
            if(composant instanceof Composite) {
                if (composant == this)
                    throw new Exception("boucle récursive : this enfant de this");
                if ((Composite)composant).getEnfantsEnProfondeur().contains(this))
                throw new Exception("boucle récursive dans le lignage");
            }
            this.composant.add(composant);
            composant.setParent(this);
            return this;
        }
    }

    public int nombreDeNoeuds(){
        int nombre=0;
        for(Composant c : composants) {
            nombre += c.nombreDeNoeuds();         
        }
        return nombre;
    }

    public Iterator<Composant> Iterator() {
        return composant.iterator();
    }

    private List<Composant> getEnfantsEnProfondeur(){

        List<Composant> enFantsEnProfondeur = new Arraylist<>();
        for(composant c : composants) {
            enfantsEnProfondeur.add(c);
            if(c instanceof ListeDeComposants){
                
            }
        }
    }
}