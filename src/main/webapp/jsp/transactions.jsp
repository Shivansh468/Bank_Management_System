<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ATM Transactions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .grid-buttons {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 15px;
        }
        .grid-buttons .btn {
            font-size: 16px;
            padding: 15px;
        }
        .exit-btn {
            margin-top: 30px;
            font-size: 18px;
            background-color: #dc3545;
            border: none;
            color: #fff;
        }
        .exit-btn:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>

<div class="container text-center">
    <h2 class="mb-4">ATM Transactions</h2>
    
    <!-- Display user info if logged in -->
    <c:if test="${not empty sessionScope.username}">
        <p>Welcome, ${sessionScope.username}!</p>
    </c:if>

    <!-- If no user is logged in, display a message -->
    <c:if test="${empty sessionScope.username}">
        <p>Please log in to access the ATM transactions.</p>
    </c:if>

    <p>Select an option below:</p>

    <!-- ATM transaction options -->
    <div class="grid-buttons">
        <button class="btn btn-warning" onclick="window.location.href='Deposit.jsp'">Deposit</button>
        <button class="btn btn-danger" onclick="window.location.href='Withdraw.jsp'">Withdrawal</button>
        <button class="btn btn-success" onclick="window.location.href='FastCash.jsp'">Fast Cash</button>
        <button class="btn btn-primary" onclick="window.location.href='MiniStatement.jsp'">Mini Statement</button>
        <button class="btn btn-secondary" onclick="window.location.href='BalanceEnquiry.jsp'">Balance Enquiry</button>
        <button class="btn btn-info" onclick="window.location.href='PinChange.jsp'">Pin Change</button>
    </div>

    <button class="btn exit-btn btn-block" onclick="exitProgram()">Exit</button>
</div>

<script>
    function exitProgram() {
        if (confirm("Are you sure you want to exit?")) {
            window.open('', '_self').close(); // Attempt to close the current tab
            alert("Please close the tab manually if it doesn't close.");
        }
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
