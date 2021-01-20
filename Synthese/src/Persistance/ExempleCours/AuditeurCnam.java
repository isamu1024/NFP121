package Persistance.ExempleCours;

import java.io.Serializable;
import java.util.*;

public class AuditeurCnam implements Serializable {
    private String nom;
    private List<Unite> liste;

    public AuditeurCnam(String nom){
        this.nom = nom;
        this.liste = new ArrayList<>();
    }

    public AuditeurCnam addUnite(Unite unite){
        this.liste.add(unite);
        return this;
    }

    public String toString(){
        StringBuilder stb = new StringBuilder();
        stb.append("nom : ").append( this.nom).append(" liste : ").append(Arrays.toString(this.liste.toArray()));
        return stb.toString();
    }

}
