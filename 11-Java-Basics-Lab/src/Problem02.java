import java.util.Scanner;

public class SumTwoNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();

        double sum = firstNum + secondNum;
        System.out.println(sum);
    }
}
