import java.util.Arrays;
import java.util.Scanner;

public class Problem08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        int cnt = 1;
        int bestCnt = 1;
        int index = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i];
            int next = nums[i + 1];

            if (next > curr) {
                cnt++;
                if (cnt > bestCnt) {
                    bestCnt = cnt;
                    index = i + 1;
                }
            } else {
                cnt = 1;
            }
        }

        index = index - bestCnt+1;
        String[] result = new String[bestCnt];

        for (int i = 0; i < bestCnt; i++) {
            String numAsStr = Integer.toString(nums[index]);
            result[i] = numAsStr;
            index++;
        }

        System.out.println(String.join(" ", result));
    }
}
