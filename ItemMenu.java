import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
/**
 * @author Jason Jasper
 * This class initializes a menu that will add items/orders to a table specified.
 */
public class ItemMenu extends JFrame {
    private int tableNumber;
    final private String[] menuItems = {"BLT", "Chicken Pot Pie", "10\" Pizza", "Pasta", "Soup of the Day", "Salad",
            "Burger and Fries", "Bacon and Eggs"};
    final private String[] beverageItems = {"Water", "Soda", "Coffee", "Tea", "Milk", "Juice"};

    public ItemMenu(int tableNum) {
        tableNumber = tableNum;
        initComponents();
        setTitle("Table "+tableNumber);
        createItemPanels();
        createBeveragePanels();

        //Orders.getOrders(tableNumber);
    }

    private void createItemPanels() {
        JPanel mainContainer = new JPanel();
        for (int i=0; i<menuItems.length; i++) {  //FOR EACH MENU ITEM IN THE ARRAY
            //CREATE A JPANEL
            JPanel itemContainer = new JPanel();

            //CREATE AND SET A TITLED BORDER FOR EACH MENU ITEM
            itemContainer.setBorder(BorderFactory.createTitledBorder(null, menuItems[i],
                    TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                    new Font("Tahoma", Font.PLAIN, 14)));

            //CREATE THE ITEM DECREMENT BUTTON, SET BUTTON FONT SIZE, AND BUTTON SIZE
            JButton decrementQuantity = new JButton("-");
            decrementQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
            decrementQuantity.setPreferredSize(new Dimension(50, 50));

            //CREATE THE TEXT BOX TO HOLD ITEM QUANTITY, AND SET THE PREFERRED SIZE OF TEXT BOX
            JTextPane itemQuantity = new JTextPane();
            itemQuantity.setPreferredSize(new Dimension(30, 30));

            //SET THE ALIGN CENTER, FONT SIZE, AND INITIALIZE THE QUANTITY TO ZERO
            StyledDocument doc = itemQuantity.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
            itemQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
            itemQuantity.setText("0");

            //CREATE THE ITEM INCREMENT BUTTON, SET BUTTON FONT SIZE, AND BUTTON SIZEc
            JButton incrementQuantity = new JButton("+");
            incrementQuantity.setPreferredSize(new Dimension(50, 50));
            incrementQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));

            //ADD ALL THE ITEMS TO THE ITEM CONTAINER
            itemContainer.add(decrementQuantity);
            itemContainer.add(itemQuantity);
            itemContainer.add(incrementQuantity);
            mainContainer.add(itemContainer);
        }
        //ADD THE ITEM CONTAINERS TO THE MAIN CONTAINERS
       foodPanel.add(mainContainer);
    }

    private void createBeveragePanels() {
        JPanel mainContainer = new JPanel();
        for (int i=0; i<beverageItems.length; i++) {  //FOR EACH MENU ITEM IN THE ARRAY
            //CREATE A JPANEL
            JPanel beverageContainer = new JPanel();

            //CREATE AND SET A TITLED BORDER FOR EACH MENU ITEM
            beverageContainer.setBorder(BorderFactory.createTitledBorder(null, beverageItems[i],
                    TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                    new Font("Tahoma", Font.PLAIN, 14)));

            //CREATE THE ITEM DECREMENT BUTTON, SET BUTTON FONT SIZE, AND BUTTON SIZE
            JButton decrementQuantity = new JButton("-");
            decrementQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
            decrementQuantity.setPreferredSize(new Dimension(50, 50));

            //CREATE THE TEXT BOX TO HOLD ITEM QUANTITY, AND SET THE PREFERRED SIZE OF TEXT BOX
            JTextPane itemQuantity = new JTextPane();
            itemQuantity.setPreferredSize(new Dimension(30, 30));

            //SET THE ALIGN CENTER, FONT SIZE, AND INITIALIZE THE QUANTITY TO ZERO
            StyledDocument doc = itemQuantity.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
            itemQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
            itemQuantity.setText("0");

            //CREATE THE ITEM INCREMENT BUTTON, SET BUTTON FONT SIZE, AND BUTTON SIZEc
            JButton incrementQuantity = new JButton("+");
            incrementQuantity.setPreferredSize(new Dimension(50, 50));
            incrementQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));

            //ADD ALL THE ITEMS TO THE ITEM CONTAINER
            beverageContainer.add(decrementQuantity);
            beverageContainer.add(itemQuantity);
            beverageContainer.add(incrementQuantity);
            mainContainer.add(beverageContainer);
        }
        //ADD THE ITEM CONTAINERS TO THE MAIN CONTAINERS
        beveragePanel.add(mainContainer);
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void addButtonActionPerformed(ActionEvent e) {
        //Todo: Add code to check if ANYTHING has been added to the order. if not, then skip this..
        if (true) {
            if (RestaurantPOS.isTableAvailable(tableNumber)) {
                System.out.println("Table " + tableNumber + " has no order. Starting new order...");
                RestaurantPOS.tableArray[tableNumber - 1].startNewOrder(tableNumber);
            } else {
                System.out.println("Table " + tableNumber + " has an order, adding to order");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jason Jasper
        tabbedPane1 = new JTabbedPane();
        foodPanel = new JPanel();
        itemPanel = new JPanel();
        actionPanel = new JPanel();
        addButton = new JButton();
        cancelButton = new JButton();
        beveragePanel = new JPanel();
        beverageItemPanel = new JPanel();
        beverageActionPanel = new JPanel();
        addButton2 = new JButton();
        cancelButton2 = new JButton();

        //======== this ========
        setTitle("Table");
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(new Font("Tahoma", Font.PLAIN, 36));

            //======== foodPanel ========
            {
                /*foodPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
                .EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder.CENTER,javax
                .swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067",java.awt.Font.BOLD,
                12),java.awt.Color.red),foodPanel. getBorder()));foodPanel. addPropertyChangeListener(new java.beans
                .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072".equals(e.
                getPropertyName()))throw new RuntimeException();}});*/
                foodPanel.setLayout(new BorderLayout());

                //======== itemPanel ========
                {
                    itemPanel.setLayout(new GridLayout());
                }
                foodPanel.add(itemPanel, BorderLayout.CENTER);

                //======== actionPanel ========
                {
                    actionPanel.setLayout(new GridLayout());

                    //---- addButton ----
                    addButton.setText("ADD");
                    addButton.setPreferredSize(new Dimension(55, 60));
                    addButton.setFont(new Font("Tahoma", Font.BOLD, 18));
                    addButton.addActionListener(e -> addButtonActionPerformed(e));
                    actionPanel.add(addButton);

                    //---- cancelButton ----
                    cancelButton.setText("Cancel");
                    cancelButton.setPreferredSize(new Dimension(63, 60));
                    cancelButton.setFont(new Font("Tahoma", Font.BOLD, 18));
                    cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                    actionPanel.add(cancelButton);
                }
                foodPanel.add(actionPanel, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("Food", foodPanel);

            //======== beveragePanel ========
            {
                beveragePanel.setLayout(new BorderLayout());

                //======== beverageItemPanel ========
                {
                    beverageItemPanel.setLayout(new GridLayout());
                }
                beveragePanel.add(beverageItemPanel, BorderLayout.CENTER);

                //======== beverageActionPanel ========
                {
                    beverageActionPanel.setLayout(new GridLayout());

                    //---- addButton2 ----
                    addButton2.setText("ADD");
                    addButton2.setPreferredSize(new Dimension(55, 60));
                    addButton2.setFont(new Font("Tahoma", Font.BOLD, 18));
                    addButton2.addActionListener(e -> addButtonActionPerformed(e));
                    beverageActionPanel.add(addButton2);

                    //---- cancelButton2 ----
                    cancelButton2.setText("Cancel");
                    cancelButton2.setPreferredSize(new Dimension(63, 60));
                    cancelButton2.setFont(new Font("Tahoma", Font.BOLD, 18));
                    cancelButton2.addActionListener(e -> cancelButtonActionPerformed(e));
                    beverageActionPanel.add(cancelButton2);
                }
                beveragePanel.add(beverageActionPanel, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("Beverage", beveragePanel);
        }
        contentPane.add(tabbedPane1);
        setSize(645, 465);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jason Jasper
    private JTabbedPane tabbedPane1;
    private JPanel foodPanel;
    private JPanel itemPanel;
    private JPanel actionPanel;
    private JButton addButton;
    private JButton cancelButton;
    private JPanel beveragePanel;
    private JPanel beverageItemPanel;
    private JPanel beverageActionPanel;
    private JButton addButton2;
    private JButton cancelButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
