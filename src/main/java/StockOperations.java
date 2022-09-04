import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class StockOperations {
    HashMap<String, Integer> storageMap = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    final int maxStock = 600;
    //boolean quiet = false;

    //adding non-existent object(K, V) to storageMap.
    public void addObject() {
        System.out.println("What do you want to add?");
        final String newObject = scan.nextLine();

        if (storageMap.containsKey(newObject)) {
            System.out.println("Object already in store");
        } else if (!newObject.equals("")){
            System.out.println("How many?");
            int num = scan.nextInt();
            if (spareRoom() >= num){
                storageMap.putIfAbsent(newObject, num);
            } else System.out.println("There is not enough room.");

        } else System.out.println("Not a valid name for an object.");
    }
    //shows all (K, V) Pairs
    public void showAll() {
    for (String i : storageMap.keySet())
        System.out.println(i + ": " + storageMap.get(i));
    }
    //shows specific (K, V) Pair
    public void show() {
        final String object = scan.nextLine();
        System.out.println("KEY: " + object + "     VALUE: " + storageMap.get(object));
        }
    //gets all the Keys
    public void keys() {
        int i = 0;
        for (String key : storageMap.keySet()) {
            System.out.println(key);
            i++;
        }
        System.out.println("different objects: " + i);
    }
    //returns value of specified key
    public Integer getValue(){
        System.out.println("Enter Key: ");
        String k = scan.nextLine();
        return storageMap.get(k);
    }

    public int spareRoom(){
        return maxStock - numValues();
    }
    //returns total of values
    public int numValues() {
        int total = 0;
        for (int value : storageMap.values()) {
            total += value;
        }
        return total;
    }
    //change the value of specified key
    public void changeStock() {
        System.out.println("Where do you want to change the value?");
        String objectToAdd = scan.nextLine();

        if (storageMap.containsKey(objectToAdd)) {
            System.out.println("KEY: " + objectToAdd + "    VALUE: " + storageMap.get(objectToAdd));

            System.out.print("ENTER NEW VALUE OR STOP:  ");
            int value = scan.nextInt();
            storageMap.replace(objectToAdd, value);

            System.out.println("KEY: " + objectToAdd + "    VALUE: " + storageMap.get(objectToAdd));
        } else System.out.println("The Object you want to change does not exist.");
    }
    //removes specified (K, V) Pair, with double check.
    public void removeEntry() {
        System.out.println("Which Entry do you want to delete?");
        String toBeRemoved = scan.nextLine();

        if (storageMap.containsKey(toBeRemoved)) {
            System.out.println("Are you sure you want to REMOVE " + toBeRemoved + " ? (Y/N)");
            String followUp = scan.nextLine().toUpperCase();

            if (followUp.equals("Y")) {
                storageMap.remove(toBeRemoved);
                System.out.println(toBeRemoved + " has been REMOVED!");
            } else System.out.println(toBeRemoved + " has NOT been removed!");
        } else System.out.println(toBeRemoved + " is not an existing object.");
    }
    //Testing BiConsumer Method
    public void test(){
        BiConsumer<String, Integer> action =
        (key, value) -> System.out.println(key + "=" + value);
        storageMap.forEach(action);
        }
}
