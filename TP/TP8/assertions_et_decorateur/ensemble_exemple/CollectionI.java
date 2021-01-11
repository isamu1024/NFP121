package ensemble_exemple;


public interface CollectionI extends Iterable<Integer>{
  /** Ajout d'un entier à la collection. 
   * @param i un entier
   */
  public void ajouter(int i);
  /** Ajout d'une collection à la collection en cours.
   * @param c la collection à ajouter
   */
  public void ajouter(CollectionI c);
  /** Retrait d'un entier de la collection.
   * @param i l'entier à supprimer, aucun effet si l'élément est absent.
   */
  public void retirer(int i);
  
  public boolean contient(int i);
  public int taille();
  
  /** Invariant de classe. cf. B. Liskov.*/
  public boolean repOk();
  /** Fonction d'abstraction. */
  public Object af();
  
}
