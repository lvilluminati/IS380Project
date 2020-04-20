import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.beans.JavaBean;

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
