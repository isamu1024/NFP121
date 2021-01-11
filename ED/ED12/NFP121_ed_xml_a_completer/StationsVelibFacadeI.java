import java.util.Collection;

public interface StationsVelibFacadeI{
  public static final String URL_VELIB_ALL = "http://www.velib.paris.fr/service/carto";
  public static final String URL_VELIB_INFO= "http://www.velib.paris.fr/service/stationdetails/"; //  /number
 
  /** Obtention de la station Vélib à partir de son numéro.
   * @param numero le numéro de la station par ex. 3011
   * @throws un exception si ce numéro est incorrect
   */
  public StationVelib getStation(int numero) throws Exception;
  
  /** Obtention des informations "temps-réél" de la station vélib.
   * En mode dégradé, ce seront les dernières valeurs enregistrées.
   * @param s la station vélib
   * @return toutes les informations sur cette station
   */
  public InfoStation getInfoStation(StationVelib s) throws Exception;
  
  /** Obtention de la liste des stations, celle-ci est immutable.
   * L'itérateur retourné par l'appel de la méthode iterator(), lève
   * une exception lors de l'appel d'un retrait par l'appel de la méthode remove
   * @return la liste immuable des stations Vélib
   */
  public Collection<StationVelib> getListeDesStations() throws Exception;
  
  /** Obtention de la distance d'une station à partir de coordonnées GPS.
   * Calcul de la distance extrait de http://www.geodatasource.com/developers/java
   * @param latitude la latitude
   * @param longitude la longitude
   * @param s la station vélib
   * @return la distance en kilomètre entre ce point et la station s, 
   *          0.0 si la station n'existe pas
   */
  public double getDistance(double latitude, double longitude, StationVelib s);
  
  /** Obtention du parser Xml associé.
   * @return le parser Xml choisi
   */
  public XmlParserStationVelibI getParser();
  
  /** Affectation, sélection du parser Xml.
   * @param parser le parser Xml
   */
  public void setParser(XmlParserStationVelibI parser);
}
