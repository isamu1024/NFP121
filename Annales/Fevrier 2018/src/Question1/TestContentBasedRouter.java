package Question1;

public class TestContentBasedRouter extends junit.framework.TestCase {
    public void testStringMessage() {
        try {
            ContentBasedRouterI router = new ContentBasedRouter("router");
            ReceiverTest a = new ReceiverTest("a");
            ReceiverTest b = new ReceiverTest("b");
            ReceiverTest c = new ReceiverTest("c");
            ReceiverTest d = new ReceiverTest("d");
            router.addReceiver(a).addReceiver(b).addReceiver(c).addReceiver(d);
            FilterI f = new TRUE();// filtre à succès
            router.addFilter(a, f).addFilter(b, f).addFilter(c, f).addFilter(d, f);
            EmitterI emitter = new Emitter("e1");
            emitter.setRouter(router);
            int number = emitter.sendMessage("meteo_pluie"); // il pleut...
            assertEquals(" received number ? ", 0, number); // aucun receveur autorisé
            router.setEnabled(a).setEnabled(b).setEnabled(c).setEnabled(d);
            number = emitter.sendMessage("meteo_pluie");
            assertEquals(" received number ? ", 4, number); // 4 receveurs autorisés
            router.addFilter(a, new ContainsFilter("meteo"));
            router.addFilter(b, new RegexFilter("[a-z]+"));
            router.addFilter(c, new RegexFilter("[A-Z]+"));
            number = emitter.sendMessage("meteo_pluie");
            assertEquals(" received number ? ", 2, number); // seuls a et d (ont reçu)
            router.setDisabled(a);
            number = emitter.sendMessage("meteo_soleil");
            assertEquals(" received number ? ", 1, number); // seul d (a reçu)
            router.removeReceiver(c);
            router.addReceiver(c).setEnabled(c);
            router.addFilter(c, new RegexFilter("[a-z_]+"));
            number = emitter.sendMessage("meteo_soleil");
            assertEquals(" received number ? ", 2, number); // c et d (ont reçu)
            number = emitter.sendMessage("meteo_exception");
            assertEquals(" received number ? ", 0, number); // pour les tests avec une exception simulée
            int numberExceptions = router.getReceiversException().size();
            assertEquals(" receiver number with exception ? ", 2, numberExceptions);
            assertTrue(router.getReceiversException().contains(c));
            assertTrue(router.getReceiversException().contains(d));
            router.setDisabled(d);
            number = emitter.sendMessage("meteo_grêle");
            assertEquals(" received number ? ", 0, number);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    private static class ReceiverTest extends Receiver {
        private String msgReceived = null;

        public ReceiverTest(String name) {
            super(name);
        }

        public void receive(String msg) {
            this.msgReceived = msg;
            if (msg.contains("exception")) throw new RuntimeException();
        }

        public String getMsgReceived() {
            String msg = msgReceived;
            msgReceived = null;
            return msg;
        }
    }
}


