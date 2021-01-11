
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
        //   de la cr�ation du container et des beans,
        //   de l'appel des mutateurs de chaque bean cr��.

        // il suffit de d�commenter la ligne ci-dessous
        //propsSystem.setProperty("verbose","true");

    }

    // Une classe de test de tous les tests r�partis dans chaque paquetage
    public void testAll() throws Exception{
        String res = new String();
        Class<?> classeDeTests = null;

        // l'exemple fondateur
        classeDeTests = martin_fowler.MartinFowlerExampleTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res=execution(classeDeTests);

        // un container est lui-m�me un bean
        classeDeTests = container.FileSystemPropsApplicationContextTest.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // Quelques exemples simples d'injection de d�pendances, cf. les notes de cours
        classeDeTests = syntaxe_exemples.ExemplesTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // Quelques exemples syntaxiques des possibilit�s offertes via le fichier de configuration
        classeDeTests = syntaxe_exemples.ExemplesSyntaxeConfigurationTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron D�corateur cf. les notes du cours
        classeDeTests = decorator.DecoratorTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron Commande
        classeDeTests = command.CommandTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron Strat�gie
        classeDeTests = strategy.StrategyTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron Procuration
        classeDeTests = proxy.ProxyTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron facade, reprend un exemple de jm Doudoux, � compl�ter
        classeDeTests = facade.FacadeTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron adapter, un adaptateur de pile, le patron fabrique en pr�liminaire
        classeDeTests = adapter.AdapterTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron fabrique, 
        classeDeTests = fabric.FabricTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // le patron Service Locator, un container de containers lui-m�me un bean
        // en g�n�ralisant nous avons des containers de containers
        classeDeTests = service_locator.ServiceLocatorTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // Une IHM d'assistance � la g�n�ration du fichier de configuration
        classeDeTests = config_editor.ConfigGeneratorTests.class;
        if(T)System.out.println("execution de : " + classeDeTests.getName());
        res+=execution(classeDeTests);

        // etc...
        // Les lignes ci-dessous sont associ�es � la pr�sentation effective de VIP en cours
        // (Variability and Injection Pattern framework)
        //
        // VIP est un petit langage de r�gles, de type si condition alors commande
        //      dans lesquelles les conditions et les commandes sont inject�es
        // Le VIP framework permet la composition de r�gles (patron composite)
        // ainsi que la cr�ation de r�gles par introspection
        //
        // VIP autorise aussi les instructions inject�es, analogue au WhileL �tudi� en cours
        // 
        // Quelques r�gles de type si condition alors commande
        // // Quelques r�gles simples sur les nombres
        // res+=execution(vip.examples.number.NumberTests.class);
        // // Quelques �gles simples sur les listes
        // res+=execution(vip.examples.list.ListTests.class);
        //
        // // R�gles avec des instructions inject�es,
        // res+=execution(vip.examples.instructions.VipInstructionsTests.class);
        // res+=execution(vip.examples.instructions.VipInstructionsTestsBis.class);
        System.out.println(res);
    }

    private static final boolean T = true; // Trace sur la console lors de l'ex�cution de cette classe

    private static String execution(Class<?> classeDeTests){
        Result result = JUnitCore.runClasses(classeDeTests);
        String res = new String("");
        for (Failure failure : result.getFailures()) {
            System.err.println("failure: " + classeDeTests.getName());
            System.err.println(failure.toString());
            res = res + failure.toString() + "\n";
        }
        //assertFalse(res, res.length()>0);
        //if(T)System.out.println("info: ex�cution de " + classeDeTests.getName());
        return res;
    }
}