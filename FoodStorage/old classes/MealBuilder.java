//----------------------------MealBuilder.java----------------------------------
// Seth Welch
// CSCI 426
// Created: 10/14/13
// Last Modified: 10/19/13
//------------------------------------------------------------------------------
// Purpose: Create a new Meal Menu Item using the builder method
//------------------------------------------------------------------------------
package foodStorage;

public class MealBuilder extends Builder
{
	Meal currentMeal;
	
	public void BuildMenuItem()
	{
		currentMeal = new Meal();
	}
	
	public void setName(String name)
	{
		currentMeal.name = name;
	}
	
	public void setPrice(float price)
	{
		currentMeal.price = price;
	}
	
	public void setCost(float cost)
	{
		currentMeal.cost = cost;
	}
	
	public void setSpecialFields(String[] delim)
	{
		currentMeal.IsSalad(delim[4]);
		currentMeal.cookTime = Integer.parseInt(delim[5]);
		currentMeal.IsOrganic(delim[6]);	
	}
	
	@Override
	public MenuItem getMenuItem() 
	{	
		return currentMeal;
	}
}
