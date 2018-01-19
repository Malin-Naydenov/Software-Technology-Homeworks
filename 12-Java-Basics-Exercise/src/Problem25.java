import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem25 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        Map<String, Date> data = new HashMap<>();
        for (int i = 1; i <= count; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            String bookName = tokens[0];
            Date releaseDate = formatter.parse(tokens[3]);

            data.put(bookName, releaseDate);
        }

        Date filterData = formatter.parse(scanner.nextLine());

        data.entrySet()
                .stream()
                .filter(b -> b.getValue().after(filterData))
                .sorted((a, b) -> {
                    int result = a.getValue().compareTo(b.getValue());

                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }

                    return result;
                })
                .forEach(kvp -> {
                    System.out.printf("%s -> %s\n", kvp.getKey(), formatter.format(kvp.getValue()));
                });
    }
}
