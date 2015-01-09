//******************************************************************************
// Heather Shadoan CSCI 426
// Created: 09/12/13
// FileName: ProfitComparator.java
//******************************************************************************
// Purpose: Profit comparator class
//******************************************************************************

package foodStorage;

public class ProfitComparator extends Comparator
{	
	@Override
	 public int CompareItem(MenuItem left, MenuItem right) 
	{	
		int result = 0;
		
		if (left.GetProfit() < right.GetProfit())
		{
			result = -1;
		}
		 if (left.GetProfit() > right.GetProfit())
		{
			result = 1;
		}
		if (left.GetProfit() == right.GetProfit())
		{
			result = 0;
		}
		return result;	        
	}

	public String toString()
	{
		return "Sorted by Profit\n";
	}
	
	public String getCompareType()
	{
		return "Profit";
	}
}
