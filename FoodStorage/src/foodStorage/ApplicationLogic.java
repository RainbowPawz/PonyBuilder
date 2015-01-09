//------------------------------------ApplicationLogic.java-----------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 12/02/13
//--------------------------------------------------------------------------------------
//Purpose - The main class to handle all the logic for the program
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//All Panels will send their requests to and form this class
//--------------------------------------------------------------------------------------
package foodStorage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import OrderClasses.Order;
import OrderClasses.OrderItem;
import Panels.AddDrinkPanel;
import Panels.AddPanel;
import Panels.BasicOrderPanel;
import Panels.DeletePanel;
import Panels.EditPanel;
import Panels.FilePanel;
import Panels.QuestionPanel;
import Panels.SearchPanel;
import Panels.TemplatePanel;

public class ApplicationLogic extends JPanel
{	
	private FoodStorage fStore = new FoodStorage();
	private Order order = new Order();
	private FileIO reader = new FileIO();
	String[] menuStrings = null;
	String[] orderStrings = null;


	TemplatePanel templatePanel;
	BasicOrderPanel orderPanel = new BasicOrderPanel(this);
	QuestionPanel questionPanel = new QuestionPanel(this);
	FilePanel filePanel = new FilePanel(this);
	SearchPanel searchPanel = new SearchPanel(this);
	AddPanel addPanel = new AddPanel(this);
	AddDrinkPanel addDrinkPanel = new AddDrinkPanel(this);
	EditPanel editPanel = new EditPanel(this);
	DeletePanel deletePanel = new DeletePanel(this);
	MenuActionListener mListener = new MenuActionListener();

	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem, menuItem2, menuItem3;

	//---------------------------------ApplicationLogic------------------------------
	//Description: Constructor for the Application logic
	//-------------------------------------------------------------------------------
	public ApplicationLogic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		BuildPanels();

		add(orderPanel);
		add(searchPanel);
		add(filePanel);
		add(questionPanel);
		add(addPanel);
		add(addDrinkPanel);
		add(editPanel);
		add(deletePanel);

		orderPanel.setVisible(false);
		questionPanel.setVisible(false);
		searchPanel.setVisible(false);
		editPanel.setVisible(false);
		addPanel.setVisible(false);
		addDrinkPanel.setVisible(false);
		deletePanel.setVisible(false);

		addPanel.repaint();

	}

	//---------------------------------LoadMenu--------------------------------------
	//Description: Load a menu item file
	//-------------------------------------------------------------------------------
	public void BuildPanels() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		orderPanel.buildPanel();
		addPanel.buildPanel();
		addDrinkPanel.buildPanel();
		filePanel.buildPanel();
		questionPanel.buildPanel();
		editPanel.buildPanel();
		deletePanel.buildPanel();
		searchPanel.buildPanel();

	}

	public JMenuBar createMenuBar() {

		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("File");
		menu.setFont (new Font ("Helvetica", Font.BOLD, 15));
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem2 = new JMenuItem("Open New File");
		menuItem2.addActionListener(mListener);
		menu.add(menuItem2);

		//a group of JMenuItems
		menuItem3 = new JMenuItem("Clear Old File");
		menuItem3.addActionListener(mListener);
		menu.add(menuItem3);

		//a group of JMenuItems
		menuItem = new JMenuItem("Exit",
				KeyEvent.VK_T);
		menuItem.addActionListener(mListener);
		menu.add(menuItem);

		return menuBar;
	}


	private class MenuActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			Object source = e.getSource();

			if(source.equals(menuItem))
			{
				Exit();
			}

			if(source.equals(menuItem2))
			{
				ClearMenu();
				OpenWindow("file");
			}

			if(source.equals(menuItem3))
			{
				questionPanel.textArea.setText(ClearMenu());
			}
		}
	}

	//---------------------------------LoadMenu--------------------------------------
	//Description: Load a menu item file
	//-------------------------------------------------------------------------------
	public void LoadMenu(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		reader.setFile(fileName);
		menuStrings = reader.readFile();
		fStore.initializeMenu(menuStrings);
		fStore.heapSort();			

		filePanel.setVisible(false);
		questionPanel.setVisible(true);

	}

	//---------------------------------GetMenuItem-------------------------------
	//Description: Gets the loaded menu
	//-------------------------------------------------------------------------------
	public String[] GetMenu() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		return fStore.GetMenu();
	}

	public String getRawMenu()
	{
		return fStore.GetRawMenu();
	}

	//---------------------------------AddMenuItem--------------------------------------
	//Description: Add a menu item to a file
	//-------------------------------------------------------------------------------
	public String AddMenuItem(String userItem)
	{
		String result = "";

		if (fStore.AddMenuItems(userItem) == true)
		{
			result = ("\nThe menu item, " + userItem + ", was successfully added.\n");
		}
		else if(fStore.AddMenuItems(userItem) == false)
		{
			result =("\nThe menu item, " + userItem + ", could not be found.\n");
		}
		return result;
	}

	public boolean AddMenuItemCheck(String userItem)
	{
		boolean bool = false;

		if (fStore.AddMenuItems(userItem) == true)
		{
			bool = true;
		}
		return bool;

	}

	public void AddMenuItem(MenuItem userItem)
	{
		fStore.AddMenuItems(userItem);

	}


	//---------------------------------OpenWindow------------------------------------
	//Description: Opens the corresponding panel when called
	//-------------------------------------------------------------------------------
	public void OpenWindow(String window)
	{
		switch(window)
		{
		case "question":
		{
			questionPanel.setVisible(true);

			orderPanel.setVisible(false);
			addDrinkPanel.setVisible(false);
			searchPanel.setVisible(false);
			filePanel.setVisible(false);
			editPanel.setVisible(false);
			addPanel.setVisible(false);
			deletePanel.setVisible(false);
			break;
		}
		case "search":
		{

			searchPanel.setVisible(true);

			orderPanel.setVisible(false);
			addDrinkPanel.setVisible(false);
			questionPanel.setVisible(false);
			filePanel.setVisible(false);
			editPanel.setVisible(false);
			addPanel.setVisible(false);
			deletePanel.setVisible(false);
			break;
		}
		case "file":
		{
			filePanel.setVisible(true);

			orderPanel.setVisible(false);
			addDrinkPanel.setVisible(false);
			questionPanel.setVisible(false);
			searchPanel.setVisible(false);
			editPanel.setVisible(false);
			addPanel.setVisible(false);
			deletePanel.setVisible(false);
			break;
		}
		case "add":
		{
			addPanel.setVisible(true);

			orderPanel.setVisible(false);
			addDrinkPanel.setVisible(false);
			questionPanel.setVisible(false);
			searchPanel.setVisible(false);
			filePanel.setVisible(false);
			editPanel.setVisible(false);
			deletePanel.setVisible(false);
			break;
		}
		case "addDrink":
		{
			addDrinkPanel.setVisible(true);

			orderPanel.setVisible(false);
			addPanel.setVisible(false);
			questionPanel.setVisible(false);
			searchPanel.setVisible(false);
			filePanel.setVisible(false);
			editPanel.setVisible(false);
			deletePanel.setVisible(false);
			break;
		}
		case "delete":
		{
			deletePanel.setVisible(true);

			orderPanel.setVisible(false);
			addDrinkPanel.setVisible(false);
			questionPanel.setVisible(false);
			searchPanel.setVisible(false);
			filePanel.setVisible(false);
			editPanel.setVisible(false);
			addPanel.setVisible(false);
			break;
		}
		case "edit":
		{
			editPanel.setVisible(true);

			orderPanel.setVisible(false);
			addDrinkPanel.setVisible(false);
			questionPanel.setVisible(false);
			searchPanel.setVisible(false);
			filePanel.setVisible(false);
			addPanel.setVisible(false);
			deletePanel.setVisible(false);
			break;
		}
		case "order":
		{
			orderPanel.setVisible(true);

			editPanel.setVisible(false);
			addDrinkPanel.setVisible(false);
			questionPanel.setVisible(false);
			searchPanel.setVisible(false);
			filePanel.setVisible(false);
			addPanel.setVisible(false);
			deletePanel.setVisible(false);
			break;
		}

		}
	}

	//---------------------------------FindMenuItem-------------------------------
	//Description: Initial FindMenuItem method
	//----------------------------------------------------------------------------
	public String FindMenuItem(String findUserItem, boolean rawString) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		String userSearch = "";

		userSearch = fStore.FindMenuItems(findUserItem, rawString);

		return userSearch;
	}


	//---------------------------------FindMenuItemString----------------------------
	//Description: Returns a string result for the search option
	//-------------------------------------------------------------------------------
	public String FindMenuItemString(String findUserItem)
	{
		String result = "";
		if ((fStore.FindMenuItemsCheck(findUserItem)== true))
		{
			result = ("\n" + fStore.FindMenuItems(findUserItem, false) + "\n");
		}
		else if(fStore.FindMenuItemsCheck(findUserItem) == false)
		{
			result =("\nThe menu item, " + findUserItem + ", could not be found.\n");
		}
		return result;
	}

	//---------------------------------FindMenuItemCheck-------------------------------
	//Description: Returns a Boolean value based on if an item was found successfully
	//---------------------------------------------------------------------------------
	public boolean FindMenuItemCheck(String deleteItem)
	{
		boolean result = false;
		if (fStore.FindMenuItemsCheck(deleteItem) == true)
		{
			result = true;
		}
		else if(fStore.FindMenuItemsCheck(deleteItem) == false)
		{
			result = false;
		}
		return result;
	}

	//---------------------------------RemoveMenuItem-------------------------------
	//Description: Remove a menu item
	//-------------------------------------------------------------------------------
	public String RemoveMenuItem(String deleteItem)
	{
		String result = "";
		if(fStore.DeleteMenuItems(deleteItem) == false)
		{
			result =("\nThe menu item, " + deleteItem + ", was successfully deleted.\n");
		}
		return result;
	}

	//---------------------------------RemoveMenuItemCheck-------------------------------
	//Description: Returns a Boolean value based on if the remove executed successfully
	//-----------------------------------------------------------------------------------
	public boolean RemoveMenuItemCheck(String deleteItem)
	{
		boolean result = false;
		if (fStore.DeleteMenuItems(deleteItem) == true)
		{
			result = true;
		}
		else if(fStore.DeleteMenuItems(deleteItem) == false)
		{
			result = false;
		}
		return result;
	}

	//---------------------------------PrintMenu-----------------------------------
	//Description: Print all the Menu items in the files
	//-----------------------------------------------------------------------------
	public String PrintMenu()
	{
		if(menuStrings != null)
		{
			System.out.println("Printing Menu");
			fStore.PrintMenu();
			fStore.heapSort();			
		}
		return fStore.PrintMenu();
	}

	//---------------------------------PrintMenu-----------------------------------
	//Description: Print all the Menu items in the files
	//-----------------------------------------------------------------------------
	public String ClearMenu()
	{			
		if(menuStrings != null)
		{
			fStore.ClearMenuItems();
		}
		return " ";
	}

	//---------------------------------Exit-----------------------------------
	//Description: Exit the systems and all panels call
	//------------------------------------------------------------------------
	public void Exit()
	{
		System.exit(0);
	}

	//---------------------------------WriteToFile----------------------------
	//Description: Allows the user to create their own files
	//------------------------------------------------------------------------
	public void WriteToFile(String data, String name, String compareType) 
	{	
		try 
		{	
			File file = new File(name + ".txt" );

			if (!file.exists()) 
			{	
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(compareType + "\n" + data);
			bw.close();
		} 
		catch (FileAlreadyExistsException x) 
		{
			System.err.format("file named %s" +
					" already exists%n");
		} 		
		catch (IOException x) 
		{
			// Some other sort of failure, such as permissions.
			System.err.format("createFile error: %s%n", x);
		}
	}

	//-------------------------------------------------------------------
	//Description:: Method to add an order item
	//-------------------------------------------------------------------
	public void AddOrderItem(OrderItem text)
	{	
		order.addingOrderItem(text);
	}

	//-------------------------------------------------------------------
	//Description: Get the preOrder data
	//-------------------------------------------------------------------
	public String getPreOrder()
	{
		return order.printOrder(); 
	}

	//-------------------------------------------------------------------
	//Description: Creats an order item
	//-------------------------------------------------------------------
	public OrderItem createOrderItem(String name, double price, int amount) 
	{
		OrderItem item;

		item = new OrderItem(name,price,amount);

		return item;
	}

	//-------------------------------------------------------------------
	//Description: Creates an order
	//-------------------------------------------------------------------
	public Order createOrder(String list) 
	{
		Order item2;

		item2 = new Order(list);

		return item2;
	}

	//-------------------------------------------------------------------
	//Description: Adds the order to the order array
	//-------------------------------------------------------------------
	public void AddOrder(Order text)
	{	
		order.addOrder(text);
	}

	//-------------------------------------------------------------------
	//Description: Prints the users initial order
	//-------------------------------------------------------------------
	public String printUserOrders(int choice)
	{
		return order.printUserOrder(choice); 
	}

	//-------------------------------------------------------------------
	//Description: Prints the paid order
	//-------------------------------------------------------------------
	public String printPOrders()
	{
		return order.printPaidOrder(); 
	}

	//-------------------------------------------------------------------
	//Description: Gets the sub totals for each item
	//-------------------------------------------------------------------
	public double getSubTotal()
	{
		return order.total(); 
	}

	//-------------------------------------------------------------------
	//Description: Makes a new order
	//-------------------------------------------------------------------
	public Order makeNewOrder()
	{
		return order.newOrder(); 
	}

	//-------------------------------------------------------------------
	//Description: Checks if the order array is emtpy
	//-------------------------------------------------------------------
	public boolean emptyCheck()
	{
		return order.emptyCheck();
	}

	//-------------------------------------------------------------------
	//Description: Checks to see if the users order exsits in the array
	//-------------------------------------------------------------------
	public boolean orderCheck(int userChoice)
	{
		return order.userOrderCheck(userChoice);
	}

}
