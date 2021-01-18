package Observer.Exempletp;

public class TestDemo extends junit.framework.TestCase {

    public void testNotify(){

        ConcreteSubject list;
        ConcreteObserver observer;

        list = new ConcreteSubject();
        observer = new ConcreteObserver();
        list.addObserver(observer);
        list.insert("il fait beau, ce matin");

        assertFalse(observer.getSenders().empty());
        assertEquals(list, observer.getSenders().pop()); // on recoupe bien l'objet qui envoie
        assertEquals("il fait beau, ce matin", observer.getArguments().pop());

    }

    // une liste, 2 observateurs
    public void test1() {
        ConcreteSubject l1 = new ConcreteSubject();
        ConcreteObserver o1 = new ConcreteObserver();
        ConcreteObserver o2 = new ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l1.insert("test");
        l1.insert(" 1 ");

        // vérifier que les deux observateurs ont bien été notifiés avec les
        // bons paramètres

        // On vérifie que les 2 stacks (observer et arguments) ont la bonne taille.
        assertEquals(2, o1.getSenders().size());
        assertEquals(2, o2.getSenders().size());
        assertEquals(2, o1.getArguments().size());
        assertEquals(2, o2.getArguments().size());

        // On verifie que les senders et arguments sont les bons
        assertEquals(l1, o1.getSenders().pop());
        assertEquals(" 1 ", o1.getArguments().pop());

        assertEquals(l1, o1.getSenders().pop());
        assertEquals("test",o1.getArguments().pop());

        assertEquals(l1, o2.getSenders().pop());
        assertEquals(" 1 ", o2.getArguments().pop());

        assertEquals(l1, o2.getSenders().pop());
        assertEquals("test",o2.getArguments().pop());

        // ne pas modifier ces lignes, dernières assertions vraies de cette
        // méthode
        assertTrue(o1.getSenders().empty() && o1.getArguments().empty());
        assertTrue(o2.getSenders().empty() && o2.getArguments().empty());

    }
}
