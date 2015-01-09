//------------------------------------Pop.cs--------------------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/12/13
//Last Modified: 09/25/13
//--------------------------------------------------------------------------------------
//Purpose - The PriceComparator class will compare MenuItems by cost.
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions.
//none
//--------------------------------------------------------------------------------------

package foodStorage;

public class CostComparator extends Comparator
{
	@Override
	public int CompareItem(MenuItem left, MenuItem right) 
	{	
		int result = 0;
		
		if (left.GetCost() < right.GetCost())
		{
			result = -1;
		}
		if (left.GetCost() > right.GetCost())
		{
			result = 1;
		}
		if (left.GetCost() == right.GetCost())
		{
			result = 0;
		}
		return result;	        
	}
	
	public String toString()
	{
		return "Sorted by Cost\n";
	}
	
	public String getCompareType()
	{
		return "Cost";
	}
}
