
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BankUserType;

public class GetUserDao extends OracleDao implements DaoMethods {

    @Override
    public  List<BankUserType> getUsers() {
        List<BankUserType> bankUserTypes = new ArrayList<>();
        try {
            
            String sql = "select id,name from bank_user_types"; 
            getConnection();
            
            psm = conn.prepareStatement(sql);
            rst = psm.executeQuery();
            while(rst.next()){
               BankUserType bankUserType = new BankUserType(rst.getInt("id"), rst.getString("name"));
               bankUserTypes.add(bankUserType); 
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
           return null;
        } finally {
            try {
                closeConnection();
             } catch (SQLException ex) {
                ex.printStackTrace();
               }
        }
        return bankUserTypes;
        
    }

    @Override
    public BankUserType getBankUserTypeByID(int id) {
        BankUserType bankUserType = null;
        try {
            String sql = "select id,name from bank_user_types where id = ? ";
            getConnection();
            
            psm = conn.prepareStatement(sql);
            psm.setInt(1, id);
            rst = psm.executeQuery();
            while(rst.next()){
               bankUserType = new BankUserType(rst.getInt("id"), rst.getString("name"));
            }
           
   
        } catch (SQLException ex) {
            Logger.getLogger(GetUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return bankUserType;
    }
    
}
