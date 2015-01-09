//--------------------------AppetizerBuilder.java-------------------------------
// Seth Welch
// CSCI 426
// Created: 10/14/13
// Last Modified: 10/19/13
//------------------------------------------------------------------------------
// Purpose: Create a new Appetizer Menu Item using the builder method
//------------------------------------------------------------------------------

package foodStorage;

public class AppetizerBuilder extends Builder{
	
	Appetizer currentAppetizer;
	
	public void BuildMenuItem()
	{
		currentAppetizer = new Appetizer();
	}
	
	public void setName(String name)
	{
		currentAppetizer.name = name;
	}
	
	public void setPrice(float price)
	{
		currentAppetizer.price = price;
	}
	
	public void setCost(float cost)
	{
		currentAppetizer.cost = cost;
	}
	
	public void setSpecialFields(String[] delim)
	{
		currentAppetizer.isCold(delim[4]);
		currentAppetizer.prepTime = Integer.parseInt(delim[5]);
		currentAppetizer.country = (delim[6]);	
	}
	
	@Override
	public MenuItem getMenuItem() 
	{	
		return currentAppetizer;
	}
}
