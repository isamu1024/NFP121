package Command;

/**
 * Cette fois, la télécommande va gérer
 * sept commandes Marche ou Arrêt, que
 * nous allons mémoriser dans les tableaux
 * correspondants.
 */
public class Telecommande {
    Commande[] commandesMarche;
    Commande[] commandesArret;

    public Telecommande() {
        commandesMarche = new Commande[7];
        commandesArret = new Commande[7];

        Commande pasDeCommande = new PasDeCommande();

        // Initialisation
        for (int i = 0; i < 7; i++) {
            commandesMarche[i] = pasDeCommande;
            commandesArret[i] = pasDeCommande;
        }
    }

    /**
     * La méthode setCommande() accepte la position
     * d’un emplacement et les commandes Marche et
     * Arrêt qui y seront stockées. Puis elle place ces
     * commandes dans les tableaux correspondants pour
     * qu’on puisse les utiliser plus tard
     *
     * @param empt emplacement a peupler
     */
    public void setCommande(int empt, Commande comMarche, Commande comArret) {

        commandesMarche[empt] = comMarche;
        commandesArret[empt] = comArret;

    }

    public void boutonMarchePresse(int empt) {
        commandesMarche[empt].executer();
    }

    public void boutonArretPresse(int empt) {
        commandesArret[empt].executer();
    }

    public String toString(){
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------Télécommande------\n");
        for (int i = 0; i < commandesMarche.length; i++){
            stringBuff.append("[empt "+ i + "] " + commandesMarche[i].getClass().getName() + " " + commandesArret[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }

}
