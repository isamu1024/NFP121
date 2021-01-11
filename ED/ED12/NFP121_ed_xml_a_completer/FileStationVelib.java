
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;

import java.io.Serializable;
import java.io.File;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;
import org.xml.sax.Attributes;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

import java.net.URL;

public class FileStationVelib{ // implements DAO<StationVelib, Integer>, Serializable{

 
  private Map<Integer,StationVelib> stations;  // adéquation numéro -> station
 
  public FileStationVelib(){
    this.stations = new TreeMap<Integer,StationVelib>();
  }
  
  public void create(StationVelib sv){
    stations.put(sv.getNumber(), sv);
  }
  
  public StationVelib retrieve(Integer id) throws Exception{
    return stations.get(id);
  }
  
  public void update(StationVelib sv) throws Exception{
    this.stations.put(sv.getNumber(), sv);
  }
  
  public void delete(Integer id) throws Exception{
    stations.remove(id);
  }
  
  public List<StationVelib> findAll() throws Exception{
    return new ArrayList<StationVelib>(stations.values());
  }
  
 
}
