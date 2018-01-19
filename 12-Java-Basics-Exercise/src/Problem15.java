import java.util.Scanner;

public class Problem15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();
        String text = scanner.nextLine();

        String[] tokens = email.split("@");

        String censoredUsername = censoreEmail(tokens[0]);
        String replacer = censoredUsername + "@" + tokens[1];

        text = text.replaceAll(email, replacer);

        System.out.println(text);
    }

    private static String censoreEmail(String username) {
        int usernameLen = username.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= usernameLen; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
