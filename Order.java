import java.util.ArrayList;

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

    public void addItemsToOrder(Item[] items) {

    }

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
