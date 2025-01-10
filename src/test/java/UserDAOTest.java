package bank.management.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    public void setUp() {
        userDAO = new UserDAO();  // Create a new instance of UserDAO before each test
    }

    @Test
    public void testLoginValidationValidUser() {
        // Assuming there's a user with cardnumber "1234" and pin "1234" in the database
        boolean isValid = userDAO.loginValidation("1234", "1234");
        assertTrue(isValid, "The login validation should return true for valid user credentials.");
    }

    @Test
    public void testLoginValidationInvalidUser() {
        // Testing with invalid credentials
        boolean isValid = userDAO.loginValidation("1234", "wrongPin");
        assertFalse(isValid, "The login validation should return false for invalid user credentials.");
    }

    @Test
    public void testRegisterUser() {
        // Test registering a new user
        boolean isRegistered = userDAO.registerUser("5678", "John Doe", "johndoe", "Male", "1990-05-15", "john@example.com", "4321");
        assertTrue(isRegistered, "The user should be successfully registered.");
    }

    @Test
    public void testGetUserDetails() {
        // Test getting user details (ensure this card number exists in the database)
        ResultSet resultSet = userDAO.getUserDetails("1234");
        try {
            assertTrue(resultSet.next(), "The user should exist in the database.");
            assertEquals("John Doe", resultSet.getString("name"), "The name should match the registered user's name.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
