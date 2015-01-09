//------------------------------------Meal.java--------------------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/12/13
//Last Modified: 
//--------------------------------------------------------------------------------------
//Purpose - The Meal class was created to give a specific implementation for a MenuItem
//          , allowing a MenuItem to have Meal specific information and implementation.
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//The Meal class reads in a comma separated string to start.
//We assume that Meal name must be 0 to 20 characters long, inheriting from its parent.
//We assume that cookTime must be in minutes.
//There are no special algorithms in this class
//--------------------------------------------------------------------------------------

package foodStorage;

public class Meal extends MenuItem
{
	boolean isSalad, organic;
	int cookTime = 0;
	
	//---------------------------------Constructor-----------------------------------
    //Description: The constructor reads in a string that must have each piece of data 
    //             separated by a comma. The order that the values must arrive in are 
	//			   as follows: type, name, cost, price, isSalad, cookTime
    //-------------------------------------------------------------------------------
	public Meal(){};
	
	public Meal(String data)
	{
		String[] temp = data.split(",");	
		name = CheckName(temp[1]);
		cost = Float.parseFloat(temp[2]);
		price = Float.parseFloat(temp[3]);
		IsSalad(temp[4]);
		cookTime = Integer.parseInt(temp[5]);
		IsOrganic(temp[6]);
	}//end of constructor
	
	//---------------------------------IsSalad------------------------------------
    //Description: Return true if the Meal is a salad meal.
    //             Return false if the Meal is not a salad meal.
    //----------------------------------------------------------------------------
	protected void IsSalad(String strBool)
	{	
		if(strBool.equalsIgnoreCase("True"))
		{
			isSalad = true;
		}
		else
		{
			isSalad = false;
		}
	}//end of IsSalad
	protected void IsOrganic(String strBool)
	{	
		if(strBool.equalsIgnoreCase("True"))
		{
			organic = true;
		}
		else
		{
			organic = false;
		}
	}//end of IsSalad
	
	//---------------------------------ToString------------------------------------
    //Description: Returns a string description of the Meal item.
    //----------------------------------------------------------------------------
	public String toString()
	{	
		String meal = "";
		String organicMeal = "";

		if(isSalad== true)
		{
			meal = "salad meal";
		}
		else
		{
			meal = "hot meal";;
		}	
		
		if(organic == true)
		{
			organicMeal = "Organic Meal";
		}
		else
		{
			organicMeal = "GMO Loaded Meal";
		}	
		
		return "\nMeal\n" + "--------------\n" + " Name: "+ name + "," + 
		" Cost: " + cost + "," + " Price: " + price + "," + " Meal type: " +
		meal + "," + " Cook Time: " + cookTime + ","
		+ " Organic Meal: " + organicMeal + "\n";	
	}//end of ToString
	
	public String rawString()
	{
		return  "MEAL"+ "," + name + ","+ cost + ","+ price + "," + isSalad + "," + cookTime + "," + organic;	
	}
}
