import java.util.Scanner;

public class CeasarCypher {

    public static void main(String... args) {

        Scanner input = new Scanner(System.in);
        MyMethods myByte = new MyMethods();
        
        int key;
        String newMessage;
        String run="start";
        while (run=="start") {

            System.out.printf("""
            
                               ---Encryption System---
                               
                               1. Encrypt Message
                               2. Decrypt Message
                               0. Exit
                        
                      """);

            System.out.print("Enter operation(0-2): ");
            String menuOption = input.next();

            if (!menuOption.matches("^[0-2]$")) {
                System.out.println("\nInvalid Option !!!\n");
                continue;
            }
            
          

            int option = myByte.stringToInteger(menuOption);
            input.nextLine(); 
            
            if(option==0){
             System.out.println("\nThank You!!!\n");
             System.exit(0);
            
            }
            
            System.out.print("Enter your message: ");
            String message = input.nextLine();

            System.out.print("Enter your key (digit 0-9 or letter a-z): ");
            char keyChar = input.next().charAt(0);
            
            switch (option) {
              
                case 1 -> { 

                    key = convertKey(keyChar); 

                    newMessage = encrypt(message, key);
                    System.out.printf("%nour Encrypted Message: %s%n",newMessage);
                    input.nextLine(); 
                }

                case 2 -> { 

                    key = convertKey(keyChar); 

                    newMessage = decrypt(message, key);
                    System.out.printf("%nYour Decrypted Message: %s%n",newMessage);
                    input.nextLine(); 
                }

                default -> System.out.println("\n\tInvalid Option !!!\n");
            }
        }
    }

    
    public static int convertKey(char keyChar) {
        int key = 0;
      
        if (Character.isDigit(keyChar)) {
            key = keyChar - '0';
        } else if (Character.isLetter(keyChar)) {
            key = Character.toUpperCase(keyChar) - 'A';
            key+=1;
        } else {
            System.out.println("Invalid key! Using key = 0.");
            key = 0;
        }

        return key;
    }


    public static String encrypt(String message, int key) {
        String newMessage = "";

        for (int index = 0; index < message.length(); index++) {
            char newcharacter = message.charAt(index);

            if (Character.isUpperCase(newcharacter)) {
                newMessage += (char) ('A' + (newcharacter - 'A' + key) % 26);
            } else if (Character.isLowerCase(newcharacter)) {
                newMessage += (char) ('a' + (newcharacter - 'a' + key) % 26);
            } else {
                newMessage += newcharacter;
            }
        }
        return newMessage;
    }

    
    public static String decrypt(String message, int key) {
        String newMessage = "";

        for (int index = 0; index < message.length(); index++) {
            char newcharacter = message.charAt(index);

            if (Character.isUpperCase(newcharacter)) {
                newMessage += (char) ('A' + (newcharacter - 'A' - key + 26) % 26);
            } else if (Character.isLowerCase(newcharacter)) {
                newMessage += (char) ('a' + (newcharacter - 'a' - key + 26) % 26);
            } else {
                newMessage += newcharacter; 
            }
        }
        return newMessage;
    }
}

