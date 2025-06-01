# Satisfactory Production Calculator

A production calculator for the game Satisfactory that helps you plan your factory production chains and calculate required materials.

## For Users

### What does this do?

This calculator tells you exactly what materials you need to produce any item in Satisfactory. Just enter what you want to make and how much, and it shows you the complete breakdown of raw materials needed.

### Requirements

- **Java SDK 24** - [Download here](https://www.oracle.com/java/technologies/downloads/#jdk24-windows)
- Windows, Mac, or Linux

### Download

- **[Download RAR file][(https://github.com/ardaaboz/satisfactory-calculator/releases/download/v1.0.0/Satisfactory.Calculator.rar)]**(https://github.com/ardaaboz/satisfactory-calculator/releases)**


### How to Run

**Windows Users (Easiest):**
1. Extract the RAR file
2. Double-click `SatisfactoryCalculator.bat`

**Everyone Else:**
1. Extract the ZIP file
2. Open command prompt/terminal in the project folder
3. Type: `javac *.java` (press Enter)
4. Type: `java ProductionCalculator` (press Enter)

### How to Use

1. Run the program
2. Choose option 1 (Calculate)
3. Type the item name (like "Computer" or "motor")
4. Type how many you want per minute
5. See the complete list of materials needed

### Example

```
Please enter product name: Computer
How much would you like to produce? 10

Computer 10.0
	>Circuit Board, 40.0
		>Copper Sheet, 60.0
			>Copper Ingot, 120.0
				>Copper Ore, 120.0
		>Plastic, 120.0
			>Crude Oil, 120.0
	>Cable, 80.0
		>Wire, 240.0
			>Copper Ingot, 120.0
				>Copper Ore, 120.0
	>Plastic, 160.0
		>Crude Oil, 160.0
	>Screw, 10.0
		>Iron Rod, 2.5
			>Iron Ingot, 2.5
				>Iron Ore, 2.5
```

This tells you that to make 10 Computers per minute, you need 120 Copper Ore, 160 Crude Oil, and 2.5 Iron Ore per minute.

---

## For Developers

### How It Works

The calculator uses a recursive algorithm to break down any item into its base components. When you request an item, it:

1. Looks up the item in the database
2. Calculates production scaling based on desired output
3. Recursively processes each ingredient requirement
4. Continues until it reaches raw materials (items with no recipe)

### Design

**Data Structure:**
- Items stored as objects with production rates and recipe requirements
- HashMap provides O(1) lookup performance with case-insensitive keys
- Recursive relationships between items represent the production chain

**Core Components:**
- `CraftableItem` - Represents an item with production rate and ingredient requirements
- `GameItemDatabase` - Contains 80+ Satisfactory items with accurate recipes and rates
- `ProductionCalculator` - Main application with recursive calculation logic and user interface

**Key Features:**
- Per-minute production rates based on default Satisfactory recipes
- Recursive production chain analysis down to raw materials
- Console-based interface with hierarchical output formatting

The database contains all major Satisfactory items with their default production rates and recipe requirements, allowing accurate calculation of complex production chains.

## License

Open source project. Use and modify freely.

## Disclaimer

Not affiliated with Coffee Stain Studios. Satisfactory is property of Coffee Stain Studios.
