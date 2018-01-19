import java.util.Arrays;
import java.util.Scanner;

public class Problem11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean hasSatisfied = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums.length == 1) {
                System.out.println("0");
                hasSatisfied = true;
                break;
            }

            int leftSum = 0;
            int rightSum = 0;

            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum = getLeftSum(nums, i);
            }

            if (i == nums.length - 1) {
                rightSum = 0;
            } else {
                rightSum = getRightSum(nums, i + 1);
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                hasSatisfied = true;
                break;
            }
        }

        if (!hasSatisfied){
            System.out.println("no");
        }
    }

    private static int getRightSum(int[] nums, int index) {
        int sum = 0;
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private static int getLeftSum(int[] nums, int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
