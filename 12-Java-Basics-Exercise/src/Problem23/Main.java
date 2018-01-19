package Problem23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = Integer.parseInt(scanner.nextLine());

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= studentCount; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            String studentName = tokens[0];
            double[] studentGrades = Arrays.stream(tokens).skip(1).mapToDouble(Double::parseDouble).toArray();
            double averageGrade = getAverageGrade(studentGrades);

            Student student = new Student(studentName, studentGrades, averageGrade);
            students.add(student);
        }

        students.stream()
                .filter(s -> s.getAverageGrade() >= 5.00)
                .sorted((a, b) -> {
                    int result = a.getName().compareTo(b.getName());

                    if (result == 0) {
                        result = Double.compare(b.getAverageGrade(), a.getAverageGrade());
                    }

                    return result;
                })
                .forEach(s -> {
                    System.out.printf("%s -> %.2f%n", s.getName(), s.getAverageGrade());
                });
    }

    private static double getAverageGrade(double[] studentGrades) {
        double averageGrade = 0.0;

        for (int i = 0; i < studentGrades.length; i++) {
            averageGrade += studentGrades[i];
        }

        averageGrade /= studentGrades.length;
        return averageGrade;
    }
}
