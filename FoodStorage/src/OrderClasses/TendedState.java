//--------------------------------------------------------------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 12/02/13
//--------------------------------------------------------------------------------------
//Purpose - Main class that handles the tended state
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//All Panels will send their requests to and form this class
//--------------------------------------------------------------------------------------
package OrderClasses;

import java.awt.Image;

import foodStorage.ApplicationLogic;
import foodStorage.FoodStorage;
import foodStorage.MenuItem;
import Panels.TemplatePanel;

public class TendedState extends OrderState
{
	//-------------------------------------------------------------------
	//Description:  Constructor for the state
	//-------------------------------------------------------------------
	TendedState()
	{
		stateName ="Tended";
		imagePath = "images/ponies/tenderApple.png";
	}
	
	@Override
	public OrderState progressOrder() 
	{
		return new PaidState();
	}

	@Override
	public OrderState reviseOrder() 
	{	
		return new InProcessState();
	}

	@Override
	public String getPicture() {

		return imagePath;
	}

	@Override
	public String getStateName() {

		return stateName;
	}

}
