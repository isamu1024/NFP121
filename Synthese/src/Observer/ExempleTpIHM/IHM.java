package Observer.ExempleTpIHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IHM extends JFrame {
    private final JButton boutonA = new JButton("A");
    private final JButton boutonB = new JButton("B");
    private final JButton boutonC = new JButton("C");

    private final TextArea contenu = new TextArea(30, 80);

    public IHM() {

            super("IHM Question2_1");
            JPanel enHaut = new JPanel();
            enHaut.add(boutonA);
            enHaut.add(boutonB);
            enHaut.add(boutonC);
            setLayout(new BorderLayout(5, 5));
            add("North", enHaut);
            add("Center", contenu); // contenu sera transmis aux observateurs, voir
            // la description des constructeurs
            enHaut.setBackground(Color.blue);
            setLocation(100, 100);
            pack();
            show();

            // le bouton A a 3 observateurs jbo1, jbo2 et jbo3

            ActionListener jbo1 = new JButtonObserver("jbo1", contenu);
            ActionListener jbo2 = new JButtonObserver("jbo2", contenu);
            ActionListener jbo3 = new JButtonObserver("jbo3", contenu);

            boutonA.addActionListener(jbo1);
            boutonA.addActionListener(jbo2);
            boutonA.addActionListener(jbo3);

            // le bouton B a 2 observateurs jbo1 et jbo2

            boutonB.addActionListener(jbo1);
            boutonB.addActionListener(jbo2);

            // le bouton C a 1 observateur jbo1

            boutonC.addActionListener(jbo1);
        }

        public static void main(String[] args){
            new IHM();
        }

    }
