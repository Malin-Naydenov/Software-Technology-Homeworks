import java.util.*;
import java.util.stream.Collectors;

public class LargestThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> nums = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int count = Math.min(nums.size(), 3);
        for (int i = 0; i < count; i++) {
            System.out.println(nums.get(i));
        }
    }
}
