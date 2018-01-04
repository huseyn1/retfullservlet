
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

public class OracleDao {
    
    protected Connection conn = null;
    protected PreparedStatement psm = null;
    protected ResultSet rst = null;
    
    private static final String URL = "jdbc:oracle:thin:@192.168.0.81:1521:IB";
    private static final String USERNAME = "ibmain";
    private static final String PASSWORD = "A4cW9mM6WX";
    
    static {
    
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("driver registr zamani");
        }
    
    }
    
    public void getConnection(){
    
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("getConnect zamani");
        }
    
    }
    
    public void closeConnection() throws SQLException{
         try{
            if (rst!=null) 
             rst.close();
            if (psm!=null)
             psm.close();
            if (conn!=null)
             conn.close();
         }
         catch (Exception ex) {
             ex.printStackTrace();
         }
    }
    
}
