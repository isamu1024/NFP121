package Question1;

import java.io.Serializable;
import java.util.Iterator;

public interface PubSubI extends Iterable<SubscriberI>, Serializable {

    /** Publication d'un message à certains souscripteurs.
     * @param names les noms des souscripteurs
     * @param message le message à transmettre
     * @return le nombre de souscripteurs ayant reçu le message
     */
    public int publish(String[] names, Message message);

    /** Publication d'un message à un souscripteur.
     * @param name le nom du souscripteur
     * @param message le message à transmettre
     * @return true si l'envoi est réussi, false autrement
     */
    public boolean publish(String name, Message message);

    /** Souscription.
     * @param subscriber le souscripteur
     * @return false si ce souscripteur a déjà souscrit avec le même nom
     */
    public boolean subscribe(SubscriberI subscriber);

    /** Obtention d'un itérateur.
     * @return un itérateur sur les souscripteurs enregistrés
     */
    public Iterator<SubscriberI> iterator();
}
