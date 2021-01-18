package Memento.ExempleCours;

import java.util.ArrayList;
import java.util.List;

/**
 * Un bloc note rudimentaire pour illustrer la sauvegarde et la restitution par memento
 */
public class NotePad {

    private List<String> notes = new ArrayList<>();

    public void addNote(String note) throws Exception {
        notes.add(note);
    }

    public String toString() {
        return notes.toString();
    }

    private List<String> getNotes() {
        return this.notes;
    }

    private void setNotes(List<String> notes) {
        this.notes = notes;
    }

    /**
     * Creation du memento et sauvegarde
     *
     * @return memento contenant la sauvegarde
     */
    public Memento createMemento() {
        Memento memento = new Memento();
        memento.setState(); // Sauvegarde ... ici la liste de notes.
        return memento;
    }

    /**
     * Récupération depuis le memento
     *
     * @param memento
     */
    public void setMemento(Memento memento) {
        memento.getState(); // Restitution du notepad
    }

    /**
     * Classe memento interne, par facilité
     */
    public class Memento {
        private List<String> mementoNotes;

        public void setState() {
            mementoNotes = new ArrayList<String>(getNotes()); // copie de la liste
        }

        public void getState() {
            setNotes(mementoNotes); // Restitution par écrasement du contenu de la variable d'instance
        }
    }
}
