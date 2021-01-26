package Adaptateur.ExempleHeadFirst;

/**
 * A court de Canard, on souhaite utiliser des objets dindon (drôle d'idée).
 * On passe donc par un adaprtateur de dindon ( de la farce )
 * <p>
 * Vous devez d’abord implémenter l’interface
 * du type auquel vous vous adaptez. C’est
 * l’interface que votre client s’attend à voir.
 */
public class AdaptateurDindon implements Canard {

    Dindon dindon; // encapsulation de l'objet a adapter

    public AdaptateurDindon(Dindon dindon){
        this.dindon = dindon;
    }

    public void cancaner(){ // substitution
        dindon.gloutouter();
    }

    public void voler(){
        for (int i = 0; i < 5; i++)
            dindon.voler();
    }

}
