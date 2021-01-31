package Question1;

public interface EmitterI{

    /** Affectation du router.
     * @param router le routeur
     */
    public void setRouter(ContentBasedRouterI router);
    /** Envoi d'un message.
     * @param msg le message à envoyer au(x) routeur(s)
     * @return le nombre de receveurs ayant reçu le message
     */
    public int sendMessage(String msg);
    /** Obtention du nom de l'émetteur.
     * @return le nom de cet émetteur
     */
    public String getName();
}
