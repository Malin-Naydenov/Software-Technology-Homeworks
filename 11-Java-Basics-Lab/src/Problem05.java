import java.util.ArrayList;
import java.util.Scanner;

public class SymetricNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<String> palindromes = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            String currNumb = Integer.toString(i);

            boolean isPalindrome = true;
            for (int j = 0; j <= currNumb.length() / 2; j++) {
                if (currNumb.charAt(j) != currNumb.charAt(currNumb.length() - j - 1)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                palindromes.add(currNumb);
            }
        }


        System.out.println(String.join(" ", palindromes));
    }
}
