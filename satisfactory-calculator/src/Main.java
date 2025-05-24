import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemManager itemManager = new ItemManager();
        boolean menuIsRunning = true;

        while (menuIsRunning) {
            System.out.println("Welcome to Satisfactory Calculator!");
            System.out.print("Please enter product name: ");
            String productNameInput = scanner.nextLine();
            System.out.print("How much would you like to produce? ");
            double productAmountInput = scanner.nextDouble();

            if (itemManager.itemNameHashMap.containsKey(productNameInput)) {
                System.out.println("Item found!");
                Item foundItem = itemManager.itemNameHashMap.get(productNameInput)
                System.out.println(foundItem.name + " "
                        + productAmountInput));
double productionRatio = productAmountInput / foundItem.defaultProductionAmount;
                for (Item item : foundItem.requiredItems) {
                    System.out.println("\t" +  item.name + ", " + item.defaultProductionAmount * productionRatio);
                }
            }
        }
    }
}
