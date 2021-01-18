package Observer.ExempleCours1;

import java.util.*;

/**
 * Classe abstraite de l'objet observé
 */

public abstract class Subject {
    protected Set<Observateur> observateurs;

    public Set<Observateur> attach(Observateur o) {
        this.observateurs.add(o);
        return this.observateurs;
    }

    public Set<Observateur> detach(Observateur o) {
        this.observateurs.remove(o);
        return this.observateurs;
    }

    public abstract void setValue(int value);

    public List<Observateur> getObservateurs(){
        return new ArrayList<>(this.observateurs);
    }

    public void notification(int value) {
        for (Observateur o : observateurs)
            o.update("Nouvelle valeur : "  + value);
    }

}
