package Command;

public class CommandeOuvrirPorteDeGarage implements Commande{

    PorteGarage porteGarage;

    public CommandeOuvrirPorteDeGarage(PorteGarage porteGarage){
        this.porteGarage = porteGarage;
    }

    @Override
    public void executer() {

        porteGarage.ouvrir();

    }
}
