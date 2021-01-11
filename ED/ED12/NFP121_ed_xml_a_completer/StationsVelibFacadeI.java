import java.util.Collection;

public interface StationsVelibFacadeI{
  public static final String URL_VELIB_ALL = "http://www.velib.paris.fr/service/carto";
  public static final String URL_VELIB_INFO= "http://www.velib.paris.fr/service/stationdetails/"; //  /number
 
  /** Obtention de la station V�lib � partir de son num�ro.
   * @param numero le num�ro de la station par ex. 3011
   * @throws un exception si ce num�ro est incorrect
   */
  public StationVelib getStation(int numero) throws Exception;
  
  /** Obtention des informations "temps-r��l" de la station v�lib.
   * En mode d�grad�, ce seront les derni�res valeurs enregistr�es.
   * @param s la station v�lib
   * @return toutes les informations sur cette station
   */
  public InfoStation getInfoStation(StationVelib s) throws Exception;
  
  /** Obtention de la liste des stations, celle-ci est immutable.
   * L'it�rateur retourn� par l'appel de la m�thode iterator(), l�ve
   * une exception lors de l'appel d'un retrait par l'appel de la m�thode remove
   * @return la liste immuable des stations V�lib
   */
  public Collection<StationVelib> getListeDesStations() throws Exception;
  
  /** Obtention de la distance d'une station � partir de coordonn�es GPS.
   * Calcul de la distance extrait de http://www.geodatasource.com/developers/java
   * @param latitude la latitude
   * @param longitude la longitude
   * @param s la station v�lib
   * @return la distance en kilom�tre entre ce point et la station s, 
   *          0.0 si la station n'existe pas
   */
  public double getDistance(double latitude, double longitude, StationVelib s);
  
  /** Obtention du parser Xml associ�.
   * @return le parser Xml choisi
   */
  public XmlParserStationVelibI getParser();
  
  /** Affectation, s�lection du parser Xml.
   * @param parser le parser Xml
   */
  public void setParser(XmlParserStationVelibI parser);
}
