import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThreeIntegersSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> nums = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int firstNum = nums.get(0);
        int secondNum = nums.get(1);
        int thirdNum = nums.get(2);

        if ((!checkNums(firstNum, secondNum, thirdNum)
                && !checkNums(firstNum, thirdNum, secondNum)
                && !checkNums(secondNum, thirdNum, firstNum))) {
            System.out.println("No");
        }
    }

    private static boolean checkNums(int firstNum, int secondNum, int sum) {
        if (firstNum + secondNum == sum) {
            if (secondNum < firstNum) {
                int temp = firstNum;
                firstNum = secondNum;
                secondNum = temp;
            }
            System.out.printf("%d + %d = %d", firstNum, secondNum, sum);
            return true;
        }
        return false;
    }
}
