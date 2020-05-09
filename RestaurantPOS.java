import javax.swing.*;
import java.awt.*;

/**
 * IS 380 Final Project - Restaurant Point of Sale program.
 * @author Jason Jasper, David Martin-Vaquero, Jared Mclaren, Regine Villongco, Chemen Wong
 * @version 0.1.0
 *
 * This is the main class. It generates 9 Table objects in an array. It also gives application wide
 * access to the Table method isAvailable(tableNum)
 */

public class RestaurantPOS {

    public static Table[] tableArray;

    // Main method for creating the restaurant point of sale GUI.
    public static void main(String[] args) {
        //Instantiate 9 Table objects.
        tableArray = new Table[9];

        for (int i=0; i<9; i++) {
            // Create table array elements.
            tableArray[i] = new Table(i+1);
        }


        // Create main window and set its look and feel.
        MainMenu mainWindow = new MainMenu();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error setting the Look and Feel!");
        }
        mainWindow.setVisible(true);
    }

    /**
    Method for checking if tables are in use.
    @return Boolean value to determine table availability.
    */
    public static boolean isTableAvailable(int tableNum) {
        return tableArray[tableNum-1].isAvailable();
    }
}
