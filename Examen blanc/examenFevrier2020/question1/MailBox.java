package question1;


import java.util.*;

public class MailBox implements IMailBox {

    List<Dest> destinataires;

    public MailBox() {

        this.destinataires = new ArrayList<>();

    }

    public MailBox(MailBox mb) {
        this.destinataires = new ArrayList<>();
        this.destinataires.addAll(mb.destinataires);
    }

    public void add(String dest) throws Exception {

        Boolean isPresent = false;

        for (Dest d : destinataires) {
            if (d.getName().equals(dest))
                isPresent = true;
        }

        if (!isPresent)
            this.destinataires.add(new Dest(dest));
        else
            throw new Exception();

    }

    public void send(String message, String dest) throws Exception {

        Boolean sent = false;

        for (Dest d : destinataires) {
            if (d.getName().equals(dest)) {
                d.recept(message);
                sent = true;
            }
        }

        if (!sent)
            throw new Exception("Destinaire inconnu");

    }

    public void send(String message, String[] destinataires) throws Exception {

        Boolean sent = false;
        List<String> validDest = new ArrayList<>();


        for (String dest : destinataires) {
            for (Dest regDest : this.destinataires) {
                if (regDest.getName().equals(dest))
                    validDest.add(dest);
            }
        }

        for (String dest : validDest) {
            this.send(message, dest);
        }

        if (validDest.size() != destinataires.length)
            throw new Exception("un destinataire était inconnu");

    }

    public List<String> read(String dest) throws Exception {

        List<String> list = new ArrayList<String>();

        for (Dest d : destinataires) {
            if (d.getName().equals(dest))
                list.addAll(d.getUnreadMessage());
        }

        return list;
    }

    public Iterator<String> iterator() {
        List<String> destinataires = new ArrayList<>();
        for (Dest d : this.destinataires)
            destinataires.add(d.getName());

        return destinataires.iterator();
    }

    public List<String> getAllMessages(String dest) throws Exception {
        List<String> list = new ArrayList<String>();
        Boolean success = false;

        for (Dest d : destinataires) {
            if (d.getName().equals(dest)) {
                list.addAll(d.getAllMessages());
                success = true;
            }
        }

        if (!success)
            throw new Exception("Destinaire inconnu");

        return list;
    }

    public List<String> getAllUnreadMessages(String dest) throws Exception {
        List<String> list = new ArrayList<String>();
        Boolean success = false;

        for (Dest d : destinataires) {
            if (d.getName().equals(dest)) {
                list.addAll(d.getUnreadMessage());
                success = true;
            }
        }

        if (!success)
            throw new Exception("Destinaire inconnu");

        return list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    public boolean equals(Object o) {
        if (!(o instanceof MailBox))
            return false;

        MailBox mb = (MailBox) o;

        if (this.destinataires.size() != mb.destinataires.size())
            return false;

        if (mb.destinataires.equals(this.destinataires))
            return true;

        return false;
    }

    public int hashCode() {
        return this.toString().hashCode();
    }
}
