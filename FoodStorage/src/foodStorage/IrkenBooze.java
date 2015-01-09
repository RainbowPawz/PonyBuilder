//------------------------------------IrkenBooze.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 11/08/13
//--------------------------------------------------------------------------------------
//Purpose - child IrkenBooze class
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//--------------------------------------------------------------------------------------
package foodStorage;

public class IrkenBooze extends MenuItem
{
	boolean chilled;
	int toxicScale = 0;
	String planet = "";

	//****************************************************************************
	//Constructor for the IrkenBooze Class
	//****************************************************************************
	public IrkenBooze(String data)
	{
		String[] delData = data.split(",");
		name = CheckName(delData[1]);
		cost = Float.parseFloat(delData[2]);
		price = Float.parseFloat(delData[3]);
		toxicScale = Integer.parseInt(delData[4]);
		isChilled(delData[5]);
		planet = (delData[6]);
	}

	//****************************************************************************
	//Method to determine if the IrkenBooze is chilled
	//****************************************************************************
	protected void isChilled(String strBool)
	{	
		if(strBool.equalsIgnoreCase("T"))
		{
			chilled = true;
		}
		else
		{
			chilled = false;
		}
	}	
	
	//****************************************************************************
	//Method to determine to create the toString
	//****************************************************************************
	public String toString()
	{
		String chill = "";

		if(chilled == true)
		{
			chill = "Cold Alien Brew";
		}
		else
		{
			chill = "Warm Alien Brew";;
		}		

		return "\nIrkenBooze\n" + "--------------\n" +  " Name: "+ name + "," + " Cost: " + cost 
				+ "," + " Price: " + price + "," + " Toxic Scale (0-10): " + toxicScale + "," 
				+ " Chilled: " + chill + "," + " Planet of Origin: " + planet + "\n" ;		
	}
	
	public String rawString()
	{
		return  "IRKENBOOZE"+ "," + name + ","+ cost + ","+ price + "," + toxicScale + "," + chilled + "," + planet;	
	}

}
