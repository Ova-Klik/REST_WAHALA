
class GradeBook {

    private String[][] reportTable;
    private final int students;
    private final int subjects;

    public GradeBook(int numberOfStudents, int numberOfSubjects) {

        this.students = numberOfStudents;
        this.subjects = numberOfSubjects;
        this.reportTable = new String[students][subjects + 3];
    }

    public void setScore(int studentIndex, int subjectIndex, int score) {
        reportTable[studentIndex][subjectIndex] = String.valueOf(score);
    }

    public void getCalculations() {
        calculateTotalsAndAverages();
        calculatePositions();
    }

    private void calculateTotalsAndAverages() {

        for (int row = 0; row < students; row++) {

            int total = 0;

            for (int column = 0; column < subjects; column++) {
                total += Integer.parseInt(reportTable[row][column]);
            }

            reportTable[row][subjects] = String.valueOf(total);

            double average = (double) total / subjects;
            reportTable[row][subjects + 1] = String.format("%.2f", average);
        }
    }

    private void calculatePositions() {

        for (int row = 0; row < students; row++) {

            int rank = 1;
            int total = Integer.parseInt(reportTable[row][subjects]);

            for (int compareRow = 0; compareRow < students; compareRow++) {

                int otherTotal = Integer.parseInt(reportTable[compareRow][subjects]);

                if (otherTotal > total) {
                    rank++;
                }
            }

            reportTable[row][subjects + 2] = String.valueOf(rank);
        }
    }

    public void displayReportCard() {

        System.out.println("\nSTUDENT\t\t" + getHeaders() + "TOT\tAVE\tPOS");
        System.out.println("=".repeat(75));

        for (int row = 0; row < students; row++) {

            System.out.print("Student " + (row + 1) + "\t");

            for (int column = 0; column < subjects + 3; column++) {
                System.out.print(reportTable[row][column] + "\t");
            }

            System.out.println();
        }
    }

    private String getHeaders() {

        StringBuilder subjectHead = new StringBuilder();

        for (int column = 1; column <= subjects; column++) {
            subjectHead.append("SUB").append(column).append("\t");
        }

        return subjectHead.toString();
    }

    public void displaySubjectSummaries() {

        System.out.println("\nSUBJECT SUMMARY");

        for (int column = 0; column < subjects; column++) {

            int high = -1;
            int low = 101;
            int subTotal = 0;
            int pass = 0;
            int fail = 0;

            int highestStudent = 0;
            int lowestStudent = 0;

            for (int row = 0; row < students; row++) {

                int score = Integer.parseInt(reportTable[row][column]);

                subTotal += score;

                if (score >= 50)
                    pass++;
                else
                    fail++;

                if (score > high) {
                    high = score;
                    highestStudent = row + 1;
                }

                if (score < low) {
                    low = score;
                    lowestStudent = row + 1;
                }
            }

            System.out.printf("Subject %d%n", column + 1);
            System.out.printf("Highest: Student %d scoring %d%n", highestStudent, high);
            System.out.printf("Lowest: Student %d scoring %d%n", lowestStudent, low);
            System.out.printf("Average: %.2f | Passes: %d | Fails: %d%n%n",
                    (double) subTotal / students, pass, fail);
        }
    }

    public void displayClassSummary() {

        int bestStudent = 0;
        int worstStudent = 0;

        int classSum = 0;

        int maxTotal = -1;
        int minTotal = 5000;

        for (int row = 0; row < students; row++) {

            int total = Integer.parseInt(reportTable[row][subjects]);

            classSum += total;

            if (total > maxTotal) {
                maxTotal = total;
                bestStudent = row + 1;
            }

            if (total < minTotal) {
                minTotal = total;
                worstStudent = row + 1;
            }
        }

        System.out.println("\nCLASS SUMMARY");
        System.out.printf("%nBest Graduating Student: Student %d scoring %d%n", bestStudent, maxTotal);
        System.out.printf("Worst Graduating Student: Student %d scoring %d%n", worstStudent, minTotal);
        System.out.printf("Class Total: %d | Class Average: %.2f%n", classSum , (double) classSum / students);
    }
}