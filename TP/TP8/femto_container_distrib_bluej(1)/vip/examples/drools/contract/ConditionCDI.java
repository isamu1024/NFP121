package vip.examples.drools.contract;

import container.*;
import vip.rules.ICondition;

public class ConditionCDI implements ICondition<Personne>{
 
    // rule "a un CDI"
    // when
        // personne: Personne( $numDossierPersonne:numDossier  )
        // c: Caracteristique( numDossier == $numDossierPersonne, nom == 'CDI' , valeur ==1  )
   
    public boolean isSatisfied(Personne p){
        for(Caracteristique caracterisitique : p.getCaracteristiques()){
          if(p.getNumDossier()==caracterisitique.getNumDossier() &&
             "CDI".equals(caracterisitique.getNom()) &&
              1 == caracterisitique.getValeur())
            return true;
        }
    return false;
    }
}
