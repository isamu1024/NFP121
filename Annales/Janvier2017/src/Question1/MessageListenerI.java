package Question1;

public interface MessageListenerI {

    /** Méthode déclenchée à chaque réception d'un message par un souscripteur.
     * @param message le message reçu.
     * @throws Exception levée par le destinataire, i.e. une erreur lors de la réception du message
     */
    public void onMessage(Message message) throws Exception;
}
