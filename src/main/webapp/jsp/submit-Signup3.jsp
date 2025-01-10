<%@ page import="java.util.*, java.io.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // Get the form data from the request
    String accountType = request.getParameter("account_type");
    String cardNumber = request.getParameter("card_number");
    String pin = request.getParameter("pin");
    String[] services = request.getParameterValues("services");

    // Store the data in session (to retain for any subsequent steps)
    session.setAttribute("accountType", accountType);
    session.setAttribute("cardNumber", cardNumber);
    session.setAttribute("pin", pin);
    session.setAttribute("services", services);

    // You can process the data here, e.g., save to a database or send it to an email.

    // Redirect to a confirmation page or final step
    response.sendRedirect("confirmation.jsp");
%>
