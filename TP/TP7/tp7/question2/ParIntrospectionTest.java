package question2;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ParIntrospectionTest extends junit.framework.TestCase {
    private Observable obs = null;

    public void test_lierObservableEtObserver() {
        try {
            Entier e = new Entier(1);
            ParIntrospection.lierObservableEtObserver(e, new Observer() {
                        public void update(Observable o, Object arg) {
                            ParIntrospectionTest.this.obs = o;
                        }
                    }
            );
            e.initialiser(3);
            assertNotNull(" notification absente ???", obs);
            assertEquals(" pas le bon Observable ???", e.toString(), obs.toString());
            assertEquals(" pas le bon Entier ???", "3", obs.toString());

            Observable observableNull = new Observable();
            Observer observerNull = null;
            ParIntrospection.lierObservableEtObserver(observableNull, new Observer() {
                        public void update(Observable o, Object arg) {
                            ParIntrospectionTest.this.obs = o;
                        }
                    }
            );

            //System.out.println(observableNull.countObservers());

        } catch (Exception e) {
            fail(" exception !!! " + e.getMessage());
        }
    }

    public void test_delierObservableEtObserver() {
        try {
            Entier e = new Entier(1);
            Observer o = new Observer() {
                public void update(Observable o, Object arg) {
                    ParIntrospectionTest.this.obs = o;
                }
            };
            ParIntrospection.lierObservableEtObserver(e, o
            );
            e.initialiser(3);

            ParIntrospection.delierObservableEtObserver(e, o);
            assertEquals(0, e.countObservers());


        } catch (Exception e) {
            fail(" exception !!! " + e.getMessage());
        }
    }

    public void test_lierJButtonEtActionListener() throws Exception {
        try {
            JButton jb = new JButton();
            ActionListener obs = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                }
            };
            question2.ParIntrospection.lierSourceEtListener(jb, obs);

            assertTrue(" l'observateur n'est pas ajouté ???", jb.getActionListeners().length == 1);
            boolean present = jb.getActionListeners()[0].equals(obs);
            assertTrue(" l'observateur n'est pas le bon, échéc lors de l'appel de \"getActionListeners\"", present);

            question2.ParIntrospection.delierSourceEtListener(jb, obs);
            assertTrue(" l'observateur n'est pas ajouté ???", jb.getActionListeners().length == 0);


        } catch (Exception e) {
            fail(" lier JButton et ActionListener lève une exception ???" + e.getMessage());
        }
    }

    public void test_lierClasseLocaleAuTestEtActionListener() {
        try {
            ClasseLocaleAuTest c = new ClasseLocaleAuTest();
            question2.ParIntrospection.lierSourceEtListener(c, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        }
                    }
            );
            assertTrue("echec lors de la liaison par introspection ???", c.al != null);
        } catch (Exception e) {
            //assertTrue(" NoSuchElementException est attendue ???", e instanceof NoSuchElementException);
            fail(" pas d'exception attendue ici !!! ");
        }
    }

    // ------

    public void test_lier_delierClasseLocaleAuTestEtActionListener() {
        try {
            ClasseLocaleAuTest c = new ClasseLocaleAuTest();
            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            };
            question2.ParIntrospection.lierSourceEtListener(c, actionListener);
            assertTrue("echec lors de la liaison par introspection ???", c.al != null);
            assertTrue("echec lors de la liaison par introspection ???", c.al == actionListener);
            question2.ParIntrospection.delierSourceEtListener(c, actionListener);
            assertTrue("echec lors de l'appel de delier ???", c.al == null);

        } catch (Exception e) {
            fail(" pas d'exception attendue ici !!! ");
        }
    }

    public void test_lierCheckBoxEtItemListener() throws Exception{
        try{
            Checkbox c = new Checkbox();
            question2.ParIntrospection.lierSourceEtListener(c, new ItemListener(){
                        public void itemStateChanged(ItemEvent e) {
                        }
                    }
            );

            ItemListener[] ls = (ItemListener[])(c.getListeners(ItemListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);
        }catch(Exception e){
            fail(" lier CheckBox et ItemListener leve une exception ???");
        }
    }


    public void test_lierJComboBoxEtActionListener() throws Exception {
        try {
            JComboBox jc = new JComboBox();
            question2.ParIntrospection.lierSourceEtListener(jc, new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                        }
                    }
            );
            ActionListener[] ls = (ActionListener[]) (jc.getListeners(ActionListener.class));
            //System.out.println(jc.getListeners().toString());
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Entier extends Observable {
        private int x;

        public Entier(int x) {
            this.x = x;
        }

        public void initialiser(int valeur) {
            this.x = valeur;
            setChanged();
            notifyObservers();
        }

        public String toString() {
            return Integer.toString(x);
        }
    }

    private static class EntierNonObservable{
        private int x;

        public EntierNonObservable(int x) {
            this.x = x;
        }

        public void initialiser(int valeur) {
            this.x = valeur;
        }

        public String toString() {
            return Integer.toString(x);
        }

    }

    private class ClasseLocaleAuTest {
        public ActionListener al = null;

        public void addActionListener(ActionListener al) {
            this.al = al;
        }

        public void removeActionListener(ActionListener l) {
            this.al = null;
        }
    }
}
