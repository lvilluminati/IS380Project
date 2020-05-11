// Jason Jasper
// David Martin-Vaquero
// Jared Mclaren
// Regine Villongco
// Chemen Wong
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.*;

/**
 * IS 380 Final Project - Restaurant Point of Sale program.
 * @author Jason Jasper, David Martin-Vaquero, Jared Mclaren, Regine Villongco, Chemen Wong
 * @version 0.1.0
 *
 * This is the RemoveItem GUI component. This will allow the user to select items from a list supplied by Order
 * which will be deleted from the order once the OK button is pressed.
 *
 */

public class RemoveItemMenu extends JFrame {
    private int tableNumber;
    private String[] itemArray;

    /**
    Constructor for remove item menu.
    @param A table number.
    */
    public RemoveItemMenu(int tableNum) {
        tableNumber = tableNum;
        constructItemArray();
        initComponents();
        setTitle("Table "+tableNumber+" Select item(s) to remove.");
    }

    /**
	Method for creating an item array.
    */
    private void constructItemArray() {
        itemArray = RestaurantPOS.tableArray[tableNumber-1].getItemList();
    }

    /**
	Method for cancel button's action.
	@param ActionEvent object generated.
    */
    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    /**
	Method for ok button's action.
	@param ActionEvent object generated.
    */
    private void okButtonActionPerformed(ActionEvent e) {
        int[] itemArray = itemList.getSelectedIndices();
        System.out.println("Deleting item indices: " + Arrays.toString(itemArray));
        int itemCount = 0;  //This is necessary to avoid out of bound indices.
        for (int i=0; i<itemArray.length; i++) {  //Loop through each index in array and remove.
            RestaurantPOS.tableArray[tableNumber-1].subFoodItemsFromOrder(itemArray[i]-itemCount);  //Remove item at readjusted index.
            itemCount++;
        }
        JOptionPane.showMessageDialog(null,itemArray.length+" item(s) removed.",
                "Items Removed", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    /**
	Method for creating panels, buttons, and lists.
    */
    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        itemScrollPane1 = new JScrollPane();
        itemList = new JList(itemArray);
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Select Item(s) To Remove");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout());

                //======== itemScrollPane1 ========
                {
                    itemScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                    //---- itemList ----
                    itemList.setFont(new Font("Tahoma", Font.PLAIN, 18));
                    itemScrollPane1.setViewportView(itemList);
                }
                contentPanel.add(itemScrollPane1, BorderLayout.CENTER);
            }
            // Add to content panel to dialog pane.
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            // Add buttons to dialog pane.
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        // Add to content pane.
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(400, 375);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane itemScrollPane1;
    private JList itemList;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
}
