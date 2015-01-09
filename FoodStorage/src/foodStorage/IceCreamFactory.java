//**********************************IceCreamFactory.java*******************************
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 10/03/13
//**************************************************************************************
//Purpose - Creates IceCream Items
//**************************************************************************************
//Notes on specifications, special algorithms, and assumptions
//Capitalization will not matter.
//**************************************************************************************
package foodStorage;

public class IceCreamFactory {

	public static IceCream createIceCreamItem(String name)
	{
		String[] temp = name.split(",");
		String type = temp[0];

		if(type.equalsIgnoreCase("Soda"))
		{
			return new Soda(name);
		}
		else if(type.equalsIgnoreCase("Milkshake"))
		{
			return new Milkshake(name);
		}
		return null;
	}	

}
