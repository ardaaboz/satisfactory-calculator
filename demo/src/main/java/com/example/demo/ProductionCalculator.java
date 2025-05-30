package com.example.demo;// Main calculator application
import java.util.Scanner;

public class ProductionCalculator {

    // Recursively prints the production chain for an item
    public static void printProductionChain(CraftableItem targetItem, double productionMultiplier, int indentLevel) {
        // Base case: raw materials have no recipe requirements
        if (targetItem.recipeRequirements == null) {
            return;
        }

        // Create indentation for visual hierarchy
        char bulletPoint = '>'; // Triangular bullet symbol
        String indentation = "\t".repeat(indentLevel);

        // Process each required ingredient
        for (CraftableItem requiredItem : targetItem.recipeRequirements.keySet()) {
            // Calculate how much of this ingredient we need
            double requiredAmount = targetItem.recipeRequirements.get(requiredItem) * productionMultiplier;
            System.out.println(indentation + bulletPoint + requiredItem.itemName + ", " + requiredAmount);

            // Calculate production multiplier for the next level down
            double nextLevelMultiplier = requiredAmount / requiredItem.baseProductionRate;

            // Recursively print ingredients for this ingredient
            printProductionChain(requiredItem, nextLevelMultiplier, indentLevel + 1);
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        GameItemDatabase gameDatabase = new GameItemDatabase();
        boolean programRunning = true;

        // Main application loop
        while (programRunning) {
            System.out.println("Welcome to Satisfactory Calculator!");
            System.out.println("1. Calculate");
            System.out.println("2. Exit");
            System.out.print("\nSelect an option: ");
            int menuInput = userInput.nextInt();
            userInput.nextLine(); // Consume the newline character

            switch (menuInput) {
                case 1:
                    // Ask for input
                    System.out.print("\nPlease enter product name: ");
                    String requestedItemName = userInput.nextLine();
                    System.out.print("How much would you like to produce? ");
                    double requestedAmount = userInput.nextDouble();
                    userInput.nextLine(); // Consume the newline character

                    // Look up the requested item in our database
                    if (gameDatabase.itemLookupTable.containsKey(requestedItemName)) {
                        System.out.println("\nItem found!");

                        CraftableItem requestedItem = gameDatabase.itemLookupTable.get(requestedItemName);

                        // Display the main production goal
                        System.out.println();
                        System.out.println(requestedItem.itemName + " " + requestedAmount);


                        // Calculate how much we need to scale production
                        double productionScale = requestedAmount / requestedItem.baseProductionRate;
                        int startingDepth = 1;

                        // Show the complete production chain
                        printProductionChain(requestedItem, productionScale, startingDepth);
                        System.out.println();
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;
                case 2:
                    programRunning = false;
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }
}