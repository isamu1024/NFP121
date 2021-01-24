package Command;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestTelecommande extends junit.framework.TestCase {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public void testAllumeLampe() {

        TelecommandeSimple telecommande = new TelecommandeSimple();
        Lampe lampe = new Lampe();
        Commande lampeAllume = new CommandeAllumerLampe(lampe);

        telecommande.setCommande(lampeAllume);

        System.setOut(new PrintStream(outContent));

        telecommande.boutonPresse();
        assertEquals("Lampe Allumee", outContent.toString());
    }

}
