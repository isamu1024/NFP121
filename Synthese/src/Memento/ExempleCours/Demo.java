package Memento.ExempleCours;

public class Demo {
    public static void main(String[] args) throws Exception {
        NotePad notes = new NotePad();

        System.out.println("----- Ajout initial -----");

        notes.addNote("15h : il pleut");
        System.out.println("notes : " + notes);

        Caretaker gardien = new Caretaker();
        gardien.setMemento(notes.createMemento()); // sauvegarde

        notes.addNote("16h ; il fait beau");
        System.out.println("notes : " + notes);
        gardien.setMemento(notes.createMemento()); // sauvegarde

        notes.addNote("17h : il neige");
        System.out.println("notes : " + notes);

        System.out.println("----- après restitution -----");
        System.out.println("1ere recupération : ");

        notes.setMemento(gardien.getMemento());
        System.out.println("notes : " + notes);

        System.out.println("2eme récupération : ");

        notes.setMemento(gardien.getMemento());
        System.out.println("notes : " + notes);


    }
}
