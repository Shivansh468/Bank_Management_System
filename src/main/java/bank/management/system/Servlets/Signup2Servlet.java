package bank.management.system;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Signup2Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String formno = request.getParameter("formno");
        String religion = request.getParameter("religion");
        String category = request.getParameter("category");
        String income = request.getParameter("income");
        String qualification = request.getParameter("qualification");
        String occupation = request.getParameter("occupation");
        String pan = request.getParameter("pan");
        String aadhar = request.getParameter("aadhar");
        String seniorcitizen = request.getParameter("seniorcitizen");
        String existingAccount = request.getParameter("existingaccount");

        // Validate data (for simplicity, just ensure PAN and Aadhar are not empty)
        if (pan == null || pan.trim().isEmpty()) {
            request.setAttribute("error", "PAN card number is required.");
            request.getRequestDispatcher("/signup2.jsp?formNumber=" + formno).forward(request, response);
            return;
        }

        try {
            // Database connection and query
            Conn c = new Conn();
            String query = "INSERT INTO signup2 (formno, religion, category, income, qualification, occupation, pan, aadhar, seniorcitizen, existingaccount) "
                    + "VALUES ('" + formno + "', '" + religion + "', '" + category + "', '" + income + "', '" + qualification + "', '"
                    + occupation + "', '" + pan + "', '" + aadhar + "', '" + seniorcitizen + "', '" + existingAccount + "')";
            c.s.executeUpdate(query);

            // Redirect to the next page (Signup3)
            response.sendRedirect("Signup3.jsp?formNumber=" + formno);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error occurred while saving additional details.");
            request.getRequestDispatcher("/Signup2.jsp?formNumber=" + formno).forward(request, response);
        }
    }
}
