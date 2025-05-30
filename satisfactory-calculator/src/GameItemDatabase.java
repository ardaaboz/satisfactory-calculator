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
        // Raw materials
        CraftableItem ironOre = new CraftableItem("Iron Ore", 60, null);
        itemLookupTable.put(ironOre.itemName.toLowerCase(), ironOre);

        CraftableItem copperOre = new CraftableItem("Copper Ore", 60, null);
        itemLookupTable.put(copperOre.itemName.toLowerCase(), copperOre);

        CraftableItem coal = new CraftableItem("Coal", 60, null);
        itemLookupTable.put(coal.itemName.toLowerCase(), coal);

        CraftableItem limestone = new CraftableItem("Limestone", 60, null);
        itemLookupTable.put(limestone.itemName.toLowerCase(), limestone);

        CraftableItem cateriumOre = new CraftableItem("Caterium Ore", 60, null);
        itemLookupTable.put(cateriumOre.itemName.toLowerCase(), cateriumOre);

        CraftableItem rawQuartz = new CraftableItem("Raw Quartz", 60, null);
        itemLookupTable.put(rawQuartz.itemName.toLowerCase(), rawQuartz);

        CraftableItem sulfur = new CraftableItem("Sulfur", 60, null);
        itemLookupTable.put(sulfur.itemName.toLowerCase(), sulfur);

        CraftableItem bauxite = new CraftableItem("Bauxite", 60, null);
        itemLookupTable.put(bauxite.itemName.toLowerCase(), bauxite);

        CraftableItem uranium = new CraftableItem("Uranium", 60, null);
        itemLookupTable.put(uranium.itemName.toLowerCase(), uranium);

        CraftableItem water = new CraftableItem("Water", 120, null);
        itemLookupTable.put(water.itemName.toLowerCase(), water);

        CraftableItem crudeOil = new CraftableItem("Crude Oil", 120, null);
        itemLookupTable.put(crudeOil.itemName.toLowerCase(), crudeOil);

        CraftableItem nitrogenGas = new CraftableItem("Nitrogen Gas", 120, null);
        itemLookupTable.put(nitrogenGas.itemName.toLowerCase(), nitrogenGas);

        CraftableItem leaves = new CraftableItem("Leaves", 60, null);
        itemLookupTable.put(leaves.itemName.toLowerCase(), leaves);

        CraftableItem wood = new CraftableItem("Wood", 60, null);
        itemLookupTable.put(wood.itemName.toLowerCase(), wood);

        CraftableItem mycelia = new CraftableItem("Mycelia", 60, null);
        itemLookupTable.put(mycelia.itemName.toLowerCase(), mycelia);

        // Fuels
        CraftableItem biomass = new CraftableItem("Biomass", 60,
                new HashMap<>(Map.of(leaves, 300.0)));
        itemLookupTable.put(biomass.itemName.toLowerCase(), biomass);

        CraftableItem solidBiofuel = new CraftableItem("Solid Biofuel", 60,
                new HashMap<>(Map.of(biomass, 120.0)));
        itemLookupTable.put(solidBiofuel.itemName.toLowerCase(), solidBiofuel);

        CraftableItem compactedCoal = new CraftableItem("Compacted Coal", 25,
                new HashMap<>(Map.of(coal, 25.0, sulfur, 25.0)));
        itemLookupTable.put(compactedCoal.itemName.toLowerCase(), compactedCoal);

        // Ingots
        CraftableItem ironIngot = new CraftableItem("Iron Ingot", 30,
                new HashMap<>(Map.of(ironOre, 30.0)));
        itemLookupTable.put(ironIngot.itemName.toLowerCase(), ironIngot);

        CraftableItem copperIngot = new CraftableItem("Copper Ingot", 30,
                new HashMap<>(Map.of(copperOre, 30.0)));
        itemLookupTable.put(copperIngot.itemName.toLowerCase(), copperIngot);

        CraftableItem steelIngot = new CraftableItem("Steel Ingot", 45,
                new HashMap<>(Map.of(ironOre, 45.0, coal, 45.0)));
        itemLookupTable.put(steelIngot.itemName.toLowerCase(), steelIngot);

        CraftableItem cateriumIngot = new CraftableItem("Caterium Ingot", 15,
                new HashMap<>(Map.of(cateriumOre, 45.0)));
        itemLookupTable.put(cateriumIngot.itemName.toLowerCase(), cateriumIngot);

        // Basic materials
        CraftableItem concrete = new CraftableItem("Concrete", 45,
                new HashMap<>(Map.of(limestone, 45.0)));
        itemLookupTable.put(concrete.itemName.toLowerCase(), concrete);

        CraftableItem quartzCrystal = new CraftableItem("Quartz Crystal", 22.5,
                new HashMap<>(Map.of(rawQuartz, 37.5)));
        itemLookupTable.put(quartzCrystal.itemName.toLowerCase(), quartzCrystal);

        CraftableItem silica = new CraftableItem("Silica", 37.5,
                new HashMap<>(Map.of(rawQuartz, 22.5)));
        itemLookupTable.put(silica.itemName.toLowerCase(), silica);

        CraftableItem copperPowder = new CraftableItem("Copper Powder", 50,
                new HashMap<>(Map.of(copperIngot, 300.0)));
        itemLookupTable.put(copperPowder.itemName.toLowerCase(), copperPowder);

        // Aluminum production chain
        CraftableItem aluminaSolution = new CraftableItem("Alumina Solution", 120,
                new HashMap<>(Map.of(bauxite, 120.0, water, 180.0)));
        itemLookupTable.put(aluminaSolution.itemName.toLowerCase(), aluminaSolution);

        CraftableItem aluminumScrap = new CraftableItem("Aluminum Scrap", 360,
                new HashMap<>(Map.of(aluminaSolution, 240.0, coal, 120.0)));
        itemLookupTable.put(aluminumScrap.itemName.toLowerCase(), aluminumScrap);

        CraftableItem aluminumIngot = new CraftableItem("Aluminum Ingot", 60,
                new HashMap<>(Map.of(aluminumScrap, 90.0, silica, 75.0)));
        itemLookupTable.put(aluminumIngot.itemName.toLowerCase(), aluminumIngot);

        // Standard parts
        CraftableItem ironRod = new CraftableItem("Iron Rod", 15,
                new HashMap<>(Map.of(ironIngot, 15.0)));
        itemLookupTable.put(ironRod.itemName.toLowerCase(), ironRod);

        CraftableItem ironPlate = new CraftableItem("Iron Plate", 20,
                new HashMap<>(Map.of(ironIngot, 30.0)));
        itemLookupTable.put(ironPlate.itemName.toLowerCase(), ironPlate);

        CraftableItem screw = new CraftableItem("Screw", 40,
                new HashMap<>(Map.of(ironRod, 10.0)));
        itemLookupTable.put(screw.itemName.toLowerCase(), screw);

        CraftableItem reinforcedIronPlate = new CraftableItem("Reinforced Iron Plate", 5,
                new HashMap<>(Map.of(ironPlate, 30.0, screw, 60.0)));
        itemLookupTable.put(reinforcedIronPlate.itemName.toLowerCase(), reinforcedIronPlate);

        CraftableItem copperSheet = new CraftableItem("Copper Sheet", 10,
                new HashMap<>(Map.of(copperIngot, 20.0)));
        itemLookupTable.put(copperSheet.itemName.toLowerCase(), copperSheet);

        CraftableItem steelPipe = new CraftableItem("Steel Pipe", 20,
                new HashMap<>(Map.of(steelIngot, 30.0)));
        itemLookupTable.put(steelPipe.itemName.toLowerCase(), steelPipe);

        CraftableItem steelBeam = new CraftableItem("Steel Beam", 15,
                new HashMap<>(Map.of(steelIngot, 60.0)));
        itemLookupTable.put(steelBeam.itemName.toLowerCase(), steelBeam);

        CraftableItem aluminumCasing = new CraftableItem("Aluminum Casing", 60,
                new HashMap<>(Map.of(aluminumIngot, 90.0)));
        itemLookupTable.put(aluminumCasing.itemName.toLowerCase(), aluminumCasing);

        CraftableItem alcladAluminumSheet = new CraftableItem("Alclad Aluminum Sheet", 30,
                new HashMap<>(Map.of(aluminumIngot, 30.0, copperIngot, 10.0)));
        itemLookupTable.put(alcladAluminumSheet.itemName.toLowerCase(), alcladAluminumSheet);

        CraftableItem fabric = new CraftableItem("Fabric", 15,
                new HashMap<>(Map.of(mycelia, 5.0, biomass, 25.0)));
        itemLookupTable.put(fabric.itemName.toLowerCase().toLowerCase(), fabric);

        // Oil processing
        CraftableItem heavyOilResidue = new CraftableItem("Heavy Oil Residue", 40,
                new HashMap<>(Map.of(crudeOil, 30.0)));
        itemLookupTable.put(heavyOilResidue.itemName.toLowerCase(), heavyOilResidue);

        CraftableItem plastic = new CraftableItem("Plastic", 20,
                new HashMap<>(Map.of(crudeOil, 30.0)));
        itemLookupTable.put(plastic.itemName.toLowerCase(), plastic);

        CraftableItem rubber = new CraftableItem("Rubber", 20,
                new HashMap<>(Map.of(crudeOil, 30.0)));
        itemLookupTable.put(rubber.itemName.toLowerCase(), rubber);

        CraftableItem fuel = new CraftableItem("Fuel", 40,
                new HashMap<>(Map.of(heavyOilResidue, 60.0)));
        itemLookupTable.put(fuel.itemName.toLowerCase(), fuel);

        CraftableItem polymerResin = new CraftableItem("Polymer Resin", 130,
                new HashMap<>(Map.of(crudeOil, 60.0)));
        itemLookupTable.put(polymerResin.itemName.toLowerCase(), polymerResin);

        CraftableItem petroleumCoke = new CraftableItem("Petroleum Coke", 120,
                new HashMap<>(Map.of(heavyOilResidue, 40.0)));
        itemLookupTable.put(petroleumCoke.itemName.toLowerCase(), petroleumCoke);

        CraftableItem turbofuel = new CraftableItem("Turbofuel", 18.75,
                new HashMap<>(Map.of(fuel, 22.5, compactedCoal, 15.0)));
        itemLookupTable.put(turbofuel.itemName.toLowerCase(), turbofuel);

        // Acids
        CraftableItem sulfuricAcid = new CraftableItem("Sulfuric Acid", 50,
                new HashMap<>(Map.of(sulfur, 50.0, water, 50.0)));
        itemLookupTable.put(sulfuricAcid.itemName.toLowerCase(), sulfuricAcid);

        CraftableItem nitricAcid = new CraftableItem("Nitric Acid", 30,
                new HashMap<>(Map.of(nitrogenGas, 120.0, water, 30.0, ironPlate, 10.0)));
        itemLookupTable.put(nitricAcid.itemName.toLowerCase(), nitricAcid);

        // Electronics
        CraftableItem wire = new CraftableItem("Wire", 30,
                new HashMap<>(Map.of(copperIngot, 15.0)));
        itemLookupTable.put(wire.itemName.toLowerCase(), wire);

        CraftableItem cable = new CraftableItem("Cable", 30,
                new HashMap<>(Map.of(wire, 60.0)));
        itemLookupTable.put(cable.itemName.toLowerCase(), cable);

        CraftableItem quickwire = new CraftableItem("Quickwire", 60,
                new HashMap<>(Map.of(cateriumIngot, 12.0)));
        itemLookupTable.put(quickwire.itemName.toLowerCase(), quickwire);

        CraftableItem circuitBoard = new CraftableItem("Circuit Board", 7.5,
                new HashMap<>(Map.of(copperSheet, 15.0, plastic, 30.0)));
        itemLookupTable.put(circuitBoard.itemName.toLowerCase(), circuitBoard);

        CraftableItem aiLimiter = new CraftableItem("AI Limiter", 5,
                new HashMap<>(Map.of(copperSheet, 25.0, quickwire, 100.0)));
        itemLookupTable.put(aiLimiter.itemName.toLowerCase(), aiLimiter);

        CraftableItem highSpeedConnector = new CraftableItem("High-Speed Connector", 3.75,
                new HashMap<>(Map.of(quickwire, 210.0, plastic, 37.5, circuitBoard, 3.75)));
        itemLookupTable.put(highSpeedConnector.itemName.toLowerCase(), highSpeedConnector);

        // Industrial parts
        CraftableItem rotor = new CraftableItem("Rotor", 4,
                new HashMap<>(Map.of(ironRod, 20.0, screw, 100.0)));
        itemLookupTable.put(rotor.itemName.toLowerCase(), rotor);

        CraftableItem stator = new CraftableItem("Stator", 5,
                new HashMap<>(Map.of(steelPipe, 15.0, wire, 40.0)));
        itemLookupTable.put(stator.itemName.toLowerCase(), stator);

        CraftableItem motor = new CraftableItem("Motor", 5,
                new HashMap<>(Map.of(rotor, 10.0, stator, 10.0)));
        itemLookupTable.put(motor.itemName.toLowerCase(), motor);

        CraftableItem heatSink = new CraftableItem("Heat Sink", 7.5,
                new HashMap<>(Map.of(alcladAluminumSheet, 37.5, copperSheet, 22.5)));
        itemLookupTable.put(heatSink.itemName.toLowerCase(), heatSink);

        CraftableItem coolingSystem = new CraftableItem("Cooling System", 6,
                new HashMap<>(Map.of(heatSink, 12.0, rubber, 12.0, water, 30.0, nitrogenGas, 150.0)));
        itemLookupTable.put(coolingSystem.itemName.toLowerCase(), coolingSystem);

        CraftableItem battery = new CraftableItem("Battery", 20,
                new HashMap<>(Map.of(sulfuricAcid, 50.0, aluminaSolution, 20.0, aluminumCasing, 10.0)));
        itemLookupTable.put(battery.itemName.toLowerCase(), battery);

        // Communications
        CraftableItem computer = new CraftableItem("Computer", 2.5,
                new HashMap<>(Map.of(circuitBoard, 10.0, cable, 20.0, plastic, 40.0, screw, 2.5)));
        itemLookupTable.put(computer.itemName.toLowerCase(), computer);

        CraftableItem supercomputer = new CraftableItem("Supercomputer", 1.875,
                new HashMap<>(Map.of(computer, 3.75, aiLimiter, 3.75, highSpeedConnector, 5.625, plastic, 52.5)));
        itemLookupTable.put(supercomputer.itemName.toLowerCase(), supercomputer);

        CraftableItem crystalOscillator = new CraftableItem("Crystal Oscillator", 1,
                new HashMap<>(Map.of(quartzCrystal, 36.0, cable, 28.0, reinforcedIronPlate, 5.0)));
        itemLookupTable.put(crystalOscillator.itemName.toLowerCase(), crystalOscillator);

        CraftableItem radioControlUnit = new CraftableItem("Radio Control Unit", 2.5,
                new HashMap<>(Map.of(aluminumCasing, 80.0, crystalOscillator, 2.5, computer, 2.5)));
        itemLookupTable.put(radioControlUnit.itemName.toLowerCase(), radioControlUnit);

        CraftableItem turboMotor = new CraftableItem("Turbo Motor", 1.875,
                new HashMap<>(Map.of(coolingSystem, 7.5, radioControlUnit, 3.75, motor, 7.5, rubber, 3.75)));
        itemLookupTable.put(turboMotor.itemName.toLowerCase(), turboMotor);

        // Complex frames
        CraftableItem modularFrame = new CraftableItem("Modular Frame", 2,
                new HashMap<>(Map.of(reinforcedIronPlate, 3.0, ironRod, 12.0)));
        itemLookupTable.put(modularFrame.itemName.toLowerCase(), modularFrame);

        CraftableItem encasedIndustrialBeam = new CraftableItem("Encased Industrial Beam", 6,
                new HashMap<>(Map.of(steelBeam, 24.0, concrete, 30.0)));
        itemLookupTable.put(encasedIndustrialBeam.itemName.toLowerCase(), encasedIndustrialBeam);

        CraftableItem heavyModularFrame = new CraftableItem("Heavy Modular Frame", 2,
                new HashMap<>(Map.of(modularFrame, 5.0, steelPipe, 15.0, encasedIndustrialBeam, 5.0, screw, 100.0)));
        itemLookupTable.put(heavyModularFrame.itemName.toLowerCase(), heavyModularFrame);

        CraftableItem fusedModularFrame = new CraftableItem("Fused Modular Frame", 1.5,
                new HashMap<>(Map.of(heavyModularFrame, 1.5, aluminumCasing, 75.0, nitrogenGas, 37.5)));
        itemLookupTable.put(fusedModularFrame.itemName.toLowerCase(), fusedModularFrame);

        // Nuclear
        CraftableItem electromagneticControlRod = new CraftableItem("Electromagnetic Control Rod", 4,
                new HashMap<>(Map.of(stator, 24.0, aiLimiter, 16.0)));
        itemLookupTable.put(electromagneticControlRod.itemName.toLowerCase(), electromagneticControlRod);

        CraftableItem encasedUraniumCell = new CraftableItem("Encased Uranium Cell", 25,
                new HashMap<>(Map.of(uranium, 50.0, concrete, 15.0, sulfuricAcid, 40.0)));
        itemLookupTable.put(encasedUraniumCell.itemName.toLowerCase(), encasedUraniumCell);

        CraftableItem uraniumFuelRod = new CraftableItem("Uranium Fuel Rod", 0.4,
                new HashMap<>(Map.of(encasedUraniumCell, 20.0, encasedIndustrialBeam, 1.2, electromagneticControlRod, 2.0)));
        itemLookupTable.put(uraniumFuelRod.itemName.toLowerCase(), uraniumFuelRod);

        // Containers
        CraftableItem emptyCanister = new CraftableItem("Empty Canister", 60,
                new HashMap<>(Map.of(plastic, 30.0)));
        itemLookupTable.put(emptyCanister.itemName.toLowerCase(), emptyCanister);

        CraftableItem emptyFluidTank = new CraftableItem("Empty Fluid Tank", 60,
                new HashMap<>(Map.of(aluminumIngot, 60.0)));
        itemLookupTable.put(emptyFluidTank.itemName.toLowerCase(), emptyFluidTank);

        CraftableItem pressureConversionCube = new CraftableItem("Pressure Conversion Cube", 2,
                new HashMap<>(Map.of(fusedModularFrame, 2.0, radioControlUnit, 4.0)));
        itemLookupTable.put(pressureConversionCube.itemName.toLowerCase(), pressureConversionCube);

        // Space Elevator parts
        CraftableItem smartPlating = new CraftableItem("Smart Plating", 2,
                new HashMap<>(Map.of(reinforcedIronPlate, 2.0, rotor, 2.0)));
        itemLookupTable.put(smartPlating.itemName.toLowerCase(), smartPlating);

        CraftableItem versatileFramework = new CraftableItem("Versatile Framework", 5,
                new HashMap<>(Map.of(modularFrame, 2.5, steelBeam, 30.0)));
        itemLookupTable.put(versatileFramework.itemName.toLowerCase(), versatileFramework);

        CraftableItem automatedWiring = new CraftableItem("Automated Wiring", 2.5,
                new HashMap<>(Map.of(stator, 2.5, cable, 50.0)));
        itemLookupTable.put(automatedWiring.itemName.toLowerCase(), automatedWiring);

        CraftableItem modularEngine = new CraftableItem("Modular Engine", 1,
                new HashMap<>(Map.of(motor, 2.0, rubber, 15.0, smartPlating, 2.0)));
        itemLookupTable.put(modularEngine.itemName.toLowerCase(), modularEngine);

        CraftableItem adaptiveControlUnit = new CraftableItem("Adaptive Control Unit", 2,
                new HashMap<>(Map.of(automatedWiring, 15.0, circuitBoard, 10.0, heavyModularFrame, 2.0, computer, 2.0)));
        itemLookupTable.put(adaptiveControlUnit.itemName.toLowerCase(), adaptiveControlUnit);

        CraftableItem assemblyDirectorSystem = new CraftableItem("Assembly Director System", 0.75,
                new HashMap<>(Map.of(adaptiveControlUnit, 1.5, supercomputer, 0.75)));
        itemLookupTable.put(assemblyDirectorSystem.itemName.toLowerCase(), assemblyDirectorSystem);

        CraftableItem magneticFieldGenerator = new CraftableItem("Magnetic Field Generator", 2,
                new HashMap<>(Map.of(versatileFramework, 5.0, electromagneticControlRod, 2.0, battery, 10.0)));
        itemLookupTable.put(magneticFieldGenerator.itemName.toLowerCase(), magneticFieldGenerator);

        CraftableItem thermalPropulsionRocket = new CraftableItem("Thermal Propulsion Rocket", 2,
                new HashMap<>(Map.of(modularEngine, 5.0, turboMotor, 2.0, coolingSystem, 3.0, fusedModularFrame, 2.0)));
        itemLookupTable.put(thermalPropulsionRocket.itemName, thermalPropulsionRocket);

        CraftableItem nuclearPasta = new CraftableItem("Nuclear Pasta", 0.5,
                new HashMap<>(Map.of(copperPowder, 100.0, pressureConversionCube, 0.5)));
        itemLookupTable.put(nuclearPasta.itemName.toLowerCase(), nuclearPasta);
    }
}
