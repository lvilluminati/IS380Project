import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
/**
 * IS 380 Final Project - Restaurant Point of Sale program.
 * @author Jason Jasper, David Martin-Vaquero, Jared Mclaren, Regine Villongco, Chemen Wong
 * @version 0.1.0
 *
 * This is the ItemMenu class. This class initializes a menu that will add items/orders to a table specified.
 * The user presses the plus or minus buttons to increment/decrement item quantities. Once done, the user clicks
 * the ADD button, and the items are added to the current table (order).
 *
 */
public class ItemMenu extends JFrame {
    private int tableNumber;
    final private String[] menuItems = {"BLT", "Chicken Pot Pie", "10\" Pizza", "Pasta", "Soup of the Day", "Salad",
            "Burger and Fries", "Bacon and Eggs"};
    final private String[] beverageItems = {"Water", "Soda", "Coffee", "Tea", "Milk", "Juice"};
    final private String[] menuIncrement = {"mIncrement0", "mIncrement1", "mIncrement2", "mIncrement3", "mIncrement4",
    "mIncrement5", "mIncrement6", "mIncrement7"};
    final private String[] menuDecrement = {"mDecrement0", "mDecrement1", "mDecrement2", "mDecrement3", "mDecrement4",
    "mDecrement5", "mDecrement6", "mDecrement7"};
    final private String[] beverageIncrement = {"bIncrement0", "bIncrement1", "bIncrement2", "bIncrement3", "bIncrement4",
    "bIncrement5"};
	final private String[] beverageDecrement = {"bDecrement0", "bDecrement1", "bDecrement2", "bDecrement3", "bDecrement4",
    "bDecrement5"};
    private JTextPane[] menuItemQuantity = new JTextPane[8];
    private JTextPane[] beverageItemQuantity = new JTextPane[6];

    /**
    Constructor for item menu.
    @param A table number.
    */
    public ItemMenu(int tableNum) {
        tableNumber = tableNum;
        initComponents();
        setTitle("Table "+tableNumber);
        createItemPanels();
        createBeveragePanels();
    }

    /**
    Method for creating food item panels.
    */
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
            //Todo: Add code that decrements count in Text Pane but not negative numbers
            JButton decrementQuantity = new JButton("-");
            decrementQuantity.setActionCommand(menuDecrement[i]);
            decrementQuantity.addActionListener(new ButtonListener());
            decrementQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
            decrementQuantity.setPreferredSize(new Dimension(50, 50));

            //CREATE THE TEXT BOX TO HOLD ITEM QUANTITY, AND SET THE PREFERRED SIZE OF TEXT BOX
            menuItemQuantity[i] = new JTextPane();
            menuItemQuantity[i].setPreferredSize(new Dimension(30, 30));

            //SET THE ALIGN CENTER, FONT SIZE, AND INITIALIZE THE QUANTITY TO ZERO
            StyledDocument doc = menuItemQuantity[i].getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
            menuItemQuantity[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
            menuItemQuantity[i].setText("0");

            //CREATE THE ITEM INCREMENT BUTTON, SET BUTTON FONT SIZE, AND BUTTON SIZE
            //Todo: Add code that increments the Text Pane
            JButton incrementQuantity = new JButton("+");
            incrementQuantity.setActionCommand(menuIncrement[i]);
            incrementQuantity.addActionListener(new ButtonListener());
            incrementQuantity.setPreferredSize(new Dimension(50, 50));
            incrementQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));

            //ADD ALL THE ITEMS TO THE ITEM CONTAINER
            itemContainer.add(decrementQuantity);
            itemContainer.add(menuItemQuantity[i]);
            itemContainer.add(incrementQuantity);
            mainContainer.add(itemContainer);
        }
        //ADD THE ITEM CONTAINERS TO THE MAIN CONTAINERS
       foodPanel.add(mainContainer);
    }

    /**
    Method for creating beverage item panels.
    */
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
            decrementQuantity.setActionCommand(beverageDecrement[i]);
            decrementQuantity.addActionListener(new ButtonListener());
            decrementQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
            decrementQuantity.setPreferredSize(new Dimension(50, 50));

            //CREATE THE TEXT BOX TO HOLD ITEM QUANTITY, AND SET THE PREFERRED SIZE OF TEXT BOX
            beverageItemQuantity[i] = new JTextPane();
            beverageItemQuantity[i].setPreferredSize(new Dimension(30, 30));

            //SET THE ALIGN CENTER, FONT SIZE, AND INITIALIZE THE QUANTITY TO ZERO
            StyledDocument doc = beverageItemQuantity[i].getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
            beverageItemQuantity[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
            beverageItemQuantity[i].setText("0");

            //CREATE THE ITEM INCREMENT BUTTON, SET BUTTON FONT SIZE, AND BUTTON SIZEc
            JButton incrementQuantity = new JButton("+");
            incrementQuantity.setActionCommand(beverageIncrement[i]);
            incrementQuantity.addActionListener(new ButtonListener());
            incrementQuantity.setPreferredSize(new Dimension(50, 50));
            incrementQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));

            //ADD ALL THE ITEMS TO THE ITEM CONTAINER
            beverageContainer.add(decrementQuantity);
            beverageContainer.add(beverageItemQuantity[i]);
            beverageContainer.add(incrementQuantity);
            mainContainer.add(beverageContainer);
        }
        //ADD THE ITEM CONTAINERS TO THE MAIN CONTAINERS
        beveragePanel.add(mainContainer);
    }

    // Private inner class for button actions.
    private class ButtonListener implements ActionListener
    {
		/**
		Override actionPerformed method.
		@param ActionEvent object generated.
		*/
		public void actionPerformed(ActionEvent e)
		{
		    for (int i=0; i<menuIncrement.length; i++) {
                if (e.getActionCommand().equals(menuIncrement[i])) {
                    // Action for incrementing food item.
                    menuItemQuantity[i].setText(Integer.toString(Integer.parseInt(menuItemQuantity[i].getText()) + 1));
                }
                else if (e.getActionCommand().equals(menuDecrement[i])) {
                    if (Integer.parseInt(menuItemQuantity[i].getText()) > 0) {
                        // Action for decrementing food item.
                        menuItemQuantity[i].setText(Integer.toString(Integer.parseInt(menuItemQuantity[i].getText()) - 1));
                    }
                }
            }
                for (int j=0; j<beverageIncrement.length; j++) {
		        if (e.getActionCommand().equals(beverageIncrement[j])) {
                    // Action for incrementing beverage item.
                    beverageItemQuantity[j].setText(Integer.toString(Integer.parseInt(beverageItemQuantity[j].getText()) + 1));
                }
		        else if (e.getActionCommand().equals(beverageDecrement[j])) {
                    if (Integer.parseInt(beverageItemQuantity[j].getText()) > 0)
                    {
						// Action for decrementing beverage item.
                        beverageItemQuantity[j].setText(Integer.toString(Integer.parseInt(beverageItemQuantity[j].getText()) - 1));
                    }
                }
            }
		}
	}

    /**
    Method for cancel button's action.
    @param ActionEvent object generated.
    */
    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    /**
	Method for add button's action.
	@param ActionEvent object generated.
    */
    private void addButtonActionPerformed(ActionEvent e) {
        //Todo: Add code to check if ANYTHING has been added to the order. if not, then skip this..
        if (RestaurantPOS.isTableAvailable(tableNumber)) {
            // Action to add order to an empty table.
            System.out.println("Table " + tableNumber + " has no order. Starting new order...");
            RestaurantPOS.tableArray[tableNumber - 1].startNewOrder(tableNumber);
            int[] foodItemArray = tallyFoodItems();
            int[] beverageItemArray = tallyBeverageItems();
            for (int j=0; j<menuItems.length; j++) {
                if (foodItemArray[j] > 0) {  //If this particular item is added
                        RestaurantPOS.tableArray[tableNumber - 1].addFoodItemsToOrder(j, foodItemArray[j]); //For each Item, add a new item with that quantity
                }
            }
            for (int i=0; i<beverageItems.length; i++) {
                if (beverageItemArray[i] > 0) {  //If this particular item is added
                        RestaurantPOS.tableArray[tableNumber - 1].addBeverageItemsToOrder(i, beverageItemArray[i]); //For each Item, add a new item with that quantity
                }
            }
        } else {
            // Action to add order to a table that has a previous order.
            System.out.println("Table " + tableNumber + " has an order, adding to order");
            int[] foodItemArray = tallyFoodItems();
            int[] beverageItemArray = tallyBeverageItems();
            for (int j=0; j<menuItems.length; j++) {
                if (foodItemArray[j] > 0) {  //If this particular item is added
                        RestaurantPOS.tableArray[tableNumber - 1].addFoodItemsToOrder(j, foodItemArray[j]); //For each Item, add a new item with that quantity
                }
            }
            for (int i=0; i<beverageItems.length; i++) {
                if (beverageItemArray[i] > 0) {  //If this particular item is added
                        RestaurantPOS.tableArray[tableNumber - 1].addBeverageItemsToOrder(i, beverageItemArray[i]); //For each Item, add a new item with that quantity
                }
            }
        }

        this.dispose(); //Close window after adding.
    }
    /**
	Method for keeping a count of food items.
	*/
    private int[] tallyFoodItems() {
        int[] foodItemCount = new int[menuItems.length];
        for (int i=0; i<menuItems.length; i++) {
			// Total all food item text boxes.
            try {
                foodItemCount[i] = Integer.parseInt(menuItemQuantity[i].getText());

            }
            catch (Exception e) {
				//  Catch invalid text boxes.
                System.out.println("Dont type things in the item quantity boxes.");
                menuItemQuantity[i].setText("0"); //Over ride whatever they typed in the box to 0;
            }
        }
        return foodItemCount;
    }

    /**
	Method for keeping a count of beverage items.
	*/
    private int[] tallyBeverageItems() {
        int[] beverageItemCount = new int[beverageItems.length];
        for (int i=0; i<beverageItems.length; i++) {
            // Total all beverage item text boxes.
            try {
                beverageItemCount[i] = Integer.parseInt(beverageItemQuantity[i].getText());

            }
            catch (Exception e) {  //If unable to parse an integer, it means they typed into the box somehow.
                // Catch invalid text boxes.
                System.out.println("Dont type things in the item quantity boxes!!");
                beverageItemQuantity[i].setText("0"); //Over ride whatever they typed in the box to 0;
            }
        }
        return beverageItemCount;
    }
    /**
    Method for creating panes and buttons.
    */
    private void initComponents() {
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
    }

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

}
