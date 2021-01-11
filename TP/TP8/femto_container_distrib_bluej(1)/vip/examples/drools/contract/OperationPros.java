package vip.examples.drools.contract;


import container.*;
import vip.rules.ICommand;

public class OperationPros implements ICommand<Personne, Personne>{
 
    public int op�rande;
    public void setOp�rande(int op�rande){ this.op�rande = op�rande;}
    
    public String message;
    public void setMessage(String message){this.message = message;}
    // rule "a un CDI"
    // when
        // personne: Personne( $numDossierPersonne:numDossier  )
        // c: Caracteristique( numDossier == $numDossierPersonne, nom == 'CDI' , valeur ==1  )
   // then
        // personne.setPros(personne.getPros()+1);
        // System.out.println("R�gle \"a un CDI\" d�clench�e !");
    
    public Personne execute(Personne entite, Personne personne){
        System.out.println("execute: " + personne);
        personne.setPros(entite.getPros()+op�rande);
        System.out.println(message);
        return personne;
    }
}
