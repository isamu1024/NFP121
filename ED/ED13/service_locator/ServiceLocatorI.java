package service_locator;

import container.ApplicationContext;
import java.util.Iterator;

/** Recherche d'un bean, apparent� "service" dans 
 *  un conteneur de conteneurs de beans
 */
public interface ServiceLocatorI extends Iterable<String>{
    
  /** Recherche d'un bean, � l'aide de son nom.
   * @param serviceName le nom du bean (du service)
   * @return le bean cr�� par l'un des conteneurs
   */
  public <T> T lookup(String serviceName) throws Exception;
  
  /** Ajout de conteneur, 'setContainer': il faut lire 'addContainer'
   * <b>Attention</b> pas de tests sur la pr�sence �ventuelle de doublons
   * @exception si l'ajout des services �choue (fichier inexistant...)
   */
  public void setContainer(ApplicationContext container) throws Exception;
  
  /** Retourne un it�rateur sur tous les services accessibles.
   *  i.e. tous les beans de tous les conteneurs ajout�s
   */
  public Iterator<String> iterator();
  
  /** Recherche d'un bean, � l'aide de son nom.
   * @param containerName le nom du conteneur de services
   * @param serviceName le nom du bean (du service)
   * @return le bean cr�� par le conteneur
   */
  public <T> T lookup(String containerName, String serviceName) throws Exception;

  /** Retourne un it�rateur sur les conteneurs ajout�s.
   */
  public Iterator<ApplicationContext> iteratorContainers();
  
  /** Retourne un it�rateur sur les services d'un conteneur.
   */
  public Iterator<String> iteratorServices(ApplicationContext container);
}