package Problem;

public class ProblemMain {
    public static void main(String[] args) {


        Person john = new Person("John");


        Problem rentProblem   = new Problem("Rent is due", ProblemType.FINANCIAL);
        Problem jambProblem   = new Problem("JAMB Exam", ProblemType.EDUCATION);
        Problem marriageProblem = new Problem("Marriage", ProblemType.SPIRITUAL);
        Problem capitalProblem  = new Problem("Need Capital", ProblemType.BUSINESS);


        rentProblem.setDescription("Rent is due next month");
        jambProblem.setDescription("Need to pass JAMB");


        john.addProblem(rentProblem);
        john.addProblem(jambProblem);
        john.addProblem(marriageProblem);
        john.addProblem(capitalProblem);


        john.solveProblem("JAMB Exam");


        john.recountUnsolvedProblems();
    }
}