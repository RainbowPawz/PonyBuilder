//--------------------------------------------------------------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 12/02/13
//--------------------------------------------------------------------------------------
//Purpose - Main class that handles the OrderItem logic
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//All Panels will send their requests to and form this class
//--------------------------------------------------------------------------------------
package OrderClasses;

import java.text.DecimalFormat;

public class OrderItem 
{
	public String itemName ="";
	public double itemPrice = 0;
	public int itemAmount = 0;

	DecimalFormat df = new DecimalFormat("$" + "0.00");

	//------------------------------------------------------------------
	//Description: Constructor for the order items
	//------------------------------------------------------------------
	public OrderItem(String name, double price, int amount)
	{
		itemName = name;
		itemPrice = price;
		itemAmount = amount;
	}
	
	//------------------------------------------------------------------
	//Description: Creates an order item
	//------------------------------------------------------------------
	public OrderItem createOrderItem(String name, double price, int amount) 
	{		
		return new OrderItem(name,price,amount);
	}

	//------------------------------------------------------------------
	//Description: Returns the name
	//------------------------------------------------------------------
	public String getName()
	{
		return itemName;
	}

	//------------------------------------------------------------------
	//Description: Gets the subtotal for each item
	//------------------------------------------------------------------
	public double subTotal()
	{ 
		double itemSub = 0;

		itemSub = itemAmount *itemPrice;

		return itemSub ;
	}

	//------------------------------------------------------------------
	//Description: Gets the amount
	//------------------------------------------------------------------
	public double getAmount()
	{ 
		return itemAmount;
	}

	//------------------------------------------------------------------
	//Description: Gets the price
	//------------------------------------------------------------------
	public double getPrice()
	{ 
		return itemPrice;
	}

	//------------------------------------------------------------------
	//Description: Creates a string representation of the order item
	//------------------------------------------------------------------
	public String toString()
	{
		return "\nOrder Item\n"  + "--------------------------------------------------------------------------------------------------------" + "\n" 
				+ "Name: " + itemName 
				+ "    Price: " + df.format(itemPrice) 
				+ "    Amount: " + itemAmount  
				+ "    SubTotal amount: " + df.format(subTotal())+ "\n";

	}

}
