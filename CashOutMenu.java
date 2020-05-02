import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
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
 * CashOut menu will include tax breakdown, tip, cash handled and change amount
 */

// Todo: Setup tips increment/decrement, 5% interval with [0-25%]
// Todo: Add something to show current tip percentage
// Todo: Allow of input to tip textpane to update both tipDouble and Grand total
// Todo: Cancel button should return to prior menu and leave order alone
// Todo: Cashout button destroys order for table and shows amount of change needed

public class CashOutMenu extends JFrame {
    private JLabel subAmount = new JLabel();
    private JLabel taxAmount = new JLabel();
    private JLabel noTaxTotalAmount = new JLabel();
    private JTextPane tipAmount = new JTextPane();
    private JTextPane totalAmount = new JTextPane();
    private double tipPercent = 0.15;
    private double taxRate = 0.08375;
    private double subDouble;
    private double tipDouble;
    private double taxDouble;
    private double totalDouble;
    private int orderNumber;
    public static DecimalFormat df2 = new DecimalFormat("#0.00");

    public CashOutMenu(int tableNumber) {
        orderNumber = tableNumber;
        System.out.println("Order #" + tableNumber + " processing for cashout");
        initComponent();
        createElements();
    }

    private void createElements(){
        JPanel subtotalContainer = new JPanel();
        JPanel taxContainer = new JPanel();
        JPanel notaxContainer = new JPanel();
        JPanel tipContainer = new JPanel();
        JPanel totalContainer = new JPanel();

        subtotalContainer.setBorder(BorderFactory.createTitledBorder(null, "Subtotal",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 18)));
        taxContainer.setBorder(BorderFactory.createTitledBorder(null, "Sales Tax",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 18)));
        notaxContainer.setBorder(BorderFactory.createTitledBorder(null, "Total",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 18)));
        tipContainer.setBorder(BorderFactory.createTitledBorder(null, "Tip",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 18)));
        totalContainer.setBorder(BorderFactory.createTitledBorder(null, "Grand Total",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 18)));
        {// sub elements
            JButton decrementQuantity = new JButton("-");
            decrementQuantity.setActionCommand("decreaseTip");
            decrementQuantity.addActionListener(new ButtonListener());
            decrementQuantity.setPreferredSize(new Dimension(50, 30));
            decrementQuantity.setFont(new Font("Tahoma", Font.PLAIN, 10));

            JButton incrementQuantity = new JButton("+");
            incrementQuantity.setActionCommand("increaseTip");
            incrementQuantity.addActionListener(new ButtonListener());
            incrementQuantity.setPreferredSize(new Dimension(50, 30));
            incrementQuantity.setFont(new Font("Tahoma", Font.PLAIN, 10));

            // initial calculated values
            subDouble = RestaurantPOS.tableArray[orderNumber - 1].getSubAmount(orderNumber);
            taxDouble = taxRate * subDouble;
            tipDouble = tipPercent * subDouble;
            totalDouble = subDouble + taxDouble + tipDouble;
            // update in increment/decrement buttonlistener

            SimpleAttributeSet center = new SimpleAttributeSet();

            subAmount = new JLabel();
            subAmount.setPreferredSize(new Dimension(300, 24));

            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            subAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
            subAmount.setText(df2.format(subDouble));

            taxAmount = new JLabel();
            taxAmount.setPreferredSize(new Dimension(300, 24));
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            taxAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
            taxAmount.setText(df2.format(taxDouble));

            noTaxTotalAmount = new JLabel();
            noTaxTotalAmount.setPreferredSize(new Dimension(300, 24));
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            noTaxTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
            noTaxTotalAmount.setText(df2.format(subDouble + taxDouble));

            tipAmount = new JTextPane();
            tipAmount.setPreferredSize(new Dimension(300, 24));
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            StyledDocument doc = tipAmount.getStyledDocument();
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
            tipAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
            tipAmount.setText(df2.format(tipDouble));

            totalAmount = new JTextPane();
            totalAmount.setPreferredSize(new Dimension(300, 24));
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
            totalAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
            totalAmount.setText(df2.format(totalDouble));


            subtotalContainer.add(subAmount);
            taxContainer.add(taxAmount);
            notaxContainer.add(noTaxTotalAmount);
            tipContainer.add(decrementQuantity);
            tipContainer.add(tipAmount);
            tipContainer.add(incrementQuantity);
            totalContainer.add(totalAmount);
        }
        cashPanel.add(subtotalContainer);
        cashPanel.add(taxContainer);
        cashPanel.add(notaxContainer);
        cashPanel.add(tipContainer);
        cashPanel.add(totalContainer);


    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("increaseTip")) {
                tipPercent = tipPercent + 0.05;
                tipDouble = tipPercent * subDouble;
                totalDouble = subDouble + taxDouble + tipDouble;
                tipAmount.setText(df2.format(tipDouble));
                totalAmount.setText(df2.format(totalDouble));
            } else if (e.getActionCommand().equals("decreaseTip") && tipPercent >= 0.05) {
                tipPercent = tipPercent - 0.05;
                tipDouble = tipPercent * subDouble;
                totalDouble = subDouble + taxDouble + tipDouble;
                tipAmount.setText(df2.format(tipDouble));
                totalAmount.setText(df2.format(totalDouble));
            }
        }
    }
    private void cashOutButtonActionPerformed(ActionEvent e) {

        this.dispose();
    }
    private void deleteButtonActionPerformed(ActionEvent e) {
        RestaurantPOS.tableArray[orderNumber - 1].disposeOrder();
        this.dispose();
    }
    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponent() {
        cashPanel = new JPanel();
        addButton = new JButton();
        subButton = new JButton();
        cashOutButton = new JButton();
        deleteButton = new JButton();
        cancelButton = new JButton();
        actionPanel = new JPanel();

        //======== set dimensions ========
        setTitle("Cash Out");
        var contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        setSize(645, 465);
        setLocationRelativeTo(getOwner());

        {

            actionPanel.setLayout(new GridLayout(1, 3, 10, 0));

            //---- Buttons ----
            cashOutButton.setText("Cash Out");
            cashOutButton.setPreferredSize(new Dimension(80, 60));
            cashOutButton.setFont(new Font("Tahoma", Font.BOLD, 18));
            cashOutButton.addActionListener(e -> cashOutButtonActionPerformed(e));
            actionPanel.add(cashOutButton);

            deleteButton.setText("Delete Order");
            deleteButton.setPreferredSize(new Dimension(80, 60));
            deleteButton.setFont(new Font("Tahoma", Font.BOLD, 18));
            deleteButton.addActionListener(e -> deleteButtonActionPerformed(e));
            actionPanel.add(deleteButton);

            cancelButton.setText("Cancel");
            cancelButton.setPreferredSize(new Dimension(80, 60));
            cancelButton.setFont(new Font("Tahoma", Font.BOLD, 18));
            cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
            actionPanel.add(cancelButton);
        }
        contentPane.setLayout(new BorderLayout());
        contentPane.add(actionPanel, BorderLayout.PAGE_END);
        contentPane.add(cashPanel);
    }

    private JPanel cashPanel;
    private JButton addButton;
    private JButton subButton;
    private JButton cashOutButton;
    private JButton deleteButton;
    private JButton cancelButton;
    private JPanel actionPanel;
}
