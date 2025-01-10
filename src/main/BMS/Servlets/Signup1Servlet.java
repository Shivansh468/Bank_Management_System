package bank.management.system;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Signup1Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String name = request.getParameter("name");
        String fatherName = request.getParameter("father_name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String marital = request.getParameter("marital");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String pin = request.getParameter("pin");

        Random rand = new Random();
        long formNumber = Math.abs((rand.nextLong() % 900L) + 1000L);

        HttpSession session = request.getSession();
        session.setAttribute("formNumber", formNumber);

        
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("error", "Name is required.");
            request.getRequestDispatcher("/signup1.jsp").forward(request, response);
            return;
        }

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signup (formno, name, father_name, gender, dob, email, marital_status, address, city, state, pin) "
                    + "VALUES ('" + formNumber + "', '" + name + "', '" + fatherName + "', '" + gender + "', '" + dob + "', '" + email + "', '"
                    + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
            c.s.executeUpdate(query);
            response.sendRedirect("Signup2.jsp?formNumber=" + formNumber);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error occurred while saving data.");
            request.getRequestDispatcher("/Signup1.jsp").forward(request, response);
        }
    }
}
