package vip.examples.drools.contract;

import java.util.*;
import container.*;
import vip.rules.*;


public class Main{
 
    public static void main(String[] args){
        System.out.println("http://blog.viseo-bt.com/demarrer-avec-drools-et-autres-astuces/");
        List<Personne> personnes=new ArrayList<Personne>();
        List<Caracteristique> caracteristiques=new ArrayList<Caracteristique>();
 
        Personne p1=new Personne(1);
        personnes.add(p1);
 
        p1.addCaracteristique(new Caracteristique(1, "CDI", 1));
        p1.addCaracteristique(new Caracteristique(1, "Salaire", 50000));
        p1.addCaracteristique(new Caracteristique(1, "NombreEnfants", 3));
        
       System.out.println("07/06/2019, Essais avec VIP d'un exemple Drools, https://www.drools.org/\n");
       ApplicationContext ctx = Factory.createApplicationContext("./vip/examples/drools/contract/README.TXT");
       Invoker<Personne,Personne> invoker = ctx.getBean("invoker");
       invoker.execute(p1,p1);
       
       System.out.println(p1.getPros());
 
        
        // rule "a un CDI"
    // when
        // personne: Personne( $numDossierPersonne:numDossier  )
        // c: Caracteristique( numDossier == $numDossierPersonne, nom == 'CDI' , valeur ==1  )
    // then
        // personne.setPros(personne.getPros()+1);
        // System.out.println("Règle \"a un CDI\" déclenchée !");
    // end
    }
}
