package Question3;

import Question1.*;

import java.io.*;
import java.security.spec.ECField;

public class PubSubPersistent extends PubSubImpl {

    private final String fileName;

    public PubSubPersistent(String name) {
        super(name);

        this.fileName = ".\\src\\Question1\\" + name + ".ser";
        File fi = new File(this.fileName);
        if (!fi.isFile())
            try {
                fi.createNewFile();
            } catch (Exception e) {
                // Todo
            }
        else {
            try {
                this.restore();
            } catch (Exception e) {
                // Todo
            }

        }
    }


    private void save() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.fileName));
        oos.writeObject(this);
        oos.close();
    }

    private void restore() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.fileName));
        PubSubI p = (PubSubI) ois.readObject();
        ois.close();
        for (SubscriberI sub : p)
            super.subscribe(sub);
    }

    @Override
    public boolean subscribe(SubscriberI subscriber) {
        if (super.subscribe(subscriber)) {
            try {
                this.save();
            } catch (Exception e) {

            }
            return true;
        }
        return false;
    }

}
