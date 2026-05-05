package Problem;

import java.util.ArrayList;
import java.util.List;


public class Person {
    private String name;
    private List<Problem> problems;

    public Person(String name) {
        this.name = name;
        this.problems = new ArrayList<>();
    }


    public void addProblem(Problem problem) {
        problems.add(problem);
        System.out.println("Problem added: " + problem.getName());
    }


    public void solveProblem(String problemName) {
        for (Problem problem : problems) {
            if (problem.getName().equalsIgnoreCase(problemName)) {
                problem.solve();
                System.out.println(problemName + " has been solved!");
                return;
            }
        }
        System.out.println("Problem not found: " + problemName);
    }


    public void recountUnsolvedProblems() {
        System.out.println("\n--- " + name + "'s Unsolved Problems ---");
        boolean hasUnsolved = false;

        for (Problem problem : problems) {
            if (!problem.isSolved()) {
                System.out.println(problem);
                hasUnsolved = true;
            }
        }

        if (!hasUnsolved) {
            System.out.println("No unsolved problems. Life is good!");
        }
    }

    public String getName() { return name; }
}