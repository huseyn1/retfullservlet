
package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.GetUserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BankUserType;

@WebServlet(name = "getUserTypeByID", urlPatterns = {"/getUserTypeByID"})
public class getUserTypeByID extends HttpServlet {
 
    ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        GetUserDao getUserDao =new GetUserDao();
        BankUserType bankUserType = getUserDao.getBankUserTypeByID(id);
        
        String result = objectMapper.writeValueAsString(bankUserType);
        
        out.println(result);
        
    }


}
