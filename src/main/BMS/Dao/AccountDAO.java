package bank.management.system;

import java.sql.*;

public class AccountDAO {
    private Connection connection;

    public AccountDAO() {
        // Create connection to the database
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementSystem", "root", "SQL@2005");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the account balance of a user
    public double getBalance(String cardNumber) {
        String sql = "SELECT balance FROM account WHERE cardnumber = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cardNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Method to update the account balance after a transaction (deposit/withdraw)
    public boolean updateBalance(String cardNumber, double newBalance) {
        String sql = "UPDATE account SET balance = ? WHERE cardnumber = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setString(2, cardNumber);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
