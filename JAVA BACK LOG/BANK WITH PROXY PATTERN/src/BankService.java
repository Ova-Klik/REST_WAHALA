interface BankService {

    void deposit(int accNo, int amount);
    void withdraw(int accNo, int amount, String pin);
    int checkBalance(int accNo, String pin);
}