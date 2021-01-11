import java.util.*;
import java.net.*;
import java.io.*;

public class TestListeDesStations extends junit.framework.TestCase{
 
  
//   public void testURLStationsVelib(){
//     try{
//       URL url = new URL("http://www.velib.paris.fr/service/carto");
//       StationsVelibFacadeI facade = new StationsVelibFacadeImpl(url);
//       
//       List<StationVelib> lesStations = facade.getListeDesStations();
//       System.out.println(lesStations.size());
// 
//       // 1224 le 24 novembre 2016
//       
//       assertTrue(lesStations.contenu().size() >= 1200);
//     }catch(Exception e){
//       fail(e.getMessage());
//     }
//    }
  
   public void testSAXFichierXmlStationsVelib() throws Exception{
     InputStream in = null;
     try{
       in = this.getClass().getResourceAsStream("stations.xml");
       StationsVelibFacadeI facade = new StationsVelibFacadeImpl(in);
       Collection<StationVelib> lesStations = facade.getListeDesStations();
       System.out.println(lesStations.size());
       assertTrue(lesStations.size() >= 1200);
       
       for(StationVelib station : lesStations){
         System.out.println(station + " : " +  facade.getInfoStation(station));
       }
    }catch(Exception e){
       e.printStackTrace();
       fail(e.getMessage());
    }finally{
      if(in!=null)in.close();
    }
  }
  
  
   public void testJDOMFichierXmlStationsVelib() throws Exception{
     InputStream in = null;
     try{
       in = this.getClass().getResourceAsStream("stations.xml");
       StationsVelibFacadeI facade = new StationsVelibFacadeImpl(in);
       facade.setParser(new XmlParserJDOMStationVelib(in));
       Collection<StationVelib> lesStations = facade.getListeDesStations();

       //System.out.println(lesStations.size());
       assertTrue(lesStations.size() >= 1201);
       
       for(StationVelib station : lesStations){
         //System.out.println(station + " : " +  facade.getInfoStation(station));
       }
    }catch(Exception e){
       fail(e.getMessage());
    }finally{
      if(in!=null)in.close();
    }
  }
  
  


  public void testStationTurbigoEtAlesia(){
     InputStream in = null;
     try{
       in = this.getClass().getResourceAsStream("stations.xml");
       StationsVelibFacadeI facade = new StationsVelibFacadeImpl(in);
       Collection<StationVelib> stations = facade.getListeDesStations();
       assertTrue(stations.size() >= 1200);
       StationVelib turbigo = facade.getStation(3011);
       System.out.println(" " + turbigo.getName());
       assertEquals("03011 - TURBIGO", turbigo.getName());
       double distance = facade.getDistance(48.867454, 2.363489, turbigo);
       assertTrue(distance>0.500 && distance<0.600);  
       distance = facade.getDistance(-22.2643536,166.3749121,turbigo);
       // https://fr.distance.to/Nouméa/Paris
       assertTrue(distance>16730 && distance<16750); // 
       InfoStation infoTurbigo = facade.getInfoStation(turbigo);
       //http://www.velib.paris/Plan
       assertEquals(31, infoTurbigo.getTotal()); // le nombre maximal de bornes
       assertTrue((infoTurbigo.getAvailable()+ infoTurbigo.getFree())<=infoTurbigo.getTotal()); // 
       
       StationVelib alesia = facade.getStation(14010);
       assertEquals("14010 - JEAN MOULIN ALESIA", alesia.getName());
       InfoStation infoAlesia = facade.getInfoStation(alesia);
       assertTrue(infoAlesia.getAvailable()<=infoAlesia.getTotal());
       
       
    
    }catch(Exception e){
      fail(e.getMessage());
    }
  }
  

  public void testNombreDeVelos() throws Exception{
    StationsVelibFacadeImpl liste = new StationsVelibFacadeImpl();
    assertNotNull(liste.getParser());
    assertNotNull(liste.getStation(3011));
    int nombre = 0; int total = 0; int exceptions = 0;
    
    for( StationVelib s : liste){
      try{
        if(s.getOpen()){
          InfoStation info = liste.getInfoStation(s);
          nombre = nombre + info.getAvailable();
          total = total + info.getTotal();
        }
      }catch(Exception e){
        exceptions++;
      }
    }
    System.out.println("total: " + total + ", nombre de vélos en circulation: " + nombre);
    System.out.println("exceptions: " + exceptions);
  }
}

