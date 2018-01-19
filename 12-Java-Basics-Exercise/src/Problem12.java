import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> nums = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int specialNumber = tokens[0];
        int bombPower = tokens[1];

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == specialNumber) {
                int leftTimes = Math.min(bombPower, i);
                int rightTimes = Math.min(bombPower, nums.size() - i - 1);

                nums.subList(i - leftTimes, i + rightTimes + 1).clear();
                i = 0;
            }
        }

        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
