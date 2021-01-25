package vip.examples.drools.contract;

import java.util.*;

import container.*;
import vip.rules.Invoker;

public class DroolsVipTests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{
        System.out.println("http://blog.viseo-bt.com/demarrer-avec-drools-et-autres-astuces/");
        System.out.println(" a priori ce blog n'existe plus..., faire une recherche sur le web avec Drools");
        List<Personne> personnes=new ArrayList<Personne>();
        List<Caracteristique> caracteristiques=new ArrayList<Caracteristique>();
 
        Personne p1=new Personne(1);
        personnes.add(p1);
 
        p1.addCaracteristique(new Caracteristique(1, "CDI", 1));
        p1.addCaracteristique(new Caracteristique(1, "Salaire", 48345));
        p1.addCaracteristique(new Caracteristique(1, "NombreEnfants", 3));
        
       //System.out.println("30/01/2018, Début d'une tentative de comparaison de femtoContainer avec Drools, https://www.drools.org/\n");
       ApplicationContext ctx = Factory.createApplicationContext("./vip/examples/drools/contract/README.TXT");
       Invoker invoker = ctx.getBean("invoker");
       invoker.execute(p1,p1);
       
       assertEquals(3,p1.getPros());
    }
}

