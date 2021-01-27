package Question1;

import java.util.Stack;

public class Tests extends junit.framework.TestCase{

        class SubscriberTest extends SimpleSubscriber{

            Stack<Message> messages;

            SubscriberTest(PubSubI pubsub, String name){
                super(name);
                pubsub.subscribe(this); // souscription de cette instance
                this.messages = new Stack<>(); // une pile de messages
            }

            public void onMessage(Message message)throws Exception{
                this.messages.push(message); // sauvegarde du message sur la pile
                                            // pour les tests, une exception est levée si le message est "error"
                if("error".equals(message.getContent()))
                    throw new Exception();
                super.onMessage(message);
            }
        }

        public void testSimple(){
            PubSubI pubsub = new PubSubImpl("pubsub");
            SubscriberTest a = new SubscriberTest(pubsub,"a");
            assertEquals("a", a.getName());
            assertTrue(a.getPubSubList().contains(pubsub)); // "a" a bien souscrit
            assertEquals(a, pubsub.iterator().next());// "a" est bien présent
            SubscriberTest b = new SubscriberTest(pubsub,"b");
            SubscriberTest c = new SubscriberTest(pubsub,"c");
            assertFalse(pubsub.subscribe(a)); // "a" a déjà souscrit
            Message message = new Message("p1","test");
            assertEquals(2,pubsub.publish(new String[]{"a","b"}, message));// 2 souscripteurs ont reçu le message, ici a et b
            assertEquals("test",a.messages.pop().getContent());
            assertEquals("test",b.messages.pop().getContent());
            assertTrue(c.messages.isEmpty());
            assertEquals(3,pubsub.publish(new String[]{"c","a","b"}, message));
            assertEquals(0,pubsub.publish(new String[]{"d","e"}, message));// 0 : pas de réception, d et e n’ont pas souscrit
        }
        public void testAvecException(){
            PubSubI pubsub = new PubSubImpl("pubsub");
            SubscriberTest a = new SubscriberTest(pubsub,"a");
            SubscriberTest b = new SubscriberTest(pubsub,"b");
            Message message = new Message("p1","error"); // exception programmée
            assertEquals(0,pubsub.publish(new String[]{"a","b","c"}, message)); // 0 : pas de réception, "error" lève une exception
        }
        public void testDeuxPubSubUnSouscripteur(){
            PubSubI pubsub1 = new PubSubImpl("pubsub1");
            PubSubI pubsub2 = new PubSubImpl("pubsub2");
            SubscriberTest st1 = new SubscriberTest(pubsub1,"a");
            SubscriberTest st2 = new SubscriberTest(pubsub2,"a");
            assertTrue(st1.getPubSubList().contains(pubsub1));
            assertEquals("a",st1.getName());
            assertTrue(st2.getPubSubList().contains(pubsub2));
            assertEquals("a",st2.getName());
            Message message = new Message("p1","test");
            assertEquals(1,pubsub1.publish(new String[]{"a"}, message));
            assertEquals("test",st1.messages.pop().getContent());
            assertEquals(1,pubsub2.publish(new String[]{"a"}, message));
            assertEquals("test",st2.messages.pop().getContent());
        }

}
