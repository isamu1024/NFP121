import java.util.List;

/** DAO/CRUD : un "DAO" (Data Access Object ) qui propose les 4 op�rations Create Retrieve Update Delete.
 *  @param <T> pour Le type souhait�
 *  @param <ID> pour l'identifiant, en g�n�ral unique, par instance de T
 */
public interface DAO<T,ID>{

   /** Cr�ation de l'instance t en BDD.
    * @param t l'instance de T
    * @throws Exception si l'op�ration est en �chec
    */
   public void create(T t) throws Exception;
   
   /* Permet de retrouver une instance de T � partie de son identifiant.
    * @param id l'identifiant associ� � t
    * @return l'instance associ�e
    * @throws Exception si l'op�ration est en �chec
    */
   public T retrieve(ID id) throws Exception;
   
   /** Mise � jour de t dans la base.
    * @param t instance de T, existante
    * @throws Exception si l'op�ration est en �chec
    */
   public void update(T t) throws Exception;
   
   /** Retrait de t dans la base.
    * @param id l'identifiant associ� � t
    * @throws Exception si l'op�ration est en �chec
    */   
   public void delete(ID id) throws Exception;
   
   /** Obtention de la liste des T.
    * @throws Exception si l'op�ration est en �chec
    */ 
   public List<T> findAll() throws Exception;
   
}
