package question3;
import java.io.*;
import java.util.*;
import question1.*;


public class SerializationMode extends PersistentMode{

  public void  writeMailBox(IMailBox mb, String fileName) throws Exception{

    IMailBox mbs = new MailBox((MailBoxPersistent) mb);

    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
    out.writeObject(mbs);
    out.close();
      
  }

  public  IMailBox readMailBox(String fileName) throws Exception{
    
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
    IMailBox mb = (IMailBox) ois.readObject();
    ois.close();
    return mb;
  }  
}
