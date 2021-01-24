package Command;

public class TelecommandeSimple {

    Commande emplacement; // Notre commande n’a qu’un seul bouton  qui ne contrôle qu’un équipement

    public TelecommandeSimple() {}

    public void setCommande(Commande commande){
        emplacement = commande;
    }

    public void boutonPresse(){
        emplacement.executer();
    }

}
