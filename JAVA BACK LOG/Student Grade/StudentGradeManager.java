
import java.util.Scanner;


public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many students do you have? ");
        int numStudents = input.nextInt();
        System.out.print("How many subjects do they offer? ");
        int numSubjects = input.nextInt();


        GradeBook myGradeBook = new GradeBook(numStudents, numSubjects);



        for (int student = 0; student < numStudents; student++) {
            System.out.println("Entering score for student " + (student + 1));
            for (int subject = 0; subject < numSubjects; subject++) {
                int score;
                while (true) {
                    System.out.print("Enter score for subject " + (subject + 1) + ": ");
                    score = input.nextInt();
                    if (score >= 0 && score <= 100) break;
                    System.out.println("Invalid: Score must be 0-100.");
                }
                myGradeBook.setScore(student, subject, score);
            }
        }

        myGradeBook.getCalculations();
        myGradeBook.displayReportCard();
        myGradeBook.displaySubjectSummaries();
        myGradeBook.displayClassSummary();
    }
}