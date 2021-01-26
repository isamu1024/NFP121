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
        testCanard(canard);

        System.out.println("Adaptateur dit ...");
        testCanard(adaptateurDindon);

    }

    static void testCanard(Canard canard) {
        canard.cancaner();
        canard.voler();
    }

}
