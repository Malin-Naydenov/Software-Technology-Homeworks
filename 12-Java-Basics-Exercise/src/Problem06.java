import java.util.Arrays;
import java.util.Scanner;

public class Problem06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String first = String.join("", firstInput);

        String[] secondInput = scanner.nextLine().split(" ");
        String second = String.join("", secondInput);

        int count = Math.min(first.length(), second.length());
        boolean hasFinished = false;

        for (int i = 0; i < count; i++) {
            if (first.charAt(i) < second.charAt(i)) {
                System.out.println(first);
                System.out.println(second);
                hasFinished = true;
                break;
            } else if (second.charAt(i) < first.charAt(i)) {
                System.out.println(second);
                System.out.println(first);
                hasFinished = true;
                break;
            }
        }

        if (!hasFinished) {
            if (first.length() == count) {
                System.out.println(first);
                System.out.println(second);
            } else {
                System.out.println(second);
                System.out.println(first);
            }
        }
    }
}
