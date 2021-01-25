package vip.examples.drools.contract;

import vip.rules.ICondition;

public class ConditionSalaire implements ICondition<Personne>{
 
// rule "a un bon salaire"
    // when
      // personne: Personne( $numDossierPersonne:numDossier  )
      // c: Caracteristique( numDossier == $numDossierPersonne, nom == 'Salaire' , valeur >=45000, valeur <60000  )
    // then
        // personne.setPros(personne.getPros()+2);
        // System.out.println("Règle \"a un bon salaire\" déclenchée !");
// end    
    private int salaireMin, salaireMax;
    public void setSalaireMin(int min){
        this.salaireMin = min;
    }
    public void setSalaireMax(int max){
        this.salaireMax = max;
    }    
    public boolean isSatisfied(Personne p){
        for(Caracteristique caracterisitique : p.getCaracteristiques()){
          if(p.getNumDossier()==caracterisitique.getNumDossier() &&
             "Salaire".equals(caracterisitique.getNom()) &&
              //(caracterisitique.getValeur()>45000 && caracterisitique.getValeur()<60000))
              ( caracterisitique.getValeur()>this.salaireMin &&
                caracterisitique.getValeur()<this.salaireMax))
            return true;
        }
    return false;
    }
}