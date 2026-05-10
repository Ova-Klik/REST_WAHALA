public class Main {

   public static void main(String[] args) {

      Bank bank = new Bank("GTBank");

      bank.registerCustomer("Victor", "1234", 1);

      BankService proxy = new BankProxy(bank);

      ATM atm = new ATM(proxy);

      // LOGIN FIRST (new flow)
      atm.login(1, "1234");

      // INTERACTIONS AFTER LOGIN
      atm.deposit(500, "1234");
      atm.withdraw(300, "1234");
      atm.checkBalance("1234");
   }
}