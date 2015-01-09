//******************************************************************************
// Heather Shadoan CSCI 426
// Created: 09/12/13
// FileName: Dessert.java
//******************************************************************************
// Purpose: Child Dessert class
//******************************************************************************

package foodStorage;

public class Dessert extends MenuItem
{	
	int MAXLENGTH = 30;
	boolean isCake, isSpecial;
	int servings = 0;
	float profit;
	String type = "Dessert";

	//****************************************************************************
	//Constructor for the Dessert class
	//****************************************************************************
	public Dessert(){}
	
	public Dessert(String data)
	{
		String[] delData = data.split(",");
		name = CheckName(delData[1]);
		cost = Float.parseFloat(delData[2]);
		price = Float.parseFloat(delData[3]);
		IsCake(delData[4]);
		servings = Integer.parseInt(delData[5]);
		IsSpecial(delData[6]);
	}

	//****************************************************************************
	//Method to determine if a Dessert item is a cake
	//****************************************************************************
	protected void IsCake(String strBool)
	{	
		if(strBool.equalsIgnoreCase("T"))
		{
			isCake = true;
		}
		else
		{
			isCake = false;
		}
	}
	
	protected void IsSpecial(String strBool)
	{	
		if(strBool.equalsIgnoreCase("True"))
		{
			isSpecial = true;
		}
		else
		{
			isSpecial = false;
		}
	}

	public String toString()
	{
		String cake = "";
		String special = "";

		if(isCake == true)
		{
			cake = "cake dessert";
		}
		else
		{
			cake = "other dessert";
		}	
		
		if(isSpecial == true)
		{
			special = "Special Dessert";
		}
		else
		{
			special = "Special Dessert";
		}	

		return "\nDessert\n" + "--------------\n" + " Name: "+ name + "," + " Cost: " + 
		cost + "," + " Price: " + price + "," + " Dessert type: " + cake + "," 
		+ " Prep Time: " + servings + "," + " Special Dessert: " + special + "\n";	
	}
	
	public String rawString()
	{
		return  "DESSERT"+ "," + name + ","+ cost + ","+ price + "," + isCake+ "," + servings + "," + isSpecial;	
	}
}
