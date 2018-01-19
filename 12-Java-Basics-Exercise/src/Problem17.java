import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17 {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String text = scanner.readLine();

        while (true) {
            int startIndex = text.indexOf("<upcase>");
            int endIndex = text.indexOf("</upcase>");

            if (startIndex == -1 || endIndex == -1) {
                break;
            }

            startIndex += "<upcase>".length();

            String oldText = "<upcase>" + text.substring(startIndex, endIndex) + "</upcase>";
            String replacer = text.substring(startIndex, endIndex).toUpperCase();

            text = text.replaceFirst(oldText, replacer);
        }

        System.out.println(text);
    }
}
