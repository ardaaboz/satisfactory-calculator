import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemManager {
    // HashMap of item name and item for search purposes
    public HashMap<String, Item> itemNameHashMap;

    Item ironOre = new Item("Iron Ore", 60, null);
    Item ironIngot = new Item("Iron Ingot", 30, new HashMap<>(Map.of(ironOre, 30)));


}
