//------------------------------------Tea.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 11/08/13
//--------------------------------------------------------------------------------------
//Purpose - child tea class
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//--------------------------------------------------------------------------------------
package foodStorage;

public class Tea extends MenuItem
{
	boolean isHerbal, isLooseLeaf, isHot;

	//****************************************************************************
	//Constructor for the Tea Class
	//****************************************************************************
	public Tea(String data)
	{
		String[] delData = data.split(",");
		name = CheckName(delData[1]);
		cost = Float.parseFloat(delData[2]);
		price = Float.parseFloat(delData[3]);
		isHerbal(delData[4]);
		isLooseLeaf(delData[5]);
		isHot(delData[6]);
	}

	//****************************************************************************
	//Method to determine if the tea is a herbal tea
	//****************************************************************************
	protected void isHerbal(String strBool)
	{	
		if(strBool.equalsIgnoreCase("T"))
		{
			isHerbal = true;
		}
		else
		{
			isHerbal = false;
		}
	}	
	//****************************************************************************
	//Method to determine if the tea is a loose leaf tea
	//****************************************************************************
	protected void isLooseLeaf(String strBool)
	{	
		if(strBool.equalsIgnoreCase("T"))
		{
			isLooseLeaf = true;
		}
		else
		{
			isLooseLeaf = false;
		}
	}
	
	//****************************************************************************
	//Method to determine if the tea is a hot tea
	//****************************************************************************
	protected void isHot(String strBool)
	{	
		if(strBool.equalsIgnoreCase("T"))
		{
			isHot = true;
		}
		else
		{
			isHot = false;
		}
	}

	//****************************************************************************
	//Method to determine create the initial toString
	//****************************************************************************
	public String toString()
	{
		String herbal = "";
		String leaf = "";
		String hot = "";

		if(isHerbal == true)
		{
			herbal = "Herbal Tea";
		}
		else
		{
			herbal = "Black Tea";
		}	
		
		if(isLooseLeaf == true)
		{
			leaf = "Loose Leaf Tea";
		}
		else
		{
			leaf = "Tea Bags";
		}
		
		if(isHot == true)
		{
			hot = "Hot Tea";
		}
		else
		{
			hot = "Cold Tea";
		}

		return "\nTea\n" + "--------------\n" +  " Name: "+ name + "," + " Cost: " + cost 
				+ "," + " Price: " + price + "," + " Tea Type: " + herbal + "," 
				+ "Loose Leaf or Tea Bags: " + leaf + "," + " Hot or Cold tea: " + hot + "\n" ;		
	}
	
	public String rawString()
	{
		return  "TEA"+ "," + name + ","+ cost + ","+ price + "," + isHerbal + "," + isLooseLeaf + "," + isHot;	
	}

}
