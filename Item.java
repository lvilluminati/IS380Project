// Jason Jasper
// David Martin-Vaquero
// Jared Mclaren
// Regine Villongco
// Chemen Wong
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

public class Item extends Order {
	//Declare Item names and prices.
	final private String[] foodNames = {"BLT", "Chicken Pot Pie", "10\" Pizza", "Pasta", "Soup of the Day", "Salad",
			"Burger and Fries", "Bacon and Eggs"};
	final private double[] foodPrices = {5.99, 8.99, 10.99, 9.99, 4.99, 6.99, 10.99, 5.99};
	final private String[] beverageNames = {"Water", "Soda", "Coffee", "Tea", "Milk", "Juice"};
	final private double[] beveragePrices = {0.00, 2.99, 1.99, 0.99, 1.99, 1.99};

	private String itemName;
	private double itemPrice;
	private boolean isComped; //True if item is comped, false if not.

	private String[] name = new String[14];
	private double[] price = new double[14];
	private int[] quantity = new int[14];

	/**
	 * Constructor for an item, no parameters passed.
	 */
	public Item() {
		for (int i = 0; i < foodNames.length; i++) {
			name[i] = foodNames[i];
		}
		for (int i = 0; i < beverageNames.length; i++) {
			name[8 + i] = beverageNames[i];
		}
		for (int i = 0; i < foodPrices.length; i++) {
			price[i] = foodPrices[i];
		}
		for (int i = 0; i < beveragePrices.length; i++) {
			price[8 + i] = beveragePrices[i];
		}
		for (int i = 0; i < quantity.length; i++) {
			quantity[i] = 0;
		}
		isComped = false;
	}

	/**
	 * Constructor for an item.
	 *
	 * @param Name of an item.
	 */
	public Item(String name) {
		itemName = name;
		isComped = false;
	}

	/**
	 * Constructor for an item.
	 *
	 * @param Name  of an item.
	 * @param Price of an item.
	 */
	public Item(String name, double price) {
		itemName = name;
		itemPrice = price;
		isComped = false;
	}

	/**
	 * Constructor for an item.
	 *
	 * @param Index  of an item.
	 * @param Item's type.
	 */
	public Item(int itemIndex, String itemType) {
		if (itemType.equals("Food")) {
			//  Set item as a food item.
			itemName = foodNames[itemIndex];
			itemPrice = foodPrices[itemIndex];
		} else if (itemType.equals("Beverage")) {
			//  Set item as a beverage item.
			itemName = beverageNames[itemIndex];
			itemPrice = beveragePrices[itemIndex];
			if (itemName.equals("Water")) {  //Set water to a comped item to prevent from showing in comped menu
				this.setComped();
			}
		}
		System.out.println("Item: " + getItemName() + " Price: " + getItemPrice() + " created!");
	}

	/**
	 * Method to get item name.
	 *
	 * @return Item name.
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Method to get item price.
	 *
	 * @return Item price.
	 */
	public double getItemPrice() {
		return itemPrice;
	}

	/**
	 * Method to set comp.
	 */
	public void setComped() {
		itemPrice = 0;
		isComped = !isComped;
		System.out.println("Item was set Comped " + isComped);
	}

	/**
	 * Method to get comp.
	 *
	 * @return Comp status.
	 */
	public boolean getComped() {
		return isComped;
	}

}