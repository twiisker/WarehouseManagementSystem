import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("What do you want to do? ('q' QUIET)");
        operations();
    }
    public static void operations() {
        StockOperations storage = new StockOperations();
        List<String> choices = new ArrayList<>();
        Collections.addAll(choices, "ADD", "SHOW ALL", "SHOW", "CHANGE", "CHANGE Q", "KEYS", "VALUES", "REMOVE", "TEST", "GET");

        boolean running = true;
        while (running) {
            System.out.println(" ADD | SHOW ALL | SHOW | CHANGE (q) | REMOVE | KEYS | VALUES | TEST | GET | END");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("END")) {
                System.out.println("GOOD BYE");
                running = false;
            } else if (choices.contains(choice)) {
                switch (choice) {
                    case "ADD" -> storage.addObject();
                    case "SHOW ALL" -> storage.showAll();
                    case "SHOW" -> storage.show();
                    case "CHANGE" -> storage.changeStock();
                    //Quiet Change: without feedback
                    //case "CHANGE Q" -> {
                    //    storage.quiet = true;
                    //    storage.changeStock();
                    //}
                    case "REMOVE" -> storage.removeEntry();
                    case "KEYS" -> storage.keys();
                    case "VALUES" -> System.out.println("STORAGE: " + storage.numValues() + " of " + storage.maxStock);
                    case "TEST" -> storage.test();
                    case "GET" -> System.out.println(storage.getValue());
                }
            } else throw new IllegalArgumentException(choice + " is not a valid option. Try again.");
        }
    }
}
