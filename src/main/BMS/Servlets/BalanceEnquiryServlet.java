package bank.management.system;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class BalanceEnquiryServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve pinnumber from request parameters
        String pinnumber = request.getParameter("pinnumber");

        // Initialize balance variable
        int balance = 0;

        try {
            // Database connection
            Conn c = new Conn();
            
            // Query to fetch transactions
            String query = "SELECT * FROM bank WHERE pin = '" + pinnumber + "'";
            ResultSet rs = c.s.executeQuery(query);
            
            // Calculate balance based on transactions
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the balance and pinnumber as request attributes
        request.setAttribute("balance", balance);
        request.setAttribute("pinnumber", pinnumber);

        // Forward the request to the JSP page to display the result
        RequestDispatcher dispatcher = request.getRequestDispatcher("balanceEnquiry.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle the "Back" button click event
        String pinnumber = request.getParameter("pinnumber");

        // Redirect to the transactions page
        response.sendRedirect("transactions.jsp?pinnumber=" + pinnumber);
    }
}
