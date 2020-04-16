import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class RestaurantPOS {

    public static void main(String[] args) {
    //TopWindowClass topClass = new TopWindowClass();
    //new TopWindowClass();
        MainMenu mainWindow = new MainMenu();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ya done fucked up");
        }
        mainWindow.setVisible(true);
    }
}
