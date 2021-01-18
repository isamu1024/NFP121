package Observer.ExempleCours1;

public class DemoTest extends junit.framework.TestCase{

    public void testNotification(){
        Subject sujet = new SujetConcret();
        Observateur observateur = new ObservateurConcret();

        sujet.attach(observateur); // on attache un observateur
        assertEquals(1, sujet.getObservateurs().size());

        sujet.detach(observateur);
        assertEquals(0, sujet.getObservateurs().size());

        sujet.attach(observateur);
        sujet.setValue(10);
        assertEquals("Nouvelle valeur : 10", observateur.getNofications().get(0));

        sujet.detach(observateur);

        Observateur obs1 = new ObservateurConcret();
        Observateur obs2 = new ObservateurConcret();

        assertEquals(0, sujet.getObservateurs().size());

        sujet.attach(obs1);

    }

}
