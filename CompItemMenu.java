import java.awt.*;
import java.awt.event.*;
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
    // Todo: Add code that removes selected items from the order. The function should go in Order class.
    private String[] temporaryItems = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
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
        this.dispose();
    }

    /**
    Method for creating panes and buttons.
    */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jason Jasper
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        itemScrollPane1 = new JScrollPane();
        itemList = new JList(itemArray);
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Select Item(s) To Comp");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {   /*
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
            0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
            .BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt.Color.
            red),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
            beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}});
            */
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jason Jasper
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane itemScrollPane1;
    private JList itemList;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
