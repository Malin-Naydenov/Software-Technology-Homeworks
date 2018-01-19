import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        String binary = Integer.toBinaryString(input);
        String hex = Integer.toHexString(input).toUpperCase();

        System.out.println(hex);
        System.out.println(binary);
    }
}
