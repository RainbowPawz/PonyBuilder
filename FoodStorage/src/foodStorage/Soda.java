//**************************************Soda.java**************************************
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 10/03/13
//**************************************************************************************
//Purpose - Creates Soda Items
//**************************************************************************************
//Notes on specifications, special algorithms, and assumptions
//Capitalization will not matter.
//**************************************************************************************
package foodStorage;

public class Soda extends IceCream 
{
	int MAXLENGTH = 30;
	float profit;
	boolean whippedCream = false;
	String iceCream = "";
	String flavor = "";
	String type = "Soda";

	//****************************************************************************
	//Constructors for the Soda class
	//****************************************************************************
	public Soda(){}
	
	public Soda(String data)
	{
		String[] delData = data.split(",");
		name = CheckName(delData[1]);
		cost = Float.parseFloat(delData[2]);
		price = Float.parseFloat(delData[3]);
		flavor =(delData[4]);
		iceCream =(delData[5]);
		whippedCream(delData[6]);
	}

	//****************************************************************************
	//Method to determine if a Soda item is a cake
	//****************************************************************************
	protected void whippedCream(String strBool)
	{	
		if(strBool.equalsIgnoreCase("T"))
		{
			whippedCream = true;
		}
	}

	public String toString()
	{
		String cream = "";

		if(whippedCream == true)
		{
			cream = "Comes with whipped cream";
		}
		else
		{
			cream = "No whipped cream";;
		}	

		return "\nSoda\n" + "--------------\n" + " Name: "+ name + "," + " Cost: " + cost + 
				"," + " Price: " + price + "," + " Flavor: " + flavor + "," + " Ice Cream: " + iceCream + "," +
				" Whipped Cream: " + cream + "\n";	
	}
	
	public String rawString()
	{
		return  "SODA"+ "," + name + ","+ cost + ","+ price + "," + flavor + "," + iceCream + "," + whippedCream;	
	}
}
