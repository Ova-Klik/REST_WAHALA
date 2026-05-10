import java.util.Scanner;


public class CardValidator{
    public static void main (String[] args){
    String run="start";
    
    Scanner take=new Scanner(System.in);
    
    while (run=="start"){
    System.out.print("\nHello Kindly enter card number to verify:\n ");
    String number=take.nextLine();
    
    CardValidatorChecker.displayCardValidation(number);
    
        while(run=="start"){
        System.out.printf("%n Will you like to validate another card (yes/no): ");
        String more=take.nextLine();
     
            if(more.equalsIgnoreCase("yes")){
                break;
            }else if(more.equalsIgnoreCase("no")){
                  System.out.printf("%n Thank you %n%n");
                  run="stop";
                  break;
            }else{
                  System.out.printf("%n Invalid input %n%n");
                   continue;
            }
      }
      
      }
}

}






