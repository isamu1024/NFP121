package observer;

import container.ApplicationContext;
import container.Factory;
import commands.Command;

public class NombreObserverTest extends junit.framework.TestCase {
    
    public void testUnNombreAvecDeuxObservateurs() {
        ApplicationContext ctx = Factory.createApplicationContext("./observer/README.TXT");
        Nombre nombre = ctx.getBean("nombre1");
        assertEquals(7, nombre.getValeur());
        
        nombre.setValeur(18);
        NombreObserver obs = ctx.getBean("observateur1");
        assertEquals(nombre, obs.getSource());
        
        obs = ctx.getBean("observateur2");
        assertEquals(nombre, obs.getSource());
    }
    
    public void testUnNombreAvecDeuxObservateursJson() {
        ApplicationContext ctx = Factory.createApplicationContext("./observer/observer.json");
        Nombre nombre = ctx.getBean("nombre1");
        assertEquals(7, nombre.getValeur());
        
        nombre.setValeur(18);
        NombreObserver obs = ctx.getBean("observateur1");
        assertEquals(nombre, obs.getSource());
        
        obs = ctx.getBean("observateur2");
        assertEquals(nombre, obs.getSource());
    }
    
    public void testUnNombreAvecUneCommandeNombre () {
        ApplicationContext ctx = Factory.createApplicationContext("./observer/README.TXT");
        Nombre nombre = ctx.getBean("nombre1");
        assertEquals(7, nombre.getValeur());
        
        Resultat resultat = new Resultat();
        resultat.setValeur(nombre.getValeur());
        assertEquals(7, resultat.getValeur());
          
        // Si la valeur de nombre est paire, alors +1
        CommandeNombre cmd = ctx.getBean("CommandePlus1");
        cmd.execute(nombre, resultat);
        assertTrue(resultat.getValeur()==7);
        
        // +1 sans condition
        CommandeNombre cmd2 = ctx.getBean("plus");
        cmd2.execute(nombre, resultat);
        assertTrue(resultat.getValeur()==8);
        
        nombre.setValeur(8);
        // Si la valeur de nombre est paire, alors +2
        CommandeNombre cmd3 = ctx.getBean("CommandePlus2");
        cmd3.execute(nombre, resultat);
        assertTrue(resultat.getValeur()==10);
    }
    
    public void testUnNombreAvecUneCommandeNombreJson () {
        ApplicationContext ctx = Factory.createApplicationContext("./observer/observer.json");
        Nombre nombre = ctx.getBean("nombre1");
        assertEquals(7, nombre.getValeur());
        
        Resultat resultat = new Resultat();
        resultat.setValeur(nombre.getValeur());
        assertEquals(7, resultat.getValeur());
          
        // Si la valeur de nombre est paire, alors +1
        CommandeNombre cmd = ctx.getBean("CommandePlus1");
        cmd.execute(nombre, resultat);
        assertTrue(resultat.getValeur()==7);
        
        // +1 sans condition
        CommandeNombre cmd2 = ctx.getBean("plus");
        cmd2.execute(nombre, resultat);
        assertTrue(resultat.getValeur()==8);
        
        nombre.setValeur(8);
        // Si la valeur de nombre est paire, alors +2
        CommandeNombre cmd3 = ctx.getBean("CommandePlus2");
        cmd3.execute(nombre, resultat);
        assertTrue(resultat.getValeur()==10);
    }
    
}
