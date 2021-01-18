package question3;

import java.io.*;
import java.util.*;

import question1.*;


public class MailBoxPersistent extends MailBox implements IMailBox{
    private final PersistentMode persistentMode;
    private final String fileName;

    public MailBoxPersistent(String fileName, PersistentMode persistentMode) throws Exception {
        super();
        this.fileName = fileName;
        this.persistentMode = persistentMode;

            try {
                IMailBox mb = persistentMode.readMailBox(fileName);
                System.out.print("mailbox lue depuis le fichier: " + mb);
                for (String dest : mb) {
                    this.add(dest);
                    for (String message : mb.getAllUnreadMessages(dest))
                        this.send(message, dest);

                }
                System.out.print("mailbox restitu�e: " + this);
            } catch (Exception e) {
                //e.printStackTrace();
            }

    }


    @Override
    public void send(String message, String destinataire) throws Exception {
        super.send(message, destinataire);

    }

    @Override
    public void send(String message, String[] destinataires) throws Exception {
        super.send(message, destinataires);
        PersistentMode out = new SerializationMode();
        out .writeMailBox(this, this.fileName);

    }


    @Override
    public List<String> read(String destinataire) throws Exception {
        List<String> list = super.read(destinataire);
        PersistentMode out = new SerializationMode();
        out .writeMailBox(this, this.fileName);
        return list;

    }




}
