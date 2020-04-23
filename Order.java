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
    private ArrayList<Item> itemList;
    private String orderNote = "";

    public Order() {

    }

    public Order(int tableNum) {
        orderNumbers++;
        thisOrderNumber = orderNumbers; //Retain current order number.
        tableNumber = tableNum;
        System.out.println("Order #" + thisOrderNumber + " For Table #" + tableNumber + " Created.");
        //Table.startNewOrder(tableNumber);
    }
    //Todo: Finish this method that adds items to an order.
    public void addItemsToOrder(Item[] items) {

    }
    //Todo: Finish this method that subtracts/deletes items from an order.
    public void subItemsFromOrder(Item[] items) {

    }

    public void setOrderNote (String note) {
        this.orderNote = note;
    }

    public String getOrderNote() {
        return this.orderNote;
    }

    public int getOrderNumber() {
        return thisOrderNumber;
    }
}
