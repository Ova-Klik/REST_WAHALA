import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLogSystem {

    static Scanner input = new Scanner(System.in);
    static ArrayList<String[]> transactionHistory = new ArrayList<>();

    public static void main(String... args) {

        double accountBalance = 0;

        while (true) {

            String accountMenu = """
                                        
                                         -- Welcome to Transaction Log App --
                                         
                                           1. Deposit Money
                                           2. Withdraw Money
                                           3. Show Transaction History
                                           4. Exit the App
                                        
                    """;

            System.out.print(accountMenu);

            while (true) {
                System.out.print("Enter Operation(1-4): ");
                String menuOption = input.next();

                if (!menuOption.matches("^[1-4]$")) {
                    System.out.println("\tInvalid Option!\n");
                    continue;
                }

                int option = menuOption.charAt(0) - '0';
                input.nextLine(); 
                switch (option) {
                    case 1 -> accountBalance = deposit(accountBalance);
                    case 2 -> accountBalance = withdraw(accountBalance);
                    case 3 -> displayTransactionHistory(transactionHistory);
                    case 4 -> {
                        System.out.println("\n\tThank you for using Transaction Log App\n\n");
                        System.exit(0);
                    }
                    default -> System.out.println("\tInvalid Option!\n");
                }
                break;
            }
        }
    }

    public static double deposit(double accountBalance) {
        double amount;
        String formatExpression = "^(?!0+(\\.0+)?$)\\d+(\\.\\d{1,2})?$";
         

        while (true) {
            System.out.print("Kindly enter amount to Deposit($100 or $100.50):$");
            String amountCollected = input.nextLine();

            if (!amountCollected.matches(formatExpression)) {
                System.out.println("\tInvalid input format!\n");
                continue;
            }

            amount = Double.parseDouble(amountCollected);
            accountBalance += amount;

            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm a"));

            
            transactionHistory.add(new String[]{
                    date,
                    time,
                    "Deposit",
                    String.format("%,.2f", amount),
                    String.format("%,.2f", accountBalance)
            });

            System.out.printf("""
                            
                        \t\t--- Deposit Successful! ---
                        
                        %-15s %-15s %-15s %-15s
                        %-15s %-15s $%,-14.2f $%,.2f
                        
                        """,
                    "Date", "Time", "Amount", "Balance",
                    date, time, amount, accountBalance
            );

            while (true) {
                System.out.print("Like to make more deposit? (yes/no): ");
                String more = input.nextLine();

                if (more.equalsIgnoreCase("yes")) break;
                else if (more.equalsIgnoreCase("no")) {
                    System.out.printf("%nThank you!%n");
                    return accountBalance;
                } else System.out.printf("\tInvalid input%n");
            }
        }
    }

    public static double withdraw(double accountBalance) {
        double amount;
        String formatExpression = "^(?!0+(\\.0+)?$)\\d+(\\.\\d{1,2})?$";

       
        while (true) {
            System.out.print("Kindly enter amount to withdraw($100 or $100.50):$");
            String amountCollected = input.nextLine();

            if (!amountCollected.matches(formatExpression)) {
                System.out.println("\tInvalid input format!\n");
                continue;
            }

            amount = Double.parseDouble(amountCollected);

            if (amount > accountBalance) {
                System.out.println("\tInsufficient funds!\n");
                continue;
            }

            accountBalance -= amount;

            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm a"));

            
            transactionHistory.add(new String[]{
                    date,
                    time,
                    "Withdrawal",
                    String.format("$%,.2f", amount),
                    String.format("$%,.2f", accountBalance)
            });

            System.out.printf("""
                        
                        \t\t--- Withdrawal Successful! ---
                        
                        %-15s %-15s %-15s %-15s
                        %-15s %-15s $%,-15.2f $%,-12.2f
                        
                        """,
                    "Date", "Time", "Amount", "Balance",
                    date, time, amount, accountBalance
            );

            while (true) {
                System.out.print("Like to make more withdrawal? (yes/no): ");
                String more = input.nextLine();

                if (more.equalsIgnoreCase("yes")) continue;
                else if (more.equalsIgnoreCase("no")) {
                    System.out.printf("%nThank you!%n");
                    return accountBalance;
                } else System.out.printf("%nInvalid input%n");
            }
        }
    }

    public static void displayTransactionHistory(ArrayList<String[]> transactionHistory) {
        String ok="";
        
        final String RESET = "\u001B[0m";
        final String BLACK_TEXT = "\u001B[30m";
        final String WHITE_BG = "\u001B[47m";
        
        if (transactionHistory.isEmpty()) {
            System.out.print("\n\tNo Transactions yet!\n\n");
        } else {
            System.out.println("-".repeat(80));
            System.out.printf(WHITE_BG + BLACK_TEXT + "%-5s %-15s %-15s %-15s %-15s %s" + RESET+ "\n",
                    "s/n","Date", "Time", "Type", "Amount", "Balance");
            System.out.println("-".repeat(80));
            
            
            int index=1;
            for (String[] transaction : transactionHistory) {
                
                System.out.printf("%-5s %-15s %-15s %-15s %-15s %2s%n%n",index,
                transaction[0], transaction[1], transaction[2], transaction[3], transaction[4]);
                index++;
            }
            
        }

        System.out.print("Press Enter to return to main menu...");
        ok=input.nextLine();
    }

}

