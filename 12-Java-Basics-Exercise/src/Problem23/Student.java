package Problem23;

public class Student {
    private String name;
    private double[] grades;
    private double averageGrade;

    public String getName() {
        return name;
    }

    public double[] getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public Student(String name, double[] grades, double averageGrade) {

        this.name = name;
        this.grades = grades;
        this.averageGrade = averageGrade;
    }
}
