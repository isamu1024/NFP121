package PlusieurPatterns.Composite;

import PlusieurPatterns.Cancaneur;

import java.util.ArrayList;
import java.util.Iterator;

public class Troupe implements Cancaneur, Iterable {
    ArrayList<Cancaneur> cancaneurs = new ArrayList<>();

    public Troupe add(Cancaneur cancaneur) {
        this.cancaneurs.add(cancaneur);
        return this;
    }

    @Override
    public void cancaner() {
        for (Cancaneur cancaneur : this.cancaneurs)
            cancaneur.cancaner();
    }

    @Override
    public Iterator iterator() {
        return this.cancaneurs.iterator();
    }
}
