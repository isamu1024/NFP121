package question3;

import java.lang.reflect.Method;

import java.lang.reflect.Modifier;
import java.util.*;

public class Introspection {


    public static Set<Method> getHeritees(String nomDeLaClasse) throws ClassNotFoundException {

        Class<?> classe = Class.forName(nomDeLaClasse);
        List<List<Method>> tree = new ArrayList<>();
        Class<?> tempClasse = classe;

        while (tempClasse != null) {
            tree.add(localMethodsMap(tempClasse));
            tempClasse = tempClasse.getSuperclass();
        }

        Set<Method> result = new HashSet<>();
        for (Method m : checkInherent(tree))
            result.add(m);

        return result;
    }


    public static void main(String[] args) throws ClassNotFoundException {
        for (Method m : Introspection.getHeritees("java.util.AbstractCollection")) {
            System.out.println(m);
        }
    }

    private static List<Method> localMethodsMap(Class c) {

        if (c == null)
            throw new NoSuchElementException();

        List<Method> localMethods = new ArrayList<>();

        for (Method m : c.getDeclaredMethods())
            if (IsPublicOrProtected(m))
                localMethods.add(m);

        return localMethods;
    }

    private static boolean IsPublicOrProtected(Method m) {
        return (Modifier.isPublic(m.getModifiers()) || Modifier.isProtected(m.getModifiers()))
                && !(Modifier.isAbstract(m.getModifiers()));
    }


    private static boolean isEqual(Method a, Method b) {
        return a.getName().equals(b.getName())
                && (Arrays.equals(a.getParameterTypes(), b.getParameterTypes()))
                && a.getReturnType().equals(b.getReturnType());
    }

    /**
     *
     * @param list
     * @return
     */
    private static List<Method> checkInherent(List<List<Method>> list) {

        List<Method> result = new ArrayList<>();

        if (list.size() > 1) {

            List<Method> allMethods = new ArrayList<>();
            Method current;
            Method compare;
            List<Method> foundIn = new ArrayList<>();
            for (int i = 0; i < list.size(); i++)
                allMethods.addAll(list.get(i));

            // Traitement des méthodes locales
            for (int i = 0; i < list.get(0).size(); i++) {
                current = allMethods.get(i);
                for (int j = i + 1; j < allMethods.size(); j++) {
                    compare = allMethods.get(j);
                    if (isEqual(current, compare)) {
                        foundIn.add(compare);
                    }
                    foundIn.add(current);
                }
            }
            // Suppression dans la liste contenant toutes les méthodes
            for (Method m : foundIn)
                allMethods.remove(m);
            foundIn.clear();

            //traitement des héritages
            for (int i = 0; i < allMethods.size(); i++) {
                current = allMethods.get(i);
                for (int j = i + 1; j < allMethods.size(); j++) {
                    compare = allMethods.get(j);
                    if (isEqual(current, compare)) {
                        foundIn.add(compare);
                    }
                }
            }

            for (Method m : foundIn)
                allMethods.remove(m);
            result.addAll(allMethods);

        }
        return result;
    }
}