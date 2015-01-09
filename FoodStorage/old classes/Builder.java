//------------------------------------Builder.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 10/13/13
//Last Modified: 10/19/13
//--------------------------------------------------------------------------------------
//Purpose - Parent class to all child builders with unimplemented methods
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//--------------------------------------------------------------------------------------
package foodStorage;

public abstract class Builder 
{
	public abstract void BuildMenuItem();
	public abstract void setName(String data);
	public abstract void setCost(float cost);
	public abstract void setPrice(float price);
	public abstract void setSpecialFields(String[] data);
	public abstract MenuItem getMenuItem();
}
