
import java.util.*;
import java.io.*;
import java.net.URL;

public class StationsVelibFacadeImpl implements StationsVelibFacadeI, Serializable, Iterable<StationVelib>{
  private Map<Integer,StationVelib> stations;
  private XmlParserStationVelibI parser;
  
  private XmlParserStationVelibI.Command addCommand =
                      new XmlParserStationVelibI.Command(){
                        public void execute(StationVelib s){
                          StationsVelibFacadeImpl.this.stations.put(s.getNumber(), s);
                        }
                      };
  
  public  StationsVelibFacadeImpl() throws Exception{
    this(StationsVelibFacadeImpl.class.getResourceAsStream("stations.xml"));
  }
  
  public  StationsVelibFacadeImpl(URL url) throws Exception{
    this(url.openStream());
  }
  
  public StationsVelibFacadeImpl(InputStream in) throws Exception{
    this.stations = new TreeMap<Integer,StationVelib>();
    if(parser==null){
      parser = new XmlParserSAXStationVelib(in);
    }
    parser.setCommand(addCommand);
    parser.parse();
  }
  
  public void setParser(XmlParserStationVelibI parser){
    this.parser = parser;
  }

  public XmlParserStationVelibI getParser(){
    return this.parser;
  }

  
  public StationVelib getStation(int numero) throws Exception{
    return stations.get(numero);
  }
  
  public InfoStation getInfoStation(StationVelib s) throws Exception{
    return new InfoStation(s);
  }
  
  public Collection<StationVelib> getListeDesStations() throws Exception{
    return Collections.unmodifiableCollection(stations.values());
  }
  
 
    
  public Iterator<StationVelib> iterator(){
      return new Iterator<StationVelib>(){
        Iterator<StationVelib> it = stations.values().iterator();
        public boolean hasNext(){return it.hasNext();}
        public StationVelib next(){ return it.next();}
        public void remove(){throw new RuntimeException();}
        };
  }
      
  
    public double getDistance(double latitude, double longitude, StationVelib s){
      try{
        return DistanceCalculator.distance(latitude,longitude,s.getLatitude(),s.getLongitude(),"K");
      }catch(Exception e){
        return 0.0;
      }
    }

    // extrait de http://www.geodatasource.com/developers/java
    private static class DistanceCalculator{
    	public static void main (String[] args) throws java.lang.Exception{
    		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Miles\n");
    		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "K") + " Kilometers\n");
    		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Nautical Miles\n");
    	}
    
    	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
    		double theta = lon1 - lon2;
    		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
    		dist = Math.acos(dist);
    		dist = rad2deg(dist);
    		dist = dist * 60 * 1.1515;
    		if (unit == "K") {
    			dist = dist * 1.609344;
    		} else if (unit == "N") {
    			dist = dist * 0.8684;
    		}
    
    		return (dist);
    	}
    
    	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    	/*::	This function converts decimal degrees to radians						 :*/
    	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    	private static double deg2rad(double deg) {
    		return (deg * Math.PI / 180.0);
    	}
    
    	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    	/*::	This function converts radians to decimal degrees						 :*/
    	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    	private static double rad2deg(double rad) {
    		return (rad * 180 / Math.PI);
    	}
    }
//       //return dao.findAll().iterator();
//       //final Iterator<StationVelib> it = dao.findAll().iterator();
//       return  new Iterator<StationVelib>(){
//         Iterator<StationVelib> it; // = dao.findAll().iterator();
//         StationVelib current;
//         {it = dao.findAll().iterator();}
//         public boolean hasNext(){
//           return it.hasNext();
//         }
//         public StationVelib next(){
//           current = it.next();
//           return current;
//         }
//         public void remove(){
//           try{
//             it.remove();
//             dao.delete(current.getNumber());
//           }catch(Exception e){
//             throw new RuntimeException(e);
//           }
//         }
//       };
//     }catch(Exception e){
//       throw new RuntimeException();
//     }
//   }
  

  
//   public void sauvegarder(String nomDeFichier)throws Exception{
//     ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(nomDeFichier ));
//     oos.writeObject(this);
//     oos.close();
//   }
//   
//   public static StationsVelibI restaurer(String nomDeFichier)throws Exception{
//     ObjectInputStream ois = new ObjectInputStream( new FileInputStream(nomDeFichier));
//     ListeDesStationsVelib liste = (StationsVelib) ois.readObject();  
//     ois.close();
//     return liste;
//   }
  
}
