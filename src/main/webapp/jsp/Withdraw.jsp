<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposit</title>
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
        }
        .btn-container {
            margin-top: 20px;
            display: flex;
            justify-content: space-between;
        }
        .btn {
            width: 48%;
        }
    </style>
</head>
<body>

<div class="container text-center">
    <h2>Deposit</h2>
    <p>Enter the amount you wish to deposit:</p>

    <!-- The form sends the deposit request to DepositServlet -->
    <form method="POST" action="DepositServlet">
        <!-- Hidden input field to send PIN number (assumed to be stored in the session) -->
        <input type="hidden" name="pinNumber" value="${sessionScope.pinNumber}" />

        <!-- Deposit amount input field -->
        <div class="form-group">
            <input type="number" class="form-control" id="depositAmount" name="depositAmount" placeholder="Enter amount" required>
        </div>

        <!-- Buttons -->
        <div class="btn-container">
            <button type="submit" class="btn btn-success">Deposit</button>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='transactions.jsp'">Back</button>
        </div>
    </form>

    <!-- Display message (if any) passed from the servlet -->
    <c:if test="${not empty depositMessage}">
        <div class="alert alert-info mt-3">${depositMessage}</div>
    </c:if>
</div>

<script>
    // Ensures only numeric input for the deposit amount field
    const depositAmount = document.getElementById('depositAmount');
    depositAmount.addEventListener('input', function () {
        this.value = this.value.replace(/[^0-9]/g, '');
    });
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
