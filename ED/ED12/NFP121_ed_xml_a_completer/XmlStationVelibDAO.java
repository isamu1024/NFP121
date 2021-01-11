import java.io.*;
import java.util.*;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;
import org.xml.sax.Attributes;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

public class XmlStationVelibDAO{
//  implements DAO<StationVelib,Integer>{
//   private List<StationVelib> stations;
//   private XmlParserStationVelibI parser;
//   
//   public XmlStationVelibDAO() throws Exception{
//     this.stations = new ArrayList<StationVelib>();
// 
//   }
//   private class addCommand implements XmlStationVelibDAO.Command<StationVelib>{
//     public void execute(StationVelib s) throws Exception{
//       stations.add(s);
//     }
//   };
//   
//   public void loadFromXml(InputStream is) throws Exception{
// //     if(parser==null) parser = new XmlParserSAXStationVelib(is,new CreateCommand());
// //     parser.parse();
//   }
//   
//   public void setParser(XmlParserStationVelibI parser){
//     this.parser = parser;
//   }
// 
//   public void create(StationVelib s) throws Exception{
//     throw new RuntimeException("operation denied");
//   }
// 
//   public StationVelib retrieve(Integer id) throws Exception{
//     return null;
//   }
// 
//   public void update(StationVelib sv) throws Exception{
//     throw new RuntimeException("operation denied");
//   }
//   
//   public void delete(Integer id) throws Exception{
//     throw new RuntimeException("operation denied");
//   }
// 
//   public List<StationVelib> findAll() throws Exception{
//     return new ArrayList<StationVelib>(stations);
//   }

}
