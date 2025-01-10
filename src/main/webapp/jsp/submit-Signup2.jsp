<%@ page import="java.util.*, java.io.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // Get form data from the request
    String religion = request.getParameter("religion");
    String category = request.getParameter("category");
    String income = request.getParameter("income");
    String education = request.getParameter("education");
    String occupation = request.getParameter("occupation");
    String pan = request.getParameter("pan");
    String aadhar = request.getParameter("aadhar");
    String seniorCitizen = request.getParameter("senior_citizen");
    String existingAccount = request.getParameter("existing_account");

    // Store the data in the session to retain it for later use
    session.setAttribute("religion", religion);
    session.setAttribute("category", category);
    session.setAttribute("income", income);
    session.setAttribute("education", education);
    session.setAttribute("occupation", occupation);
    session.setAttribute("pan", pan);
    session.setAttribute("aadhar", aadhar);
    session.setAttribute("seniorCitizen", seniorCitizen);
    session.setAttribute("existingAccount", existingAccount);

    // Redirect to the next signup step or confirmation page
    response.sendRedirect("signup3.jsp");
%>
