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
 * Sub-Total button will provide the sub-total amount
 */

public class SubTotalMenu extends JFrame 
{
    private JLabel subTotal = new JLabel();
    private double subDouble;
    private int orderNumber;
    public static DecimalFormat df2 = new DecimalFormat("#0.00");
    private JPanel subTotalPanel;
    private JButton okButton;
    private JPanel actionPanel;
    private JLabel message;

    /**
    Constructor for the sub-total menu.
    */
    
    public SubTotalMenu(int tableNumber) 
    {
        orderNumber = tableNumber;
        System.out.println("Order #" + tableNumber + " processing for subtotal");
        initComponent();
        createElements();
    }
    
    /**
    Method for creating panes, labels, and buttons for the sub-total menu.
    */
    
    private void createElements(){
        JPanel subtotalContainer = new JPanel();
        JPanel messageContainer = new JPanel(); 
        SimpleAttributeSet center = new SimpleAttributeSet();

        // Set sub-total pane's characteristics.
        subtotalContainer.setBorder(BorderFactory.createTitledBorder(null, "Subtotal Amount:",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 18)));
        
        // Message to the user. 
        messageContainer.setBorder(BorderFactory.createTitledBorder(null, "To Checkout:", 
        		TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
        		new Font("Tahoma", Font.PLAIN, 18)));
        
        {
       
            // Calculated values.
            subDouble = RestaurantPOS.tableArray[orderNumber - 1].getSubAmount(orderNumber);

            // Create sub-total label and set its size.
            subTotal = new JLabel();
            subTotal.setPreferredSize(new Dimension(300, 24));

            // Set sub-total label's text characteristics.
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            subTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
            subTotal.setText(df2.format(subDouble));
            
            // Create message label and set its size. 
            message = new JLabel(); 
            message.setPreferredSize(new Dimension(300, 24));
            
            // Set message label's text characteristics 
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER); 
            message.setFont(new Font("Tahoma", Font.PLAIN, 12));
            message.setText("Click 'Ok' then click 'Cash Out' and then select table #");
           
            // Add labels and buttons to the panes.
            subtotalContainer.add(subTotal);
            messageContainer.add(message);
        }
        
        // Add the panes to the sub-total panel.
        subTotalPanel.add(subtotalContainer);
        subTotalPanel.add(messageContainer);

    }

    /**
	Method for the ok's button action.
    */
    
    private void cancelButtonActionPerformed(ActionEvent e) 
    {
        this.dispose();
    }

    /**
    Method for creating the sub-total panel and buttons.
    */
    
    private void initComponent() 
    {
    	subTotalPanel = new JPanel();
        okButton = new JButton();
        actionPanel = new JPanel();

        //======== set dimensions ========
        setTitle("Sub-Total Information");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        setSize(450, 290);
        setLocationRelativeTo(getOwner());

        {
            actionPanel.setLayout(new GridLayout(1, 3, 10, 0));

            // Set cancel button's characteristics.
            okButton.setText("Ok");
            okButton.setPreferredSize(new Dimension(20, 60));
            okButton.setFont(new Font("Tahoma", Font.BOLD, 18));
            okButton.addActionListener(e -> cancelButtonActionPerformed(e));
            actionPanel.add(okButton);
        }
        
        //  Set content pane's layout.
        contentPane.setLayout(new BorderLayout());
        
        // Add the panels to content pane.
        contentPane.add(actionPanel, BorderLayout.PAGE_END);
        contentPane.add(subTotalPanel);
    }

}
