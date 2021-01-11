package question3;

import question1.PolygoneRegulier;

public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        // déclarer p1
        // déclarer p2
        
        PileI<PolygoneRegulier> p1 = new Pile2<PolygoneRegulier>();
        PileI<PolygoneRegulier> p1PourLesTests = new Pile2<PolygoneRegulier>();

        PileI<PileI<PolygoneRegulier>> p2 = new Pile2<PileI<PolygoneRegulier>>();
        PileI<PileI<PolygoneRegulier>> p3 = new Pile2<PileI<PolygoneRegulier>>(3);
        PileI<PileI<PolygoneRegulier>> p4 = new Pile2<PileI<PolygoneRegulier>>(2);
        PileI<PileI<PolygoneRegulier>> p5 = new Pile2<PileI<PolygoneRegulier>>(1);

        //p1 est ici une pile de polygones réguliers PolygoneRegulier.java
        
        
        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));

        System.out.println(" la pile p1 = " + p1);

        p2.empiler(p1);
        System.out.println(" la pile p2 = " + p2);

        try {
            p1.empiler(new PolygoneRegulier(5,100)); // désormais une erreur de
            // compilation
            // ....
            String s = (String)p1.depiler().toString(); // désormais une erreur de
            // compilation
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Comme demandé dans le test, on va donc jouer avec plusieurs piles

        System.out.println("Avec une autre pile");

        System.out.println("La capacité est de: " + p2.capacite());
        System.out.println("La taille est maintenant de " + p2.taille());

        System.out.println("On empile");

        p2.empiler(p1);
        System.out.println("La taille est maintenant de " + p2.taille());

        System.out.println("On dépile");
        p2.depiler();
        System.out.println("La taille est maintenant de " + p2.taille());

        // On empile une pile vide
        p2.empiler(p1PourLesTests);

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());

        System.out.println("on crée un PolygoneRegulier dans la pile stackee: ");
        p1PourLesTests.empiler(new PolygoneRegulier(3, 3));

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());
        p1PourLesTests.depiler();

        // try {
        //     p1.empiler(new PolygoneRegulier(5,10)); // vérifiez qu'une erreur est levée à la compilation
              
        //     String s = (String)p1.depiler();
        //   } catch(Exception e ) {
        //     e.printStackTrace();
        //   }

        // L'erreur de cast est bien notifiée, 

        System.out.println("Avec une autre pile");

        System.out.println("La capacité est de: " + p3.capacite());
        System.out.println("La taille est maintenant de " + p3.taille());

        System.out.println("On empile");

        p3.empiler(p1);
        System.out.println("La taille est maintenant de " + p3.taille());

        System.out.println("On dépile");
        p3.depiler();
        System.out.println("La taille est maintenant de " + p3.taille());

        // On empile une pile vide
        p3.empiler(p1PourLesTests);

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());

        System.out.println("on crée un PolygoneRegulier dans la pile stackee: ");
        p1PourLesTests.empiler(new PolygoneRegulier(3, 3));
        p1PourLesTests.empiler(new PolygoneRegulier(30, 13));

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());
        p1PourLesTests.depiler();
        p1PourLesTests.depiler();

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());

        System.out.println("Avec une autre pile");

        System.out.println("La capacité est de: " + p4.capacite());
        System.out.println("La taille est maintenant de " + p4.taille());

        System.out.println("On empile");

        p4.empiler(p1);
        System.out.println("La taille est maintenant de " + p4.taille());

        System.out.println("On dépile");
        p4.depiler();
        System.out.println("La taille est maintenant de " + p4.taille());

        // On empile une pile vide
        p4.empiler(p1PourLesTests);

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());

        System.out.println("on crée un PolygoneRegulier dans la pile stackee: ");
        p1PourLesTests.empiler(new PolygoneRegulier(3, 3));
        p1PourLesTests.empiler(new PolygoneRegulier(30, 13));

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());
        p1PourLesTests.depiler();
        p1PourLesTests.depiler();

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());

        System.out.println("Avec une autre pile");

        System.out.println("La capacité est de: " + p5.capacite());
        System.out.println("La taille est maintenant de " + p5.taille());

        System.out.println("On empile");

        p5.empiler(p1);
        System.out.println("La taille est maintenant de " + p5.taille());

        System.out.println("On dépile");
        p5.depiler();
        System.out.println("La taille est maintenant de " + p5.taille());

        // On empile une pile vide
        p5.empiler(p1PourLesTests);

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());

        System.out.println("on crée un PolygoneRegulier dans la pile stackee: ");
        p1PourLesTests.empiler(new PolygoneRegulier(3, 3));
        p1PourLesTests.empiler(new PolygoneRegulier(30, 13));

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());
        p1PourLesTests.depiler();
        p1PourLesTests.depiler();

        System.out.println("Ce que contient notre pile " + p1PourLesTests.toString());

    }

}