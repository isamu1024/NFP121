
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;
import org.xml.sax.Attributes;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

import java.io.InputStream;

public class XmlParserSAXStationVelib  extends DefaultHandler implements XmlParserStationVelibI{
  private Command cmd;
  private InputStream in;
  
  public XmlParserSAXStationVelib(InputStream in) throws Exception{
    this.in = in;
  }
  
  public void setCommand(Command cmd){
    this.cmd = cmd;
  }
  
  public void parse() throws Exception{
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser sp = spf.newSAXParser();
    XMLReader xr = sp.getXMLReader();
    xr.setContentHandler(this);
    xr.parse(new InputSource(this.in));
  }

  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
    super.startElement(uri, localName, qName, attributes);

// à décommenter    if(qName.equals("marker")){
        
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
        throw new SAXException(exc.getMessage());
      }

    }
  //}
}