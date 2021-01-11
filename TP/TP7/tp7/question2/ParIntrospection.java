package question2;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class ParIntrospection {

    /**
     * Cette methode permet de relier par introspection, un observable et un observateur<p>
     * Appel par introspection de la methode observable.addObserver(observer)
     *
     * @param observable une instance de la classe java.util.Observable ou l'une de ses derivees
     * @param observer   une implementation de l'interface java.util.Observer
     * @throws NoSuchElementException en cas d'erreur
     */
    public static void lierObservableEtObserver(Object observable, Object observer) throws Exception {
        try {
            // Par pur plaisir de reprendre la méthodologie vue en UTC503...
            Arrays.stream(
                    observable.getClass().getMethods())  // On récupère les méthodes
                    .filter(x -> x.getName().contains("addObserver")) // on filtre sur les méthodes contenant "add"
                    .filter(x -> x.getParameterTypes().length == 1) // si la méthode n'accepte qu'un paramètre
                    .filter(x -> x.getParameterTypes()[0].isInstance(observer)) // Si ce paramètre est d'instance égale à celle de Listener
                    .collect(Collectors.toList()) // on repasse en liste
                    .get(0) // on récupère le seul choix possible (normalement .... )
                    .invoke(observable, observer); // on invoque la méthode
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }


    /**
     * Cette methode permet de delier par introspection, un observable et un observateur<p>
     * Appel par introspection de la methode observable.deleteObserver(observer)
     *
     * @param observable une instance de la classe java.util.Observable ou l'une de ses derivees
     * @param observer   une implementation de l'interface java.util.Observer
     * @throws NoSuchElementException en cas d'erreur
     */
    public static void delierObservableEtObserver(Object observable, Object observer) throws Exception {
        try {
            Arrays.stream(
                    observable.getClass().getMethods())
                    .filter(x -> x.getName().contains("deleteObserver"))
                    .filter(x -> x.getParameterTypes().length == 1)
                    .filter(x -> x.getParameterTypes()[0].isInstance(observer))
                    .collect(Collectors.toList())
                    .get(0)
                    .invoke(observable, observer);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    /**
     * Cette methode permet de relier par introspection, une source et un "listener"<p>
     * Appel par introspection de la methode source.addXXXXListener(listener)
     *
     * @param source   est une instance
     * @param listener une implementation d'une interface XXXXListener
     * @throws NoSuchElementException en cas d'erreur
     */
    public static void lierSourceEtListener(Object source, Object listener) throws Exception {
        try {
            Arrays.stream(
                    source.getClass().getMethods())
                    .filter(x -> x.getName().contains("add") && x.getName().contains("Listener"))
                    .filter(x -> x.getParameterTypes().length == 1)
                    .filter(x -> x.getParameterTypes()[0].isInstance(listener))
                    .collect(Collectors.toList())
                    .get(0)
                    .invoke(source, listener);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    /**
     * Cette methode permet de delier par introspection, une source et un "listener"<p>
     * Appel par introspection de la methode source.removeXXXXListener(listener)
     *
     * @param source   est une instance
     * @param listener une implementation d'une interface XXXXListener
     * @throws NoSuchElementException en cas d'erreur
     */
    public static void delierSourceEtListener(Object source, Object listener) throws Exception {
        try {
            Arrays.stream(
                    source.getClass().getMethods())
                    .filter(x -> x.getName().contains("remove") && x.getName().contains("Listener"))
                    .filter(x -> x.getParameterTypes().length == 1)
                    .filter(x -> x.getParameterTypes()[0].isInstance(listener))
                    .collect(Collectors.toList())
                    .get(0)
                    .invoke(source, listener);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }
}
