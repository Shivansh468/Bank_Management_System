<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup - Page 3</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center">Signup - Step 3</h2>

    <!-- Display error or success messages -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">
            ${errorMessage}
        </div>
    </c:if>
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success">
            ${successMessage}
        </div>
    </c:if>

    <!-- Form for account details -->
    <form action="submit-signup3.jsp" method="POST">
        <div class="form-group">
            <label>Account Type:</label><br>
            <label class="radio-inline">
                <input type="radio" name="account_type" value="Savings Account" ${param.account_type == 'Savings Account' ? 'checked' : ''} required> Savings Account
            </label>
            <label class="radio-inline">
                <input type="radio" name="account_type" value="Fixed Deposit" ${param.account_type == 'Fixed Deposit' ? 'checked' : ''} required> Fixed Deposit
            </label>
            <label class="radio-inline">
                <input type="radio" name="account_type" value="Salary Account" ${param.account_type == 'Salary Account' ? 'checked' : ''} required> Salary Account
            </label>
            <label class="radio-inline">
                <input type="radio" name="account_type" value="Current Account" ${param.account_type == 'Current Account' ? 'checked' : ''} required> Current Account
            </label>
        </div>

        <div class="form-group">
            <label for="card_number">Card Number:</label>
            <input type="text" id="card_number" name="card_number" class="form-control" placeholder="XXXX-XXXX-XXXX-2005" value="${param.card_number}" required>
        </div>

        <div class="form-group">
            <label for="pin">PIN:</label>
            <input type="password" id="pin" name="pin" class="form-control" placeholder="XXXX" value="${param.pin}" required>
        </div>

        <div class="form-group">
            <label>Services Required:</label><br>
            <label class="checkbox-inline">
                <input type="checkbox" name="services" value="ATM Card" ${param.services != null && param.services.contains('ATM Card') ? 'checked' : ''}> ATM Card
            </label>
            <label class="checkbox-inline">
                <input type="checkbox" name="services" value="Emails & SMS Alerts" ${param.services != null && param.services.contains('Emails & SMS Alerts') ? 'checked' : ''}> Emails & SMS Alerts
            </label>
            <label class="checkbox-inline">
                <input type="checkbox" name="services" value="Mobile Banking" ${param.services != null && param.services.contains('Mobile Banking') ? 'checked' : ''}> Mobile Banking
            </label>
            <label class="checkbox-inline">
                <input type="checkbox" name="services" value="Internet Banking" ${param.services != null && param.services.contains('Internet Banking') ? 'checked' : ''}> Internet Banking
            </label>
            <label class="checkbox-inline">
                <input type="checkbox" name="services" value="Check Book" ${param.services != null && param.services.contains('Check Book') ? 'checked' : ''}> Check Book
            </label>
            <label class="checkbox-inline">
                <input type="checkbox" name="services" value="E-Statement" ${param.services != null && param.services.contains('E-Statement') ? 'checked' : ''}> E-Statement
            </label>
        </div>

        <div class="form-group text-center">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='/cancel-signup'">Cancel</button>
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
