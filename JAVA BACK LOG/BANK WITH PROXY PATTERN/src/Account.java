import CustomException.InsufficientFundsException;
import CustomException.InvalidAmountException;
import CustomException.InvalidPinException;

class Account {
    private String name;
    private int balance;
    private String pin;
    private int number;

    public Account(String name, String pin, int number) {
        this.name = name;
        this.pin = pin;
        this.number = number;
        this.balance = 0;
    }

    private void validatePin(String inputPin) {
        if (!this.pin.equals(inputPin)) {
            throw new InvalidPinException("Invalid PIN");
        }
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(int amount, String pin) {
        validatePin(pin);

        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be positive");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        balance -= amount;
    }

    public int checkBalance(String pin) {
        validatePin(pin);
        return balance;
    }

    public int getNumber() {
        return number;
    }
}