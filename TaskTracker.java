import java.util.Arrays;

public class TaskTracker {

    private static String extractTitle(String[] args, int startIndex) {
        String title = String.join(" ", Arrays.copyOfRange(args, startIndex, args.length)).trim();
        return title;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments given");
            return;
        }

        switch (args[0].toLowerCase()) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Invalid Task Title");
                    break;
                } else {
                    String title = extractTitle(args, 1);
                    System.out.println("Added: " + title);
                    break;
                }

            case "delete":
                System.out.println("You gave a delete command");
                break;

            case "update":
                System.out.println("You gave an update command");
                break;

            case "list":
                System.out.println("[ID]:       [Task]:");
                break;

            default:
                System.out.println("Unknown Command!");
        }
    }
}
