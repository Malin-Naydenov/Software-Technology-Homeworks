import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String hexadecimalFormat = scanner.nextLine();
        int output = Integer.parseInt(hexadecimalFormat,16);
        System.out.println(output);
    }
}
