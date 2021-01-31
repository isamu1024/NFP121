package Question1;

import java.util.Iterator;
import java.util.Set;

public interface ContentBasedRouterI extends Iterable<ReceiverI> {
    /**
     * Installation d'un receveur de message.
     * Par défaut, ce receveur ne peut recevoir de message(cf. setEnabled),
     *
     * @param receiver le receveur.
     * @return this
     * @throws RuntimeException en cas de doublons
     */
    ContentBasedRouterI addReceiver(ReceiverI receiver);

    /**
     * Ajout d'un filtre pour un receveur. Les filtres sont cumulés en ET,
     * (en ET: tous les filtres doivent accepter le message)
     *
     * @param receiver le receveur.
     * @param filter   le filtre à appliquer sur le contenu du message.
     * @return this
     * @throws RuntimeException si le receveur n'existe pas, n'a pas été ajouté.
     */
    ContentBasedRouterI addFilter(ReceiverI receiver, FilterI filter);

    /**
     * Retrait d'un receveur de message.
     *
     * @param receiver le receveur.
     * @return this
     * @throws RuntimeException si le receveur n'existe pas, n'a pas été ajouté.
     */
    ContentBasedRouterI removeReceiver(ReceiverI receiver);

    /**
     * Envoi d'un message à tous les receveurs.
     * Cet envoi est conditionné par la réussite de tous les filtres
     * et l'autorisation à recevoir. Les receveurs ayant levé une exception
     * sont inhibés et accessibles par la méthode getReceiversException.
     *
     * @param msg le message.
     * @return le nombre de receveurs auxquels ce message a été envoyé et reçu
     */
    int sendMessage(String msg);

    /**
     * Autorisation de recevoir un message.
     * Par défaut, dès son ajout au routeur, le receveur est inhibé.
     *
     * @param receiver le receveur à autoriser.
     * @return this
     * @throws RuntimeException si le receveur n'existe pas, n'a pas été ajouté.
     */
    ContentBasedRouterI setEnabled(ReceiverI receiver);

    /**
     * Blocage, inhibition de l'envoi d'un message vers ce récepteur.
     *
     * @param receiver le receveur à inhiber.
     * @return this
     * @throws RuntimeException si le receveur n'existe pas, n'a pas été ajouté.
     */
    ContentBasedRouterI setDisabled(ReceiverI receiver);

    /**
     * Obtention d'un itérateur, sur les receveurs installés.
     *
     * @return un itérateur.
     */
    Iterator<ReceiverI> iterator();

    /**
     * Obtention de l'ensemble des receveurs ayant levé une exception.
     *
     * @return un ensemble des receveurs ayant levé une exception.
     */
    Set<ReceiverI> getReceiversException();
}

