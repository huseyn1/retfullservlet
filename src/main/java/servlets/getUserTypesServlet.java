
package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.GetUserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BankUserType;

@WebServlet(name = "getUserTypesServlet", urlPatterns = {"/getUserTypes"})
public class getUserTypesServlet extends HttpServlet {
    
    ObjectMapper objectMapper = new ObjectMapper();

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        GetUserDao getUserDao =new GetUserDao();
        List<BankUserType> bankUserTypes = getUserDao.getUsers();
        
        String result = objectMapper.writeValueAsString(bankUserTypes);
        
        out.println(result);
    }
 
}
