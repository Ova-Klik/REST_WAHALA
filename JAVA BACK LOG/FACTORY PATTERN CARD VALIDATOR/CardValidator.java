import java.util.Scanner;

public class CardValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String run = "start";

        while (run.equals("start")) {
            System.out.print("\nEnter card number to verify: ");
            String number = input.nextLine();

            if (!CardUtils.checkCardIsDigits(number)) {
                System.out.println("Invalid input! Not digits.");
                continue;
            }

            Card card = CardFactory.getCard(number);

            System.out.println("\n**Card Type: " + card.getType());
            System.out.println("**Card Number: " + number);
            System.out.println("**Digit Length: " + number.length());
            System.out.println("**Card Validity: " + (card.checkValidity(number) ? "Valid" : "Invalid"));

            System.out.print("\nValidate another card? (yes/no): ");
            String more = input.nextLine();

            if (more.equalsIgnoreCase("no")) {
                System.out.println("Thank you!");
                run = "stop";
            }
        }
    }
}

