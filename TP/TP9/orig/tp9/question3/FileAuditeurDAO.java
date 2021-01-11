package question3;


import java.util.*;
import java.io.*;


public class FileAuditeurDAO implements DAO<Auditeur, Integer>{
   private String fileName;
// à compléter
   
   public FileAuditeurDAO(final String path, final String fileName) throws Exception{
     
     File dir = new File(path);
     if (!dir.exists()){ // si le répertoire n'existe pas (1 seul niveau)
       dir.mkdir();
     }
     this.fileName = path+fileName;
     File f = new File(this.fileName);
     if(!(f.isFile())){ // si le fichier n'existe pas
       // à compléter
     }

   }
   
   public FileAuditeurDAO(final String fileName) throws Exception{
     this("."+File.separator, fileName);
   }

 
   public void create(Auditeur a) throws Exception{
// à compléter
   }
   

   public Auditeur retrieve(Integer id) throws Exception{
     return null; 
   }
   

   public List<Auditeur> findAll() throws Exception{
// à compléter
     return null;
   }
   

   public void update(Auditeur a) throws Exception{
// à compléter

   }
   
   public void delete(Integer id) throws Exception{
// à compléter
   }
   
   public List<Auditeur> filter(Criteria<Auditeur> criteria) throws Exception{
     return DAO.DAOUtils.filter(this,criteria);
   }
   
}
