import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Composite extends Composant implements Iterable<Composant>{

    private List<Composant> composants;

    public Composite(String nom){
        super(nom);
        this.composants = new ArrayList<>();
    }

    public Composite ajouter(Composant composant) throws Exception {
        // AJOUTE POUR EVITER LES BOUCLES INFINIES
        if(composant instanceof Composite) {
            if(composant == this)
                throw new Exception("boucle récursive infinie :this enfant de this");
            // if( ((Composite)composant).getEnfantsEnProfondeur().contains(this))
            if(this.estEnfantDe(composant))
                throw new Exception("boucle récursive infinie dans le lignage");
        }
        
        this.composants.add(composant);
        composant.setParent(this);
        return this;
    }

    public int nombreDeNoeuds(){
        int nombre=0;
        for(Composant c : composants) {
            nombre += c.nombreDeNoeuds();
        }
        return nombre;
    }

    public Iterator<Composant> iterator() {
        return composants.iterator();
    }
    
    // AJOUTE COMME OUTIL POUR EVITER LES BOUCLES INFINIES AVEC LA METHODE AJOUTER()
    // private List<Composant> getEnfantsEnProfondeur() {
        // List<Composant> enfantsEnProfondeur =  new ArrayList<>();
        // List<Composant> enfants2 =  new ArrayList<>();
        // for(Composant c : composants) {
            // enfantsEnProfondeur.add(c);
            // if(c instanceof Composite) {
                // enfants2 = ((Composite)c).getEnfantsEnProfondeur();
                // enfantsEnProfondeur.addAll(enfants2);
            // }
        // }
        // return enfantsEnProfondeur;
    // }


}