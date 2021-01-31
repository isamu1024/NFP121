package Question1;

public interface FilterI{
    /** Filtrage du message.
     * @param msg le message en entrée
     * @return true si le filtre réussit, false autrement.
     */
    public boolean accept(String msg);
}