//******************************************************************************
// Heather Shadoan CSCI 426
// Created: 09/12/13
// FileName: PriceComparator.java
//******************************************************************************
// Purpose: Price comparator class
//******************************************************************************

package foodStorage;

public class PriceComparator extends Comparator 
{
	@Override
	public int CompareItem(MenuItem left, MenuItem right) 
	{	
		int result = 0;
		
		if (left.GetPrice() < right.GetPrice())
		{
			result = -1;
		}
		if (left.GetPrice() > right.GetPrice())
		{
			result = 1;
		}
		if (left.GetPrice() == right.GetPrice())
		{
			result = 0;
		}
		return result;	        
	}
	
	public String toString()
	{
		return "Sorted by Price\n";
	}
	
	public String getCompareType()
	{
		return "Price";
	}
	
	
}
