package vip.examples.drools.contract;

import java.util.*;

public class Personne implements java.io.Serializable{
    private int numDossier;
    private int pros;
    private int cons;
    private boolean solvable;
    private List<Caracteristique> caracteristiques;
    
    public Personne(){
      super();
      caracteristiques = new ArrayList<Caracteristique>();
    }

    public Personne(int numDossier) {
        this();
        this.numDossier = numDossier;
    }
    public int getNumDossier(){ return numDossier;}
    public void addCaracteristique(Caracteristique caracteristique){
        caracteristiques.add(caracteristique);
    }
    public List<Caracteristique> getCaracteristiques(){
        return Collections.unmodifiableList(caracteristiques);
    }
    public void setPros(int pros){
        this.pros = pros;
    }
    public int getPros(){
        return this.pros;
    }
    public String toString(){
        return numDossier + caracteristiques.toString();
    }
    //getters and setters …
    
}