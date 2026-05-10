

public class CardValidatorChecker {
    
    public static String checkCardType(String number) {
   
        if (number.startsWith("4")) {
            return "Visa Card";
        } else if (number.startsWith("5")) {
            return "Verve Card";
       } else if (number.startsWith("37")) {
            return "American Express Card";
      } else if (number.startsWith("6")) {
            return "Discover Card";
        } else return "false"; 
        
    }


    public static boolean checkNumberLength(String number) {
        if (number.length() >= 13 && number.length() <= 16) {
        
            return true;
      }else {
            return false;
      }  
    }
    
    public static boolean checkNumberIsDigits(String number){
    boolean numberLengthMatches=checkNumberLength(number);
    
      if (numberLengthMatches == true) {
    for (int count = 0; count < number.length(); count++) {
        if (!Character.isDigit(number.charAt(count))) {
            return false; 
        }
    }
    return true; 
  } 
   return false;
  } 
    public static boolean checkCardValidity(String number) {
        int sum = 0;
       
        for (int index = number.length() - 1; index >= 0; index--) {
            int newNumber = number.charAt(index)-'0';
            if (index%2==0) {
                newNumber *= 2;
                if (newNumber > 9) {
                    newNumber -= 9;
                }
            }
            sum += newNumber;
           
        }
        return (sum % 10 == 0);
    }

   
    public static void displayCardValidation(String number) {
        String cardHasType = checkCardType(number);
        boolean cardNumberIsDigits = checkNumberIsDigits(number);
        boolean cardIsValid = checkCardValidity(number);
        
        if (cardHasType=="false"){
            System.out.println("\n**Invalid Card Number!**\n");
        }
        else if (cardNumberIsDigits==false){
            System.out.println("\n**Invalid Card Number!**\n");
        }
        else if (cardNumberIsDigits==false && cardHasType!="false" ){
            System.out.println("\n**Invalid Card Number!**\n");
        }    
        else if (cardIsValid==false && cardHasType!="false"){
        
            System.out.printf("\n**Credit Card Type: %s%n", cardHasType);
            System.out.printf("**Credit Card Number: %s%n", number);
            System.out.printf("**Credit Card Digit Length: %d%n", number.length());
            System.out.printf("**Credit Card Validity: Invalid%n%n");
        }
        else{
            System.out.printf("\n**Credit Card Type: %s%n", cardHasType);
            System.out.printf("**Credit Card Number: %s%n", number);
            System.out.printf("**Credit Card Digit Length: %d%n", number.length());
            System.out.printf("**Credit Card Validity: Valid%n%n");
           
        }
      }
    }
    
  
