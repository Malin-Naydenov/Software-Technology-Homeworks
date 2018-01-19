import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new TreeMap<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("END")) {
                break;
            }

            String[] tokens = line.split(" ");

            if (tokens.length == 2) {
                String name = tokens[1];

                if (phonebook.containsKey(name)) {
                    System.out.printf("%s -> %s%n", name, phonebook.get(name));
                } else {
                    System.out.printf("Contact %s does not exist.%n", name);
                }
            } else if (tokens.length == 3) {
                String name = tokens[1];
                String phone = tokens[2];

                phonebook.put(name, phone);
            } else if (tokens.length == 1) {
                for (String key : phonebook.keySet()) {
                    System.out.printf("%s -> %s%n", key, phonebook.get(key));
                }
            }
        }
    }
}
