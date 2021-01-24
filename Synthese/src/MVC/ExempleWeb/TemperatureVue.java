package MVC.ExempleWeb;

import java.awt.event.ActionListener;
import java.util.Observer;
import javax.swing.*;
import java.awt.*;

/**
 * Chaque vue doit implémenter l’interface java.util.Observer et par conséquent implémenter la méthode update.
 * Le premier paramètre permet ’identifier le sujet à l’origine de la mise à jour et le second permet de recevoir des informations supplémentaires concernant la mise à jour.
 * Une vue peut éventuellement avoir plusieurs modèles. Chaque vue a besoin de connaître le modèle et le contrôleur.
 * La connaissance du modèle permet d’enregistrer la vue auprès de ce dernier et d’appeler les méthodes du modèle pour mettre à jour la vue.
 * Les actions de l’utilisateur sur l’interface sont envoyées au contrôleur.
 * Comme nous avons deux vues très semblables, nous définissons la classe abstraite suivante :
 */
public abstract class TemperatureVue implements Observer {
    private final String label;
    private final JFrame temperatureJFrame;
    private final JTextField display = new JTextField();
    private final JButton upJButton = new JButton("+");
    private final JButton downJButton = new JButton("-");
    protected TemperatureModel model;
    protected TemperatureController controller;

    TemperatureVue(String label, TemperatureModel model, TemperatureController controller, int posX, int posY) {
        this.label = label;
        this.model = model;
        this.controller = controller;
        temperatureJFrame = new JFrame(label);
        temperatureJFrame.add(new JLabel(label), BorderLayout.NORTH);
        temperatureJFrame.add(display, BorderLayout.CENTER);
        JPanel panelbuttons = new JPanel();
        panelbuttons.add(downJButton);
        panelbuttons.add(upJButton);
        temperatureJFrame.add(panelbuttons, BorderLayout.SOUTH);
        temperatureJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model.addObserver(this); // Connexion entre la vue et le modele
        temperatureJFrame.setSize(200, 100);
        temperatureJFrame.setLocation(posX, posY);
        temperatureJFrame.setVisible(true);
    }

    public void enableWarningColor() {
        display.setBackground(Color.RED);
    }

    public void disableWarningColor() {
        display.setBackground(Color.WHITE);
    }

    public double getDisplay() {
        double result = 0.0;
        try {
            result = Double.valueOf(display.getText()).doubleValue();
        } catch (NumberFormatException e) {
        }
        return result;
    }

    public void setDisplay(String s) {
        display.setText(s);
    }

    public void addDisplayListener(ActionListener a) {
        display.addActionListener(a);
    }

    public void addUpListener(ActionListener a) {
        upJButton.addActionListener(a);
    }

    public void addDownListener(ActionListener a) {
        downJButton.addActionListener(a);
    }

    protected TemperatureModel model() {
        return model;
    }
}