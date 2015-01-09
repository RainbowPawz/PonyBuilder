//**************************************MenuItemDirector.java**************************************
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 10/13/13
//Last Modified: 
//**************************************************************************************
//Purpose - Creates the initial interface for the builder pattern
//**************************************************************************************
//Notes on specifications, special algorithms, and assumptions
//None at this moment
//**************************************************************************************
package foodStorage;

public class MenuItemDirector  
{
	public MenuItem createMenuItem(Builder builder, String data)
	{
		String[] delim = data.split(",");
		System.out.println("Builder: " + builder);
		builder.BuildMenuItem();
		builder.setName(delim[1]);
		builder.setCost(Float.parseFloat(delim[2]));
		builder.setPrice(Float.parseFloat(delim[3]));
		builder.setSpecialFields(delim);
		
		return builder.getMenuItem();			
	}
}
