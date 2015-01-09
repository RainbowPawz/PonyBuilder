//------------------------------------Order.java--------------------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 12/02/13
//--------------------------------------------------------------------------------------
//Purpose - Main class that handles order logic
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//All Panels will send their requests to and form this class
//--------------------------------------------------------------------------------------
package OrderClasses;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import foodStorage.FoodStorage;
import foodStorage.MenuItem;

public class Order 
{	
	private ArrayList<OrderItem> orderList = new ArrayList<OrderItem>();

	private ArrayList<Order> order = new ArrayList<Order>();

	DecimalFormat df = new DecimalFormat("$" + "0.00");
	String orderString = "";
	double orderSub = 0;
	double orderTotal = 0;

	public Order()
	{}

	//-------------------------------------------------------------------
	//Description: Clears an order
	//-------------------------------------------------------------------
	public void reset() 
	{
		orderList.clear();
	}

	//-------------------------------------------------------------------
	//Description: Creates a new order
	//-------------------------------------------------------------------
	public Order newOrder() 
	{
		orderList.clear();
		return new Order();
	}

	//-------------------------------------------------------------------
	//Description: Checks if the order list is empty
	//-------------------------------------------------------------------
	public boolean emptyCheck()
	{
		boolean success = false;

		if(order.isEmpty())
		{
			success = true;
		}
		return success;
	}

	//-------------------------------------------------------------------
	//Description: Check to see if the users order exists in the order array
	//-------------------------------------------------------------------
	public boolean userOrderCheck(int userChoice)
	{
		boolean success = false;

		if(order.contains(order.get(userChoice)))
		{
			success = true;
		}
		
		return success;
	}

	//-------------------------------------------------------------------
	//Description: Secondary constructor
	//-------------------------------------------------------------------
	public Order(String orderlist2) 
	{
		orderString = orderlist2;
	}

	//-------------------------------------------------------------------
	//Description: Add an order to the array list
	//-------------------------------------------------------------------
	public void addOrder(Order orderList)
	{
		order.add(orderList);
	}

	//-------------------------------------------------------------------
	//Description: Gets the overall total for each order
	//-------------------------------------------------------------------
	public double total()
	{
		double orderTotal = 0;
		double orderFinal = 0;

		Iterator<OrderItem> it;

		it = orderList.iterator();

		while(it.hasNext())
		{		
			orderTotal = it.next().subTotal();

			orderFinal += orderTotal;
		}
		return orderFinal;
	}

	//-------------------------------------------------------------------
	//Description: Adds an order item to the order item array list
	//-------------------------------------------------------------------
	public void addingOrderItem(OrderItem item)
	{
		orderList.add(item);
	}

	//-------------------------------------------------------------------
	//Description: Prints the initial order
	//-------------------------------------------------------------------
	public String printOrder()
	{
		String orderString = "";

		Iterator<OrderItem> it;

		it = orderList.iterator();

		while(it.hasNext())
		{
			orderString += it.next().toString();
		}

		return orderString;	
	}

	//-------------------------------------------------------------------
	//Description: Prints the paid order
	//-------------------------------------------------------------------
	public String printPaidOrder()
	{
		String orderString = "";

		Iterator<OrderItem> it;

		it = orderList.iterator();

		while(it.hasNext())
		{
			orderString += it.next().toString();
		}

		orderString += "\n" + "--------------------------------------------------------------------------------------------------------"
				+ "\n" + "Final Total Due: " + df.format(total()) + "\n";

		return orderString;	
	}

	//-------------------------------------------------------------------
	//Description: Creates a new order
	//-------------------------------------------------------------------
	public Order createOrder(String orderlist2)
	{
		return new Order(orderlist2);
	}

	//-------------------------------------------------------------------
	//Description: Prints the users order choice
	//-------------------------------------------------------------------
	public String printUserOrder(int userChoice)
	{
		String orderS = "";

		orderS = order.get(userChoice).toString();

		return orderS;	
	}

	//-------------------------------------------------------------------
	//Description: ToString for the order class
	//-------------------------------------------------------------------
	public String toString()
	{
		return orderString + "\n";
	}


}
