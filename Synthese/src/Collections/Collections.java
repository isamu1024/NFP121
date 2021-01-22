package Collections;

import java.util.*;

import Persistance.ExempleCours.Unite;

public class Collections {

    /**
     * https://www.jmdoudoux.fr/java/dej/chap-collections.htm
     * Un immense merci a M. Doudoux pour son indispensable site
     * <p>
     * 2 grandes familles de collections :
     * java.util.Collection : pour gérer un groupe d'objets
     * java.util.Map : pour gérer des éléments de type paires de clé/valeur
     */

    public static void main(String[] args) {

        // Les collections de type List

        // Arraylist :
        // Conserve l'ordre d'insertion
        // Autorise le null
        // Autorise les doublons
        List<Integer> arraylist = new ArrayList<>();
        arraylist.add(3);
        arraylist.add(2);
        arraylist.add(3);
        System.out.println(arraylist.toString());
        // [3, 2, 3]

        // LinkedList
        // Conserve l'ordre d'insertion
        // Autorise le null
        // Autorise les doublons
        // elle n'a pas besoin d'être redimensionnée quelque soit le nombre d'éléments qu'elle contient
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(6);
        linkedList.add(2);
        linkedList.add(2);
        System.out.println(linkedList.toString());
        // [1, 6, 2, 2]
        // La suppression ou l'ajout d'un élément se fait simplement en modifiant des pointeurs.
        linkedList.remove(0); // index
        System.out.println(linkedList.toString());
        // [6, 2, 2]

        // Les Collections de types Set

        // HashSet
        // elle ne permet pas d'ajouter des doublons mais elle permet l'ajout d'un élément null

        Set<String> hashSet = new HashSet<>();
        hashSet.add("CCCCC");
        hashSet.add("BBBBB");
        hashSet.add("DDDDD");
        hashSet.add("BBBBB");
        hashSet.add("AAAAA");

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // BBBBB
        // AAAAA
        // DDDDD
        // CCCCC

        // TreeSet
        // La classe TreeSet, ajoutée à Java 1.2, stocke ses éléments de manière ordonnée en les comparant entre-eux.
        // Cette classe permet d'insérer des éléments dans n'importe quel ordre et de restituer ces éléments dans un ordre précis lors de son parcours.
        // L'ordre des éléments de la collection peut être défini par deux moyens :
        // - l'ordre naturel des éléments s'ils implémentent l'interface Comparable
        // - l'ordre obtenu par l'utilisation d'une instance de type Comparator fournie en paramètre du constructeur de la collection

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("CCCCC");
        treeSet.add("BBBBB");
        treeSet.add("DDDDD");
        treeSet.add("BBBBB");
        treeSet.add("AAAAA");

        iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        // AAAAA BBBBB CCCCC DDDDD

        System.out.println();

        // Map : les associations de type clé/valeur

        // HashTable
        // ! Tous les objets qui sont utilisés comme clés doivent obligatoirement redéfinir les méthodes equals() et hashCode()
        //  en respectant le contrat portant sur l'implémentation de ces deux méthodes.

        Map<Integer, Unite> listeUnite = new Hashtable<>();
        listeUnite.put(1, new Unite("nfp121"));
        listeUnite.put(2, new Unite("nsy102"));
        listeUnite.put(3, new Unite("ang320"));

        Unite u = listeUnite.get(1);
        System.out.println(u.toString());
        // nfp121
        System.out.println(listeUnite.values());
        // [ang320, nsy102, nfp121]

        // hashMap

        Map<Unite, Boolean> listeUniteValide = new HashMap<>();
        listeUniteValide.put(new Unite("NFP121"), false);
        listeUniteValide.put(new Unite("Ang320"), false);
        listeUniteValide.put(new Unite("UTC501"), true);
        listeUniteValide.put(new Unite("UTC502"), true);
        listeUniteValide.put(new Unite("UTC503"), true);
        listeUniteValide.put(new Unite("NFP135"), true);
        listeUniteValide.put(new Unite("NFP136"), true);

        List<Unite> valide = new ArrayList<>(listeUniteValide.size());

        // Iterateur

        for (Map.Entry<Unite, Boolean> entry : listeUniteValide.entrySet()) {
            if (entry.getValue()) {
                valide.add(entry.getKey());
                System.out.println(entry.getKey().toString());
            }
        }

        System.out.println("Nombre d'unite valide : " + valide.size());




    }

}
