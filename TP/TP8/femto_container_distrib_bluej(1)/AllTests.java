
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.util.Properties;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Properties;

public class AllTests extends junit.framework.TestCase{
    static{
        Properties propsSystem = System.getProperties();
        // Avec des traces sur la console lors : 
        //   de la création du container et des beans,
        //   de l'appel des mutateurs de chaque bean créé.

        // il suffit de décommenter la ligne ci-dessous
        //propsSystem.setProperty("verbose","true");

    }

    // Une classe de test de tous les tests répartis dans chaque paquetage
    public void testAll() throws Exception{
        String res = new String();
        Class<?> classeDeTests = null;

        // l'exemple fondateur
        classeDeTests = martin_fowler.MartinFowlerExampleTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res=execution(classeDeTests);

        // un container est lui-même un bean
        classeDeTests = container.FileSystemPropsApplicationContextTest.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // Quelques exemples simples d'injection de dépendances, cf. les notes de cours
        classeDeTests = syntaxe_exemples.ExemplesTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // Quelques exemples syntaxiques des possibilités offertes via le fichier de configuration
        classeDeTests = syntaxe_exemples.ExemplesSyntaxeConfigurationTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron Décorateur cf. les notes du cours
        classeDeTests = decorator.DecoratorTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron Commande
        classeDeTests = command.CommandTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron Stratégie
        classeDeTests = strategy.StrategyTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron Procuration
        classeDeTests = proxy.ProxyTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron facade, reprend un exemple de jm Doudoux, à compléter
        classeDeTests = facade.FacadeTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron adapter, un adaptateur de pile, le patron fabrique en préliminaire
        classeDeTests = adapter.AdapterTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron fabrique, 
        classeDeTests = fabric.FabricTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron Service Locator, un container de containers lui-même un bean
        // en généralisant nous avons des containers de containers
        classeDeTests = service_locator.ServiceLocatorTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // Une IHM d'assistance à la génération du fichier de configuration
        classeDeTests = config_editor.ConfigGeneratorTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // etc...
        // Les lignes ci-dessous sont associées à la présentation effective de VIP en cours
        // (Variability and Injection Pattern framework)
        //
        // VIP est un petit langage de règles, de type si condition alors commande
        //      dans lesquelles les conditions et les commandes sont injectées
        // Le VIP framework permet la composition de règles (patron composite)
        // ainsi que la création de règles par introspection
        //
        // VIP autorise aussi les instructions injectées, analogue au WhileL étudié en cours
        // 
        // Quelques règles de type si condition alors commande
        // // Quelques règles simples sur les nombres
        // res+=execution(vip.examples.number.NumberTests.class);
        // // Quelques ègles simples sur les listes
        // res+=execution(vip.examples.list.ListTests.class);
        //
        // // Règles avec des instructions injectées,
        // res+=execution(vip.examples.instructions.VipInstructionsTests.class);
        // res+=execution(vip.examples.instructions.VipInstructionsTestsBis.class);
        System.out.println(res);
    }

    private static final boolean T = true; // Trace sur la console lors de l'exécution de cette classe

    private static String execution(Class<?> classeDeTests){
        Result result = JUnitCore.runClasses(classeDeTests);
        String res = new String("");
        for (Failure failure : result.getFailures()) {
            System.err.println("failure: " + classeDeTests.getName());
            System.err.println(failure.toString());
            res = res + failure.toString() + "\n";
        }
        //assertFalse(res, res.length()>0);
        //if(T)System.out.println("info: exécution de " + classeDeTests.getName());
        return res;
    }
}