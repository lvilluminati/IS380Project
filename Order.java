import java.util.ArrayList;

/**
 * IS 380 Final Project - Restaurant Point of Sale program.
 * @author Jason Jasper, David Martin-Vaquero, Jared Mclaren, Regine Villongco, Chemen Wong
 * @version 0.1.0
 *
 * This is the Order class. It is the object abstraction that will hold all the different orders
 * for tables. Table is the parent class since Order belongs to Table.
 */
public class Order extends Table {
    /*
    THIS CLASS WILL STORE ORDER DATA.
    THE HIERARCHY SHOULD BE TABLE HAS AN ORDER HAS ITEMS.
    ONLY ONE ORDER PER TABLE.
    */

    static int orderNumbers;        //INCREMENT (COUNT) ORDER NUMBERS.
    private int thisOrderNumber;
    private int tableNumber;
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private String orderNote = "";

    /**
    Constructor for order, no parameters passed.
    */
    public Order() {

    }

    /**
	Constructor for order.
	@param A table number.
    */
    public Order(int tableNum) {
        orderNumbers++;
        thisOrderNumber = orderNumbers; //Retain current order number.
        tableNumber = tableNum;
        System.out.println("Order #" + thisOrderNumber + " For Table #" + tableNumber + " Created.");
        //Table.startNewOrder(tableNumber);
    }
    //Todo: Finish this method that adds items to an order.
    /**
	Method to add food items to array.
	@param Item's index number.
    */
    public void addFoodItems(int itemIndex) {
        itemList.add(new Item(itemIndex, "Food"));
        Item thisguy = itemList.get(itemList.size()-1);
        System.out.println(thisguy.getItemName());
    }
    //Todo: Finish this method that subtracts/deletes items from an order.
    /**
    Method to subtract food items from array.
    @param ArrayList index number.
    */
    public void subFoodItems(int arrayListIndex) {
        itemList.remove(arrayListIndex);
    }
    /**
	Method to add beverage items to array.
    @param Item's index number.
    */
    public void addBeverageItems(int itemIndex) {
        itemList.add(new Item(itemIndex, "Beverage"));
        Item thisguy = itemList.get(itemList.size()-1);
        System.out.println(thisguy.getItemName());
    }
    //Todo: Finish this method that subtracts/deletes items from an order.
    /**
	Method to subtract beverage items from array.
    @param ArrayList index number.
    */
    public void subBeverageItems(int arrayListIndex) {
        itemList.remove(arrayListIndex);
    }

    /**
    Method for setting order note.
    @param Order note.
    */
    public void setOrderNote (String note) {
        this.orderNote = note;
    }

    /**
	Method for getting order note.
    @return Order note.
    */
    public String getOrderNote() {
        return this.orderNote;
    }

    /**
    Method for getting order number.
	@return Order number.
    */
    public int getOrderNumber() {
        return thisOrderNumber;
    }

    /**
    Method to get subtotal.
	@return Subtotal.
    */
    public double getSubTotal() {
        double subtotal = 0;
        for (int i=0; i<itemList.size(); i++) {
            // Total item's prices.
            Item tallyItem = itemList.get(i);
            subtotal += tallyItem.getItemPrice();
            //tallyItem = null; //Send unused object to garbage collection not necessary when falls out of loop
            System.out.println("Subtotal: " + subtotal);
        }
        return subtotal;
    }

    /**
	Method to get order items, ignoring comped items..
	@return Array of order items.
    */
    public String[] getOrderItemList() {
        String[] thisItemList = new String[itemList.size()];
        for (int i=0; i<itemList.size(); i++) {
            Item listItem = itemList.get(i);
            if (!listItem.getComped()) {  //If the item isn't comped, add it to the list. This also adds very small blank lines to the list.
                // Add non-comped items to the array.
                thisItemList[i] = listItem.getItemName();
            }
        }
        return thisItemList;
    }

    /**
	Method to get total order items including comped items.
	@return Array of order items.
    */
    public String[] getTotalOrderItemList() {
        String[] thisItemList = new String[itemList.size()];
        for (int i=0; i<itemList.size(); i++) {
            // Add items to the array.
            Item listItem = itemList.get(i);

        }
        return thisItemList;
    }
}
