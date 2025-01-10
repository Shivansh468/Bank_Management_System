package bank.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountDAOTest {

    private AccountDAO accountDAO;

    @BeforeEach
    public void setUp() {
        accountDAO = new AccountDAO();  // Create a new instance of AccountDAO before each test
    }

    @Test
    public void testGetBalance() {
        // Test if the balance is fetched correctly for an account
        double balance = accountDAO.getBalance("1234");  // Make sure a user with cardnumber "1234" exists
        assertNotNull(balance, "The balance should not be null.");
        assertTrue(balance >= 0, "The balance should be greater than or equal to 0.");
    }

    @Test
    public void testUpdateBalance() {
        // Test if the balance is updated correctly after a deposit or withdrawal
        double newBalance = 500.00;
        boolean isUpdated = accountDAO.updateBalance("1234", newBalance);  // Make sure user with cardnumber "1234" exists
        assertTrue(isUpdated, "The balance should be updated successfully.");
        
        // Verify the balance has been updated
        double updatedBalance = accountDAO.getBalance("1234");
        assertEquals(newBalance, updatedBalance, "The updated balance should match the new balance.");
    }
}
