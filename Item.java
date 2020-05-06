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

    /**
    Constructor for an item, no parameters passed.
    */
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
    /**
    Constructor for an item.
    @param Name of an item.
    */
    public Item(String name) {
        itemName = name;
        isComped = false;
    }
    /**
	Constructor for an item.
	@param Name of an item.
	@param Price of an item.
    */
    public Item(String name, double price) {
        itemName = name;
        itemPrice = price;
        isComped = false;
    }

    /**
	Constructor for an item.
	@param Index of an item.
	@param Item's type.
    */
    public Item(int itemIndex, String itemType) {
        if (itemType.equals("Food")) {
            //  Set item as a food item.
            itemName = foodNames[itemIndex];
            itemPrice = foodPrices[itemIndex];
        }
        else if (itemType.equals("Beverage")) {
            //  Set item as a beverage item.
            itemName = beverageNames[itemIndex];
            itemPrice = beveragePrices[itemIndex];
            if (itemName.equals("Water")) {  //Set water to a comped item to prevent from showing in comped menu
                this.setComped();
            }
        }
        System.out.println("Item: "+getItemName()+" Price: "+getItemPrice()+" created!");
    }

    /**
    Method to get item name.
    @return Item name.
    */
    public String getItemName() {
        return itemName;
    }

    /**
	Method to get item price.
    @return Item price.
    */
    public double getItemPrice(){
        return itemPrice;
    }

    /**
	Method to set comp.
    */
    public void setComped () {
        itemPrice = 0;
        isComped = !isComped;
        System.out.println("Item was set Comped "+isComped);
    }

    /**
	Method to get comp.
    @return Comp status.
    */
    public boolean getComped () {
        return isComped;
    }


    /**
	Method to change comp.
    */
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
	/**
	Method to get BLT string.
    @return Item name.
    */
	public String getBltName()
	{
		return name[0];
	}
	/**
	Method to get pie string.
    @return Item name.
    */
	public String getPieName()
	{
		return name[1];
	}
	/**
	Method to get pizza string.
    @return Item name.
    */
	public String getPizzaName()
	{
		return name[2];
	}
	/**
	Method to get pasta string.
    @return Item name.
    */
	public String getPastaName()
	{
		return name[3];
	}
	/**
	Method to get soup string.
    @return Item name.
    */
	public String getSoupName()
	{
		return name[4];
	}
	/**
	Method to get salad string.
    @return Item name.
    */
	public String getSaladName()
	{
		return name[5];
	}
	/**
	Method to get burger string.
    @return Item name.
    */
	public String getBurgerName()
	{
		return name[6];
	}
	/**
	Method to get bacon and eggs string.
    @return Item name.
    */
	public String getBaconEggsName()
	{
		return name[7];
	}
	/**
	Method to get water string.
    @return Item name.
    */
	public String getWaterName()
	{
		return name[8];
	}
	/**
	Method to get soda string.
    @return Item name.
    */
	public String getSodaName()
	{
		return name[9];
	}
	/**
	Method to get coffee string.
    @return Item name.
    */
	public String getCoffeeName()
	{
		return name[10];
	}
	/**
	Method to get tea string.
    @return Item name.
    */
	public String getTeaName()
	{
		return name[11];
	}
	/**
	Method to get milk string.
    @return Item name.
    */
	public String getMilkName()
	{
		return name[12];
	}
	/**
	Method to get juice string.
    @return Item name.
    */
	public String getJuiceName()
	{
		return name[13];
	}
	/**
	Method to set BLT quantity.
	@param Quantity number.
    */
	public void setBlt(int number)
	{
		quantity[0] = number;
	}
	/**
	Method to set pie quantity.
	@param Quantity number.
    */
	public void setPie(int number)
	{
		quantity[1] = number;
	}
	/**
	Method to set pizza quantity.
	@param Quantity number.
    */
	public void setPizza(int number)
	{
		quantity[2] = number;
	}
	/**
	Method to set pasta quantity.
	@param Quantity number.
    */
	public void setPasta(int number)
	{
		quantity[3] = number;
	}
	/**
	Method to set soup quantity.
	@param Quantity number.
    */
	public void setSoup(int number)
	{
		quantity[4] = number;
	}
	/**
	Method to set salad quantity.
	@param Quantity number.
    */
	public void setSalad(int number)
	{
		quantity[5] = number;
	}
	/**
	Method to set burger quantity.
	@param Quantity number.
    */
	public void setBurger(int number)
	{
		quantity[6] = number;
	}
	/**
	Method to set bacon and eggs quantity.
	@param Quantity number.
    */
	public void setBaconEggs(int number)
	{
		quantity[7] = number;
	}
	/**
	Method to set water quantity.
	@param Quantity number.
    */
	public void setWater(int number)
	{
		quantity[8] = number;
	}
	/**
	Method to set soda quantity.
	@param Quantity number.
    */
	public void setSoda(int number)
	{
		quantity[9] = number;
	}
	/**
	Method to set coffee quantity.
	@param Quantity number.
    */
	public void setCoffee(int number)
	{
		quantity[10] = number;
	}
	/**
	Method to set tea quantity.
	@param Quantity number.
    */
	public void setTea(int number)
	{
		quantity[11] = number;
	}
	/**
	Method to set milk quantity.
	@param Quantity number.
    */
	public void setMilk(int number)
	{
		quantity[12] = number;
	}
	/**
	Method to set juice quantity.
	@param Quantity number.
    */
	public void setJuice(int number)
	{
		quantity[13] = number;
	}
	/**
	Method to get BLT quantity.
    @return Item quantity.
    */
	public int getBlt()
	{
		return quantity[0];
	}
	/**
	Method to get pie quantity.
    @return Item quantity.
    */
	public int getPie()
	{
		return quantity[1];
	}
	/**
	Method to get pizza quantity.
    @return Item quantity.
    */
	public int getPizza()
	{
		return quantity[2];
	}
	/**
	Method to get pasta quantity.
    @return Item quantity.
    */
	public int getPasta()
	{
		return quantity[3];
	}
	/**
	Method to get soup quantity.
    @return Item quantity.
    */
	public int getSoup()
	{
		return quantity[4];
	}
	/**
	Method to get salad quantity.
    @return Item quantity.
    */
	public int getSalad()
	{
		return quantity[5];
	}
	/**
	Method to get burger quantity.
    @return Item quantity.
    */
	public int getBurger()
	{
		return quantity[6];
	}
	/**
	Method to get bacon and eggs quantity.
    @return Item quantity.
    */
	public int getBaconEggs()
	{
		return quantity[7];
	}
	/**
	Method to get water quantity.
    @return Item quantity.
    */
	public int getWater()
	{
		return quantity[8];
	}
	/**
	Method to get soda quantity.
    @return Item quantity.
    */
	public int getSoda()
	{
		return quantity[9];
	}
	/**
	Method to get coffee quantity.
    @return Item quantity.
    */
	public int getCoffee()
	{
		return quantity[10];
	}
	/**
	Method to get tea quantity.
    @return Item quantity.
    */
	public int getTea()
	{
		return quantity[11];
	}
	/**
	Method to get milk quantity.
    @return Item quantity.
    */
	public int getMilk()
	{
		return quantity[12];
	}
	/**
	Method to get juice quantity.
    @return Item quantity.
    */
	public int getJuice()
	{
		return quantity[13];
	}
	/**
	Method to get BLT price.
    @return Item price.
    */
	public double getPriceBlt()
	{
		return price[0];
	}
	/**
	Method to get pie price.
    @return Item price.
    */
	public double getPricePie()
	{
		return price[1];
	}
	/**
	Method to get pizza price.
    @return Item price.
    */
	public double getPricePizza()
	{
		return price[2];
	}
	/**
	Method to get pasta price.
    @return Item price.
    */
	public double getPricePasta()
	{
		return price[3];
	}
	/**
	Method to get soup price.
    @return Item price.
    */
	public double getPriceSoup()
	{
		return price[4];
	}
	/**
	Method to get salad price.
    @return Item price.
    */
	public double getPriceSalad()
	{
		return price[5];
	}
	/**
	Method to get burger price.
    @return Item price.
    */
	public double getPriceBurger()
	{
		return price[6];
	}
	/**
	Method to get bacon and eggs price.
    @return Item price.
    */
	public double getPriceBaconEggs()
	{
		return price[7];
	}
	/**
	Method to get water price.
    @return Item price.
    */
	public double getPriceWater()
	{
		return price[8];
	}
	/**
	Method to get soda price.
    @return Item price.
    */
	public double getPriceSoda()
	{
		return price[9];
	}
	/**
	Method to get coffee price.
    @return Item price.
    */
	public double getPriceCoffee()
	{
		return price[10];
	}
	/**
	Method to get tea price.
    @return Item price.
    */
	public double getPriceTea()
	{
		return price[11];
	}
	/**
	Method to get milk price.
    @return Item price.
    */
	public double getPriceMilk()
	{
		return price[12];
	}
	/**
	Method to get juice price.
    @return Item price.
    */
	public double getPriceJuice()
	{
		return price[13];
	}
}
