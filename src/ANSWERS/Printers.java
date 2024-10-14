package ANSWERS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Printers 
{
    // 2D array to store ink usage data for each printer over the years
    private static final int[][] inkUsage = 
    {
        {10, 15, 30},  // 2018
        {35, 22, 31},  // 2019
        {20, 12, 33}   // 2020
    };

    // Array of printer names
    private static final String[] printers = 
    {
        "HP DeskJet 650", 
        "Epson K750", 
        "Canon Z100"
    };

    // Array of years for which ink usage data is available
    private static final String[] years = 
    {
        "2018", 
        "2019", 
        "2020"
    };

    // GUI components
    private JFrame frame;                // Main application window
    private JComboBox<String> printerComboBox;  // Dropdown for printer selection
    private JComboBox<String> yearComboBox;     // Dropdown for year selection
    private JButton submitButton;        // Button to submit the selection

    public Printers() 
    {
        // Set the look and feel to the system's default for better aesthetics
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize the main application frame
        frame = new JFrame("Cartridge Usage");
        frame.setSize(400, 300); // Set the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        frame.setLayout(new GridBagLayout()); // Use GridBagLayout for layout management
        GridBagConstraints gbc = new GridBagConstraints(); // Constraints for positioning components

        // Add printer selection label and combo box
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing around components
        gbc.gridx = 0; gbc.gridy = 0; // Position for label
        frame.add(new JLabel("Select Printer:"), gbc); // Add label

        printerComboBox = new JComboBox<>(printers); // Initialize printer combo box
        gbc.gridx = 1; gbc.gridy = 0; // Position for combo box
        frame.add(printerComboBox, gbc); // Add combo box

        // Add year selection label and combo box
        gbc.gridx = 0; gbc.gridy = 1; // Position for label
        frame.add(new JLabel("Select Year:"), gbc); // Add label

        yearComboBox = new JComboBox<>(years); // Initialize year combo box
        gbc.gridx = 1; gbc.gridy = 1; // Position for combo box
        frame.add(yearComboBox, gbc); // Add combo box

        // Add submit button
        submitButton = new JButton("Submit"); // Create submit button
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; // Position for button (span across two columns)
        gbc.anchor = GridBagConstraints.CENTER; // Center the button
        frame.add(submitButton, gbc); // Add button
        
        // Add action listener to the submit button
        submitButton.addActionListener(e -> showInkUsage());

        // Set up the menu bar
        setupMenu();

        frame.setVisible(true); // Make the frame visible
    }

    // Method to set up the menu bar
    private void setupMenu() 
    {
        JMenuBar menuBar = new JMenuBar(); // Create a menu bar
        JMenu fileMenu = new JMenu("File"); // Create file menu
        JMenuItem exitMenuItem = new JMenuItem("Exit"); // Create exit menu item

        // Action for exit menu item
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem); // Add exit item to file menu
        menuBar.add(fileMenu); // Add file menu to menu bar

        // Create tools menu with actions
        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.add(createMenuItem("Submit", e -> showInkUsage())); // Add submit action
        toolsMenu.add(createMenuItem("Yearly Usage", e -> showReport())); // Add report action
        menuBar.add(toolsMenu); // Add tools menu to menu bar

        frame.setJMenuBar(menuBar); // Set menu bar in the frame
    }

    // Helper method to create a menu item
    private JMenuItem createMenuItem(String text, ActionListener action) 
    {
        JMenuItem menuItem = new JMenuItem(text); // Create menu item
        menuItem.addActionListener(action); // Add action listener
        return menuItem; // Return the created menu item
    }

    // Method to show ink usage for the selected printer and year
    private void showInkUsage() 
    {
        int printerIndex = printerComboBox.getSelectedIndex(); // Get selected printer index
        int yearIndex = yearComboBox.getSelectedIndex(); // Get selected year index
        int inkUsed = inkUsage[yearIndex][printerIndex]; // Get ink used based on selections

        // Show ink usage in a dialog
        JOptionPane.showMessageDialog(frame,
                String.format("PRINTER: %s\nYEAR: %s\nUSAGE: %d",
                printers[printerIndex], years[yearIndex], inkUsed),
                "Cartridge Usage", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to show total ink usage report for each printer
    private void showReport() 
    {
        StringBuilder report = new StringBuilder(); // StringBuilder for constructing report
        for (int i = 0; i < printers.length; i++) // Loop through each printer
        {
            int total = 0; // Initialize total cartridges used for the printer
            for (int j = 0; j < years.length; j++) // Loop through years
            {
                total += inkUsage[j][i]; // Sum ink usage for each year
            }
            report.append(String.format("Total cartridges for %s is %d\n", printers[i], total)); // Append to report
        }

        // Show the complete report in a dialog
        JOptionPane.showMessageDialog(frame, report.toString(), "Usage Report", JOptionPane.INFORMATION_MESSAGE);
    }

    // Main method to run the application
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(Printers::new); // Launch the GUI on the Event Dispatch Thread
    }
}
