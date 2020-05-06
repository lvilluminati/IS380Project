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
 * This is the CompItemMenu class. This is the GUI component to list order items. A JList holds the current
 * items in the order, the user selects items to comp (items that are free but not deleted off the order).
 *
 */
public class CompItemMenu extends JFrame {
    private int tableNumber;
    private String[] itemArray;

    /**
    Constructor for creating comp item menu.
    @param A table number.
    */
    public CompItemMenu(int tableNum) {
        tableNumber = tableNum;
        constructItemArray();
        initComponents();
        setTitle("Table "+tableNumber+" Select item(s) to comp.");
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
    */
    private void okButtonActionPerformed() {
        int[] itemArray = itemList.getSelectedIndices();
        System.out.println("Comping item indices: " + Arrays.toString(itemArray));
        int itemCount = 0;  //This is necessary to avoid out of bound indices.
        for (int i=0; i<itemArray.length; i++) {  //Loop through each index in array and remove.
            RestaurantPOS.tableArray[tableNumber-1].compFoodItemsFromOrder(itemArray[i]-itemCount);  //Remove item at readjusted index.
            itemCount++;
        }
        JOptionPane.showMessageDialog(null,itemArray.length+" item(s) comped.",
                "Items Comped", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    /**
    Method for creating panes and buttons.
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
        setTitle("Select Item(s) To Comp");
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
                okButton.addActionListener(e -> okButtonActionPerformed());
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
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(400, 375);
        setLocationRelativeTo(getOwner());
    }

    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane itemScrollPane1;
    private JList itemList;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
}
