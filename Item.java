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

    private String name[] = new String[14];
    private double price[] = new double[14];
    private int quantity[] = new int[14];

    public Item() {
        //Todo: maybe do something for the default constructor.
        for (int i = 0; i < foodNames.length; i++)
        {
			name[i] = foodNames[i];
		}
		for (int i = 0; i < beverageNames.length; i++)
		{
			name[8 + i] = beverageNames[i];
		}
		for (int i = 0; i < foodPrices.length; i++)
		{
			price[i] = foodPrices[i];
		}
		for (int i = 0; i < beveragePrices.length; i++)
		{
			price[8 + i] = beveragePrices[i];
		}
		for (int i = 0; i < quantity.length; i++)
		{
			quantity[i] = 0;
		}
        isComped = false;
    }
    public Item(String name) {
        itemName = name;
        isComped = false;
    }
    public Item(String name, double price) {
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


    public void changeComped()
    {
		if (isComped == false)
		{
			isComped = true;
		}
		else
		{
			isComped = false;
		}
	}
	public void setBlt(int number)
	{
		quantity[0] = number;
	}
	public void setPie(int number)
	{
		quantity[1] = number;
	}
	public void setPizza(int number)
	{
		quantity[2] = number;
	}
	public void setPasta(int number)
	{
		quantity[3] = number;
	}
	public void setSoup(int number)
	{
		quantity[4] = number;
	}
	public void setSalad(int number)
	{
		quantity[5] = number;
	}
	public void setBurger(int number)
	{
		quantity[6] = number;
	}
	public void setBaconEggs(int number)
	{
		quantity[7] = number;
	}
	public void setWater(int number)
	{
		quantity[8] = number;
	}
	public void setSoda(int number)
	{
		quantity[9] = number;
	}
	public void setCoffee(int number)
	{
		quantity[10] = number;
	}
	public void setTea(int number)
	{
		quantity[11] = number;
	}
	public void setMilk(int number)
	{
		quantity[12] = number;
	}
	public void setJuice(int number)
	{
		quantity[13] = number;
	}
	public int getBlt()
	{
		return quantity[0];
	}
	public int getPie()
	{
		return quantity[1];
	}
	public int getPizza()
	{
		return quantity[2];
	}
	public int getPasta()
	{
		return quantity[3];
	}
	public int getSoup()
	{
		return quantity[4];
	}
	public int getSalad()
	{
		return quantity[5];
	}
	public int getBurger()
	{
		return quantity[6];
	}
	public int getBaconEggs()
	{
		return quantity[7];
	}
	public int getWater()
	{
		return quantity[8];
	}
	public int getSoda()
	{
		return quantity[9];
	}
	public int getCoffee()
	{
		return quantity[10];
	}
	public int getTea()
	{
		return quantity[11];
	}
	public int getMilk()
	{
		return quantity[12];
	}
	public int getJuice()
	{
		return quantity[13];
	}
	public double getPriceBlt()
	{
		return price[0];
	}
	public double getPricePie()
	{
		return price[1];
	}
	public double getPricePizza()
	{
		return price[2];
	}
	public double getPricePasta()
	{
		return price[3];
	}
	public double getPriceSoup()
	{
		return price[4];
	}
	public double getPriceSalad()
	{
		return price[5];
	}
	public double getPriceBurger()
	{
		return price[6];
	}
	public double getPriceBaconEggs()
	{
		return price[7];
	}
	public double getPriceWater()
	{
		return price[8];
	}
	public double getPriceSoda()
	{
		return price[9];
	}
	public double getPriceCoffee()
	{
		return price[10];
	}
	public double getPriceTea()
	{
		return price[11];
	}
	public double getPriceMilk()
	{
		return price[12];
	}
	public double getPriceJuice()
	{
		return price[13];
	}
}
