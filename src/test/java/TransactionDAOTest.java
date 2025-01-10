package bank.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionDAOTest {

    private TransactionDAO transactionDAO;

    @BeforeEach
    public void setUp() {
        transactionDAO = new TransactionDAO();  // Create a new instance of TransactionDAO before each test
    }

    @Test
    public void testWithdraw() {
        // Test withdrawal functionality (ensure there's a user with cardnumber "1234" and enough balance)
        boolean isWithdrawn = transactionDAO.withdraw("1234", 100.00);
        assertTrue(isWithdrawn, "The withdrawal should be successful if the user has enough balance.");
    }

    @Test
    public void testDeposit() {
        // Test deposit functionality
        boolean isDeposited = transactionDAO.deposit("1234", 200.00);
        assertTrue(isDeposited, "The deposit should be successful.");
    }

    @Test
    public void testGetTransactionHistory() {
        // Test if transaction history is returned (ensure the user has at least one transaction)
        List<String> transactionHistory = transactionDAO.getTransactionHistory("1234");
        assertNotNull(transactionHistory, "The transaction history should not be null.");
        assertTrue(transactionHistory.size() > 0, "The transaction history should contain at least one transaction.");
    }
}
