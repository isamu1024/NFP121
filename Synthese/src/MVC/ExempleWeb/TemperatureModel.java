package MVC.ExempleWeb;

import java.util.Observable;


/**
 * Le modèle dérive de la classe java.util.Observable.
 * La classe doit définir les accesseurs et les mutateurs pour obtenir et modifier l’état courant du modèle.
 * Chaque mutateur doit appeler la méthode setChanged() et notifyObservers() après avoir modifié les données du modèle.
 * notifyObservers va notifier chaque vue qu’un changement d’état du modèle a eu lieu.
 * notifyObservers permet également de passer des informations supplémentaires concernant le changement d’état (variante push du patron de conceptionObservateur).
 * Voici la classe du modèle correspondant à notre interface :
 */
public class TemperatureModel extends Observable {
    private double temperatureC = 20;

    public double getC() {
        return temperatureC;
    }

    public void setC(double tempC) {
        temperatureC = tempC;
        setChanged();
        notifyObservers();
    }

    public double getF() {
        return temperatureC * 9.0 / 5.0 + 32.0;
    }

    public void setF(double tempF) {
        temperatureC = (tempF - 32) * 5.0 / 9.0;
        setChanged();
        notifyObservers();
    }
}
