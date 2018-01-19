import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        char thirdChar = scanner.nextLine().charAt(0);

        String result = new StringBuilder().append(firstChar).append(secondChar).append(thirdChar).reverse().toString();
        System.out.println(result);
    }
}
