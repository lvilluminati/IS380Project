import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * IS 380 Final Project - Restaurant Point of Sale program.
 * @author Jason Jasper, David Martin-Vaquero, Jared Mclaren, Regine Villongco, Chemen Wong
 * @version 0.1.0
 *
 * This is the Order Window GUI component. This class controls all the functionality of being able to select a
 * order function, which consists of:
 * Add - Adds an item(s) to an Order.
 * Sub - Subtracts (deletes) an item(s) from an Order.
 * Comp - Comps an item(s) for an order. This is where the item is basically given for free to the customer.
 * Note - This adds a note/special instructions to an order, i.e. Mild/Medium/Hot
 * Sub-Total - This calculates a current sub-total for an order.
 * Cash Out - This tenders the total amount for the order, archives the order data (for reporting), and destroys
 *            the Order object associated with a table so a new one can be made.
 *
 * Once a function is selected, a table can then be selected, opening up the appropriate GUI window for that function.
 *
 */
public class OrderMenu extends JFrame {

    private String functionSelected;

    public OrderMenu() {
        initComponents();
        //Todo: Set table button color based on whether it has an order or not.
        //this.setVisible(true);
    }
    private void tableButtonActionPerformed(ActionEvent e) {
        String tableString = e.getActionCommand();
        int tableNum = Integer.parseInt(tableString);
        System.out.println(functionSelected + " function on Table " + tableNum);

        if (this.functionSelected.equals("Add")) {
            if (RestaurantPOS.isTableAvailable(tableNum)) {
                System.out.println("Table " + tableNum+ " is available.");
                //RestaurantPOS.tableArray[tableNum-1].startNewOrder(tableNum); I need to move this to ItemMenu
            }
            else { System.out.println("Table " + tableNum + " has an order"); }

            ItemMenu itemMenu = new ItemMenu(tableNum);
            itemMenu.setVisible(true);
        }
        if (this.functionSelected.equals("Sub")) {
            RemoveItemMenu subMenu = new RemoveItemMenu(tableNum);
            subMenu.setVisible(true);
        }
        if (this.functionSelected.equals("Comp")) {
            CompItemMenu compMenu = new CompItemMenu(tableNum);
            compMenu.setVisible(true);
        }
        if (this.functionSelected.equals("Note")) {
            if (RestaurantPOS.isTableAvailable(tableNum)) {
                System.out.println("Table "+tableNum+" does NOT have an order to put a note on.");
            }
            else { System.out.println("Table " + tableNum + " opening note window");
            OrderNoteMenu noteMenu = new OrderNoteMenu(tableNum);
            noteMenu.setVisible(true);
            }
        }
        if (this.functionSelected.equals("Subtotal")) {
            if (RestaurantPOS.isTableAvailable(tableNum)) {
                System.out.println("Table "+tableNum+" does NOT have an order to subtotal.");
            }
            else {
                System.out.println("Table " + tableNum + " getting subtotal!");
                RestaurantPOS.tableArray[tableNum - 1].getSubtotal(tableNum);
            }
        }
        if (this.functionSelected.equals("Close")) {
            if (RestaurantPOS.isTableAvailable(tableNum)) {
                System.out.println("Table "+tableNum+" does NOT have an order to close.");
            }
            else {
                System.out.println("Table " + tableNum + " closing out order!");
                CashOutMenu cashOutMenu = new CashOutMenu(tableNum);
                cashOutMenu.setVisible(true);
            }
        }
    }
    private void backButtonActionPerformed(ActionEvent e) {
        /*
        MainMenu haha = new MainMenu();

        haha.setVisible(true);
        this.setVisible(false);
         */
        //Using dispose to close window rather than hiding it, this should fix a bug that keeps
        //the color coding on the buttons from working more than once.
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        this.dispose();
    }

    private void addbuttonActionPerformed(ActionEvent e) {
        this.enableTableButtons();
        addbutton.setForeground(Color.white);
        addbutton.setBackground(Color.red );
        subButton.setForeground(null);
        subButton.setBackground(null);
        compButton.setForeground(null);
        compButton.setBackground(null);
        noteButton.setForeground(null);
        noteButton.setBackground(null);
        subTotalButton.setForeground(null);
        subTotalButton.setBackground(null);
        cashOutButton.setForeground(null);
        cashOutButton.setBackground(null);
        this.functionSelected = "Add";
    }

    private void subButtonActionPerformed(ActionEvent e) {
        this.enableTableButtons();
        addbutton.setForeground(null);
        addbutton.setBackground(null);
        subButton.setForeground(Color.white);
        subButton.setBackground(Color.red);
        compButton.setForeground(null);
        compButton.setBackground(null);
        noteButton.setForeground(null);
        noteButton.setBackground(null);
        subTotalButton.setForeground(null);
        subTotalButton.setBackground(null);
        cashOutButton.setForeground(null);
        cashOutButton.setBackground(null);
        this.functionSelected = "Sub";
    }

    private void compButtonActionPerformed(ActionEvent e) {
        this.enableTableButtons();
        addbutton.setForeground(null);
        addbutton.setBackground(null);
        subButton.setForeground(null);
        subButton.setBackground(null);
        compButton.setForeground(Color.white);
        compButton.setBackground(Color.red);
        noteButton.setForeground(null);
        noteButton.setBackground(null);
        subTotalButton.setForeground(null);
        subTotalButton.setBackground(null);
        cashOutButton.setForeground(null);
        cashOutButton.setBackground(null);
        this.functionSelected = "Comp";
    }

    private void noteButtonActionPerformed(ActionEvent e) {
        this.enableTableButtons();
        addbutton.setForeground(null);
        addbutton.setBackground(null);
        subButton.setForeground(null);
        subButton.setBackground(null);
        compButton.setForeground(null);
        compButton.setBackground(null);
        noteButton.setForeground(Color.white);
        noteButton.setBackground(Color.red);
        subTotalButton.setForeground(null);
        subTotalButton.setBackground(null);
        cashOutButton.setForeground(null);
        cashOutButton.setBackground(null);
        this.functionSelected = "Note";
    }

    private void subTotalButtonActionPerformed(ActionEvent e) {
        this.enableTableButtons();
        addbutton.setForeground(null);
        addbutton.setBackground(null);
        subButton.setForeground(null);
        subButton.setBackground(null);
        compButton.setForeground(null);
        compButton.setBackground(null);
        noteButton.setForeground(null);
        noteButton.setBackground(null);
        subTotalButton.setForeground(Color.white);
        subTotalButton.setBackground(Color.red);
        cashOutButton.setForeground(null);
        cashOutButton.setBackground(null);
        this.functionSelected = "Subtotal";
    }

    private void cashOutButtonActionPerformed(ActionEvent e) {
        this.enableTableButtons();
        addbutton.setForeground(null);
        addbutton.setBackground(null);
        subButton.setForeground(null);
        subButton.setBackground(null);
        compButton.setForeground(null);
        compButton.setBackground(null);
        noteButton.setForeground(null);
        noteButton.setBackground(null);
        subTotalButton.setForeground(null);
        subTotalButton.setBackground(null);
        cashOutButton.setForeground(Color.white);
        cashOutButton.setBackground(Color.red);
        this.functionSelected = "Close";
    }

    private void enableTableButtons() {
        tablePanel.setEnabled(true);
        table1.setEnabled(true);
        table2.setEnabled(true);
        table3.setEnabled(true);
        table4.setEnabled(true);
        table5.setEnabled(true);
        table6.setEnabled(true);
        table7.setEnabled(true);
        table8.setEnabled(true);
        table9.setEnabled(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jason Jasper
        label1 = new JLabel();
        tablePanel = new JPanel();
        table1 = new JButton();
        table2 = new JButton();
        table3 = new JButton();
        table4 = new JButton();
        table5 = new JButton();
        table6 = new JButton();
        table7 = new JButton();
        table8 = new JButton();
        table9 = new JButton();
        hSpacer1 = new JPanel(null);
        hSpacer2 = new JPanel(null);
        bottomPanel = new JPanel();
        operationsPanel = new JPanel();
        addbutton = new JButton();
        subButton = new JButton();
        compButton = new JButton();
        noteButton = new JButton();
        functionsPanel = new JPanel();
        backButton = new JButton();
        subTotalButton = new JButton();
        cashOutButton = new JButton();

        //======== this ========
        setTitle("Orders");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10));

        //---- label1 ----
        label1.setText("Select a Table");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, BorderLayout.NORTH);

        //======== tablePanel ========
        {
            tablePanel.setPreferredSize(new Dimension(300, 200));
            tablePanel.setEnabled(false);
            /*tablePanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067",java.awt.Font
            .BOLD,12),java.awt.Color.red),tablePanel. getBorder()));tablePanel. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072"
            .equals(e.getPropertyName()))throw new RuntimeException();}});*/
            tablePanel.setLayout(new GridLayout(3, 3, 5, 5));

            //---- table1 ----
            table1.setText("1");
            table1.setFont(new Font("Tahoma", Font.PLAIN, 18));
            table1.setEnabled(false);
            table1.addActionListener(e -> tableButtonActionPerformed(e));
            tablePanel.add(table1);

            //---- table2 ----
            table2.setText("2");
            table2.setFont(new Font("Tahoma", Font.PLAIN, 18));
            table2.setEnabled(false);
            table2.addActionListener(e -> tableButtonActionPerformed(e));
            tablePanel.add(table2);

            //---- table3 ----
            table3.setText("3");
            table3.setFont(new Font("Tahoma", Font.PLAIN, 18));
            table3.setEnabled(false);
            table3.addActionListener(e -> tableButtonActionPerformed(e));
            tablePanel.add(table3);

            //---- table4 ----
            table4.setText("4");
            table4.setFont(new Font("Tahoma", Font.PLAIN, 18));
            table4.setEnabled(false);
            table4.addActionListener(e -> tableButtonActionPerformed(e));
            tablePanel.add(table4);

            //---- table5 ----
            table5.setText("5");
            table5.setFont(new Font("Tahoma", Font.PLAIN, 18));
            table5.setEnabled(false);
            table5.addActionListener(e -> tableButtonActionPerformed(e));
            tablePanel.add(table5);

            //---- table6 ----
            table6.setText("6");
            table6.setFont(new Font("Tahoma", Font.PLAIN, 18));
            table6.setEnabled(false);
            table6.addActionListener(e -> tableButtonActionPerformed(e));
            tablePanel.add(table6);

            //---- table7 ----
            table7.setText("7");
            table7.setFont(new Font("Tahoma", Font.PLAIN, 18));
            table7.setEnabled(false);
            table7.addActionListener(e -> tableButtonActionPerformed(e));
            tablePanel.add(table7);

            //---- table8 ----
            table8.setText("8");
            table8.setFont(new Font("Tahoma", Font.PLAIN, 18));
            table8.setEnabled(false);
            table8.addActionListener(e -> tableButtonActionPerformed(e));
            tablePanel.add(table8);

            //---- table9 ----
            table9.setText("9");
            table9.setFont(new Font("Tahoma", Font.PLAIN, 18));
            table9.setEnabled(false);
            table9.addActionListener(e -> tableButtonActionPerformed(e));
            tablePanel.add(table9);
        }
        contentPane.add(tablePanel, BorderLayout.CENTER);
        contentPane.add(hSpacer1, BorderLayout.WEST);
        contentPane.add(hSpacer2, BorderLayout.EAST);

        //======== bottomPanel ========
        {
            bottomPanel.setPreferredSize(new Dimension(1000, 150));
            bottomPanel.setLayout(new BorderLayout(5, 5));

            //======== operationsPanel ========
            {
                operationsPanel.setPreferredSize(new Dimension(500, 56));
                operationsPanel.setLayout(new GridLayout(2, 1, 10, 10));

                //---- addbutton ----
                addbutton.setText("Add");
                addbutton.setFont(new Font("Tahoma", Font.PLAIN, 28));
                addbutton.addActionListener(e -> addbuttonActionPerformed(e));
                operationsPanel.add(addbutton);

                //---- subButton ----
                subButton.setText("Sub");
                subButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
                subButton.addActionListener(e -> subButtonActionPerformed(e));
                operationsPanel.add(subButton);

                //---- compButton ----
                compButton.setText("Comp");
                compButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
                compButton.addActionListener(e -> compButtonActionPerformed(e));
                operationsPanel.add(compButton);

                //---- noteButton ----
                noteButton.setText("Note");
                noteButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
                noteButton.addActionListener(e -> noteButtonActionPerformed(e));
                operationsPanel.add(noteButton);
            }
            bottomPanel.add(operationsPanel, BorderLayout.CENTER);

            //======== functionsPanel ========
            {
                functionsPanel.setLayout(new GridLayout(1, 3, 10, 0));

                //---- backButton ----
                backButton.setText("Back");
                backButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
                backButton.setForeground(Color.red);
                backButton.addActionListener(e -> backButtonActionPerformed(e));
                functionsPanel.add(backButton);

                //---- subTotalButton ----
                subTotalButton.setText("Sub-Total");
                subTotalButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
                subTotalButton.addActionListener(e -> subTotalButtonActionPerformed(e));
                functionsPanel.add(subTotalButton);

                //---- cashOutButton ----
                cashOutButton.setText("Cash Out");
                cashOutButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
                cashOutButton.addActionListener(e -> cashOutButtonActionPerformed(e));
                functionsPanel.add(cashOutButton);
            }
            bottomPanel.add(functionsPanel, BorderLayout.PAGE_END);
        }
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
        setSize(930, 580);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jason Jasper
    private JLabel label1;
    private JPanel tablePanel;
    private JButton table1;
    private JButton table2;
    private JButton table3;
    private JButton table4;
    private JButton table5;
    private JButton table6;
    private JButton table7;
    private JButton table8;
    private JButton table9;
    private JPanel hSpacer1;
    private JPanel hSpacer2;
    private JPanel bottomPanel;
    private JPanel operationsPanel;
    private JButton addbutton;
    private JButton subButton;
    private JButton compButton;
    private JButton noteButton;
    private JPanel functionsPanel;
    private JButton backButton;
    private JButton subTotalButton;
    private JButton cashOutButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
