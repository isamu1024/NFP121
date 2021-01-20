package Persistance.ExempleCours;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Save {

    private String path;

    public Save(String path){
        this.path = path;
    }

    public void sauvegarder(String fileName, Object o) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path +fileName));
        oos.writeObject(o);
        oos.close();
    }

}
