import java.util.ArrayList;
import java.util.HashMap;

public class Item {
    public String name;
    public double defaultProductionAmount;

    // Required items HashMap (Item, Amount)
    public HashMap<Item, Double> requiredItems;

    public Item(String name, double defaultProductionAmount, HashMap<Item, Double> requiredItems) {
        this.name = name;
        this.defaultProductionAmount = defaultProductionAmount;
        this.requiredItems = requiredItems;
    }
}
