package Adaptateur.ExempleHeadFirst;

public class Demo {
    public static void main(String[] args) {
        Colvert canard = new Colvert();

        DindonSauvage dindon = new DindonSauvage();
        Canard adaptateurDindon = new AdaptateurDindon(dindon);

        System.out.println("Dindon dit ...");
        dindon.gloutouter();
        dindon.voler();

        System.out.println("Canard dit ...");
        testCanard(canard); // forcément cela fonctionne

        System.out.println("Adaptateur dit ...");
        testCanard(adaptateurDindon); // mais notre dindon déguisé aussi :D

    }

    /**
     * Voici notre méthode testerCanard() : elle reçoit un canard et
     * appelle ses méthodes cancaner() et voler().
     *
     * @param canard un membre de la famille des canards
     * ou tout autre espèce qui essaye de se faire passer pour tel ;)
     */
    static void testCanard(Canard canard) {
        canard.cancaner();
        canard.voler();
    }

}
