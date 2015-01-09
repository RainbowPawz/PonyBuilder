//--------------------------------------------------------------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 12/02/13
//--------------------------------------------------------------------------------------
//Purpose - Main class that handles the NewOrder state
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//All Panels will send their requests to and form this class
//--------------------------------------------------------------------------------------
package OrderClasses;

import java.awt.Image;

import foodStorage.ApplicationLogic;
import foodStorage.FoodStorage;
import foodStorage.MenuItem;

public class NewOrderState extends OrderState
{
	//-------------------------------------------------------------------
	//Description:  Constructor for the state
	//-------------------------------------------------------------------
	public NewOrderState()
	{
		stateName ="NewOrder";
		imagePath = "images/ponies/newOrderApple.png";
	}

	@Override
	public OrderState progressOrder() 
	{
		return new TendedState();
	}

	@Override
	public OrderState reviseOrder() 
	{

		return null;
	}

	public String printMessage() 
	{

		return null;
	}

	@Override
	public String getPicture() 
	{
		return imagePath;
	}

	@Override
	public String getStateName() 
	{
		return stateName;
	}


}
