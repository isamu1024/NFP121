package Command;


/**
 * La CommandeEteindreLampe fonctionne
 * également de la même manière que
 * CommandeAllumerLampe, excepté que
 * nous associons le récepteur) à une action
 * différente : la méthode arret().
 */
public class CommandeEteindreLampe implements Commande {
    Lampe lampe;

    public CommandeEteindreLampe(Lampe lampe) {
        this.lampe = lampe;
    }

    @Override
    public void executer() {
        this.lampe.arret();
    }
}
