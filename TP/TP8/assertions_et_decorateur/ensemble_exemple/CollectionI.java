package ensemble_exemple;


public interface CollectionI extends Iterable<Integer>{
  /** Ajout d'un entier � la collection. 
   * @param i un entier
   */
  public void ajouter(int i);
  /** Ajout d'une collection � la collection en cours.
   * @param c la collection � ajouter
   */
  public void ajouter(CollectionI c);
  /** Retrait d'un entier de la collection.
   * @param i l'entier � supprimer, aucun effet si l'�l�ment est absent.
   */
  public void retirer(int i);
  
  public boolean contient(int i);
  public int taille();
  
  /** Invariant de classe. cf. B. Liskov.*/
  public boolean repOk();
  /** Fonction d'abstraction. */
  public Object af();
  
}
