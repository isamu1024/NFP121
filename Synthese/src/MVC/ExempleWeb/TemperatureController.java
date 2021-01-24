package MVC.ExempleWeb;

/**
 * http://lacl.fr/tan/devpro/lifl/tp3mvc.pdf
 *
 * Chaque vue est associée à un unique contrôleur.
 * Le contrôleur interprète les actions de l’utilisateur et met à jour le modèle.
 * Le contrôleur peut utiliser le patron de conception stratégie pour mettre en oeuvre différentes stratégies d’interprétation des actions de l’utilisateur.
 * Dans l’exemple ci-dessous, nous pouvons augmenter la température d’un degré quand on clique sur le bouton + mais il doit être possible de modifier la façon
 * dont la température augmente ou diminue sans avoir à réécrire complètement la classe TemperatureController.
 * Enfin, le contrôleur doit également avoir connaissance de la vue qui lui est associée pour éventuellement modifier cette dernière.
 * En effet des actions de l’utilisateur sur la vue peuvent avoir pour conséquencede modifier la vue sans pour autant modifier le modèle.
 * Cela se fait par un appel de méthode de la vue.
 * Dans l’exemple ci-dessous, nous faisons passer le champ de texte en rouge quand la température dépasse 40C par un appel dans la méthode control() de la méthode enableWarningColor() définie dans la vue.
 * On pourrait de la même façon ajouter un bouton qui, quand on clique dessus sur la vue, modifie par exemple la couleur de l’arrière plan de l’interface.
 * Le contrôleur pourrait aussi vérifier que le texte saisi par l’utilisateur dans les champs de texte correspond bien à un nombre et, le cas échéant, informer la vue qu’une erreur de saisie a eu lieu.
 */
public class TemperatureController {
    private final TemperatureModel model;
    private TemperatureVue view = null;
    private final ModifieTemperature modtemp = new ModifieTemperaturePlus1();

    public TemperatureController(TemperatureModel m) {
        this.model = m;
    }

    public void augmenteDegresC() {
        model.setC(modtemp.augmenteDegres(model.getC()));
        control();
    }

    public void diminueDegresC() {
        model.setC(modtemp.diminueDegres(model.getC()));
        control();
    }

    public void fixeDegresC(double tempC) {
        model.setC(tempC);
        control();
    }

    public void augmenteDegresF() {
        model.setF(modtemp.augmenteDegres(model.getF()));
        control();
    }

    public void diminueDegresF() {
        model.setF(modtemp.augmenteDegres(model.getF()));
        control();
    }

    public void fixeDegresF(double tempF){
        model.setF(tempF);
        control();
    }

    public void control() {
        if (view != null) {
            if (model.getC() > 40.0) {
                view.enableWarningColor();
            } else {
                view.disableWarningColor();
            }
        }
    }

    public void addView(TemperatureVue vue){
        this.view = view;
    }

}
