//generate random numbers for first operand
//generate random number less than the range of first number for second operand
//display  first number minus second to the user
//collect user input as answer
//if the user is correct, add 1  to correct answer counter
// but if the user is wrong, try again one more time
// if the user is right at the second try, add 1 to correct count counter
// but if the user is wrong this time, add 1 to wrong count counter
// generate another question
// do the previous actions again until ten questions is generated
// add the correct answer counter together
//add the wrong counter counter together
//display the result to the user
//display how long it took the user to answer 10 questions 


import java.util.Scanner;
import java.util.Random;
import java.time.Instant;
import java.time.Duration;


public class SimpleArithmetic{

    public static void main (String...args){

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    Instant startTime =  Instant.now();

    int correctCount = 0;
    int wrongCount = 0;
    int operand1=0;
    int operand2=0;


    System.out.println("\n\tWELCOME TO SIMPLE SUBTRACTION ARITHMETIC APP\n");

    for(int question=1; question<=10;question++){

    operand1 = 10 + rand.nextInt(10);
    operand2 = rand.nextInt(10);

    for(int trial=0; trial<2; trial++){

    System.out.printf("Question number %d: %n%d - %d = ",question, operand1, operand2);
    int answer=input.nextInt();

        if(answer==(operand1-operand2)){
            correctCount++;
            break;

        }else if(answer!=(operand1-operand2) && trial<2) continue;
        wrongCount++;
    }
    }

    Instant endTime = Instant.now();

    System.out.printf("You got %d Questions out of 10: Congratulations%n%n",correctCount);
    System.out.printf("You used %d seconds for the Quiz", Duration.between(startTime, endTime).getSeconds());
    }
}


