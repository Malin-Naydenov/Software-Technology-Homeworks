import java.util.Scanner;

public class Problem16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] tokens = input.split("://");

        String protocol = "";
        String server = "";
        String resources = "";

        if (tokens.length > 1) {
            protocol = tokens[0];
            String[] serverAndResource = tokens[1].split("/");

            server = serverAndResource[0];
            resources = getResources(serverAndResource);
        } else {
            String[] serverAndResource = tokens[0].split("/");

            server = serverAndResource[0];
            resources = getResources(serverAndResource);
        }

        System.out.printf("[protocol] = \"%s\"%n",protocol);
        System.out.printf("[server] = \"%s\"%n",server);
        System.out.printf("[resource] = \"%s\"%n",resources);
    }


    private static String getResources(String[] serverAndResource) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < serverAndResource.length; i++) {
            if (i > 1) {
                sb.append("/");
            }
            sb.append(serverAndResource[i]);
        }
        return sb.toString();
    }
}
