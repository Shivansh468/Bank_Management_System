package bank.management.system;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO() {
        // Create connection to the database
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementSystem", "root", "SQL@2005");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for withdrawing money
    public boolean withdraw(String cardNumber, double amount) {
        String sql = "UPDATE account SET balance = balance - ? WHERE cardnumber = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, cardNumber);
            int rowsAffected = preparedStatement.executeUpdate();
            
            if (rowsAffected > 0) {
                recordTransaction(cardNumber, "Withdraw", amount);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method for depositing money
    public boolean deposit(String cardNumber, double amount) {
        String sql = "UPDATE account SET balance = balance + ? WHERE cardnumber = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, cardNumber);
            int rowsAffected = preparedStatement.executeUpdate();
            
            if (rowsAffected > 0) {
                recordTransaction(cardNumber, "Deposit", amount);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to record a transaction
    private void recordTransaction(String cardNumber, String transactionType, double amount) {
        String sql = "INSERT INTO transactions (cardnumber, transaction_type, amount, transaction_date) VALUES (?, ?, ?, NOW())";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cardNumber);
            preparedStatement.setString(2, transactionType);
            preparedStatement.setDouble(3, amount);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the transaction history of a user
    public List<String> getTransactionHistory(String cardNumber) {
        List<String> transactionHistory = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE cardnumber = ? ORDER BY transaction_date DESC";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cardNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                String transaction = "Type: " + resultSet.getString("transaction_type") + 
                                     ", Amount: " + resultSet.getDouble("amount") + 
                                     ", Date: " + resultSet.getTimestamp("transaction_date");
                transactionHistory.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionHistory;
    }
}
