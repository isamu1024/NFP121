
import java.io.*;

public interface XmlParserStationVelibI{

  public interface Command{
    void execute(StationVelib s) throws Exception;
  }

  public void setCommand(Command cmd);
  
  public void parse() throws Exception;
        
}
