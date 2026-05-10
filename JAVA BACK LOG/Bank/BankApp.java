package Bank;

import Bank.Account.Account;
import Bank.CustomException.*;

import javax.swing.*;
import java.math.BigDecimal;

public class BankApp {
    private static Bank bank = new Bank("Byte Bank");

    public static void main(String[] args) {
        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                    """
                   
                           BYTE BANK              
                    
                      1. Create Account           
                      2. Deposit                  
                      3. Withdraw                 
                      4. Transfer                 
                      5. Check Balance            
                      6. Remove Account           
                      7. Total Accounts           
                      8. Exit                     
                    
                    Enter choice:
                    """,
                    "Byte Bank — Main Menu",
                    JOptionPane.PLAIN_MESSAGE);

            if (choice == null || choice.trim().equals("8")) {
                JOptionPane.showMessageDialog(null,
                        "Thank you for banking with Byte Bank. Goodbye!",
                        "Bye!", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            switch (choice.trim()) {
                case "1" -> createAccount();
                case "2" -> deposit();
                case "3" -> withdraw();
                case "4" -> transfer();
                case "5" -> checkBalance();
                case "6" -> removeAccount();
                case "7" -> totalAccounts();
                default  -> showError("Invalid choice '" + choice + "'. Enter a number between 1 and 8.");
            }
        }
    }

    private static void createAccount() {
        try {
            String name = prompt("Enter your full name:", "Create Account");
            if (name == null) return;

            String pin = prompt("Create a 4-digit PIN:", "Create Account");
            if (pin == null) return;

            String confirmPin = prompt("Confirm your PIN:", "Create Account");
            if (confirmPin == null) return;

            if (!pin.equals(confirmPin)) {
                showError("PINs do not match. Please try again.");
                return;
            }

            Account account = bank.registerCustomer(name, pin);

            JOptionPane.showMessageDialog(null,
                    """
                    ✅ Account created successfully!
                    
                    Name:           %s
                    Account Number: %s
                    
                    Please save your account number safely.
                    """.formatted(name, account.getAcctNumber()),
                    "Account Created", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    private static void deposit() {
        try {
            String acctNumber = prompt("Enter account number:", "Deposit");
            if (acctNumber == null) return;

            String amountStr = prompt("Enter amount to deposit:", "Deposit");
            if (amountStr == null) return;

            BigDecimal amount = parseBigDecimal(amountStr);
            bank.deposit(acctNumber, amount);

            JOptionPane.showMessageDialog(null,
                    "✅ Deposit successful!\n\nAmount deposited: ₦" + amount,
                    "Deposit", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    private static void withdraw() {
        try {
            String acctNumber = prompt("Enter account number:", "Withdraw");
            if (acctNumber == null) return;

            String pin = promptPin("Withdraw");
            if (pin == null) return;

            String amountStr = prompt("Enter amount to withdraw:", "Withdraw");
            if (amountStr == null) return;

            BigDecimal amount = parseBigDecimal(amountStr);
            bank.withdraw(acctNumber, amount, pin);

            JOptionPane.showMessageDialog(null,
                    "✅ Withdrawal successful!\n\nAmount withdrawn: ₦" + amount,
                    "Withdraw", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    private static void transfer() {
        try {
            String fromAcct = prompt("Enter YOUR account number:", "Transfer");
            if (fromAcct == null) return;

            String pin = promptPin("Transfer");
            if (pin == null) return;

            String toAcct = prompt("Enter RECIPIENT account number:", "Transfer");
            if (toAcct == null) return;

            String amountStr = prompt("Enter amount to transfer:", "Transfer");
            if (amountStr == null) return;

            BigDecimal amount = parseBigDecimal(amountStr);
            bank.transfer(fromAcct, toAcct, amount, pin);

            JOptionPane.showMessageDialog(null,
                    """
                    ✅ Transfer successful!
                    
                    From:   %s
                    To:     %s
                    Amount: ₦%s
                    """.formatted(fromAcct, toAcct, amount),
                    "Transfer", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    private static void checkBalance() {
        try {
            String acctNumber = prompt("Enter account number:", "Check Balance");
            if (acctNumber == null) return;

            String pin = promptPin("Check Balance");
            if (pin == null) return;

            BigDecimal balance = bank.checkBalance(acctNumber, pin);

            JOptionPane.showMessageDialog(null,
                    """
                    Account Number: %s
                    
                    Available Balance: ₦%s
                    """.formatted(acctNumber, balance),
                    "Balance", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    private static void removeAccount() {
        try {
            String acctNumber = prompt("Enter account number to close:", "Remove Account");
            if (acctNumber == null) return;

            String pin = promptPin("Remove Account");
            if (pin == null) return;

            int confirm = JOptionPane.showConfirmDialog(null,
                    "⚠️ Are you sure you want to permanently close account\n" + acctNumber + "?",
                    "Confirm Account Closure", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirm != JOptionPane.YES_OPTION) return;

            bank.removeAccount(acctNumber, pin);

            JOptionPane.showMessageDialog(null,
                    "✅ Account " + acctNumber + " has been closed.",
                    "Account Removed", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    private static void totalAccounts() {
        JOptionPane.showMessageDialog(null,
                "Total registered accounts: " + bank.getNumberOfAccounts(),
                "Total Accounts", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String prompt(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    private static String promptPin(String title) {
        return JOptionPane.showInputDialog(null, "Enter your PIN:", title, JOptionPane.PLAIN_MESSAGE);
    }

    private static BigDecimal parseBigDecimal(String value) {
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid amount: '" + value + "'. Please enter a valid number.");
        }
    }

    private static void showError(String message) {
        JOptionPane.showMessageDialog(null,
                "❌ " + message,
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}