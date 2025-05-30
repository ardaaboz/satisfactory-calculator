package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat; // Import for formatting doubles

public class HelloApplication extends Application {

    // Helper for formatting double values to avoid long decimals
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    /**
     * Recursively prints the production chain for a given item.
     *
     * @param targetItem The item for which to print the production chain.
     * @param requestedProductionRate The desired production rate of the targetItem per minute.
     * @param indentLevel The current indentation level for visual hierarchy.
     * @return A string representing the production chain.
     */
    public static String printProductionChain(CraftableItem targetItem, double requestedProductionRate, int indentLevel) {
        StringBuilder sb = new StringBuilder(); // Use StringBuilder for efficient string concatenation

        // Create indentation for visual hierarchy
        char bulletPoint = '>';
        String indentation = "\t".repeat(indentLevel);

        // Check if the target item is a raw material (no recipe requirements)
        if (targetItem.recipeRequirements == null || targetItem.recipeRequirements.isEmpty()) {
            // For raw materials, we just print the item name and the amount directly needed
            // This case should ideally be handled when the recursion stops,
            // but if a user searches for a raw material directly, this covers it.
            // In a full production chain, raw materials are the "end" of a branch.
            // We'll let the recursive calls handle the actual requirements for raw materials.
            return ""; // Raw materials don't have further sub-recipes to print here
        }

        // Process each required ingredient
        for (CraftableItem requiredItem : targetItem.recipeRequirements.keySet()) {
            double requiredAmountPerMinute = targetItem.recipeRequirements.get(requiredItem); // Amount of requiredItem needed per unit of targetItem
            double totalRequiredAmount = requiredAmountPerMinute * (requestedProductionRate / targetItem.baseProductionRate);

            // Append the current item and its calculated amount
            sb.append(indentation)
                    .append(bulletPoint)
                    .append(" ") // Add a space for readability
                    .append(requiredItem.itemName)
                    .append(" (")
                    .append(DECIMAL_FORMAT.format(totalRequiredAmount)) // Format the double
                    .append(" /min)\n"); // Newline for each item

            // Recursively print ingredients for this required item
            // The requestedProductionRate for the next level is the totalRequiredAmount calculated above
            sb.append(printProductionChain(requiredItem, totalRequiredAmount, indentLevel + 1));
        }
        return sb.toString();
    }

    @Override
    public void start(Stage stage) throws IOException {
        GameItemDatabase gameItemDatabase = new GameItemDatabase();

        // Creating and setting up header
        Label header = new Label("Welcome to Satisfactory Calculator!");
        header.setFont(new Font("Arial", 24));

        // Creating and setting up question
        Label question = new Label("Which item would you like to produce and at what rate?");
        question.setFont(new Font("Arial", 14)); // Changed font size for question

        // Create TextField for user input
        TextField searchField = new TextField();
        // Set prompt text
        searchField.setPromptText("Item name...");
        searchField.setMaxWidth(200); // Limit width for better layout

        // Create TextField for amount
        TextField amountField = new TextField();
        // Set prompt text
        amountField.setPromptText("Requested amount per minute...");
        amountField.setMaxWidth(200); // Limit width for better layout

        // Create result text
        Text resultText = new Text();
        resultText.setFont(new Font("Monospaced", 12)); // Use monospaced font for production chain output

        // Create search button
        Button searchButton = new Button("Calculate Production"); // Set button text

        // Add action to the search button
        searchButton.setOnAction(e -> { // Corrected: use setOnAction
            // Set variable for input
            String searchTerm = searchField.getText().trim(); // Trim whitespace
            String amountString = amountField.getText().trim(); // Get and trim amount text

            // Check if inputs are empty
            if (searchTerm.isEmpty() || amountString.isEmpty()) {
                resultText.setText("Please enter both an item name and a requested amount.");
                return; // Exit early
            }

            // Attempt to parse the amount
            double requestedAmount;
            try {
                requestedAmount = Double.parseDouble(amountString);
                if (requestedAmount <= 0) {
                    resultText.setText("Requested amount must be a positive number.");
                    return;
                }
            } catch (NumberFormatException ex) {
                resultText.setText("Invalid amount: Please enter a valid number (e.g., 10, 50.5).");
                return; // Exit early
            }

            // Check if search term exists in lookup table
            if (gameItemDatabase.itemLookupTable.containsKey(searchTerm)) {
                // Set requested item
                CraftableItem requestedItem = gameItemDatabase.itemLookupTable.get(searchTerm);

                // Calculate the production chain
                // The initial call should provide the requested amount as the 'requestedProductionRate' for the target item.
                String productionChain = "To produce " + requestedAmount + " " + requestedItem.itemName + " per minute, you will need:\n";
                productionChain += printProductionChain(requestedItem, requestedAmount, 1); // Start with indent level 1

                // If the item itself is a raw material, the chain will be empty.
                if (requestedItem.recipeRequirements == null || requestedItem.recipeRequirements.isEmpty()) {
                    productionChain = requestedItem.itemName + " is a raw material. You just need to gather " + requestedAmount + " of it per minute.";
                } else if (productionChain.endsWith(":\n")) { // If nothing was added (e.g., item has recipe but recipe is empty)
                    productionChain += "No further crafting steps required (or recipe is empty).";
                }

                resultText.setText(productionChain);

            } else {
                resultText.setText("Item '" + searchTerm + "' not found in the database. Please check spelling.");
            }
        });

        // Create HBox for input fields and button
        HBox inputRow = new HBox(10, searchField, amountField, searchButton);
        inputRow.setAlignment(Pos.CENTER);

        // Create Vertical Box to hold all nodes in a column
        VBox vBox = new VBox(20, header, question, inputRow, resultText); // Added inputRow and resultText
        // Center all items
        vBox.setAlignment(Pos.TOP_CENTER); // Align to top center
        vBox.setPadding(new javafx.geometry.Insets(20)); // Add padding

        // Create scene with vBox inside, and 400 height 300 width
        Scene scene = new Scene(vBox, 600, 500); // Increased scene size
        // Set the title of the stage
        stage.setTitle("Satisfactory Production Calculator");
        // Set scene in stage
        stage.setScene(scene);
        // Display stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}