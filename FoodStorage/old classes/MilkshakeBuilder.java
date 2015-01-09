//**************************************MilkShake.java**************************************
//Mike Banzet, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 10/14/2013
//Last Modified: 10/19/2013
//**************************************************************************************
//Purpose - Creates MilkShake Items
//**************************************************************************************

package foodStorage;

public class MilkshakeBuilder extends Builder
{
	Milkshake currentMilkshake;
	
	public void BuildMenuItem()
	{
		currentMilkshake = new Milkshake();
	}
	
	public void setName(String name)
	{
		currentMilkshake.name = name;
	}
	
	public void setPrice(float price)
	{
		currentMilkshake.price = price;
	}
	
	public void setCost(float cost)
	{
		currentMilkshake.cost = cost;
	}
	
	public void setSpecialFields(String[] delim)
	{	
		currentMilkshake.flavor = (delim[4]);
		currentMilkshake.iceCream =(delim[5]);
		currentMilkshake.maltPowderScoops = Integer.parseInt(delim[6]);
	}
	
	@Override
	public MenuItem getMenuItem() 
	{
		IceCreamAdapter adapt  = new IceCreamAdapter();
		adapt.setIceCreamObject(currentMilkshake);
		return adapt;
	}
}



