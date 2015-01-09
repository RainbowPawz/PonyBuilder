//**************************************MilkShake.java**************************************
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 10/03/13
//**************************************************************************************
//Purpose - Creates MilkShake Items
//**************************************************************************************
//Notes on specifications, special algorithms, and assumptions
//Capitalization will not matter.
//**************************************************************************************
package foodStorage;

public class Milkshake extends IceCream 
{
	int MAXLENGTH = 30;
	float profit;
	int maltPowderScoops = 0;
	String iceCream = "";
	String flavor = "";
	String type = "Milkshake";

	//****************************************************************************
	//Constructor for the MilkShake class
	//****************************************************************************
	public Milkshake(){};
	
	public Milkshake(String data)
	{
		String[] delData = data.split(",");
		name = CheckName(delData[1]);
		cost = Float.parseFloat(delData[2]);
		price = Float.parseFloat(delData[3]);
		flavor =(delData[4]);
		iceCream =(delData[5]);
		maltPowderScoops = Integer.parseInt(delData[6]);
	}
	  public int GetScoops()
      {
          return maltPowderScoops;
      }

	//****************************************************************************
	//Description: toString for the MilkShake items
	//****************************************************************************
	public String toString()
	{
		return "\nMilkshake\n" + "--------------\n" + " Name: "+ name + "," + "Cost: " + cost + 
				"," + " Price: " + price + "," + " Flavor: " + flavor + "," + " Ice Cream: " + iceCream + ","+
				" Malt powder scoops: " + maltPowderScoops + "\n";	
	}
	
	public String rawString()
	{
		return  "MILKSHAKE"+ "," + name + ","+ cost + ","+ price + "," + flavor + "," + iceCream+ "," + maltPowderScoops;	
	}
}
