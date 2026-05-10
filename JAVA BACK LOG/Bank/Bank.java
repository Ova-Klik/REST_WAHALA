import java.util.ArrayList;
import java.util.List;

class Bank implements BankService {
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public Account registerCustomer(String name, String pin, int number) {
        Account account = new Account(name, pin, number);
        accounts.add(account);
        return account;
    }

    private Account findAccount(int number) {
        return accounts.stream()
                .filter(acc -> acc.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public void deposit(int accountNumber, int amount) {
        findAccount(accountNumber).deposit(amount);
    }

    @Override
    public void withdraw(int accountNumber, int amount, String pin) {
        findAccount(accountNumber).withdraw(amount, pin);
    }

    @Override
    public int checkBalance(int accountNumber, String pin) {
        return findAccount(accountNumber).checkBalance(pin);
    }
}

