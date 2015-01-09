//------------------------------------BuilderFactory.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 10/13/13
//Last Modified: 10/19/13
//--------------------------------------------------------------------------------------
//Purpose - Factory method to call the specific builders
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//Capitalization will not matter.
//--------------------------------------------------------------------------------------
package foodStorage;

class BuilderFactory 
{
	public Builder getBuilder(String name)
	{

		if(name.equalsIgnoreCase("MEAL"))
		{
			return new MealBuilder();
		}
		else if(name.equalsIgnoreCase("APPETIZER"))
		{
			return new AppetizerBuilder();
		}
		else if(name.equalsIgnoreCase("DESSERT"))
		{
			return new DessertBuilder();
		}
		else if(name.equalsIgnoreCase("SODA"))
		{
			return new SodaBuilder();
		}
		else if(name.equalsIgnoreCase("MILKSHAKE"))
		{
			return new MilkshakeBuilder();
		}
		return null;
	}

}
