//******************************************************************************
// Heather Shadoan CSCI 426
// Created: 09/12/13
// FileName: CompareFactory.java
//******************************************************************************
// Purpose: Factory to create new Comparators based on their String type.
//******************************************************************************

package foodStorage;

public class CompareFactory 
{
	
	public Comparator returnComparator(String type)
	{		
		if(type.equalsIgnoreCase("Cost"))
		{
			return new CostComparator();
		}
		else if(type.equalsIgnoreCase("Price"))
		{
			return new PriceComparator();
		}
		else if(type.equalsIgnoreCase("Profit"))
		{
			return new ProfitComparator();
		}
		else if(type.equalsIgnoreCase("Name"))
		{
			return new NameComparator();
		}
		

		return null;		
	}
}
