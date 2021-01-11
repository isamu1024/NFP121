
import org.jdom.*;
import org.jdom.input.*;

import java.io.*;
import java.util.*;
public class XmlParserJDOMStationVelib implements XmlParserStationVelibI{
  private InputStream is;
  private Command cmd;
  
  public XmlParserJDOMStationVelib(InputStream is) throws Exception{
    this.is = is;
  }
  
  public  void setCommand(Command cmd){
    this.cmd = cmd;
  }
  
  public void parse() throws Exception{
    SAXBuilder saxB = new SAXBuilder();
    Document document = saxB.build(is);
    Element racine = document.getRootElement();
    //      System.out.println(racine.getText() + " " + racine.getName());
    //      racine.getAttribute("class").getValue());
    List<Element> list = racine.getChildren("markers");
    Element markers = list.get(0);
    System.out.println(markers);
    List<Element> listStation = markers.getChildren("marker"); 
    System.out.println(listStation.size());
    
    for(Element e : listStation){
        
// à compléter
// à compléter
// à compléter
// à compléter
// à compléter
// à compléter
// à compléter
// à compléter
// à compléter

      try{
        //cmd.execute(station);
      }catch(NullPointerException exc){
        throw new NullPointerException("setCommand must be called");
      }catch(Exception exc){
        throw new Exception(exc.getMessage());
      }
    }

  }
}
