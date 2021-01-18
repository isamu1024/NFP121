package question2;

import question1.*;


import java.util.*;

public class MailBoxNotification extends MailBox implements IMailBoxNotification{


    private Map<String, List<MailBoxListener>> allListeners;

    public MailBoxNotification(){
        super();
        this.allListeners = new HashMap<>();
    } 

    private boolean contains(String destinataire){
        for(String dest : this){
            if(dest.equals(destinataire))
                return true;
        }

        return false;
    }

    public void addMailBoxListener(String destinataire, MailBoxListener listener) throws Exception{
        if(!contains(destinataire))
            throw new Exception(destinataire + " inconnu...");

        if (this.allListeners.get(destinataire) == null)
            this.allListeners.put(destinataire, new ArrayList<>());

        List<MailBoxListener> mbl = this.allListeners.get(destinataire);
        mbl.add(listener);
    }

    @Override
    public void send(String message, String destinataire) throws Exception{
        try{
            super.send(message,destinataire);
            for (MailBoxListener mbl : this.allListeners.get(destinataire))
                mbl.onReceive(message);
            
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void send(String message, String[] destinataires) throws Exception{
        for(String dest : destinataires){
            try{
                this.send(message, dest);

            }catch(Exception e){
            }
        }
    }
}
