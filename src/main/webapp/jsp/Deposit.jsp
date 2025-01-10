<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form method="POST" action="DepositServlet">
    <input type="hidden" name="pinNumber" value="${sessionScope.pinNumber}" />
    
    <div class="form-group">
        <input type="number" class="form-control" id="depositAmount" name="depositAmount" placeholder="Enter amount" required>
    </div>
    
    <div class="btn-container">
        <button type="submit" class="btn btn-success">Deposit</button>
        <button type="button" class="btn btn-secondary" onclick="window.location.href='transactions.jsp'">Back</button>
    </div>
</form>

<c:if test="${not empty depositMessage}">
    <div class="alert alert-info mt-3">${depositMessage}</div>
</c:if>
