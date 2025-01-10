<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup - Page 2</title>
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
    <h2 class="text-center">Signup - Step 2</h2>

    <!-- Conditionally display an error or success message -->
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

    <!-- Form to collect additional details -->
    <form action="submit-signup2.jsp" method="POST">

        <!-- Use EL to retrieve values from session or request scope if needed -->
        <div class="form-group">
            <label for="religion">Religion:</label>
            <select id="religion" name="religion" class="form-control" required>
                <option value="" disabled selected>Select your religion</option>
                <option value="Hindu" ${param.religion == 'Hindu' ? 'selected' : ''}>Hindu</option>
                <option value="Muslim" ${param.religion == 'Muslim' ? 'selected' : ''}>Muslim</option>
                <option value="Christian" ${param.religion == 'Christian' ? 'selected' : ''}>Christian</option>
                <option value="Sikh" ${param.religion == 'Sikh' ? 'selected' : ''}>Sikh</option>
                <option value="Others" ${param.religion == 'Others' ? 'selected' : ''}>Others</option>
            </select>
        </div>

        <div class="form-group">
            <label for="category">Category:</label>
            <select id="category" name="category" class="form-control" required>
                <option value="" disabled selected>Select your category</option>
                <option value="General" ${param.category == 'General' ? 'selected' : ''}>General</option>
                <option value="OBC" ${param.category == 'OBC' ? 'selected' : ''}>OBC</option>
                <option value="SC" ${param.category == 'SC' ? 'selected' : ''}>SC</option>
                <option value="ST" ${param.category == 'ST' ? 'selected' : ''}>ST</option>
            </select>
        </div>

        <div class="form-group">
            <label for="income">Annual Income:</label>
            <select id="income" name="income" class="form-control" required>
                <option value="" disabled selected>Select your income range</option>
                <option value="Less than 2.5 Lakhs" ${param.income == 'Less than 2.5 Lakhs' ? 'selected' : ''}>Less than 2.5 Lakhs</option>
                <option value="2.5 Lakhs to 5 Lakhs" ${param.income == '2.5 Lakhs to 5 Lakhs' ? 'selected' : ''}>2.5 Lakhs to 5 Lakhs</option>
                <option value="5 Lakhs to 10 Lakhs" ${param.income == '5 Lakhs to 10 Lakhs' ? 'selected' : ''}>5 Lakhs to 10 Lakhs</option>
                <option value="More than 10 Lakhs" ${param.income == 'More than 10 Lakhs' ? 'selected' : ''}>More than 10 Lakhs</option>
            </select>
        </div>

        <div class="form-group">
            <label for="education">Educational Qualifications:</label>
            <select id="education" name="education" class="form-control" required>
                <option value="" disabled selected>Select your highest qualification</option>
                <option value="High School" ${param.education == 'High School' ? 'selected' : ''}>High School</option>
                <option value="Undergraduate" ${param.education == 'Undergraduate' ? 'selected' : ''}>Undergraduate</option>
                <option value="Postgraduate" ${param.education == 'Postgraduate' ? 'selected' : ''}>Postgraduate</option>
                <option value="Doctorate" ${param.education == 'Doctorate' ? 'selected' : ''}>Doctorate</option>
            </select>
        </div>

        <div class="form-group">
            <label for="occupation">Occupation:</label>
            <select id="occupation" name="occupation" class="form-control" required>
                <option value="" disabled selected>Select your occupation</option>
                <option value="Employed" ${param.occupation == 'Employed' ? 'selected' : ''}>Employed</option>
                <option value="Self-Employed" ${param.occupation == 'Self-Employed' ? 'selected' : ''}>Self-Employed</option>
                <option value="Student" ${param.occupation == 'Student' ? 'selected' : ''}>Student</option>
                <option value="Unemployed" ${param.occupation == 'Unemployed' ? 'selected' : ''}>Unemployed</option>
                <option value="Retired" ${param.occupation == 'Retired' ? 'selected' : ''}>Retired</option>
            </select>
        </div>

        <div class="form-group">
            <label for="pan">PAN Number:</label>
            <input type="text" id="pan" name="pan" class="form-control" placeholder="Enter PAN number" value="${param.pan}" required>
        </div>

        <div class="form-group">
            <label for="aadhar">Aadhar Number:</label>
            <input type="text" id="aadhar" name="aadhar" class="form-control" placeholder="Enter Aadhar number" value="${param.aadhar}" required>
        </div>

        <div class="form-group">
            <label>Are you a Senior Citizen?</label><br>
            <label class="radio-inline">
                <input type="radio" name="senior_citizen" value="Yes" ${param.senior_citizen == 'Yes' ? 'checked' : ''} required> Yes
            </label>
            <label class="radio-inline">
                <input type="radio" name="senior_citizen" value="No" ${param.senior_citizen == 'No' ? 'checked' : ''} required> No
            </label>
        </div>

        <div class="form-group">
            <label>Do you have an Existing Account?</label><br>
            <label class="radio-inline">
                <input type="radio" name="existing_account" value="Yes" ${param.existing_account == 'Yes' ? 'checked' : ''} required> Yes
            </label>
            <label class="radio-inline">
                <input type="radio" name="existing_account" value="No" ${param.existing_account == 'No' ? 'checked' : ''} required> No
            </label>
        </div>

        <div class="form-group text-center">
            <button type="submit" class="btn btn-primary">Next</button>
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
