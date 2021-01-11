package heritage_pre_post_pour_discussion;


public interface NombreI{
   
  /** Affectation de la valeur du nombre.
   * La valeur est 2*i.
  */
  void setValeurEiffel(int i);
  /** Affectation de la valeur du nombre.
   * La valeur est 2*i.
   */
  void setValeurLiskov(int i); 
  
  /** Lecture de la valeur de ce nombre.
   * @return la valeur de ce nombre.
   */
  int getValeur();
}
