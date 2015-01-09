//********************************IceCreamAdapter.java**********************************
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 10/03/13
//**************************************************************************************
//Purpose - Uses the Adapter pattern to link the adapt an Icecream item to the menu items
//**************************************************************************************
//Notes on specifications, special algorithms, and assumptions
//Capitalization will not matter.
//**************************************************************************************
package foodStorage;

public class IceCreamAdapter extends MenuItem
{
	IceCream adaptIceCream;
		
	public IceCreamAdapter(String name)
	{
        adaptIceCream = IceCreamFactory.createIceCreamItem(name);
	}
	
	public IceCreamAdapter(){}
	
	public void setIceCreamObject(IceCream obj)
	{
		adaptIceCream = obj;
	}
	
	public String GetName()
    {
        return adaptIceCream.GetName();
    }

    public float GetCost()
    {
        return adaptIceCream.GetCost();
    }

    public float GetPrice()
    {
        return adaptIceCream.GetPrice();
    }

    public float GetProfit()
    {
        return adaptIceCream.GetProfit();
    }

    public String GetFlavor()
    {
        return adaptIceCream.GetFlavor();
    }

    public String toString()
    {
        return adaptIceCream.toString();
    }
    
    public String rawString()
    {
    	return adaptIceCream.rawString();
    }
	
}
