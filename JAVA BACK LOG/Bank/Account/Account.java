package Bank.Account;

import CustomException.*;

import java.math.BigDecimal;

public class Account {
    private String name;
    private final String pin;
    private BigDecimal balance;

    public Account(String name, String pin) {
        if (pin == null || name == null) throw new NullFieldException("Fields cannot be null");
        checkEmptyField(name);
        checkEmptyField(pin);
        this.pin = pin;
        this.name = name;
        this.balance = BigDecimal.ZERO;
    }

    public BigDecimal getBalance(String pin) {
        checkInvalidPin(pin);
        return balance;
    }

    public void deposit(BigDecimal amount) {
        checkNullAmount(amount);
        checkInvalidAmount(amount);
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount, String pin) {
        checkInvalidPin(pin);
        checkNullAmount(amount);
        checkInvalidAmount(amount);
        checkInsufficientFunds(amount);
        balance = balance.subtract(amount);
    }

    private void checkInvalidPin(String pin) {
        if (!this.pin.equals(pin)) throw new InvalidPinException("Invalid pin");
    }

    private void checkEmptyField(String field) {
        if (field.isEmpty()) throw new EmptyFieldException("Fields cannot be empty");
    }

    private void checkNullAmount(BigDecimal amount) {
        if (amount == null) throw new NullFieldException("Amount cannot be null");
    }

    private void checkInvalidAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) throw new InvalidAmountException("Amount cannot be negative");
    }

    private void checkInsufficientFunds(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) throw new InsufficientFundException("Insufficient funds");
    }
}