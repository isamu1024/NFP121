package question2;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;

public class ParIntrospection{

  /** Cette methode permet de relier par introspection, un observable et un observateur<p>
   * Appel par introspection de la methode observable.addObserver(observer) 
   *
   * @param observable une instance de la classe java.util.Observable ou l'une de ses derivees
   * @param observer une implementation de l'interface java.util.Observer
   * @throws NoSuchElementException en cas d'erreur
   */
  public static void lierObservableEtObserver(Object observable, Object observer) throws Exception{
    // à completer
  }
  
  /** Cette methode permet de delier par introspection, un observable et un observateur<p>
   * Appel par introspection de la methode observable.deleteObserver(observer) 
   * 
   * @param observable une instance de la classe java.util.Observable ou l'une de ses derivees
   * @param observer une implementation de l'interface java.util.Observer
   * @throws NoSuchElementException en cas d'erreur
   */
  public static void delierObservableEtObserver(Object observable, Object observer) throws Exception{
// à completer
  }
  
  /** Cette methode permet de relier par introspection, une source et un "listener"<p>
   * Appel par introspection de la methode source.addXXXXListener(listener) 
   * 
   * @param source est une instance 
   * @param listener une implementation d'une interface XXXXListener
   * @throws NoSuchElementException en cas d'erreur
   */
  public static void lierSourceEtListener(Object source, Object listener) throws Exception{
// à completer
  }

  /** Cette methode permet de delier par introspection, une source et un "listener"<p>
   * Appel par introspection de la methode source.removeXXXXListener(listener) 
   * 
   * @param source est une instance 
   * @param listener une implementation d'une interface XXXXListener
   * @throws NoSuchElementException en cas d'erreur
   */
  public static void delierSourceEtListener(Object source, Object listener) throws Exception{
// à completer
  }
  
}
