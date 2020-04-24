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

//Demonstrating GitHub
public class RestaurantPOS {

    public static Table[] tableArray;

    public static void main(String[] args) {
    //TopWindowClass topClass = new TopWindowClass();
    //new TopWindowClass();

        tableArray = new Table[9];

        for (int i=0; i<9; i++) {
            tableArray[i] = new Table(i+1);
        }

        //Table table0 = new Table(1);
        //System.out.println(table0.isAvailable());

        MainMenu mainWindow = new MainMenu();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ya done fucked up");
        }
        mainWindow.setVisible(true);
    }

    public static boolean isTableAvailable(int tableNum) {
        return tableArray[tableNum-1].isAvailable();
    }
}
