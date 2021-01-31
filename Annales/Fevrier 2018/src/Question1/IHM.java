package Question1;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.*;

public class IHM {
    private ContentBasedRouterI router;
    private Map<String, LocalReceiver> map;

    public static void main(String[] args) throws Exception {
        new IHM().config();
    }

    public void config() throws Exception {
        this.router = new ContentBasedRouter("router");
        this.map = new TreeMap<>();
        this.map.put("a", new LocalReceiver("a"));
        this.map.put("b", new LocalReceiver("b"));
        this.map.put("c", new LocalReceiver("c"));
        this.map.put("d", new LocalReceiver("d"));
        for (String name : map.keySet()) {
            router.addReceiver(map.get(name));
            router.setEnabled(map.get(name));
        }
        new IHMRouter(router);
    }

    private static class IHMReceiver extends JFrame {
        private final JTextArea resultat;

        public IHMReceiver(String name) {
            this.setTitle(name);
            Container container = this.getContentPane();
            container.setLayout(new BorderLayout());
            resultat = new JTextArea("message reçus par " + name + ":\n", 3, 14);
            container.add(resultat, BorderLayout.NORTH);
            this.pack();
            this.setVisible(true);
        }

        public void println(String str) {
            resultat.setText(resultat.getText() + "\n" + str);
            this.pack();
        }
    }

    private class IHMRouter extends JFrame {
        private final JTextArea resultat = new JTextArea("", 7, 60);
        private final JTextField message = new JTextField("meteo_pluie", 8);
        private final JButton envoi = new JButton("envoyer");
        private final JTextField filtre = new JTextField("ContainsFilter", 12);
        private final JTextField parametre = new JTextField("meteo", 8);
        private final JTextField receveur = new JTextField("a", 3);
        private final JButton charger = new JButton("charger");
        private final ContentBasedRouterI router;

        public IHMRouter(ContentBasedRouterI router) {
            this.setTitle("router " + router.getClass().getSimpleName());
            this.router = router;
            this.setAlwaysOnTop(true);
            Container container = this.getContentPane();
            container.setLayout(new BorderLayout());
            container.add(resultat, BorderLayout.NORTH);
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.add(new JLabel("message:"));
            panel.add(message);
            panel.add(envoi);
            panel.add(new JLabel("filtre ?:"));
            panel.add(filtre);
            panel.add(new JLabel("pattern ?:"));
            panel.add(parametre);
            panel.add(new JLabel("receiver ?:"));
            panel.add(receveur);
            panel.add(charger);
            container.add(panel, BorderLayout.SOUTH);
            this.envoi.addActionListener(
                    x -> {
                        router.sendMessage(message.getText());
                    }
            );
            this.charger.addActionListener(
                    x -> {
                        try {
                            Class<?> cl = Class.forName("Question1." + filtre.getText());
                            Constructor<?> constructor = cl.getConstructor(String.class);

                            Object fi;
                            ReceiverI rec = map.get(receveur.getText());

                            fi = constructor.newInstance(parametre.getText());

                            if (rec != null) {
                                router.addFilter(rec, (FilterI) fi);
                            } else {
                                throw new RuntimeException();
                            }

                        } catch (Exception exc) {
                            exc.printStackTrace();
                        }
                    }
            );
            this.pack();
            this.setVisible(true);
        }
    }

    private class LocalReceiver extends Receiver {
        private final IHMReceiver ihm;

        public LocalReceiver(String name) {
            super(name);
            this.ihm = new IHMReceiver(name);
        }

        public void receive(String msg) throws Exception {
            ihm.println(msg);
        }

        public String toString() {
            return "Receiver: " + getName();
        }
    }
}
