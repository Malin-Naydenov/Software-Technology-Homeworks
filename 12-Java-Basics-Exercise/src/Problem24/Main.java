package Problem24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= count; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            String title = tokens[0];
            String author = tokens[1];
            String publisher = tokens[2];
            String date = tokens[3];
            String isbn = tokens[4];
            double price = Double.parseDouble(tokens[5]);

            Book book = new Book(title, author, publisher, date, isbn, price);
            books.add(book);
        }

        Map<String, Double> authorSales = new HashMap<>();

        for (Book book : books) {
            String author = book.getAuthor();
            double bookIncome = book.getPrice();
            authorSales.putIfAbsent(author, 0.0);
            authorSales.put(author, authorSales.get(author) + bookIncome);
        }

        authorSales.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = Double.compare(b.getValue(), a.getValue());

                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }

                    return result;
                })
                .forEach(kvp -> {
                    String author = kvp.getKey();
                    Double authorIncome = kvp.getValue();

                    System.out.printf("%s -> %.2f%n", author, authorIncome);
                });

    }
}
