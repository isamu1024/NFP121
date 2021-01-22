package Persistance.ExempleCours;

import java.io.Serializable;
import java.util.Objects;

public class Unite implements Serializable {
    private String nom;

    public Unite(String nom){
        this.nom = nom;
    }

    public String toString(){
        return this.nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unite unite = (Unite) o;
        return Objects.equals(nom, unite.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
