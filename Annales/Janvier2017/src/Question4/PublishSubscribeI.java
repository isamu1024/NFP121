package Question4;

import Question1.*;

import java.util.*;

public interface PublishSubscribeI extends Iterable<String>{
    /** Publication pour sur thème (topic) d'un message.
     * @param topic le thème
     * @param message le message à transmettre
     * @return le nombre de souscripteurs ayant été notifiés
     */
    public int publish(String topic, Message message);

    /** Souscription à un thème (topic) de publication.
     * @param topic le thème
     * @param subscriber le souscripteur
     * @return false le souscripteur est déjà inscrit à ce thème
     */
    public boolean subscribe(String topic, SubscriberI subscriber);

    /** Obtention d'un itérateur.
     * @return un itérateur sur les thèmes enregistrés
     */
    public Iterator<String> iterator();

    /**Obtention de la liste des souscripteurs à un thème.
     * @param topic le thème
     * @return la liste des souscripteurs, une liste vide si ce thème n'existe pas
     */
    public List<SubscriberI> getSubscribers(String topic);
}
