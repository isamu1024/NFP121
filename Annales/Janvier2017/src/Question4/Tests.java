package Question4;

import Question1.*;

import java.util.Stack;

public class Tests extends junit.framework.TestCase {

    class SubscriberTest extends SimpleSubscriber {
        Stack<Message> messages;

        SubscriberTest(String name) {
            super(name);
            this.messages = new Stack<Message>();
        }

        public void onMessage(Message message) throws Exception {
            this.messages.push(message);
            if ("error".equals(message.getContent())) throw new Exception();
            super.onMessage(message);
        }
    }

    public void testSimple() {
        PublishSubscribeI pubsub = new PublishSubscribeImpl();
        SubscriberTest a = new SubscriberTest("a");
        assertTrue(pubsub.subscribe("meteo", a));
        SubscriberTest b = new SubscriberTest("b");
        assertTrue(pubsub.subscribe("meteo", b));
        SubscriberTest c = new SubscriberTest("c");
        assertTrue(pubsub.subscribe("meteo", c));
        Message message = new Message("p1", "il neige");
        assertEquals(3, pubsub.publish("meteo", message));
        assertEquals("il neige", a.messages.pop().getContent());
        assertEquals("il neige", b.messages.pop().getContent());
        assertEquals("meteo", pubsub.iterator().next());
    }

    public void testDeuxThemesUnSouscripteur() {
        PublishSubscribeI pubsub = new PublishSubscribeImpl();
        SubscriberTest a = new SubscriberTest("a");
        assertTrue(pubsub.subscribe("meteo", a));
        assertTrue(pubsub.subscribe("verglas", a));
        Message message = new Message("p1", "il gèle");
        assertEquals(1, pubsub.publish("meteo", message));
        assertEquals(1, pubsub.publish("verglas", message));
    }
}