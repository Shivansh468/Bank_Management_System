package bank.management.system;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class WithdrawServlet extends HttpServlet {

    // Handle the POST request to process withdrawal
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the pin number and withdrawal amount from the request
        String pinNumber = request.getParameter("pinNumber");
        String withdrawAmount = request.getParameter("withdrawAmount");

        
        
        // If withdrawal amount is empty or invalid, set error message
        if (withdrawAmount == null || withdrawAmount.isEmpty()) {
            request.setAttribute("withdrawMessage", "Please enter a valid amount to withdraw.");
            // Forward the request back to the withdraw.jsp page with the error message
            request.getRequestDispatcher("withdraw.jsp").forward(request, response);
            return;
        }

        try {
            // Establish connection with the database
            Conn conn = new Conn();
            
            // Create a query to insert the transaction (Withdrawal) into the bank table
            String query = "INSERT INTO bank (pin, date, transaction_type, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.getQuery(query);
            stmt.setString(1, pinNumber);
            
            stmt.setString(3, "Withdrawal");
            stmt.setString(4, withdrawAmount);
            
            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // If the transaction was successfully inserted, send success message
            if (rowsAffected > 0) {
                request.setAttribute("withdrawMessage", "₹" + withdrawAmount + " successfully withdrawn from your account.");
            } else {
                request.setAttribute("withdrawMessage", "An error occurred while processing your withdrawal.");
            }

            // Forward the request back to the withdrawal page
            request.getRequestDispatcher("withdraw.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            // Set error message in case of exception
            request.setAttribute("withdrawMessage", "An error occurred while processing the withdrawal.");
            // Forward to withdraw.jsp with the error message
            request.getRequestDispatcher("withdraw.jsp").forward(request, response);
        }
    }

    // Handle the GET request (to show the withdrawal page initially)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // For GET requests, just show the withdrawal page without any processing
        request.getRequestDispatcher("withdraw.jsp").forward(request, response);
    }
}
