package Persistance.ExempleCours;

import java.io.Serializable;

public class Unite implements Serializable {
    private String nom;

    public Unite(String nom){
        this.nom = nom;
    }

    public String toString(){
        return this.nom;
    }

}
