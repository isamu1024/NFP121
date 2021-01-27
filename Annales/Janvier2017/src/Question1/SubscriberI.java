package Question1;

import java.io.Serializable;
import java.util.List;

public interface SubscriberI extends MessageListenerI, Serializable {

    /** Obtention du nom du souscripteur.
     * @return le nom du souscripteur
     */
    public String getName();

    /** Obtention de la liste des abonnements de ce souscripteur.
     * @return la liste des souscriptions effectuées
     */
    public List<PubSubI> getPubSubList();

    /** Ajout d'un abonnement pour ce souscripteur.
     * @return false si l'abonnement était déjà en place
     */
    public boolean addPubSub(PubSubI pubsub);
}
