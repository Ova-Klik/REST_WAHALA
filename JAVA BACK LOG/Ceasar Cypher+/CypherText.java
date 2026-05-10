import java.util.Scanner;


public class CypherText{
    public static void main (String...args){
    
    Scanner input=new Scanner(System.in);
    int key=0;
    String  encryptedMessage="";
    String  decryptedMessage="";


while(true){    
    
    System.out.printf("""
    
                               ---Encryption System---
                               
                               1. Encrypt Message
                               2. Decrypt Message
                               
                               0. Exit
                        
                      """);
    
    System.out.print("Enter operation: ");
    String menuOption = input.next();
   
   if (!menuOption.matches("[0-3]")){
        System.out.println("     \nInvalid Option !!! \n\n");
        continue;
    }else{  
            
    int option=menuOption.charAt(0)-'0'; 
    input.nextLine();       
    switch(option){
        
        case 0-> {   System.out.println("\nThank You!!!\n");
                    System.exit(0);
                 }
    
        case 1-> {      
            System.out.print("Kindly enter the message to encrypt: ");
            String message = input.nextLine();

            System.out.print("\nKindly enter your encryption key (Single key e.g 3 or c): ");            
            char keyChar = input.next().charAt(0);

        if(Character.isDigit(keyChar)){

            key=keyChar - '0';
            for (int index = 0; index < message.length(); index++) {
            encryptedMessage+= (char)(message.charAt(index)+ key);
            }
            
        }else {
            for (int index = 0; index < message.length(); index++) {
            encryptedMessage+= (char)(message.charAt(index)+ keyChar);
            
        } 
        }

            System.out.println("\nEncrypted Message: \n\n" + encryptedMessage);

            }
            
       case 2-> {      
            System.out.print("Kindly enter the message to Decrypt: ");
            String message = input.nextLine();

            System.out.print("Kindly enter your Decryption key (Single key e.g 3 or c): ");
            char keyChar = input.next().charAt(0);

        if(Character.isDigit(keyChar)){

            key=keyChar - '0';
            for (int index = 0; index < message.length(); index++) {
            decryptedMessage+= (char)(message.charAt(index)- key);
           
            }
            
        }else {
            for (int index = 0; index < message.length(); index++) {
            decryptedMessage+= (char)(message.charAt(index)- keyChar);
            
        } 
        }

            System.out.println("\nThe actual Message: \n" + decryptedMessage);
     
            }
            
       default ->
                System.out.println("\n\t Invalid Option\n");        
            }
}
}
}
}
