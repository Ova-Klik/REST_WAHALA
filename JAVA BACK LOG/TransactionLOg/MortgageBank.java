import java.util.Scanner; 


public class MortgageBank{

    public static void main (String...args){
    
    Scanner take=new Scanner(System.in);
    double principal=0.0;
    double annualInterestRate=0.0;
    double duration=0.0;
    
    while(true){ 
         while(true){ 
                System.out.print("Enter the principal amount: ");
                String letPrincipal=take.nextLine();
                
                    if(letPrincipal.matches("^(?!0+(\\.0+)?$)\\d+(\\.\\d{1,2})?$")){
                            principal=Double.parseDouble(letPrincipal); 
                            break;
                        }else{
                        
                        System.out.println("Invalid Input!!!\n");
                        continue;
                        }
                        }

    while(true){ 
        System.out.print("Enter the annual interest rate: ");
        String letRate=take.nextLine();
            if(letRate.matches("^(?!0+(\\.0+)?$)\\d+(\\.\\d{1,2})?$")){
                    annualInterestRate=Double.parseDouble(letRate); 
                    break;
                }else{
                
                System.out.println("Invalid Input!!!\n");
                continue;
                }
                }
    while(true){
        System.out.print("Enter duration: ");
        String letduration=take.nextLine();
        
            if(letduration.matches("^(?!0+(\\.0+)?$)\\d+(\\.\\d{1,2})?$")){
                            duration=Double.parseDouble(letduration); 
                            break;
                        }else{
                        
                        System.out.println("Invalid Input!!!\n");
                        continue;
                        }
                        }
    
    CalculatePayment(principal, annualInterestRate,duration);
    
    System.out.printf("%n Will you like to make other calculations? (yes/no): ");
    String more=take.nextLine();
    
        if(more.equalsIgnoreCase("yes")){
                continue;
            }else{
                  System.out.printf("%n Thank you %n%n");
                break;
            }
        }
    }
    
    
    public static void CalculatePayment (double principal, double annualInterestRate, double duration){
        
        duration=duration*12;
        double monthlyInterestRate=(annualInterestRate/100)/12;
        double monthlyPayment= principal * (monthlyInterestRate*(Math.pow(1 + monthlyInterestRate,duration)))/(Math.pow(1 + monthlyInterestRate,duration)-1);
        System.out.printf("Your monthly payment is: $%,.2f %n%n", monthlyPayment);
    
    }
}
