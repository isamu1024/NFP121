package Rules.Command;

/** La commande à exécuter.
 *
 * @param <R> le type de la donnée et du résultat.
 * */
public abstract class Command<R> {
    /** L'exécution de la commande
     *
     * @param r La donnée transmise
     * @return le résultat retourné
     * */

    public abstract R execute (R r) throws Exception;

    /** Patron interpreter.
     * @return une représentation textuelle de la commande
     * */

    public abstract String interpreter();

}
