/**
 * Biblio :
 * https://stackabuse.com/reading-and-writing-csvs-in-java/
 */


package question3;


import java.util.*;
import java.io.*;


public class FileAuditeurDAO implements DAO<Auditeur, Integer> {

    private String fileName;
    private int lastId;

    public FileAuditeurDAO(final String path, final String fileName) throws Exception{

        File dir = new File(path);
        if (!dir.exists()) { // si le répertoire n'existe pas (1 seul niveau)
            dir.mkdir();
        }
        this.fileName = path + fileName;
        File f = new File(this.fileName);
        if (!(f.isFile())) { // si le fichier n'existe pas
            f.createNewFile();
        }
    }

    public FileAuditeurDAO(final String fileName) throws Exception {
        this("." + File.separator, fileName);
    }

    public void create(Auditeur a) throws Exception {
        String row;
        this.lastId = 0;
        String[] auditeurData;
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));


        while ((row = br.readLine()) != null) {
            String[] data = row.split(";");
            this.lastId = Integer.parseInt(data[0]) + 1;
        }

        br.close();

        a.setId(this.lastId);
        auditeurData = new String[]{
                String.valueOf(a.getId()),
                a.getNom(),
                a.getPrenom(),
                a.getEmail()
        };
        BufferedWriter fw = new BufferedWriter(new FileWriter(this.fileName, true));
        fw.append(String.join(";", auditeurData) + "\n");
        fw.close();
    }

    public Auditeur retrieve(Integer id) throws Exception {
        Auditeur a = null;
        String line = null;
        String[] data = null;
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));

        while ((line = br.readLine()) != null) {
            data = line.split(";");
            if (Integer.parseInt(data[0]) == id)
                break;
            data = null;
        }

        br.close();

        if (data == null)
            throw new NoSuchElementException();

        if (data != null) {
            a = new Auditeur(
                    data[1],
                    data[2],
                    data[3]);
            Integer.parseInt(data[0]);
            a.setId(Integer.parseInt(data[0]));
        }
        return a;
    }

    public List<Auditeur> findAll() throws Exception {
        String line;
        String[] data;
        Auditeur auditeur;
        List<Auditeur> auditeurs = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        while ((line = br.readLine()) != null) {
            data = line.split(";");
            auditeur = new Auditeur(
                    data[1],    // Nom
                    data[2],    // prenom
                    data[3]     // email
            );
            auditeur.setId(Integer.parseInt(data[0]));
            auditeurs.add(auditeur);
        }

        br.close();

        return auditeurs;
    }

    public void update(Auditeur a) throws Exception {
        BufferedReader br=new BufferedReader(new FileReader(this.fileName));
        StringBuffer sb=new StringBuffer("");
        String line;
        String[] data;

        while((line=br.readLine())!=null) {
            data = data = line.split(";");
            if (Integer.parseInt(data[0]) == a.getId()){
                data[0] = String.valueOf(a.getId());
                data[1] = a.getNom();
                data[2] = a.getPrenom();
                data[3] = a.getEmail();
                sb.append(String.join(";", data) + "\n");
            } else {
                sb.append(line + "\n");
            }
        }

        br.close();
        FileWriter fw=new FileWriter(this.fileName);
        fw.write(sb.toString());
        fw.close();
    }

    public void delete(Integer id) throws Exception {
        BufferedReader br=new BufferedReader(new FileReader(this.fileName));
        StringBuffer sb=new StringBuffer("");
        String line = null;
        String[] data = null;

        while((line=br.readLine())!=null) {
            data = line.split(";");
            if (Integer.parseInt(data[0]) != id)
                sb.append(line+"\n");
        }
        br.close();

        FileWriter fw=new FileWriter(new File(this.fileName));
        fw.write(sb.toString());
        fw.close();
    }

    public List<Auditeur> filter(Criteria<Auditeur> criteria) throws Exception {
        return DAO.DAOUtils.filter(this, criteria);
    }

}
