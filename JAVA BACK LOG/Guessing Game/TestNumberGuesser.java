import java.util.Random;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNumberGuesser{

    NumberGuesser guess;
    Random  rand = new Random();

    @BeforeEach
    void setUp(){
        
        guess = new NumberGuesser();
       
    }
    
    @Test
    public void testThatRandomNumberBetween1and10Includes10(){
        
        int []randomNumbers = {1,2,3,4,5,6,7,8,9,10};
        
        boolean result = guess.checkRandomIncludesLastNumberInRange(randomNumbers);
        boolean expected=true;
        
        assertEquals(result,expected);
    }
    
    @Test
    public void testThatGuessIsCorrect(){
        
        int guessedNumber=3;
        int randomNumberGenerated=3;
        
        boolean result = guess.compareGuessWithRandomNumber(randomNumberGenerated,guessedNumber);
        boolean expected=true;
        
        assertEquals(result,expected);
    }
    
    
    @Test
    public void testThatGuessIsWrong(){
        
        int guessedNumber=7;
        int randomNumberGenerated = 5;
        
        boolean result = guess.compareGuessWithRandomNumber(randomNumberGenerated,guessedNumber);
        boolean expected=false;
        
        assertEquals(result,expected);
    }
    
    @Test
    public void testThatGuessedIsNumberIsAboveGeneratedRange(){
        
        
        int guessedNumber=13;
        int randomNumberGenerated = 7;
        
        boolean result = guess.compareGuessWithRandomNumber(randomNumberGenerated,guessedNumber);
        boolean expected=false;
        
        assertEquals(result,expected);
    }
    
   
}
