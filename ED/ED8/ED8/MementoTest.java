public class MementoTest extends junit.framework.TestCase{

    public void testSauvegardeRestitution(){
        Entier e = new Entier(5);
        Memento memento = new Memento(e);
        e.inc();
        assertEquals(6, e.getValeur());
        assertEquals(5, memento.getSavedState());
    }

    public void testExceptionRestitution(){
        Entier e = new Entier(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, e.getValeur());
        Memento memento = null;
        try{
            memento = new Memento(e);
            e.inc();
        }catch(Exception exc){
            e.restoreFromMemento(memento);
        }
        assertEquals(Integer.MAX_VALUE, e.getValeur());
    }
}
