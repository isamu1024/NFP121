package Composite.ExempleTPCommit.Composite;

import java.util.ArrayList;
import java.util.List;

public class GroupeDeContributeurs extends Cotisant implements Iterable<Cotisant> {

    private List<Cotisant> liste;

    public GroupeDeContributeurs(String nomDuGroupe){
        super(nomDuGroupe);
        this.liste  = new ArrayList<>();
    }

    public void ajouter(Cotisant cotisant) {
        if (this.liste.contains(cotisant))
            System.out.println("Cotisant déjà présent");

        this.liste.add(cotisant);
        cotisant.setParent(this);
    }

    public int nombreDeCotisants(){
        int nombre = 0;

        for (Cotisant cotisant : this.liste)
            nombre += cotisant.nombreDeCotisant(); // rappel la feuille renvoi 1
        return nombre;
    }

    /**
     *
     * @return format attendu :  "<Contributeur : " + nom + "," + solde + ">"
     */
    public String toString(){

    }

}
