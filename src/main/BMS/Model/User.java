package bank.management.system;

public class User {
    private String username;
    private String password;
    private String cardNumber;
    private String pin;

    public User(String username, String password, String cardNumber, String pin) {
        this.username = username;
        this.password = password;
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
