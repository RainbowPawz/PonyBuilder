//------------------------------------Wine.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 11/08/13
//--------------------------------------------------------------------------------------
//Purpose - child Beer class
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//--------------------------------------------------------------------------------------
package foodStorage;

public class Beer extends MenuItem
{
	boolean hasFoam, isAmberAle;
	String flavor = "";

	//****************************************************************************
	//Constructor for the Beer class
	//****************************************************************************
	public Beer(String data)
	{
		String[] delData = data.split(",");
		name = CheckName(delData[1]);
		cost = Float.parseFloat(delData[2]);
		price = Float.parseFloat(delData[3]);
		hasFoam(delData[4]);
		isAmberAle(delData[5]);
		flavor = (delData[6]);
	}

	//****************************************************************************
	//Method to determine if the Beer has foam
	//****************************************************************************
	protected void hasFoam(String strBool)
	{	
		if(strBool.equalsIgnoreCase("T"))
		{
			hasFoam = true;
		}
		else
		{
			hasFoam = false;
		}
	}	

	//****************************************************************************
	//Method to determine if the Beer is amber
	//****************************************************************************
	protected void isAmberAle(String strBool)
	{	
		if(strBool.equalsIgnoreCase("T"))
		{
			isAmberAle = true;
		}
		else
		{
			isAmberAle = false;
		}
	}	

	//****************************************************************************
	//Method to create the initial toString
	//****************************************************************************
	public String toString()
	{
		String foam = "";

		String ale = "";

		if(hasFoam == true)
		{
			foam = "Foamy Beer";
		}
		else
		{
			foam = "No Foam";
		}	

		if(isAmberAle == true)
		{
			ale = "Amber Ale";
		}
		else
		{
			ale = "Dark Brew";
		}	

		return "\nBeer\n" + "--------------\n" +  " Name: "+ name + "," + " Cost: " + cost 
				+ "," + " Price: " + price + "," + " Foamy Beer: " + foam + "," 
				+ " Amber Ale or Dark Brew: " + ale+ "," + " Beer Flavor: " + flavor + "\n" ;		
	}

	public String rawString()
	{
		return  "BEER"+ "," + name + ","+ cost + ","+ price + "," + hasFoam + "," + isAmberAle + "," + flavor;	
	}
}
