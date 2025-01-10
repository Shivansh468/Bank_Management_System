package bank.management.system;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class TransactionsServlet extends HttpServlet {

    private TransactionService transactionService = new TransactionService();
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardNumber = request.getParameter("cardNumber");
        double amount = Double.parseDouble(request.getParameter("amount"));
        
        boolean success = transactionService.withdraw(cardNumber, amount);  // Or use deposit method
        if (success) {
            response.getWriter().write("Transaction successful.");
        } else {
            response.getWriter().write("Insufficient balance.");
        }
    
        String action = request.getParameter("action");

        // Get the pin number from session (assumes user is logged in)
        HttpSession session = request.getSession();
        String pinnumber = (String) session.getAttribute("pinnumber");

        if (pinnumber == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if pin is not found
            return;
        }

        // Handle the action based on what the user selected
        switch (action) {
            case "deposit":
                // Redirect to the deposit page (another servlet or JSP)
                response.sendRedirect("DepositServlet?pinnumber=" + pinnumber);
                break;

            case "withdraw":
                // Redirect to the withdraw page (another servlet or JSP)
                response.sendRedirect("WithdrawServlet?pinnumber=" + pinnumber);
                break;

            case "fastcash":
                // Redirect to fast cash page
                response.sendRedirect("FastCashServlet?pinnumber=" + pinnumber);
                break;

            case "ministatement":
                // Redirect to mini statement page
                response.sendRedirect("MiniStatementServlet?pinnumber=" + pinnumber);
                break;

            case "pinchange":
                // Redirect to pin change page
                response.sendRedirect("PinChangeServlet?pinnumber=" + pinnumber);
                break;

            case "checkbalance":
                // Redirect to balance enquiry page
                response.sendRedirect("BalanceEnquiryServlet?pinnumber=" + pinnumber);
                break;

            case "exit":
                // Exit action, log out the user and redirect to login
                session.invalidate();
                response.sendRedirect("login.jsp");
                break;

            default:
                // If no valid action, redirect to the transactions page
                response.sendRedirect("transactions.jsp");
                break;
        }
    }
    
}
