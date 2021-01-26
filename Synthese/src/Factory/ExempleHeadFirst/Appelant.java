package Factory.ExempleHeadFirst;

/**
 * Un Appelant qui cancane mais qui n’a
 * pas l’air tout à fait vrai.
 */

public class Appelant implements Cancaneur {
    public void cancaner() {
        System.out.println("Couincouin");
    }
}