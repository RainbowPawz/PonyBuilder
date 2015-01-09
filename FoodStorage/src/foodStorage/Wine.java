//------------------------------------Wine.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 11/09/13
//--------------------------------------------------------------------------------------
//Purpose - child wine class
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//--------------------------------------------------------------------------------------
package foodStorage;

public class Wine extends MenuItem
{
	boolean isRed;
	int year = 0;
	String country = "";

	//****************************************************************************
	//Constructor for the Wine Class
	//****************************************************************************
	public Wine(String data)
	{
		String[] delData = data.split(",");
		name = CheckName(delData[1]);
		cost = Float.parseFloat(delData[2]);
		price = Float.parseFloat(delData[3]);
		isRed(delData[4]);
		year = Integer.parseInt(delData[5]);
		country = (delData[6]);
	}

	//****************************************************************************
	//Method to determine if the wine is a red
	//****************************************************************************
	protected void isRed(String strBool)
	{	
		if(strBool.equalsIgnoreCase("T"))
		{
			isRed = true;
		}
		else
		{
			isRed = false;
		}
	}	
	
	//****************************************************************************
	//Method to create the initial toString
	//****************************************************************************
	public String toString()
	{
		String wine = "";

		if(isRed == true)
		{
			wine = "Red Wine";
		}
		else
		{
			wine = "White Wine";;
		}		

		return "\nWine\n" + "--------------\n" +  " Name: "+ name + "," + " Cost: " + cost 
				+ "," + " Price: " + price + "," + " Red Wine or White: " + wine + "," 
				+ " Year Vintage: " + year + "," + " Country of Origin: " + country + "\n" ;		
	}
	
	public String rawString()
	{
		return  "WINE"+ "," + name + ","+ cost + ","+ price + "," + isRed + "," + year + "," + country;	
	}

}
