
package dao;

import java.util.List;
import model.BankUserType;

public interface DaoMethods {
    public List<BankUserType> getUsers();
    public BankUserType getBankUserTypeByID(int id);
}
