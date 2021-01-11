

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import java.util.StringTokenizer;
import java.util.List;
/** 
 * Patron Data Access Object.
 * Largement inspiré de http://best-practice-software-engineering.ifs.tuwien.ac.at/patterns/dao.html
 */

public class DBStationVelib{ // implements DAO<StationVelib,Integer> {

  private PreparedStatement createStmt;
  private PreparedStatement retrieveStmt;
  private PreparedStatement updateStmt;
  private PreparedStatement deleteStmt;
  private Connection conn;
  
  public  DBStationVelib(String url, String user, String password) throws Exception{
    this.conn = DriverManager.getConnection(url, user, password);
    this.createStmt   = conn.prepareStatement("INSERT INTO stations (ts,number,name,address,fullAdress,lat,lng,open,bonus) VALUES(?,?,?,?,?,?,?,?,?)");
    this.retrieveStmt = conn.prepareStatement("SELECT name,address,fullAddress,lat,lng,open,bonus FROM stations WHERE number=?");
    this.updateStmt   = conn.prepareStatement("UPDATE stations SET  WHERE number=?");
    this.deleteStmt   = conn.prepareStatement("DELETE FROM stations WHERE number=?");
  }

  public void create(StationVelib sv) throws Exception{
    //this.createStmt   = conn.prepareStatement("INSERT INTO stations (ts,number,name,address,fullAddress,lat,lng,open,bonus) VALUES(?,?,?,?,?,?,?,?,?)");
     createStmt.setTimestamp(1,new Timestamp(System.currentTimeMillis())); 
     createStmt.setInt(2, sv.getNumber());  
     createStmt.setString(3, sv.getName());
     createStmt.setString(4, sv.getAddress());
     createStmt.setString(5, sv.getFullAddress());
     createStmt.setDouble(6, sv.getLatitude());  
     createStmt.setDouble(7, sv.getLongitude());  
     createStmt.setBoolean(8, sv.getOpen());  
     createStmt.setBoolean(9, sv.getBonus()); 
     createStmt.executeUpdate();
   }

   
   public StationVelib retrieve(Integer id) throws Exception{
//    this.retrieveStmt = conn.prepareStatement("SELECT name,address,fullAddress,lat,lng,open,bonus FROM stations WHERE number=?");
     retrieveStmt.setInt(1, id);
     ResultSet result = retrieveStmt.executeQuery();
     if(!result.next()) throw new Exception(" pas de resultat pour " + id + " ???");
    
     StationVelib sv = new StationVelib();
     sv.setNumber(result.getInt("number"));
     throw new Exception(" à terminer");
     
     //return sv;
   }


   public void update(StationVelib sv) throws Exception{
//     this.updateStmt   = conn.prepareStatement("UPDATE stations SET xxxxxxx à terminer xxxxxxxx WHERE number=?");
throw new Exception(" à terminer");
//      updateStmt.setInt(1, sv.getNumber());
//      updateStmt.executeUpdate();
   }
   

  public void delete(Integer id) throws Exception{
    throw new Exception(" à terminer");
   }
  
  public List<StationVelib> findAll() throws Exception{ 
     throw new Exception(" à terminer");
     //return null;
  }
}