package foodStorage;

public class NameComparator extends Comparator {

	@Override
	public int CompareItem(MenuItem left, MenuItem right) 
	{	
		int answer = 0;	 
		
		if (left.GetName().compareToIgnoreCase(right.GetName()) < 1)
		{
			answer = -1;
		}
		 if (left.GetName().compareToIgnoreCase(right.GetName()) > 1)
		{
			answer = 1;
		}
		if (left.GetName().compareToIgnoreCase(right.GetName()) == 1)
		{
			answer = 0;
		}
		return answer;	
	}
	
	public String toString()
	{
		return "Sorted by Name\n";
	}
	
	public String getCompareType()
	{
		return "Name";
	}

}
