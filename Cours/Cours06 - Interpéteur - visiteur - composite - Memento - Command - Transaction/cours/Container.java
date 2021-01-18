import java.util.*;

public abstract class Container extends Composant{
    protected List<Composant> liste;

    public void dessiner(){
        for(Composant c : liste){
            c.dessiner();
        }
    }

    public Container (){liste = new ArrayList<Composant>();}

    public void ajouter(Composant c){ liste.add(c);}
}