package Command;

public class CommandeAllumerLampe implements Commande {

    Lampe lampe;

    public CommandeAllumerLampe(Lampe lampe){
        this.lampe = lampe;
    }

    public void executer(){
        lampe.marche();
    }
}
