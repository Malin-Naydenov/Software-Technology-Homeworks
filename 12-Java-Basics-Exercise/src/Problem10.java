import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append((char) ('a' + i));
        }

        char[] input = scanner.nextLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            char currChar = input[i];
            int index = sb.indexOf(String.valueOf(currChar));

            System.out.printf("%c -> %d%n", currChar, index);
        }
    }
}
