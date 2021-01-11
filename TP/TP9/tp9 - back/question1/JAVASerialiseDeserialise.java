package question1;


import java.io.*;

/**
 * Décrivez votre classe JAVASerialiseDeserialise ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class JAVASerialiseDeserialise {
    /**
     * Sauvegarde un objet de type IProgr
     * @param p Objet de tyoe IProgr
     * @param nomDuFichier path et nom du fichier ser de sauvegarde
     * @throws IOException
     */
    public static void serialjava(IProgr p, String nomDuFichier) throws IOException {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
            oos.writeObject(p);
            oos.close();
    }

    /**
     * Restitue un objet de type IProgr
     * @param nomDuFichier
     * @return
     * @throws Exception
     */
    public static IProgr deserialjava(String nomDuFichier) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomDuFichier));
        IProgr obj = (IProgr) ois.readObject();
        ois.close();
        return obj;
    }
}
