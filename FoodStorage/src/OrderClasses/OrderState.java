//--------------------------------------------------------------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 12/02/13
//--------------------------------------------------------------------------------------
//Purpose - Main class that handles the Order States.
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//All Panels will send their requests to and form this class
//--------------------------------------------------------------------------------------
package OrderClasses;

import java.awt.Image;

import foodStorage.ApplicationLogic;
import foodStorage.FoodStorage;
import foodStorage.MenuItem;

public abstract class OrderState 
{
	public String imagePath;
	public String stateName;
	
	public abstract String getPicture();
	public abstract String getStateName();
	public abstract OrderState progressOrder();
	public abstract OrderState reviseOrder();
}
