
public class NumberGuesser{



    public boolean checkRandomIncludesLastNumberInRange(int[]randomNumbers ){
        
        int largestRandomNumber=10;
        
        for(int index=0; index<randomNumbers.length;index++){
            if(randomNumbers[index]==largestRandomNumber){
            
                return true;
            }
        }
            return false;
}
    
    public boolean compareGuessWithRandomNumber(int randomNumberGenerated,int guessedNumber ){
        int guessCount=0;
        
        
        while(true){
        
            if(Character.isLetter(guessedNumber)){
            
            System.out.println(" Invalid input!! Kindly guess a digit(1 to 100):");
            continue;
            
        }else if(guessedNumber<1 || guessedNumber>100){
        
             System.out.println(" You have been warned!!! Kindly guess a digit(1 to 100):");
             continue;
        }
        
        
        for(int count=1; count<=5;count++){
        
            if(randomNumberGenerated==guessedNumber){
                return true;
            }else if(randomNumberGenerated != guessedNumber){
                    
                    if(randomNumberGenerated > guessedNumber){ 
                        System.out.println("Your Guess is higher! TRY AGAIN ");
                        guessCount++;
                        continue;
                        
                    }else {
                        
                         System.out.println("Your Guess is Lower! TRY AGAIN ");
                         guessCount++;
                         continue;
                    }
            }
            
//            if(countGuess==0){
//            
//                System.out.println()
//            }
            
        }return false;
            
}
}
}
