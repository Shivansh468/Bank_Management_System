<%@ page import="java.util.*, java.io.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // Get form data from the request
    String name = request.getParameter("name");
    String fatherName = request.getParameter("father_name");
    String dob = request.getParameter("dob");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    String city = request.getParameter("city");
    String state = request.getParameter("state");
    String pincode = request.getParameter("pincode");
    String gender = request.getParameter("gender");
    String maritalStatus = request.getParameter("marital_status");

    // Store the data in session to retain for next step (signup2.jsp)
    session.setAttribute("name", name);
    session.setAttribute("fatherName", fatherName);
    session.setAttribute("dob", dob);
    session.setAttribute("email", email);
    session.setAttribute("address", address);
    session.setAttribute("city", city);
    session.setAttribute("state", state);
    session.setAttribute("pincode", pincode);
    session.setAttribute("gender", gender);
    session.setAttribute("maritalStatus", maritalStatus);

    // Redirect to the next step in the signup process
    response.sendRedirect("signup2.jsp");
%>
