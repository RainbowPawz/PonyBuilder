//******************************************************************************
// Heather Shadoan CSCI 426
// Created: 09/12/13
// FileName: ItemFactory.java
//******************************************************************************
// Purpose: Factory to create new Menu Items based on their String name.
//******************************************************************************

package foodStorage;

class ItemFactory 
{
	public MenuItem createMenuItem(String name)
	{
		String[] temp = name.split(",");
		
		if (temp.length == 1)
			return null;
		
		String type = temp[0];

		if(type.equalsIgnoreCase("MEAL"))
		{
			return new Meal(name);
		}
		else if(type.equalsIgnoreCase("APPETIZER"))
		{
			return new Appetizer(name);
		}
		else if(type.equalsIgnoreCase("DESSERT"))
		{
			return new Dessert(name);
		}
		if(type.equalsIgnoreCase("WINE"))
		{
			return new Wine(name);
		}
		else if(type.equalsIgnoreCase("BEER"))
		{
			return new Beer(name);
		}
		else if(type.equalsIgnoreCase("IRKENBOOZE"))
		{
			return new IrkenBooze(name);
		}
		else if(type.equalsIgnoreCase("TEA"))
		{
			return new Tea(name);
		}
		else
		{
			return new IceCreamAdapter(name);
		}
		
	}	
}
