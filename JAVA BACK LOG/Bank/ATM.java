class ATM {

    private BankService bankService;
    private int currentAccount;

    public ATM(BankService bankService) {
        this.bankService = bankService;
    }

    // LOGIN SIMULATION
    public void login(int accNo, String pin) {
        System.out.println("\n=================================");
        System.out.println("🔐 Authenticating user...");

        bankService.checkBalance(accNo, pin);

        this.currentAccount = accNo;

        System.out.println("✅ Login successful!");
        System.out.println("👤 Welcome, Account Holder #" + accNo);
        System.out.println("=================================\n");

        showDashboard(pin);
    }

    // DASHBOARD
    public void showDashboard(String pin) {
        System.out.println("📊 ACCOUNT DASHBOARD");
        System.out.println("---------------------------------");
        System.out.println("Account Number: " + currentAccount);
        System.out.println("Current Balance: " + bankService.checkBalance(currentAccount, pin));
        System.out.println("---------------------------------\n");
    }

    // WITHDRAW
    public void withdraw(int amount, String pin) {
        System.out.println("💸 Processing withdrawal of ₦" + amount + "...");

        bankService.withdraw(currentAccount, amount, pin);

        System.out.println("✅ Withdrawal successful!");
        showDashboard(pin);
    }

    // DEPOSIT
    public void deposit(int amount, String pin) {
        System.out.println("💰 Processing deposit of ₦" + amount + "...");

        bankService.deposit(currentAccount, amount);

        System.out.println("✅ Deposit successful!");
        showDashboard(pin);
    }

    // CHECK BALANCE
    public void checkBalance(String pin) {
        System.out.println("📡 Fetching account balance...");

        int balance = bankService.checkBalance(currentAccount, pin);

        System.out.println("💳 Available Balance: ₦" + balance);
        System.out.println("---------------------------------\n");
    }
}