class BankProxy implements BankService {
    private Bank bank;
    private int dailyLimit = 200;
    private int withdrawnToday = 0;

    public BankProxy(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void deposit(int accNo, int amount) {
        bank.deposit(accNo, amount);
    }

    @Override
    public void withdraw(int accNo, int amount, String pin) {
        if (withdrawnToday + amount > dailyLimit) {
            throw new RuntimeException("Daily limit exceeded");
        }

        bank.withdraw(accNo, amount, pin);
        withdrawnToday += amount;
    }

    @Override
    public int checkBalance(int accNo, String pin) {
        return bank.checkBalance(accNo, pin);
    }
}