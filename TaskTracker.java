import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TaskTracker {

    private static String extractTitle(String[] args, int startIndex) {
        String title = String.join(" ", Arrays.copyOfRange(args, startIndex, args.length)).trim();
        return title;
    }

    public static void main(String[] args) throws IOException {
        // create the data folder with data.json file to store list input
        String JSON_FILE = "data/data.json";

        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File jsonFile = new File(JSON_FILE);

        if (args.length == 0) {
            System.out.println("No arguments given");
            return;
        }
        // ----------------------------------------------------------------------------------------------------------------------------------//
        // switch for add, delete, update and list commands
        switch (args[0].toLowerCase()) {
            case "add":
                if (args.length < 2) { // if no entry after "add", then title missing
                    System.out.println("Invalid Task Title");
                    break;
                }

                // extract title from args
                String title = extractTitle(args, 1).replace("\\", "\\\\").replace("\"", "\\\"");

                // document id, so we an increment for each entry, get latest one from json, if
                // starting new list use 0
                Path idPath = Paths.get("data/.id");
                int nextId = (Files.exists(idPath) ? Integer.parseInt(Files.readString(idPath).trim()) + 1 : 0);

                Files.writeString(idPath, String.valueOf(nextId)); // store latest id

                try (FileWriter w = new FileWriter("data/data.json", true)) { // store added task
                    w.write("{ \"id\": " + nextId + ", \"task\": \"" + title + "\" }\n");
                }
                System.out.println("Task added (ID: " + nextId + ")");
                break;

            // -------------------------------------------------------------------------------------------------------------------------------------//
            // removes specified task, behaves similarly to add
            case "delete":
                if (args.length < 2) { // if no entry after "add", then title missing
                    System.out.println("Invalid id");
                    break;
                }

                // TODO: Ensure we only get integers for ids, check if valid id, then somehow
                // use it to select which list item we delete
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
