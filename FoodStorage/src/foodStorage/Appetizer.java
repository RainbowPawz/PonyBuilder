//******************************************************************************
// Heather Shadoan CSCI 426
// Created: 09/12/13
// FileName: Appetizer.java
//******************************************************************************
// Purpose: Appetizer child class
//******************************************************************************

package foodStorage;

public class Appetizer extends MenuItem
{
	boolean isCold;
	int prepTime = 0;
	String country = "";

	//****************************************************************************
	//Constructor for the Appetizer class
	//****************************************************************************
	public Appetizer(){};
	
	public Appetizer(String data)
	{
		String[] delData = data.split(",");
		name = CheckName(delData[1]);
		cost = Float.parseFloat(delData[2]);
		price = Float.parseFloat(delData[3]);
		isCold(delData[4]);
		prepTime = Integer.parseInt(delData[5]);
		country = (delData[6]);
	}

	//****************************************************************************
	//Method to determine if a Appetizer item is a cold item
	//****************************************************************************
	protected void isCold(String strBool)
	{	
		if(strBool.equalsIgnoreCase("T"))
		{
			isCold = true;
		}
		else
		{
			isCold = false;
		}
	}	

	public String toString()
	{
		String dish = "";

		if(isCold == true)
		{
			dish = "cold appetizer";
		}
		else
		{
			dish = "hot appetizer";;
		}		

		return "\nAppetizer\n" + "--------------\n" +  " Name: "+ name + "," + " Cost: " + cost 
				+ "," + " Price: " + price + "," + " Appetizer type: " + dish + "," 
				+ " Prep Time: " + prepTime + "," + " Country of Origin: " + country + "\n" ;		
	}
	
	public String rawString()
	{
		return  "APPETIZER"+ "," + name + ","+ cost + ","+ price + "," + isCold + "," + prepTime + "," + country;	
	}
}
