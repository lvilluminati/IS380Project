import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * IS 380 Final Project - Restaurant Point of Sale program.
 * @author Jason Jasper, David Martin-Vaquero, Jared Mclaren, Regine Villongco, Chemen Wong
 * @version 0.1.0
 *
 * This is the Main Menu GUI component. There are only 3 options, the Order screen, the Reports screen, and Exit.
 * Order opens up the main portion of this app where the user can Add, Subtract, Comp, and add Notes to orders.
 * Reports opens up a Report window (not yet implemented)
 * Exit closes the entire App.
 *
 */
public class MainMenu extends JFrame {
    public JFrame orderWindow;
    public MainMenu() {
        initComponents();
        //Commenting this out to fix color coded button bug - Not working
        orderWindow = new OrderMenu();
        orderWindow.setVisible(false);
    }

    /**
    Method for exit button's action.
    @param ActionEvent object generated.
    */
    private void exitButtonActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    /**
	Method for order button's action.
	@param ActionEvent object generated.
    */
    private void orderButtonActionPerformed(ActionEvent e) {
        orderWindow.setVisible(true);
        this.setVisible(false);
        /*
        OrderMenu orderWindow = new OrderMenu();
        orderWindow.setVisible(true);
        this.dispose();
        */
    }

    /**
    Method to hide main menu.
    */
    public void hideMain() {
        this.setVisible(false);
    }

    /**
    Method to show main menu.
    */
    public void showMain() {
        this.setVisible(true);
    }

    /**
    Method to create buttons.
    */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jason Jasper
        orderButton = new JButton();
        reportButton = new JButton();
        exitButton = new JButton();

        //======== this ========
        setTitle("Main Menu");
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 1, 10, 10));

        //---- orderButton ----
        orderButton.setText("Orders");
        orderButton.setFont(new Font("Arial Black", Font.BOLD, 26));
        orderButton.addActionListener(e -> orderButtonActionPerformed(e));
        contentPane.add(orderButton);

        //---- reportButton ----
        reportButton.setText("Reports");
        reportButton.setFont(new Font("Arial Black", Font.BOLD, 26));
        contentPane.add(reportButton);

        //---- exitButton ----
        exitButton.setText("Exit");
        exitButton.setFont(exitButton.getFont().deriveFont(exitButton.getFont().getSize() + 10f));
        exitButton.addActionListener(e -> exitButtonActionPerformed(e));
        contentPane.add(exitButton);
        setSize(605, 435);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jason Jasper
    private JButton orderButton;
    private JButton reportButton;
    private JButton exitButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
