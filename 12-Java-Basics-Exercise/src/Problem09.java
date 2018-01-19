import java.util.Arrays;
import java.util.Scanner;

public class Problem09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        int bestCnt = 1;
        int bestNum = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            int cnt = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    cnt++;
                }
            }
            if (cnt > bestCnt) {
                bestCnt = cnt;
                bestNum = nums[i];
            }
        }

        System.out.println(bestNum);
    }
}
