package bank.management.system;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardnumber = request.getParameter("cardnumber");
        String pinnumber = request.getParameter("pinnumber");
        
        
        Conn conn = new Conn();
        String query = "SELECT * FROM login WHERE cardnumber = ? AND pinnumber = ?";
        try {
            PreparedStatement pstmt = (PreparedStatement) conn.s.executeQuery(query);
            pstmt.setString(1, cardnumber);
            pstmt.setString(2, pinnumber);
            ResultSet rs = pstmt.executeQuery();

            
            if (rs.next()) {
                
                response.sendRedirect("transactions.jsp?pinnumber=" + pinnumber);
            } else {
                
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h3 style='color: red;'>Incorrect card number or PIN</h3>");
                out.println("<a href='login.html'>Go back to login</a>");
                out.println("</body></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred");
        }
    }
}
