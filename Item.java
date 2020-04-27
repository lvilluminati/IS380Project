/**
 * IS 380 Final Project - Restaurant Point of Sale program.
 * @author Jason Jasper, David Martin-Vaquero, Jared Mclaren, Regine Villongco, Chemen Wong
 * @version 0.1.0
 *
 * This is the Item class. This class will hold all of the menu item data such as name and price.
 * Items will be added to an order which will be held in an ArrayList.
 *
 * NOT YET IMPLEMENTED
 */

    //Todo: Add class fields that store item names and prices.
    //Todo: Add method that returns a list of item names.
    //Todo: Add a method that returns a list of item prices.
    //Todo: Add a method that returns a list of item names and prices.

public class Item extends Order{
    //Declare Item names and prices.
    final private String[] foodNames = {"BLT", "Chicken Pot Pie", "10\" Pizza", "Pasta", "Soup of the Day", "Salad",
            "Burger and Fries", "Bacon and Eggs"};
    final private double[] foodPrices = {5.99, 8.99, 10.99, 9.99, 4.99, 6.99, 10.99,  5.99};
    final private String[] beverageNames = {"Water", "Soda", "Coffee", "Tea", "Milk", "Juice"};
    final private double[] beveragePrices = {0.00, 2.99, 1.99, 0.99, 1.99, 1.99};

    private String itemName;
    private double itemPrice;
    private boolean isComped; //True if item is comped, false if not.

    public Item() {
        //Todo: maybe do something for the default constructor.
    }
    public Item(String name) {
        itemName = name;
        isComped = false;
    }
    public Item(String name, float price) {
        itemName = name;
        itemPrice = price;
        isComped = false;
    }

    public Item(int itemIndex, String itemType) {
        if (itemType.equals("Food")) {
            itemName = foodNames[itemIndex];
            itemPrice = foodPrices[itemIndex];
        }
        else if (itemType.equals("Beverage")) {
            itemName = beverageNames[itemIndex];
            itemPrice = beveragePrices[itemIndex];
            if (itemName.equals("Water")) {  //Set water to a comped item to prevent from showing in comped menu
                this.setComped();
            }
        }
        System.out.println("Item: "+getItemName()+" Price: "+getItemPrice()+" created!");
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public void setComped () {
        itemPrice = 0;
        isComped = !isComped;
        System.out.println("Item was set Comped "+isComped);
    }

    public boolean getComped () {
        return isComped;
    }


}
