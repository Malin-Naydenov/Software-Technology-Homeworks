import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.length() < 20) {
            input = padRight(input);
        } else if (input.length() > 20) {
            input = input.substring(0, 20);
        }

        System.out.println(input);
    }

    private static String padRight(String input) {
        StringBuilder sb = new StringBuilder(input);

        for (int i = input.length(); i < 20; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
