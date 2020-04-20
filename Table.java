public class Table {
    /*
    THIS CLASS WILL STORE TABLE DATA.
    THE HIERARCHY SHOULD BE TABLE HAS AN ORDER HAS ITEMS.
    RIGHT NOW THERE ARE NINE TABLES WHICH IS HARD CODED.
     */

    private int tableNumber;
    private boolean hasOrder;
    private Order thisOrder;

    public Table() {

    }

    public Table(int tableNum) {
        hasOrder = false;
        tableNumber = tableNum;
        System.out.println("Table #"+tableNum+" Created!!");
    }

    protected void startNewOrder(int tableNumber) {
        Order order = new Order(tableNumber);
        //this.setAvailable(true);
        hasOrder = true;
        thisOrder = order;
        System.out.println("Order started for Table "+tableNumber);
    }

    protected void disposeOrder() {
        int orderNum = thisOrder.getOrderNumber();
        System.out.println("Order #" + orderNum + " Being destroyed.");
        thisOrder = null;
        hasOrder = false;
    }

    protected String getOrderNote() {
        return thisOrder.getOrderNote();
    }

    protected void setOrderNote(String note) {
        thisOrder.setOrderNote(note);
    }
    private void setAvailable (boolean status) {
        hasOrder = status;
    }

    public boolean isAvailable () {
        return !hasOrder;
    }
}
