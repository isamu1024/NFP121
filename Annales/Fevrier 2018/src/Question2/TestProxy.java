package Question2;

import Question1.*;

public class TestProxy extends junit.framework.TestCase{

    public void testSimple(){
        ContentBasedRouterI router = new ContentBasedRouter("router");
        ReceiverI a = new Receiver("a");
        ReceiverI b = new Receiver("b");
        router.addReceiver(a).addReceiver(b);
        FilterI f = new TRUE();
        router.addFilter(a,f).setEnabled(a).addFilter(b,f).setEnabled(b);
        EmitterI emitter = new Emitter("inconnu"); // sans proxy
        emitter.setRouter(router);
        int nombre=emitter.sendMessage("meteo_pluie");
        assertEquals(2,nombre); // a et b ont reçu le message
        emitter = new EmitterProxy("inconnu"); // avec proxy, (contrôle du nom)
        emitter.setRouter(router);
        nombre=emitter.sendMessage("meteo_pluie");
        assertEquals(0,nombre); // aucun n'a reçu le message
    }
}
