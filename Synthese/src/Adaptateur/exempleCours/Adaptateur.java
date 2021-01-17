package Adaptateur.exempleCours;

/**
 * Encapsulation de l'objet adapté ici ce sera notre prise RCA
 */
public class Adaptateur implements Prise {
    public Plug adapte; // ce qui sera adapte

    public Adaptateur(Plug adapte){
        this.adapte = adapte;
    }

    public void afficher(){
        adapte.afficher();
    }

}
