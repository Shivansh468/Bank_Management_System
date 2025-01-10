package bank.management.system;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class DepositServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String depositAmountStr = request.getParameter("depositAmount");
        String pinNumber = request.getParameter("pinNumber"); // Assuming pinNumber is passed in the form

        // Initialize message variables
        String message = "";
        double depositAmount = 0;

        // Validate the deposit amount
        try {
            if (depositAmountStr != null && !depositAmountStr.isEmpty()) {
                depositAmount = Double.parseDouble(depositAmountStr);
            } else {
                message = "Please enter a valid deposit amount.";
            }
        } catch (NumberFormatException e) {
            message = "Invalid amount entered. Please enter a numeric value.";
        }

        // If the deposit amount is valid, proceed with the transaction
        if (message.isEmpty()) {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                // Connect to the database
                
                // Fetch the current balance from the database
                String balanceQuery = "SELECT balance FROM accounts WHERE pin_number = ?";
                ps = conn.prepareStatement(balanceQuery);
                ps.setString(1, pinNumber);
                rs = ps.executeQuery();

                if (rs.next()) {
                    double currentBalance = rs.getDouble("balance");

                    // Update the balance with the deposited amount
                    double newBalance = currentBalance + depositAmount;
                    String updateQuery = "UPDATE accounts SET balance = ? WHERE pin_number = ?";
                    ps = conn.prepareStatement(updateQuery);
                    ps.setDouble(1, newBalance);
                    ps.setString(2, pinNumber);

                    // Execute the update
                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        // Record the transaction
                        String transactionQuery = "INSERT INTO transactions (pin_number, date, type, amount) VALUES (?, ?, ?, ?)";
                        ps = conn.prepareStatement(transactionQuery);
                        ps.setString(1, pinNumber);
                        
                        ps.setString(3, "Deposit");
                        ps.setDouble(4, depositAmount);

                        ps.executeUpdate();

                        // Success message
                        message = "Rs " + depositAmount + " has been deposited successfully. Your new balance is Rs " + newBalance;
                    } else {
                        message = "Failed to update the balance. Please try again.";
                    }
                } else {
                    message = "Account not found. Please check your PIN.";
                }

            } catch (SQLException e) {
                e.printStackTrace();
                message = "An error occurred while processing your deposit. Please try again.";
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Set the message as a request attribute and forward to a JSP page for display
        request.setAttribute("depositMessage", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/deposit.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request, typically for loading the deposit form (if necessary)
        request.getRequestDispatcher("/deposit.jsp").forward(request, response);
    }
}
