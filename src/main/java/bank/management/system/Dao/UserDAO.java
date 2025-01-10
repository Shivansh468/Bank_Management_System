package bank.management.system;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        // Create connection to the database
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementSystem", "root", "SQL@2005");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for validating login
    public boolean loginValidation(String cardNumber, String pinNumber) {
        String sql = "SELECT * FROM login WHERE cardnumber = ? AND pinnumber = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cardNumber);
            preparedStatement.setString(2, pinNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();  // Returns true if the user is found
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method for registering a new user
    public boolean registerUser(String cardNumber, String name, String username, String gender, String dob, String email, String pinNumber) {
        String sql = "INSERT INTO login (cardnumber, name, username, gender, dob, email, pinnumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cardNumber);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, dob);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, pinNumber);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;  // Returns true if the user was successfully added
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to get user details
    public ResultSet getUserDetails(String cardNumber) {
        String sql = "SELECT * FROM login WHERE cardnumber = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cardNumber);
            return preparedStatement.executeQuery();  // Returns the ResultSet with the user details
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
