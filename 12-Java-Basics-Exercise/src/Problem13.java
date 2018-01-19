import java.util.Scanner;

public class Problem13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();

        String result = "";
        for (int i = input.length - 1; i >= 0; i--) {
            result += Character.toString(input[i]);
        }
        System.out.println(result);
    }
}
