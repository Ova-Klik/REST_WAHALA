import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class CheckOutAppBranch {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a"));
        
        int count=0;
        double subTotal=0; ArrayList<String> productName = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();
        ArrayList<Double> unitPrice = new ArrayList<>();
        
        double discountPercent=0;
        String cashiersName="";
        String customersName="";
        String more="";
        String run="start";
        
        System.out.printf("\t\t\n\nWELCOME TO SEMICOLON STORES \n\tMAIN BRANCH");
        
        
        
         while (run=="start") {
        System.out.println("\n\nEnter Customer's Name: ");
        String letcustomersName = input.nextLine();
        
           if(letcustomersName.matches("^[A-Za-z]+(?:[ '-][A-Za-z]+)*$")){
            customersName=letcustomersName;
            break;
        }else{
        
        System.out.println("Invalid name format!\n");
        continue;
        }
        }
        
        
        while (run=="start") {

    while (run=="start") {
    System.out.println("What did the user buy?: ");
    String letProductName=input.nextLine();
   
    
    if(letProductName.matches("^[A-Za-z]+(?:[ '-][A-Za-z]+)*$")){
            productName.add(letProductName);
            break;
        }else{
        
        System.out.println("Invalid input\n");
        continue;
        }
        }
    
    while(run=="start"){
    System.out.println("How many pieces(e.g 4)?: ");
    String letQuantity=input.next();
    input.nextLine();
        if(letQuantity.matches("^[0-9]+$")){
            int validQuantity=Integer.parseInt(letQuantity); 
            quantity.add(validQuantity);
            
            break;
        }else
        
        System.out.println("Invalid number of pieces!!!\n");
        continue;
        }
        
    
        while(run=="start"){
    System.out.println("How much per unit?(e.g 3000): ");
    String letPrice=input.nextLine();
    
        if(letPrice.matches("^(?!0+(\\.0+)?$)\\d+(\\.\\d{1,2})?$")){
            double validPrice=Double.parseDouble(letPrice); 
            
            unitPrice.add(validPrice);
            break;
        }else{
        
        System.out.println("Invalid Input!!!\n");
        continue;
        }
        }


    subTotal += unitPrice.get(count) * quantity.get(count);
    while(run=="start"){
    System.out.println("Add more item?(yes/no): ");
    more = input.nextLine();
    
    if (more.equalsIgnoreCase("yes")){
        break;
    
    }else if (more.equalsIgnoreCase("no")) {
        System.out.println("Enter Your Name: ");
        cashiersName = input.nextLine();

        System.out.println("Kindly enter discount in percentage(e.g 2)?: ");
        discountPercent = input.nextDouble();
        run="stop";
        break;
    }else{
    
        
    }
    }

    count++;
}

      
        double discount = subTotal * (discountPercent/100);
        double vat = subTotal * 0.075;
        double billTotal = subTotal - discount + vat;
        double amountPaid=0;
        
        
        
       System.out.printf(         
                                    """ 
                
                                            SEMICOLON STORES
                                            MAIN BRANCH
                                            LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
                                            TEL: 03293828343
                                            Date: %s
                                            
                                            Cashier: %s
                                            Customer's Name: %s
                                            
                                            %s
                                            %18s %8s %10s %10s
                                            %s
                                    
                                   """, time, cashiersName, customersName,
                                        "==".repeat(28),"ITEM","QTY","PRICE","TOTAL",
                                        "--".repeat(28));    
                          
                           
                                             
 for(int index=0;index<productName.size();index++){
         double productTotal=quantity.get(index) * unitPrice.get(index);
         
         System.out.printf("%28s %5d %,12.2f %,12.2f%n",
         productName.get(index), 
         quantity.get(index), 
         unitPrice.get(index),  
         productTotal
         );
                                
  }
                                
  System.out.printf(              """     
                                           %s
                                            
                                           \t\t\tSub Total:          ₦%,.2f   
                                           \t\t\tDiscount:           ₦%,.2f
                                           \t\t\tVAT @ 7.5%%:         ₦%,.2f           
                                           %s
                                           \t\t\tBill Total:         ₦%,.2f
                                                                  
                                           %s
                                           \tTHIS IS NOT A RECEIPT...KINDLY PAY   ₦%,.2f
                                           %s
                                  ""","__".repeat(28),subTotal,discount,vat,"==".repeat(28),          
                                  billTotal,"==".repeat(28), billTotal, "==".repeat(28));
                                    
        
          
 System.out.print("\n\n\nHow much did the customer give to you: ");
 
 amountPaid = input.nextDouble();
 double balance = amountPaid-billTotal;
       
                    System.out.printf(         
                                      """            
                                                SEMICOLON STORES
                                                MAIN BRANCH
                                                LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
                                                TEL: 03293828343
                                                Date: %s
                                                
                                                Cashier: %s
                                                Customer's Name: %s
                                                
                                                %s
                                                %18s %8s %10s %10s
                                                %s
                                    
                                       """, time, cashiersName, customersName,
                                        "==".repeat(28),"ITEM","QTY","PRICE","TOTAL", "--".repeat(28));        
                          
                           
                                     
for(int index=0;index<productName.size();index++){
double productTotal=quantity.get(index) * unitPrice.get(index);

    System.out.printf("%28s %5d %,12.2f %,12.2f%n",
    productName.get(index), 
    quantity.get(index), 
    unitPrice.get(index), 
    productTotal
);
                }
                    System.out.printf("""     
                                                %s
                                                            
                                                \t\t\tSub Total:          ₦%,.2f   
                                                \t\t\tDiscount:           ₦%,.2f
                                                \t\t\tVAT @ 7.5%%:         ₦%,.2f            
                                                %s
                                                \t\t\tBill Total:         ₦%.2f
                                                \t\t\tAmount Paid:        ₦%.2f
                                                \t\t\tBalance:            ₦%.2f
                                                %s
                                                \t\tTHANK YOU FOR YOUR PATRONAGE
                                                %s
                                       ""","__".repeat(28),subTotal,discount,vat,"==".repeat(28),
                                       billTotal,amountPaid,balance,"==".repeat(28),"==".repeat(28));

    }
}

