package Bank;

import Bank.Account.Account;
import Bank.CustomException.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private final String bankCode = "085";
    private List<Account> accounts;

    public Bank(String name) {
        if (name == null) throw new NullFieldException("Bank name cannot be null");
        if (name.isEmpty()) throw new EmptyFieldException("Bank name cannot be empty");
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public Account registerCustomer(String name, String pin) {
        String acctNumber = generateAccountNumber();
        Account account = new Account(name, acctNumber, pin);
        accounts.add(account);
        return account;
    }

    public void deposit(String acctNumber, BigDecimal amount) {
        Account account = findAccount(acctNumber);
        account.deposit(amount);
    }

    public void withdraw(String acctNumber, BigDecimal amount, String pin) {
        Account account = findAccount(acctNumber);
        account.withdraw(amount, pin);
    }

    public void transfer(String fromAcctNumber, String toAcctNumber, BigDecimal amount, String pin) {
        Account from = findAccount(fromAcctNumber);
        Account to = findAccount(toAcctNumber);
        from.withdraw(amount, pin);
        to.deposit(amount);
    }

    public BigDecimal checkBalance(String acctNumber, String pin) {
        Account account = findAccount(acctNumber);
        return account.getBalance(pin);
    }

    public void removeAccount(String acctNumber, String pin) {
        Account account = findAccount(acctNumber);
        account.getBalance(pin);                // validates pin before removal
        accounts.remove(account);
    }

    public Account findAccount(String acctNumber) {
        if (acctNumber == null) throw new NullFieldException("Account number cannot be null");
        if (acctNumber.isEmpty()) throw new EmptyFieldException("Account number cannot be empty");
        for (Account account : accounts) {
            if (account.getAcctNumber().equals(acctNumber)) return account;
        }
        throw new AccountNotFoundException("Account " + acctNumber + " not found");
    }

    private String generateAccountNumber() {
        String serialNumber = generateSerialNumber();
        String checkDigit = calculateCheckDigit(serialNumber);
        return bankCode + serialNumber + checkDigit;
    }

    private String generateSerialNumber() {
        return String.format("%06d", accounts.size() + 1);
    }

    private String calculateCheckDigit(String serialNumber) {
        int[] weights = {3, 7, 3, 3, 7, 3, 3, 7, 3};
        String combined = bankCode + serialNumber;
        int sum = 0;
        for (int index = 0; index < combined.length(); index++) {
            sum += Character.getNumericValue(combined.charAt(index)) * weights[index];
        }
        int checkDigit = (10 - (sum % 10)) % 10;
        return String.valueOf(checkDigit);
    }
}