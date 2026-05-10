import java.util.Scanner;
import java.util.ArrayList;

public class BookSuggestion {
    public static void main(String... args) {

        Scanner input = new Scanner(System.in);

        ArrayList<String> bookTitle = new ArrayList<>();
        ArrayList<String> numberOfPages = new ArrayList<>();
        ArrayList<String> bookAuthor = new ArrayList<>();

        bookTitle.add("The Hobbit");
        numberOfPages.add("47");
        bookAuthor.add("wisdom craig");

        bookTitle.add("The Mystery");
        numberOfPages.add("12");
        bookAuthor.add("Martin Manser");
        
        int option=0;
        int count = 0;
        String more="";
      
        mainMenu:
        while (true) {

            String bookMenu = """
                                       
                                    --Welcome To The Book Suggestion System--

                                        1. Get Suggestions
                                        2. Add Book
                                        3. Remove Book
                                        4. Update Book
                                        5. Show all books

                                        0. Exit
                    """;

            System.out.print(bookMenu);
            System.out.print("Enter operation(0-5): ");
            String bookMenuOption = input.nextLine();


            if (!bookMenuOption.matches("^[0-5]$")) {
                System.out.println("\t Invalid input\n");
                
              }else{ 
                option=Integer.parseInt(bookMenuOption);   
                if (option==0){
                    System.out.printf("%nThank you for visiting the library...%n%n");
                    break;
                
                }

            switch (option) {

                case 1 -> {  
                    String run="start";
                    while (run=="start") {

                        if (count >= bookTitle.size()) {
                                    System.out.printf("%nNo more book to suggest! \nWill you like to add book? (yes/no): ");
                                    String exitToAdd = input.nextLine();

                                    if (exitToAdd.equalsIgnoreCase("yes")) {
                                        System.out.printf("%nThank you for choosing to contribute, kindly add on main menu!!%n");
                                    } else {
                                        System.out.printf("%nThank you!!! Kindly check back later%n");
                                    }

                                    run = "stop";
                                   continue;
}

                        System.out.printf("""
                               
                                                    Book For The Day:
                                                    Book Title: %s
                                                    Pages: %s
                                                    Author: %s%n
                                          """,
                                bookTitle.get(count),
                                numberOfPages.get(count),
                                bookAuthor.get(count)
                        );
                        
                        while (run=="start"){
                        System.out.print("Would you like to get another suggestion? (yes/no): ");
                        more = input.nextLine();
                        
                        if (more.equalsIgnoreCase("yes")) {
                          count++;
                          break;
                        } else if(more.equalsIgnoreCase("no")){
                            System.out.printf("%nThank you!!! Kindly check back later%n%n");
                            run="stop";
                            
                        }else{
                            System.out.printf("%n\tInvalid input %n%n");
                            continue;
                        }
                    }
                }
                }
                case 2 -> { 
                
                    int indexMatch = -1;
                        int counter=0;
                        
                        String run="start";
                        while(run=="start"){
                            
                        System.out.print("Kindly enter the Book Title to Add: ");
                        String newBookTitle = input.nextLine();
                        
                        if (!newBookTitle.matches("^(?=.*[A-Za-z0-9])[A-Za-z0-9\\s\\-&]+$"
)){
                            System.out.println("\t Invalid input\n");
                           continue;
                            }
                       
                            
                            for(int index=0;index<bookTitle.size();index++){
                                    if(bookTitle.get(index).equalsIgnoreCase(newBookTitle)){
                                        indexMatch = index;
                                        
                                    }
                                    }
                                    
                                    if(indexMatch==-1){
                                      
                                        
                                        bookTitle.add(newBookTitle);
                                        
                                        System.out.printf("Kindly enter the number of Pages:  ");
                                        numberOfPages.add(input.nextLine());
                                        
                                        System.out.printf("Kindly enter name of Author:  ");
                                        bookAuthor.add(input.nextLine());
                                        
                                        System.out.printf("%nBook Added Successfully!%n");
                                        counter+=1;
                                        
                                        }else{
                                        
                                            System.out.print("Book already exist in Record\n\n");
                                            indexMatch=-1;
                                            
                                        }
                                        while(run=="start"){
                                        System.out.print("\nWould you like to add another book? (yes/no): ");
                                        more = input.nextLine();
                                                
                                        if (more.equalsIgnoreCase("yes")) {
                                            count++;
                                            break;
                                        } else if(more.equalsIgnoreCase("no")){
                                                    System.out.printf("%nThank you!!! Kindly check back later%n%n");
                                                    run="stop";
                                                    break;
                                        }else{
                                                System.out.printf("%n\tInvalid input %n%n");
                                                continue;
                                                }
                                            }
                                }
                       }
              
                
                
                case 3 -> {
                    String run="start";
                    while (run=="start") {
                        System.out.print("Kindly enter the Book Title to remove: ");
                        String remBookTitle = input.nextLine();

                        int indexToRemove = -1;

                               
                                for (int index = 0; index < bookTitle.size(); index++) {
                                    if (bookTitle.get(index).equalsIgnoreCase(remBookTitle)) {
                                        indexToRemove = index;
                                        break;
                                    }
                                }

                                if (indexToRemove != -1) {
                                    bookTitle.remove(indexToRemove);
                                    numberOfPages.remove(indexToRemove);
                                    bookAuthor.remove(indexToRemove);

                                    System.out.println("Book removed successfully.");
                                } else {
                            System.out.println("Book record not found.");
                        
                           }
                        while(run=="start"){
                        System.out.print("Will you like to remove more book? (yes/no): ");
                        more = input.nextLine();

                        if (more.equalsIgnoreCase("yes")) {
                            break;
                        }else if(more.equalsIgnoreCase("no")){
                            System.out.println("%nThank you");
                            run="stop";
                            break;
                        }else{
                            System.out.printf("%n\tInvalid input %n%n");
                            continue;
                        }
                } 
                }  
                }  
   

        case 4 -> {
            String run="start";
            while (run=="start") {
            System.out.print("Kindly enter the Book Title to update: ");
            String editBookTitle = input.nextLine();

            int indexToUpdate = -1;

           
            for (int index = 0; index < bookTitle.size(); index++) {
                if (bookTitle.get(index).equalsIgnoreCase(editBookTitle)) {
                    indexToUpdate = index;
                    break;
                }
            }

            if (indexToUpdate != -1) {
                System.out.print("Kindly enter the new Book Title to update: ");
                String newBookTitle = input.nextLine();
                bookTitle.set(indexToUpdate, newBookTitle);
                
                System.out.print("Kindly enter the new Number pages: ");
                String newNumberOfPages = input.nextLine();
                numberOfPages.set(indexToUpdate, newNumberOfPages);
                
                System.out.print("Kindly enter the new Name of Author ");
                String newNameOfAuthor = input.nextLine();
                bookAuthor.set(indexToUpdate, newNameOfAuthor);

                System.out.println("Book Updated successfully.");
            } else {
                System.out.println("Book record not found.");
            }
            
            while(run=="start"){
            System.out.print("Would you like to update another book? (yes/no): ");
            more = input.nextLine();
        
             if (more.equalsIgnoreCase("yes")) {
                break;
            }else if(more.equalsIgnoreCase("no")){
                System.out.println("\t\nThank you");
                run="stop";
                break;
            }else{
                 System.out.printf("%\tInvalid input %n%n");
                continue;
            }
        }   
    } 
    
     } 
    
        case 5 -> {
            if(bookTitle.isEmpty()){
            
            System.out.println("No Books available to show: ");
            
            }else {
          
             System.out.println("\n\n===== LIST OF ALL BOOKS IN LIBRARY=====");
                                
             for(int index=0; index<bookTitle.size();index++)        
             
             System.out.printf("""
                                             
                                        Book %d                
                                        Title: %s
                                        Pages: %s
                                        Author: %s
                                    
            
                               """,index+1, bookTitle.get(index), numberOfPages.get(index), bookAuthor.get(index));
            
            
            }
            
        }

                default -> System.out.println("Invalid option!");
                }
            
        }}
    }
}

