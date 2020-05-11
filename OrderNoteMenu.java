// Jason Jasper
// David Martin-Vaquero
// Jared Mclaren
// Regine Villongco
// Chemen Wong
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * IS 380 Final Project - Restaurant Point of Sale program.
 * @author Jason Jasper, David Martin-Vaquero, Jared Mclaren, Regine Villongco, Chemen Wong
 * @version 0.1.0
 *
 * This is the OrderNote GUI component. This will add a text note (special instructions) to an existing order.
 * This does not check to make sure there is an active order first, that is done by OrderMenu. It will throw
 * an exception if a note is missing.
 *
 */
public class OrderNoteMenu extends JFrame {

    private int tableNumber;
    /**
    Constructor for order note menu.
    @param A table number.
    */
    public OrderNoteMenu(int tableNum) {
        tableNumber = tableNum;
        initComponents();
        this.setTitle("Table "+tableNumber+ " Add a Note to the Order.");
        try {
            orderNoteArea.setText(RestaurantPOS.tableArray[tableNumber-1].getOrderNote());
        }
        catch (Exception e) {
            System.out.println("ERROR RETRIEVING ORDER NOTE!!\n" + e.getMessage());
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
	Method for ok button's action.
	@param ActionEvent object generated.
    */
    private void okButtonActionPerformed(ActionEvent e) {
        String orderNote = orderNoteArea.getText();
        RestaurantPOS.tableArray[tableNumber-1].setOrderNote(orderNote);
        this.dispose();
    }

    /**
	Method for creating panels, text areas, and buttons.
    */
    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        orderNoteArea = new JTextArea();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Add Note to Order");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout());

                //======== scrollPane1 ========
                {
                    scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                    //---- orderNoteArea ----
                    orderNoteArea.setFont(new Font("Arial", Font.PLAIN, 13));
                    orderNoteArea.setLineWrap(true);
                    orderNoteArea.setWrapStyleWord(true);
                    scrollPane1.setViewportView(orderNoteArea);
                }
                // Add to content panel.
                contentPanel.add(scrollPane1, BorderLayout.CENTER);
            }
            // Add panel to dialog pane.
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

    }
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTextArea orderNoteArea;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
}
