import java.util.*;

import java.io.*;

/** Un fichier par station.
 * 
 * Patron Data Access Object.
 * voir http://best-practice-software-engineering.ifs.tuwien.ac.at/patterns/dao.html
 
 */
public class FileStationVelibDAO implements DAO<StationVelib,Integer>{

   private String basePath;

   public FileStationVelibDAO(String basePath) {
     this.basePath = basePath;
   }
   
   public void create(StationVelib s) throws Exception{
     File file = new File(basePath + s.getNumber() + ".velib");
     String sep = System.getProperty("file.separator");
     String dirName = Integer.toString(s.getNumber());
     File dir = new File(dirName);
     if(!dir.exists())
        dir.mkdir();
     int number = dir.list().length;
     number++;
     FileWriter fw = new FileWriter(dir + sep + s.getNumber()+"_"+number+".txt");
     fw.write(s.toString());
     fw.close();
   }
   
//    ublic class FileBookDAO implements BookDAO {
//         
//   private String basePath;
// 
//   public FileBookDAO(String basePath) {
//     this.basePath = basePath;
//   }
// 
//   public Book loadBook(String isbn) {
//     FileReader fr = new FileReader(basePath + isbn);
//     BufferedReader br = new BufferedReader(fr);
//     Book b = new Book();
//     String rIsbn = br.readLine();
//     String rTitle = br.readLine();
//     String rAuthor = br.readLine();
//         
//     if (rIsbn.startsWith("ISBN: ")) {
//       b.setIsbn(rIsbn.substring("ISBN: ".length()));
//     } else {
//       return null;
//     }
//     if (rTitle.startsWith("TITLE: ")) {
//       b.setTitle(rTitle.substring("TITLE: ".length()));
//     } else {
//       return null;
//     }
//     if (rAuthor.startsWith("AUTHOR: ")) {
//       b.setAuthor(rAuthor.substring("AUTHOR: ".length()));
//     } else {
//       return null;
//     }
//     return b;
//   }
// 
//   public void saveBook(Book b) {
//     FileWriter fw = new FileWriter(basePath + b.getIsbn() + ".book");
//     fw.write("ISBN: " + b.getIsbn());
//     fw.write("TITLE: " + b.getTitle());
//     fw.write("AUTHOR: " + b.getAuthor());
//     fw.close();
//   }
// }

   public StationVelib retrieve(Integer id) throws Exception{
     return null;
    }
   

   public void update(StationVelib s) throws Exception{
    }
   
   
   public void delete(Integer id) throws Exception{
    }
   

   public List<StationVelib> findAll() throws Exception{
     return null;
    }
}
