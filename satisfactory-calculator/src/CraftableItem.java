// Represents a craftable item with its production rate and recipe requirements
import java.util.HashMap;

public class CraftableItem {
    public String itemName;
    public double baseProductionRate; // Items produced per minute by default

    // Recipe requirements: each required item and how much is needed per minute
    public HashMap<CraftableItem, Double> recipeRequirements;

    public CraftableItem(String itemName, double baseProductionRate, HashMap<CraftableItem, Double> recipeRequirements) {
        this.itemName = itemName;
        this.baseProductionRate = baseProductionRate;
        this.recipeRequirements = recipeRequirements;
    }
}