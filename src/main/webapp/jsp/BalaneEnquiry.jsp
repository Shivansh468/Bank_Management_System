<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, java.io.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Balance Enquiry</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        .container {
            max-width: 400px;
            margin-top: 50px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .balance {
            font-size: 24px;
            font-weight: bold;
            color: #28a745;
            margin-top: 20px;
            margin-bottom: 20px;
        }
        .btn {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Balance Enquiry</h2>
    <p>Your current balance is:</p>

    <!-- Dynamically display the balance using JSTL and EL -->
    <div class="balance">
        <!-- EL to display the current balance from the session -->
        <c:choose>
            <c:when test="${not empty sessionScope.currentBalance}">
                ₹${sessionScope.currentBalance}
            </c:when>
            <c:otherwise>
                ₹50,000.00 <!-- Default balance if no value found in session -->
            </c:otherwise>
        </c:choose>
    </div>

    <!-- Back button -->
    <button class="btn btn-secondary" onclick="window.location.href='transactions.jsp'">Back</button>
</div>

<script>
    // Optional: If you'd like to add balance fetching script logic later
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
