package Rules.Rule;

import Rules.Specification.Specification;

public class EstInferieur extends Specification<Integer> {

    private int valeur;

    public EstInferieur(){}

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public EstInferieur(int valeur){
        this.valeur = valeur;
    }

    public boolean isSatisfiedBy(Integer i){
        return i < valeur;
    }

    public String interpreter(){
        return "estInferieur_a_" + valeur;
    }
}