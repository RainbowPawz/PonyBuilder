//******************************FoodStorage.java********************************
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/12/13
//Last Modified: 10/03/13
//******************************************************************************
//Purpose - The main storage class for all the menu items.
//******************************************************************************
//Notes on specifications, special algorithms, and assumptions
//Heap sort is instantiated here.
//******************************************************************************

package foodStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.management.InvalidAttributeValueException;

public class FoodStorage 
{
	private ItemFactory itemFactory = new ItemFactory();
	private CompareFactory comparatorFactory = new CompareFactory();
	private Comparator newCompare;
	private ArrayList<MenuItem> itemStore = new ArrayList<MenuItem>();

	//******************************************************************************
	//Description: Initialize the Menu
	//******************************************************************************
	public String[] initializeMenu(String[] items)
	{
		chooseComparator(items[0]);
		createMenuItems(items);

		return items;
	}

	//******************************************************************************
	//Description: Gets the menu
	//******************************************************************************
	public String[] GetMenu()
	{
		if(itemStore.size() > 0)
		{
			String[] menuList = new String[itemStore.size()];
			Iterator<MenuItem> items = itemStore.iterator();
			int count = 0;

			while(items.hasNext())
			{
				menuList[count] = items.next().toString();
				count++;
			}

			return menuList;
		}

		return null;
	}

	//******************************************************************************
	//Description: Gets the menu
	//******************************************************************************
	public String GetRawMenu()
	{
		String menuList = "";

		Iterator<MenuItem> items = itemStore.iterator();
		
			while(items.hasNext())
			{
				menuList += items.next().rawString() + "\n";		
			}
		

		return menuList;
	}

	//******************************************************************************
	//Description: Create the Menu Items
	//******************************************************************************

	protected void createMenuItems(String[] temp)
	{ 
		for(int i = 0; i < temp.length; i++){

			MenuItem tempItem = itemFactory.createMenuItem(temp[i]);

			if(tempItem != null)
			{
				itemStore.add(tempItem); 				
			}
		}		 
	}

	protected boolean createMenuItem(String temp)
	{
		MenuItem newItem = itemFactory.createMenuItem(temp);
		itemStore.add(newItem);

		if(newItem != null)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	//******************************************************************************
	//Description: Add a Menu items, overloaded methods for the successful adding
	//of the MenuItem.
	//******************************************************************************

	public void AddMenuItems(MenuItem userItem)
	{
		itemStore.add(userItem);
	}

	public boolean AddMenuItems(String temp)
	{
		boolean success = createMenuItem(temp);

		return success;	
	}

	public Boolean AddItem(MenuItem item)
	{
		String error = "";

		try
		{    
			itemStore.add(item);
			itemStore.set(0, item);

			return true;
		}
		catch (Exception ex)
		{
			error = ex.getMessage();
		}
		return false;
	}


	//******************************************************************************
	//Description: Delete a selected Menu Item based upon a name reference
	//******************************************************************************

	public boolean DeleteMenuItems(String deleteItem)
	{	
		String userChoice = "Item not found.";
		Iterator<MenuItem> items = itemStore.iterator();
		MenuItem item;

		boolean bool = false;

		while(items.hasNext())
		{
			item = items.next();

			if (item != null && item.GetName().equalsIgnoreCase(deleteItem))
			{	
				userChoice = item.toString();
				bool = itemStore.remove(item);

				break;
			}
			if( item == null)
			{
				bool = false;
			}	
		}

		return bool;
	}

	public void ClearMenuItems()
	{
		itemStore.clear();
	}

	//*************************************************************************************
	//Description: Find a Menu Item based upon the name and return a string of the listing
	//*************************************************************************************

	public String FindMenuItems(String name, boolean rawString)
	{

		String userChoice = "Item not Found";
		Iterator<MenuItem> items = itemStore.iterator();
		MenuItem item;

		while(items.hasNext())
		{
			item = items.next();
			if (item != null && item.GetName().equalsIgnoreCase(name))
			{
				if(rawString){
					userChoice = item.rawString();				
				}
				else
				{	
					userChoice = item.toString();				
				}	
				break;
			}		
		}	
		return userChoice;
	}

	public boolean FindMenuItemsCheck(String name)
	{

		String userChoice = "Item not found.";
		Iterator<MenuItem> items = itemStore.iterator();
		MenuItem item;
		boolean bool = false;

		while(items.hasNext())
		{
			item = items.next();

			if (item != null && item.GetName().equalsIgnoreCase(name))
			{	
				userChoice = item.toString();
				bool = true;
				break;
			}
			if( item == null)
			{
				bool = false;
			}	
		}
		return bool;
	}
	
	public Iterator<MenuItem> getMenuArray(){
		
		return itemStore.iterator();
		
	}

	//******************************************************************************
	//Description: Print Menu list
	//******************************************************************************

	public String PrintMenu()
	{
		String menuString = "";

		menuString += newCompare.toString();

		Iterator<MenuItem> it;

		it = itemStore.iterator();

		while(it.hasNext())
		{
			menuString += it.next().toString();
		}

		return menuString;		
	}


	//******************************************************************************
	//Description: Choose the comparator
	//******************************************************************************

	protected void chooseComparator(String compType)
	{
		newCompare = comparatorFactory.returnComparator(compType);
	}

	//******************************************************************************
	//Description: Heap sort algorithm.
	//******************************************************************************

	public void heapSort()
	{
		// buildHeap //
		for (int index = itemStore.size() / 2; index >= 0; index--)
		{  
			trickleDown(itemStore, index, itemStore.size());
		}

		// deleteMax //
		for (int index = itemStore.size() - 1; index > 0; index--)
		{
			swap(itemStore, index, 0);            
			trickleDown(itemStore, 0, index);
		}
	}

	//******************************************************************************
	//Description: Calculate the left child.
	//******************************************************************************

	public int leftChild(int i)
	{
		return (2 * i + 1);
	}
	//******************************************************************************
	//Description: TrickleDown method for the Heap Sort
	//******************************************************************************

	public void trickleDown(ArrayList<MenuItem> unsortedList, int top, int bottom)
	{
		int root = top;
		MenuItem temp; 

		for(temp = unsortedList.get(top); leftChild(top) < bottom; top = root)
		{
			int child = leftChild(root);
			int swap = root;

			if(newCompare.CompareItem(unsortedList.get(swap), unsortedList.get(child)) == -1)
			{
				swap = child;
			}
			if((child != bottom -1 ) && newCompare.CompareItem(unsortedList.get(swap), unsortedList.get(child + 1)) == -1)
			{
				swap = child + 1;
			}
			if(swap != root)
			{
				swap(unsortedList, root, swap);
				root = swap;
			}
			else
			{
				return;
			}
		}

	}

	//******************************************************************************
	//Description: Swap two elements in the list
	//******************************************************************************

	public void swap(ArrayList<MenuItem> unsortedList, int indexOne, int indexTwo)
	{
		MenuItem holder = unsortedList.get(indexOne);

		unsortedList.set(indexOne, unsortedList.get(indexTwo));
		unsortedList.set(indexTwo, holder);
	}
}
