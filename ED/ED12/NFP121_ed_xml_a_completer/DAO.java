import java.util.List;

/** DAO/CRUD : un "DAO" (Data Access Object ) qui propose les 4 opérations Create Retrieve Update Delete.
 *  @param <T> pour Le type souhaité
 *  @param <ID> pour l'identifiant, en général unique, par instance de T
 */
public interface DAO<T,ID>{

   /** Création de l'instance t en BDD.
    * @param t l'instance de T
    * @throws Exception si l'opération est en échec
    */
   public void create(T t) throws Exception;
   
   /* Permet de retrouver une instance de T à partie de son identifiant.
    * @param id l'identifiant associé à t
    * @return l'instance associée
    * @throws Exception si l'opération est en échec
    */
   public T retrieve(ID id) throws Exception;
   
   /** Mise à jour de t dans la base.
    * @param t instance de T, existante
    * @throws Exception si l'opération est en échec
    */
   public void update(T t) throws Exception;
   
   /** Retrait de t dans la base.
    * @param id l'identifiant associé à t
    * @throws Exception si l'opération est en échec
    */   
   public void delete(ID id) throws Exception;
   
   /** Obtention de la liste des T.
    * @throws Exception si l'opération est en échec
    */ 
   public List<T> findAll() throws Exception;
   
}
