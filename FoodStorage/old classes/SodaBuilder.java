//**************************************MilkShake.java**************************************
//Mike Banzet, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 10/14/2013
//Last Modified: 10/19/2013
//**************************************************************************************
//Purpose - Creates Soda Items
//**************************************************************************************

package foodStorage;

public class SodaBuilder extends Builder
{
	
	Soda currentSoda;
	
	public void BuildMenuItem()
	{
		currentSoda = new Soda();
	}
	
	public void setName(String name)
	{
		currentSoda.name = name;
	}
	
	public void setPrice(float price)
	{	
		currentSoda.price = price;
	}
	
	public void setCost(float cost)
	{	
		currentSoda.cost = cost;
	}
	
	public void setSpecialFields(String[] delim)
	{	
		currentSoda.flavor = (delim[4]);
		currentSoda.iceCream =(delim[5]);
		currentSoda.whippedCream(delim[6]);
	}
	
	@Override
	public MenuItem getMenuItem() 
	{
		IceCreamAdapter adapt  = new IceCreamAdapter();
		adapt.setIceCreamObject(currentSoda);
		return adapt;
	}	
}
