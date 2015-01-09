//--------------------------DessertBuilder.java---------------------------------
// Seth Welch
// CSCI 426
// Created: 10/14/13
// Last Modified: 10/19/13
//------------------------------------------------------------------------------
// Purpose: Create a new Dessert Menu Item using the builder method
//------------------------------------------------------------------------------

package foodStorage;

public class DessertBuilder extends Builder
{
	Dessert currentDessert;
	
	public void BuildMenuItem()
	{
		currentDessert = new Dessert();
	}
	
	public void setName(String name)
	{
		currentDessert.name = name;
	}
	
	public void setPrice(float price)
	{
		currentDessert.price = price;
	}
	
	public void setCost(float cost)
	{
		currentDessert.cost = cost;
	}
	
	public void setSpecialFields(String[] delim)
	{	
		currentDessert.IsCake(delim[4]);
		currentDessert.servings = Integer.parseInt(delim[5]);
		currentDessert.IsSpecial(delim[6]);	
	}
	
	@Override
	public MenuItem getMenuItem() 
	{
		return currentDessert;
	}
}