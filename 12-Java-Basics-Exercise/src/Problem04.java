import java.util.Scanner;

public class Problem04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input = scanner.nextLine().charAt(0);

        if (input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u') {
            System.out.println("vowel");
        } else if (Character.isDigit(input)) {
            System.out.println("digit");
        } else {
            System.out.println("other");
        }
    }
}
