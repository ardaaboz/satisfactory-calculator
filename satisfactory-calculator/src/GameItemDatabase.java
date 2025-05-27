// Manages all available items and their recipes
import java.util.HashMap;
import java.util.Map;

public class GameItemDatabase {
    // Maps item names to their objects for quick lookup
    public HashMap<String, CraftableItem> itemLookupTable;

    public GameItemDatabase() {
        itemLookupTable = new HashMap<>();

        // Initialize all game items with their production rates and recipes
        initializeGameItems();
    }

    private void initializeGameItems() {
        // Raw materials (no recipe requirements)
        CraftableItem ironOre = new CraftableItem("Iron Ore", 60, null);
        itemLookupTable.put(ironOre.itemName, ironOre);

        // Basic processed materials
        CraftableItem ironIngot = new CraftableItem("Iron Ingot", 30,
                new HashMap<>(Map.of(ironOre, 30.0)));
        itemLookupTable.put(ironIngot.itemName, ironIngot);

        CraftableItem ironRod = new CraftableItem("Iron Rod", 15,
                new HashMap<>(Map.of(ironIngot, 15.0)));
        itemLookupTable.put(ironRod.itemName, ironRod);

        CraftableItem ironPlate = new CraftableItem("Iron Plate", 20,
                new HashMap<>(Map.of(ironIngot, 30.0)));
        itemLookupTable.put(ironPlate.itemName, ironPlate);

        CraftableItem screw = new CraftableItem("Screw", 40,
                new HashMap<>(Map.of(ironRod, 10.0)));
        itemLookupTable.put(screw.itemName, screw);

        // Complex manufactured items
        CraftableItem reinforcedIronPlate = new CraftableItem("Reinforced Iron Plate", 5,
                new HashMap<>(Map.of(ironPlate, 30.0, screw, 60.0)));
        itemLookupTable.put(reinforcedIronPlate.itemName, reinforcedIronPlate);

        CraftableItem rotor = new CraftableItem("Rotor", 4,
                new HashMap<>(Map.of(ironRod, 20.0, screw, 100.0)));
        itemLookupTable.put(rotor.itemName, rotor);
    }
}
