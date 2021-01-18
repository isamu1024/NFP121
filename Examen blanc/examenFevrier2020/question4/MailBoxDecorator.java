package question4;

import java.util.*;
import question2.MailBoxListener;
import question3.PersistentMode;

public abstract class MailBoxDecorator implements IMailBox{
    private IMailBox mb;

    public MailBoxDecorator(IMailBox mb){
       this.mb=mb;
    }
    public MailBoxDecorator(){}
    public void setMailBox(IMailBox mb){
        this.mb=mb;
    }
    public void add(String dest) throws Exception{
        /* a completer */
    }

    public void send(String message, String dest) throws Exception{
        /* a completer */
    }

    public void send(String message, String[] dest) throws Exception{
        /* a completer */
    }
    
    public List<String> read(String dest) throws Exception{
        return/* a completer */null;
    }

 
    public Iterator<String> iterator(){
        return /* a completer */ null;
    }

    public List<String> getAllMessages(String dest) throws Exception{
        return /* a completer */ null;
    }
    
    public List<String> getAllUnreadMessages(String dest) throws Exception{
        return /* a completer */ null;
    }
    
    public void addMailBoxListener(String destinataire, MailBoxListener listener) throws Exception{
       /* a completer */ 
    }

 
}