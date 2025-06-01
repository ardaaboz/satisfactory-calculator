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
        // TIER 0: RAW MATERIALS (no dependencies)
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

        CraftableItem flowerPetals = new CraftableItem("Flower Petals", 60, null);
        itemLookupTable.put(flowerPetals.itemName.toLowerCase(), flowerPetals);

        // Special items (found/collected)
        CraftableItem sam = new CraftableItem("SAM", 60, null);
        itemLookupTable.put(sam.itemName.toLowerCase(), sam);

        CraftableItem bluePowerSlug = new CraftableItem("Blue Power Slug", 60, null);
        itemLookupTable.put(bluePowerSlug.itemName.toLowerCase(), bluePowerSlug);

        CraftableItem yellowPowerSlug = new CraftableItem("Yellow Power Slug", 60, null);
        itemLookupTable.put(yellowPowerSlug.itemName.toLowerCase(), yellowPowerSlug);

        CraftableItem purplePowerSlug = new CraftableItem("Purple Power Slug", 60, null);
        itemLookupTable.put(purplePowerSlug.itemName.toLowerCase(), purplePowerSlug);

        CraftableItem alienProtein = new CraftableItem("Alien Protein", 20, null);
        itemLookupTable.put(alienProtein.itemName.toLowerCase(), alienProtein);

        CraftableItem darkMatterResidue = new CraftableItem("Dark Matter Residue", 200, null);
        itemLookupTable.put(darkMatterResidue.itemName.toLowerCase(), darkMatterResidue);

        CraftableItem excitedPhotonicMatter = new CraftableItem("Excited Photonic Matter", 37.5, null);
        itemLookupTable.put(excitedPhotonicMatter.itemName.toLowerCase(), excitedPhotonicMatter);

        CraftableItem ficsitCoupon = new CraftableItem("FICSIT Coupon", 1, null);
        itemLookupTable.put(ficsitCoupon.itemName.toLowerCase(), ficsitCoupon);

        // TIER 1: BASIC MATERIALS (depend only on raw materials)
        CraftableItem biomass = new CraftableItem("Biomass", 60,
                new HashMap<>(Map.of(leaves, 300.0)));
        itemLookupTable.put(biomass.itemName.toLowerCase(), biomass);

        CraftableItem concrete = new CraftableItem("Concrete", 45,
                new HashMap<>(Map.of(limestone, 45.0)));
        itemLookupTable.put(concrete.itemName.toLowerCase(), concrete);

        CraftableItem quartzCrystal = new CraftableItem("Quartz Crystal", 22.5,
                new HashMap<>(Map.of(rawQuartz, 37.5)));
        itemLookupTable.put(quartzCrystal.itemName.toLowerCase(), quartzCrystal);

        CraftableItem silica = new CraftableItem("Silica", 37.5,
                new HashMap<>(Map.of(rawQuartz, 22.5)));
        itemLookupTable.put(silica.itemName.toLowerCase(), silica);

        CraftableItem aluminaSolution = new CraftableItem("Alumina Solution", 120,
                new HashMap<>(Map.of(bauxite, 120.0, water, 180.0)));
        itemLookupTable.put(aluminaSolution.itemName.toLowerCase(), aluminaSolution);

        CraftableItem heavyOilResidue = new CraftableItem("Heavy Oil Residue", 40,
                new HashMap<>(Map.of(crudeOil, 30.0)));
        itemLookupTable.put(heavyOilResidue.itemName.toLowerCase(), heavyOilResidue);

        CraftableItem plastic = new CraftableItem("Plastic", 20,
                new HashMap<>(Map.of(crudeOil, 30.0)));
        itemLookupTable.put(plastic.itemName.toLowerCase(), plastic);

        CraftableItem rubber = new CraftableItem("Rubber", 20,
                new HashMap<>(Map.of(crudeOil, 30.0)));
        itemLookupTable.put(rubber.itemName.toLowerCase(), rubber);

        CraftableItem polymerResin = new CraftableItem("Polymer Resin", 130,
                new HashMap<>(Map.of(crudeOil, 60.0)));
        itemLookupTable.put(polymerResin.itemName.toLowerCase(), polymerResin);

        CraftableItem petroleumCoke = new CraftableItem("Petroleum Coke", 120,
                new HashMap<>(Map.of(heavyOilResidue, 40.0)));
        itemLookupTable.put(petroleumCoke.itemName.toLowerCase(), petroleumCoke);

        CraftableItem sulfuricAcid = new CraftableItem("Sulfuric Acid", 50,
                new HashMap<>(Map.of(sulfur, 50.0, water, 50.0)));
        itemLookupTable.put(sulfuricAcid.itemName.toLowerCase(), sulfuricAcid);

        CraftableItem compactedCoal = new CraftableItem("Compacted Coal", 25,
                new HashMap<>(Map.of(coal, 25.0, sulfur, 25.0)));
        itemLookupTable.put(compactedCoal.itemName.toLowerCase(), compactedCoal);

        CraftableItem blackPowder = new CraftableItem("Black Powder", 30,
                new HashMap<>(Map.of(coal, 15.0, sulfur, 15.0)));
        itemLookupTable.put(blackPowder.itemName.toLowerCase(), blackPowder);

        CraftableItem reanimatedSAM = new CraftableItem("Reanimated SAM", 30,
                new HashMap<>(Map.of(sam, 120.0)));
        itemLookupTable.put(reanimatedSAM.itemName.toLowerCase(), reanimatedSAM);

        CraftableItem alienDNACapsule = new CraftableItem("Alien DNA Capsule", 10,
                new HashMap<>(Map.of(alienProtein, 10.0)));
        itemLookupTable.put(alienDNACapsule.itemName.toLowerCase(), alienDNACapsule);

        CraftableItem powerShard = new CraftableItem("Power Shard", 1,
                new HashMap<>(Map.of(bluePowerSlug, 1.0)));
        itemLookupTable.put(powerShard.itemName.toLowerCase(), powerShard);

        CraftableItem diamonds = new CraftableItem("Diamonds", 30,
                new HashMap<>(Map.of(coal, 300.0)));
        itemLookupTable.put(diamonds.itemName.toLowerCase(), diamonds);

        CraftableItem darkMatterCrystal = new CraftableItem("Dark Matter Crystal", 30,
                new HashMap<>(Map.of(darkMatterResidue, 200.0)));
        itemLookupTable.put(darkMatterCrystal.itemName.toLowerCase(), darkMatterCrystal);

        CraftableItem colorCartridge = new CraftableItem("Color Cartridge", 60,
                new HashMap<>(Map.of(flowerPetals, 75.0)));
        itemLookupTable.put(colorCartridge.itemName.toLowerCase(), colorCartridge);

        // TIER 2: INGOTS (depend on basic materials)
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

        CraftableItem aluminumScrap = new CraftableItem("Aluminum Scrap", 360,
                new HashMap<>(Map.of(aluminaSolution, 240.0, coal, 120.0)));
        itemLookupTable.put(aluminumScrap.itemName.toLowerCase(), aluminumScrap);

        CraftableItem aluminumIngot = new CraftableItem("Aluminum Ingot", 60,
                new HashMap<>(Map.of(aluminumScrap, 90.0, silica, 75.0)));
        itemLookupTable.put(aluminumIngot.itemName.toLowerCase(), aluminumIngot);

        CraftableItem ficsite = new CraftableItem("Ficsite Ingot", 30,
                new HashMap<>(Map.of(reanimatedSAM, 60.0)));
        itemLookupTable.put(ficsite.itemName.toLowerCase(), ficsite);

        // TIER 3: PROCESSED MATERIALS (depend on ingots)
        CraftableItem copperPowder = new CraftableItem("Copper Powder", 50,
                new HashMap<>(Map.of(copperIngot, 300.0)));
        itemLookupTable.put(copperPowder.itemName.toLowerCase(), copperPowder);

        CraftableItem fuel = new CraftableItem("Fuel", 40,
                new HashMap<>(Map.of(heavyOilResidue, 60.0)));
        itemLookupTable.put(fuel.itemName.toLowerCase(), fuel);

        CraftableItem solidBiofuel = new CraftableItem("Solid Biofuel", 60,
                new HashMap<>(Map.of(biomass, 120.0)));
        itemLookupTable.put(solidBiofuel.itemName.toLowerCase(), solidBiofuel);

        CraftableItem fabric = new CraftableItem("Fabric", 15,
                new HashMap<>(Map.of(mycelia, 5.0, biomass, 25.0)));
        itemLookupTable.put(fabric.itemName.toLowerCase(), fabric);

        CraftableItem smokelessPowder = new CraftableItem("Smokeless Powder", 20,
                new HashMap<>(Map.of(blackPowder, 20.0, heavyOilResidue, 10.0)));
        itemLookupTable.put(smokelessPowder.itemName.toLowerCase(), smokelessPowder);

        CraftableItem turbofuel = new CraftableItem("Turbofuel", 18.75,
                new HashMap<>(Map.of(fuel, 22.5, compactedCoal, 15.0)));
        itemLookupTable.put(turbofuel.itemName.toLowerCase(), turbofuel);

        CraftableItem liquidBiofuel = new CraftableItem("Liquid Biofuel", 60,
                new HashMap<>(Map.of(solidBiofuel, 90.0, water, 45.0)));
        itemLookupTable.put(liquidBiofuel.itemName.toLowerCase(), liquidBiofuel);

        CraftableItem timeCrystal = new CraftableItem("Time Crystal", 6,
                new HashMap<>(Map.of(diamonds, 12.0, darkMatterCrystal, 24.0)));
        itemLookupTable.put(timeCrystal.itemName.toLowerCase(), timeCrystal);

        CraftableItem ficsiteTrigon = new CraftableItem("Ficsite Trigon", 30,
                new HashMap<>(Map.of(ficsite, 10.0)));
        itemLookupTable.put(ficsiteTrigon.itemName.toLowerCase(), ficsiteTrigon);

        // TIER 4: STANDARD PARTS (depend on ingots)
        CraftableItem ironRod = new CraftableItem("Iron Rod", 15,
                new HashMap<>(Map.of(ironIngot, 15.0)));
        itemLookupTable.put(ironRod.itemName.toLowerCase(), ironRod);

        CraftableItem ironPlate = new CraftableItem("Iron Plate", 20,
                new HashMap<>(Map.of(ironIngot, 30.0)));
        itemLookupTable.put(ironPlate.itemName.toLowerCase(), ironPlate);

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

        CraftableItem wire = new CraftableItem("Wire", 30,
                new HashMap<>(Map.of(copperIngot, 15.0)));
        itemLookupTable.put(wire.itemName.toLowerCase(), wire);

        CraftableItem quickwire = new CraftableItem("Quickwire", 60,
                new HashMap<>(Map.of(cateriumIngot, 12.0)));
        itemLookupTable.put(quickwire.itemName.toLowerCase(), quickwire);

        CraftableItem emptyCanister = new CraftableItem("Empty Canister", 60,
                new HashMap<>(Map.of(plastic, 30.0)));
        itemLookupTable.put(emptyCanister.itemName.toLowerCase(), emptyCanister);

        CraftableItem emptyFluidTank = new CraftableItem("Empty Fluid Tank", 60,
                new HashMap<>(Map.of(aluminumIngot, 60.0)));
        itemLookupTable.put(emptyFluidTank.itemName.toLowerCase(), emptyFluidTank);

        // TIER 5: COMPLEX ACIDS (depend on standard parts)
        CraftableItem nitricAcid = new CraftableItem("Nitric Acid", 30,
                new HashMap<>(Map.of(nitrogenGas, 120.0, water, 30.0, ironPlate, 10.0)));
        itemLookupTable.put(nitricAcid.itemName.toLowerCase(), nitricAcid);

        CraftableItem rocketFuel = new CraftableItem("Rocket Fuel", 100,
                new HashMap<>(Map.of(turbofuel, 100.0, nitricAcid, 100.0)));
        itemLookupTable.put(rocketFuel.itemName.toLowerCase(), rocketFuel);

        CraftableItem ionizedFuel = new CraftableItem("Ionized Fuel", 40,
                new HashMap<>(Map.of(rocketFuel, 80.0, powerShard, 40.0)));
        itemLookupTable.put(ionizedFuel.itemName.toLowerCase(), ionizedFuel);

        // TIER 6: COMPOUND PARTS (depend on standard parts)
        CraftableItem screw = new CraftableItem("Screw", 40,
                new HashMap<>(Map.of(ironRod, 10.0)));
        itemLookupTable.put(screw.itemName.toLowerCase(), screw);

        CraftableItem cable = new CraftableItem("Cable", 30,
                new HashMap<>(Map.of(wire, 60.0)));
        itemLookupTable.put(cable.itemName.toLowerCase(), cable);

        CraftableItem reinforcedIronPlate = new CraftableItem("Reinforced Iron Plate", 5,
                new HashMap<>(Map.of(ironPlate, 30.0, screw, 60.0)));
        itemLookupTable.put(reinforcedIronPlate.itemName.toLowerCase(), reinforcedIronPlate);

        CraftableItem encasedIndustrialBeam = new CraftableItem("Encased Industrial Beam", 6,
                new HashMap<>(Map.of(steelBeam, 24.0, concrete, 30.0)));
        itemLookupTable.put(encasedIndustrialBeam.itemName.toLowerCase(), encasedIndustrialBeam);

        CraftableItem modularFrame = new CraftableItem("Modular Frame", 2,
                new HashMap<>(Map.of(reinforcedIronPlate, 3.0, ironRod, 12.0)));
        itemLookupTable.put(modularFrame.itemName.toLowerCase(), modularFrame);

        CraftableItem circuitBoard = new CraftableItem("Circuit Board", 7.5,
                new HashMap<>(Map.of(copperSheet, 15.0, plastic, 30.0)));
        itemLookupTable.put(circuitBoard.itemName.toLowerCase(), circuitBoard);

        CraftableItem aiLimiter = new CraftableItem("AI Limiter", 5,
                new HashMap<>(Map.of(copperSheet, 25.0, quickwire, 100.0)));
        itemLookupTable.put(aiLimiter.itemName.toLowerCase(), aiLimiter);

        CraftableItem rotor = new CraftableItem("Rotor", 4,
                new HashMap<>(Map.of(ironRod, 20.0, screw, 100.0)));
        itemLookupTable.put(rotor.itemName.toLowerCase(), rotor);

        CraftableItem stator = new CraftableItem("Stator", 5,
                new HashMap<>(Map.of(steelPipe, 15.0, wire, 40.0)));
        itemLookupTable.put(stator.itemName.toLowerCase(), stator);

        CraftableItem battery = new CraftableItem("Battery", 20,
                new HashMap<>(Map.of(sulfuricAcid, 50.0, aluminaSolution, 20.0, aluminumCasing, 10.0)));
        itemLookupTable.put(battery.itemName.toLowerCase(), battery);

        CraftableItem samFluctuator = new CraftableItem("SAM Fluctuator", 60,
                new HashMap<>(Map.of(reanimatedSAM, 60.0, wire, 50.0, steelPipe, 30.0)));
        itemLookupTable.put(samFluctuator.itemName.toLowerCase(), samFluctuator);

        // TIER 7: AMMUNITION AND EQUIPMENT
        CraftableItem ironRebar = new CraftableItem("Iron Rebar", 15,
                new HashMap<>(Map.of(ironRod, 15.0)));
        itemLookupTable.put(ironRebar.itemName.toLowerCase(), ironRebar);

        CraftableItem stunRebar = new CraftableItem("Stun Rebar", 10,
                new HashMap<>(Map.of(ironRebar, 10.0, quickwire, 50.0)));
        itemLookupTable.put(stunRebar.itemName.toLowerCase(), stunRebar);

        CraftableItem shatterRebar = new CraftableItem("Shatter Rebar", 5,
                new HashMap<>(Map.of(ironRebar, 10.0, quartzCrystal, 15.0)));
        itemLookupTable.put(shatterRebar.itemName.toLowerCase(), shatterRebar);

        CraftableItem explosiveRebar = new CraftableItem("Explosive Rebar", 5,
                new HashMap<>(Map.of(ironRebar, 10.0, smokelessPowder, 10.0, steelPipe, 10.0)));
        itemLookupTable.put(explosiveRebar.itemName.toLowerCase(), explosiveRebar);

        CraftableItem rifleAmmo = new CraftableItem("Rifle Ammo", 75,
                new HashMap<>(Map.of(copperSheet, 15.0, smokelessPowder, 10.0)));
        itemLookupTable.put(rifleAmmo.itemName.toLowerCase(), rifleAmmo);

        CraftableItem nobelisk = new CraftableItem("Nobelisk", 10,
                new HashMap<>(Map.of(blackPowder, 20.0, steelPipe, 20.0)));
        itemLookupTable.put(nobelisk.itemName.toLowerCase(), nobelisk);

        CraftableItem gasFilter = new CraftableItem("Gas Filter", 7.5,
                new HashMap<>(Map.of(coal, 37.5, rubber, 15.0, fabric, 15.0)));
        itemLookupTable.put(gasFilter.itemName.toLowerCase(), gasFilter);

        CraftableItem beacon = new CraftableItem("Beacon", 10,
                new HashMap<>(Map.of(ironPlate, 22.5, ironRod, 7.5, wire, 15.0, cable, 7.5)));
        itemLookupTable.put(beacon.itemName.toLowerCase(), beacon);

        // TIER 8: ADVANCED ELECTRONICS
        CraftableItem highSpeedConnector = new CraftableItem("High-Speed Connector", 3.75,
                new HashMap<>(Map.of(quickwire, 210.0, plastic, 37.5, circuitBoard, 3.75)));
        itemLookupTable.put(highSpeedConnector.itemName.toLowerCase(), highSpeedConnector);

        CraftableItem motor = new CraftableItem("Motor", 5,
                new HashMap<>(Map.of(rotor, 10.0, stator, 10.0)));
        itemLookupTable.put(motor.itemName.toLowerCase(), motor);

        CraftableItem heatSink = new CraftableItem("Heat Sink", 7.5,
                new HashMap<>(Map.of(alcladAluminumSheet, 37.5, copperSheet, 22.5)));
        itemLookupTable.put(heatSink.itemName.toLowerCase(), heatSink);

        CraftableItem crystalOscillator = new CraftableItem("Crystal Oscillator", 1,
                new HashMap<>(Map.of(quartzCrystal, 36.0, cable, 28.0, reinforcedIronPlate, 5.0)));
        itemLookupTable.put(crystalOscillator.itemName.toLowerCase(), crystalOscillator);

        CraftableItem electromagneticControlRod = new CraftableItem("Electromagnetic Control Rod", 4,
                new HashMap<>(Map.of(stator, 24.0, aiLimiter, 16.0)));
        itemLookupTable.put(electromagneticControlRod.itemName.toLowerCase(), electromagneticControlRod);

        // TIER 9: ADVANCED AMMUNITION
        CraftableItem homingRifleAmmo = new CraftableItem("Homing Rifle Ammo", 25,
                new HashMap<>(Map.of(rifleAmmo, 50.0, highSpeedConnector, 2.5)));
        itemLookupTable.put(homingRifleAmmo.itemName.toLowerCase(), homingRifleAmmo);

        CraftableItem turboRifleAmmo = new CraftableItem("Turbo Rifle Ammo", 125,
                new HashMap<>(Map.of(rifleAmmo, 125.0, aluminumCasing, 15.0, turbofuel, 15.0)));
        itemLookupTable.put(turboRifleAmmo.itemName.toLowerCase(), turboRifleAmmo);

        CraftableItem gasNobelisk = new CraftableItem("Gas Nobelisk", 5,
                new HashMap<>(Map.of(nobelisk, 5.0, biomass, 50.0)));
        itemLookupTable.put(gasNobelisk.itemName.toLowerCase(), gasNobelisk);

        CraftableItem pulseNobelisk = new CraftableItem("Pulse Nobelisk", 5,
                new HashMap<>(Map.of(nobelisk, 5.0, crystalOscillator, 1.0)));
        itemLookupTable.put(pulseNobelisk.itemName.toLowerCase(), pulseNobelisk);

        CraftableItem clusterNobelisk = new CraftableItem("Cluster Nobelisk", 2.5,
                new HashMap<>(Map.of(nobelisk, 7.5, smokelessPowder, 10.0)));
        itemLookupTable.put(clusterNobelisk.itemName.toLowerCase(), clusterNobelisk);

        CraftableItem iodineInfusedFilter = new CraftableItem("Iodine-Infused Filter", 3.75,
                new HashMap<>(Map.of(gasFilter, 3.75, quickwire, 30.0, aluminumCasing, 3.75)));
        itemLookupTable.put(iodineInfusedFilter.itemName.toLowerCase(), iodineInfusedFilter);

        // TIER 10: ADVANCED SYSTEMS
        CraftableItem heavyModularFrame = new CraftableItem("Heavy Modular Frame", 2,
                new HashMap<>(Map.of(modularFrame, 5.0, steelPipe, 15.0, encasedIndustrialBeam, 5.0, screw, 100.0)));
        itemLookupTable.put(heavyModularFrame.itemName.toLowerCase(), heavyModularFrame);

        CraftableItem computer = new CraftableItem("Computer", 2.5,
                new HashMap<>(Map.of(circuitBoard, 10.0, cable, 20.0, plastic, 40.0, screw, 2.5)));
        itemLookupTable.put(computer.itemName.toLowerCase(), computer);

        CraftableItem coolingSystem = new CraftableItem("Cooling System", 6,
                new HashMap<>(Map.of(heatSink, 12.0, rubber, 12.0, water, 30.0, nitrogenGas, 150.0)));
        itemLookupTable.put(coolingSystem.itemName.toLowerCase(), coolingSystem);

        CraftableItem encasedUraniumCell = new CraftableItem("Encased Uranium Cell", 25,
                new HashMap<>(Map.of(uranium, 50.0, concrete, 15.0, sulfuricAcid, 40.0)));
        itemLookupTable.put(encasedUraniumCell.itemName.toLowerCase(), encasedUraniumCell);

        // TIER 11: HIGH-END SYSTEMS
        CraftableItem fusedModularFrame = new CraftableItem("Fused Modular Frame", 1.5,
                new HashMap<>(Map.of(heavyModularFrame, 1.5, aluminumCasing, 75.0, nitrogenGas, 37.5)));
        itemLookupTable.put(fusedModularFrame.itemName.toLowerCase(), fusedModularFrame);

        CraftableItem radioControlUnit = new CraftableItem("Radio Control Unit", 2.5,
                new HashMap<>(Map.of(aluminumCasing, 80.0, crystalOscillator, 2.5, computer, 2.5)));
        itemLookupTable.put(radioControlUnit.itemName.toLowerCase(), radioControlUnit);

        CraftableItem supercomputer = new CraftableItem("Supercomputer", 1.875,
                new HashMap<>(Map.of(computer, 3.75, aiLimiter, 3.75, highSpeedConnector, 5.625, plastic, 52.5)));
        itemLookupTable.put(supercomputer.itemName.toLowerCase(), supercomputer);

        CraftableItem turboMotor = new CraftableItem("Turbo Motor", 1.875,
                new HashMap<>(Map.of(coolingSystem, 7.5, radioControlUnit, 3.75, motor, 7.5, rubber, 3.75)));
        itemLookupTable.put(turboMotor.itemName.toLowerCase(), turboMotor);

        CraftableItem uraniumFuelRod = new CraftableItem("Uranium Fuel Rod", 0.4,
                new HashMap<>(Map.of(encasedUraniumCell, 20.0, encasedIndustrialBeam, 1.2, electromagneticControlRod, 2.0)));
        itemLookupTable.put(uraniumFuelRod.itemName.toLowerCase(), uraniumFuelRod);

        CraftableItem pressureConversionCube = new CraftableItem("Pressure Conversion Cube", 2,
                new HashMap<>(Map.of(fusedModularFrame, 2.0, radioControlUnit, 4.0)));
        itemLookupTable.put(pressureConversionCube.itemName.toLowerCase(), pressureConversionCube);

        CraftableItem nukeNobelisk = new CraftableItem("Nuke Nobelisk", 0.5,
                new HashMap<>(Map.of(nobelisk, 2.5, encasedUraniumCell, 10.0, smokelessPowder, 5.0)));
        itemLookupTable.put(nukeNobelisk.itemName.toLowerCase(), nukeNobelisk);

        // TIER 12: SPACE ELEVATOR PARTS
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
        itemLookupTable.put(thermalPropulsionRocket.itemName.toLowerCase(), thermalPropulsionRocket);

        CraftableItem nuclearPasta = new CraftableItem("Nuclear Pasta", 0.5,
                new HashMap<>(Map.of(copperPowder, 100.0, pressureConversionCube, 0.5)));
        itemLookupTable.put(nuclearPasta.itemName.toLowerCase(), nuclearPasta);

        // TIER 13: QUANTUM/END-GAME ITEMS
        CraftableItem superpositionOscillator = new CraftableItem("Superposition Oscillator", 3.75,
                new HashMap<>(Map.of(darkMatterCrystal, 22.5, crystalOscillator, 3.75, alcladAluminumSheet, 67.5, excitedPhotonicMatter, 37.5)));
        itemLookupTable.put(superpositionOscillator.itemName.toLowerCase(), superpositionOscillator);

        CraftableItem neuralQuantumProcessor = new CraftableItem("Neural-Quantum Processor", 3,
                new HashMap<>(Map.of(timeCrystal, 15.0, superpositionOscillator, 6.0, ficsiteTrigon, 45.0, excitedPhotonicMatter, 15.0)));
        itemLookupTable.put(neuralQuantumProcessor.itemName.toLowerCase(), neuralQuantumProcessor);

        CraftableItem alienPowerMatrix = new CraftableItem("Alien Power Matrix", 2.5,
                new HashMap<>(Map.of(samFluctuator, 5.0, superpositionOscillator, 5.0, excitedPhotonicMatter, 20.0)));
        itemLookupTable.put(alienPowerMatrix.itemName.toLowerCase(), alienPowerMatrix);

        CraftableItem singularityCell = new CraftableItem("Singularity Cell", 10,
                new HashMap<>(Map.of(nuclearPasta, 1.0, darkMatterCrystal, 20.0, ironPlate, 100.0, concrete, 200.0)));
        itemLookupTable.put(singularityCell.itemName.toLowerCase(), singularityCell);

        // TIER 14: ULTIMATE END-GAME
        CraftableItem ficsonium = new CraftableItem("Ficsonium", 10,
                new HashMap<>(Map.of(uraniumFuelRod, 10.0, singularityCell, 10.0, darkMatterResidue, 40.0)));
        itemLookupTable.put(ficsonium.itemName.toLowerCase(), ficsonium);

        CraftableItem ficsoniumFuelRod = new CraftableItem("Ficsonium Fuel Rod", 2.5,
                new HashMap<>(Map.of(ficsonium, 2.5, electromagneticControlRod, 2.5, darkMatterCrystal, 100.0)));
        itemLookupTable.put(ficsoniumFuelRod.itemName.toLowerCase(), ficsoniumFuelRod);

        CraftableItem biochemicalSculptor = new CraftableItem("Biochemical Sculptor", 1,
                new HashMap<>(Map.of(assemblyDirectorSystem, 1.0, neuralQuantumProcessor, 1.0, alcladAluminumSheet, 50.0)));
        itemLookupTable.put(biochemicalSculptor.itemName.toLowerCase(), biochemicalSculptor);

        CraftableItem ballisticWarpDrive = new CraftableItem("Ballistic Warp Drive", 1,
                new HashMap<>(Map.of(thermalPropulsionRocket, 1.0, singularityCell, 5.0, superpositionOscillator, 2.0, darkMatterCrystal, 40.0)));
        itemLookupTable.put(ballisticWarpDrive.itemName.toLowerCase(), ballisticWarpDrive);

        CraftableItem aiExpansionServer = new CraftableItem("AI Expansion Server", 2.5,
                new HashMap<>(Map.of(magneticFieldGenerator, 2.5, neuralQuantumProcessor, 2.5, supercomputer, 2.5, coolingSystem, 5.0)));
        itemLookupTable.put(aiExpansionServer.itemName.toLowerCase(), aiExpansionServer);
    }
}