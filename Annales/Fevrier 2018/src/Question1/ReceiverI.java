package Question1;

public interface ReceiverI{
    /** Réception d'un message via le routeur.
     * @param msg le message reçu
     */
    public void receive(String msg) throws Exception;

    /** Réception d'un message via le routeur.
     * @return le nom du receveur
     */
    public String getName();
}
