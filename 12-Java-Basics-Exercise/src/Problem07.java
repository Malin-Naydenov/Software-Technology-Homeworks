import java.util.Arrays;
import java.util.Scanner;

public class Problem07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        int cnt = 1;
        int bestCnt = 1;
        int bestNum = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];

            if (current == next) {
                cnt++;
                if (cnt > bestCnt) {
                    bestCnt = cnt;
                    bestNum = nums[i];
                }
            } else {
                cnt = 1;
            }
        }

        String bestNumAsStr = Integer.toString(bestNum);
        String[] result = new String[bestCnt];

        for (int i = 0; i < result.length; i++) {
            result[i] = bestNumAsStr;
        }

        System.out.println(String.join(" ",result));
    }
}
