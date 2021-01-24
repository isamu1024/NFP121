package MVC.ExempleWeb;

public class Demo {
    public Demo() {
        // Initialisation du modèle
        TemperatureModel tempmod = new TemperatureModel();

        // Initisalisation des controlleurs
        TemperatureController tempcontrolC = new TemperatureController(tempmod);

        // Initialisation des vues
        TemperatureVueCelsuis pvc = new TemperatureVueCelsuis(tempmod, tempcontrolC, 100, 200);
        tempcontrolC.addView(pvc);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Demo();
            }
        });
    }
}
