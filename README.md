# Printer Usage Report Application

## Overview

The Printer Usage Report application is a Java-based GUI tool that allows users to track and report ink usage for different printers over several years. Users can select a specific printer and year to view ink usage, or generate a report summarizing total ink usage across all years for each printer.

## Features

- User-friendly GUI for selecting printers and years.
- Displays specific ink usage for a selected printer and year.
- Generates a summary report of total ink usage for each printer across all years.
- Exit option available in the menu.

## Components

- **Printers Class**: The main class that sets up the GUI, handles user interactions, and processes ink usage data.

## Installation

1. Ensure you have Java Development Kit (JDK) installed on your machine.
2. Clone or download this repository to your local machine.
3. Navigate to the project directory.

## Usage

To run the application:

1. Open your terminal or command prompt.
2. Navigate to the project directory.
3. Compile the Java file using:
   ```bash
   javac Printers.java
   ```
4. Run the application using:
   ```bash
   java Printers
   ```

## User Interface

1. **Select Printer**: Choose a printer from the dropdown menu.
2. **Select Year**: Choose a year from the dropdown menu.
3. **Submit Button**: Click to view ink usage for the selected printer and year.
4. **Menu Bar**: Access the "File" menu to exit the application or the "Tools" menu to submit or generate a yearly usage report.

## Example Output

When you select a printer and a year and click "Submit," a dialog will display ink usage like this:

```
PRINTER: HP DeskJet 650
YEAR: 2019
USAGE: 35
```

Selecting "Yearly Usage" from the tools menu will show a report like this:

```
Total cartridges for HP DeskJet 650 is 65
Total cartridges for Epson K750 is 49
Total cartridges for Canon Z100 is 94
```

## Conclusion

This application provides an efficient way to manage and report on printer ink usage, making it a valuable tool for users who need to monitor cartridge consumption over time.
