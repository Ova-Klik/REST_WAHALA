package Problem;

public class Problem {
    private String name;
    private String description;
    private ProblemType type;
    private boolean isSolved;


    public Problem(String name, ProblemType type) {
        this.name = name;
        this.type = type;
        this.description = "";
        this.isSolved = false;
    }


    public String getName()        { return name; }
    public ProblemType getType()   { return type; }
    public String getDescription() { return description; }
    public boolean isSolved()      { return isSolved; }


    public void setDescription(String description) { this.description = description; }


    public void solve() {
        this.isSolved = true;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + name + " | Solved: " + isSolved;
    }
}