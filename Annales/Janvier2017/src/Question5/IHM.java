package Question5;

import Question1.*;
import Question4.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class IHM extends JFrame {
    private final JTextArea resultat = new JTextArea("", 7, 60);
    private final JButton creerTheme = new JButton("créer ce thème");
    private final JTextField theme = new JTextField("meteo", 6);
    private final JTextField message = new JTextField("il pleut", 8);
    private final JButton envoyerMessage = new JButton("envoyer ce message");
    private final JTextField souscripteur = new JTextField("s1", 4);
    private final JButton ajouterSouscripteur = new JButton("ajouter ce souscripteur");
    private final JButton liste = new JButton("liste");
    private final JButton raz = new JButton("raz");
    private final PublishSubscribeI pubsub;

    public IHM() {
        this.setTitle("IHM de \"test\" class question4.PublishSubscribe");
        this.pubsub = new PublishSubscribeImpl();
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(resultat, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("thème:"));
        panel.add(theme);
        //panel.add(creerTheme);
        panel.add(new JLabel("message:"));
        panel.add(message);
        panel.add(envoyerMessage);
        panel.add(new JLabel("souscripteur:"));
        panel.add(souscripteur);
        panel.add(ajouterSouscripteur);
        panel.add(liste);
        panel.add(raz);
        container.add(panel, BorderLayout.SOUTH);

        this.ajouterSouscripteur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                SubscriberI sub = new SimpleSubscriber(souscripteur.getText());
                pubsub.subscribe(theme.getText(), sub );
                IHM.this.pack();
            }
        });
        this.envoyerMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Message message = new Message()

                IHM.this.pack();
            }
        });
        this.liste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
// à compléter, indiquez sur votre copie "code pour liste"
                IHM.this.pack();
            }
        });
        this.raz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
// à compléter, indiquez sur votre copie "code pour raz"
                IHM.this.pack();
            }
        });
        this.pack();
        this.setVisible(true);
    }

    public static void main() {
        new IHM();
    }

    public class SubscriberIHM extends SimpleSubscriber {
        public SubscriberIHM(String name) {
            super(name);
        }

        @Override
        public void onMessage(Message message) {
            resultat.setText(resultat.getText() + "\n" + message + "\n");
        }
    }
}