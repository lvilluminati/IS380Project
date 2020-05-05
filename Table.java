/**
 * IS 380 Final Project - Restaurant Point of Sale program.
 * @author Jason Jasper, David Martin-Vaquero, Jared Mclaren, Regine Villongco, Chemen Wong
 * @version 0.1.0
 *
 * This is the Table class. This class controls orders for every table and provides functions for
 * checking to see if a table is available and instantiating new instances of Order.
 */
public class Table {

    private int tableNumber;
    private boolean hasOrder;
    private Order thisOrder;

    /**
    Constructor for table, no parameters passed.
    */
    public Table() {

    }

    /**
	Constructor for table.
	@param A table number.
    */
    public Table(int tableNum) {
        hasOrder = false;
        tableNumber = tableNum;
        System.out.println("Table #"+tableNum+" Created!!");
    }

    /**
	Method for creating a new order.
    @param A table number.
    */
    protected void startNewOrder(int tableNumber) {
        Order order = new Order(tableNumber);
        //this.setAvailable(true);
        hasOrder = true;
        thisOrder = order;
        System.out.println("Order started for Table "+tableNumber);
    }

    /**
	Method to remove an order.
	*/
    protected void disposeOrder() {
        int orderNum = thisOrder.getOrderNumber();
        System.out.println("Order #" + orderNum + " Being destroyed.");
        thisOrder = null;
        hasOrder = false;
    }

    /**
	Method to get an order note.
	@return An order note.
	*/
    protected String getOrderNote() {
        return thisOrder.getOrderNote();
    }

    /**
	Method to set an order note.
	@param An order note.
	*/
    protected void setOrderNote(String note) {
        thisOrder.setOrderNote(note);
    }
    /**
    Method to set table availability.
	@param Status of table availability.
	*/
    private void setAvailable (boolean status) {
        hasOrder = status;
    }

    /**
	Method to get subtotal.
	@param A table number.
	*/
    protected void getSubtotal(int tableNumber) {
        System.out.println(String.format("%.2f", thisOrder.getSubTotal()));
    }

    /**
	Method to get sub amount.
	@param A table number.
	*/
    protected double getSubAmount(int tableNumber) {
        return thisOrder.getSubTotal();
    }

    /**
	Method to add food items to order.
	@param An order index number.
	@param Quantity of food items.
	*/
    protected void addFoodItemsToOrder(int orderIndex, int quantity) {
        for (int i=0; i<quantity; i++) {
            thisOrder.addFoodItems(orderIndex);
        }
    }

    /**
	Method to add beverage items to order.
	@param An order index number.
	@param Quantity of beverage items.
	*/
    protected void addBeverageItemsToOrder(int orderIndex, int quantity) {
        for (int i=0; i<quantity; i++) {
            thisOrder.addBeverageItems(orderIndex);
        }
    }

    /**
	Method to get list of items.
	@return Array of items in the order.
	*/
    protected String[] getItemList() {
        return thisOrder.getOrderItemList();
    }
    /**
	Method to check if table is available.
	@return Boolean value for table availability.
	*/
    public boolean isAvailable () {
        return !hasOrder;
    }
}
