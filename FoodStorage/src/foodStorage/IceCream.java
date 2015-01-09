//**************************************IceCream.java**************************************
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 10/03/13
//**************************************************************************************
//Purpose - Main Parent to cream IceCream objects
//**************************************************************************************
//Notes on specifications, special algorithms, and assumptions
//Capitalization will not matter.
//**************************************************************************************
package foodStorage;

public abstract class IceCream 
{
	int MAXLENGTH = 20;
	protected String name, flavor, iceCream;
	protected Float cost, price, profit; //the assignment explicitly states that these are floats

	//------------------------------GetName----------------------------------------
	//Description: Gets the name of a specific item
	//-----------------------------------------------------------------------------
	public String GetName()
	{
		return name;
	}//end of GetName

	//------------------------------SetName----------------------------------------
	//Description: Sets the name of a specific item, then calls CheckName to verify
	//             That it is of appropriate length
	//-----------------------------------------------------------------------------
	public void SetName(String newName)
	{
		name = CheckName(newName);
	}//end of SetName

	//------------------------------CheckName----------------------------------------
	//Description: Used to verify that a name attribute is of appropriate length set
	//             and determined by an items MAXLENGTH variable.
	//-------------------------------------------------------------------------------
	public String CheckName(String name)
	{		      
		if (MAXLENGTH > name.length())
		{
			MAXLENGTH = name.length();
		}        
		return name.substring(0 , MAXLENGTH);
	}

	//------------------------------GetCost----------------------------------------
	//Description: Gets the cost of a specific item
	//-----------------------------------------------------------------------------
	public float GetCost()
	{
		return cost;
	}//end of GetCost

	//------------------------------GetCost----------------------------------------
	//Description: Sets the cost of a specific item and recalculates the profit 
	//			   variable
	//-----------------------------------------------------------------------------
	public void SetCost(float newCost)
	{
		cost = newCost;
		CalculateProfit();
	}//end of SetCost

	//------------------------------GetPrice----------------------------------------
	//Description: Gets the cost of a specific item
	//------------------------------------------------------------------------------
	public float GetPrice()
	{
		return price;
	}//end of GetPrice

	//------------------------------GetPrice----------------------------------------
	//Description: Sets the price of a specific item and recalculates the profit 
	//			   variable
	//------------------------------------------------------------------------------
	public void SetPrice(float newPrice)
	{
		price = newPrice;
		CalculateProfit();
	}//end of SetPrice

	//------------------------------GetProfit----------------------------------------
	//Description: Gets the profit of a specific item
	//-------------------------------------------------------------------------------
	public float GetProfit()
	{
		CalculateProfit();
		return profit;
	}//end of GetProfit

	//------------------------------CalculateProfit----------------------------------------
	//Description: Calculates the profit from a menu item buy finding the difference between
	//              the price and cost
	//-------------------------------------------------------------------------------------
	protected void CalculateProfit()
	{
		profit = (price - cost);
	}//end of CalculateProfit

	//------------------------------GetFlavor----------------------------------------
	//Description: Gets the name of a specific item
	//-----------------------------------------------------------------------------
	public String GetFlavor()
	{
		return flavor;
	}//end of GetName
	
	public abstract String rawString();//end of GetName
	
	
}
