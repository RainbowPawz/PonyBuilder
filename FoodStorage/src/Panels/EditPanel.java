//------------------------------------EditPanel.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/12/13
//Last Modified: 10/03/13
//--------------------------------------------------------------------------------------
//Purpose - Creates the initial EditPanel, here this panel will request user input
//          to search for an item and then edit it if one exits in the search.
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//Capitalization will not matter.
//--------------------------------------------------------------------------------------
package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import foodStorage.ApplicationLogic;



public class EditPanel extends TemplatePanel
{

	//------------------------------------------------------------------
	//Description: Variables instantiations
	//------------------------------------------------------------------
	private JRadioButton[] radioButtons = new JRadioButton[9];// appetizer, meal, dessert, soda, milkshake
	private static JButton[] actionButtons = new JButton[3];
	JTextField searchField = new JTextField(26);
	JTextField pTextFields[];

	//------------------------------------------------------------------
	//Description: Menu variables instantiations
	//------------------------------------------------------------------
	String APPETIZER_MENU = "Appetizer,Name,Cost,Price,Cold Dish (Type True or False)                 ,Prep Time in Minutes,Country of Origin";
	String MEAL_MENU =      "Meal,Name,Cost,Price,Salad Dish (Type True or False)               ,Cook Time in Minutes,Organic (Type True or False)";
	String DESSERT_MENU =   "Dessert,Name,Cost,Price,Cake Dish (Type True or False)                ,Servings,Special Dish (Type True or False)";																			
	String SODA_MENU =      "Soda,Name,Cost,Price,Flavor,Ice Cream Flavor,Whippedcream (Type True or False)      ";
	String MILKSHAKE_MENU = "Milkshake,Name,Cost,Price,Flavor,Ice Cream Flavor,Number of Malt Scoops                             ";
	String WINE_MENU =      "Wine,Name,Cost,Price,Red Wine(Type True or False)                 ,Year Vintage,Country of Origin";
	String BEER_MENU =      "Beer,Name,Cost,Price,Has Foam (Type True or False)               ,Is Ale (Type True or False) ,Flavor   ";
	String IRKENBOOZE_MENU ="IrkenBooze,Name,Cost,Price,Toxic Scale (0-10)                                      ,Chilled (Type True or False),Planet Of Origin ";																			
	String TEA_MENU =       "Tea,Name,Cost,Price,Is it Herbal(Type True or False)               ,Is it Loose Leaf (Type True or False),Is it Hot (Type True or False)      ";
	
	private TextListener tListener = new TextListener();

	MenuItemEntryPanel menuPanel = new MenuItemEntryPanel(APPETIZER_MENU);
	RetrieveItemPanel rItem = new RetrieveItemPanel();
	JButton enterButton = new JButton("SEARCH");

	public EditPanel(ApplicationLogic appLogic) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.appLogic = appLogic;
	}
	
	void specialFeatures() 
	{
		//-------------------------------------------------------------------
		//Description:Creates variables and sets up the borders
		//-------------------------------------------------------------------

		searchLabel = new JLabel("Edit a Menu Item! ");

		tListener = new TextListener();
		ButtonActionListener bListener = new ButtonActionListener(this);
		CheckListener cListener = new CheckListener();

		//-------------------------------------------------------------------
		//Description: Creates the Checkboxes and instantiates each
		//-------------------------------------------------------------------
		radioButtons[0] = new JRadioButton("Appetizer");
		radioButtons[1] = new JRadioButton("Meal");
		radioButtons[2] = new JRadioButton("Dessert");
		radioButtons[3] = new JRadioButton("Soda");
		radioButtons[4] = new JRadioButton("Milkshake");
		radioButtons[5] = new JRadioButton("Wine");
		radioButtons[6] = new JRadioButton("Beer");
		radioButtons[7] = new JRadioButton("Irken Booze");
		radioButtons[8] = new JRadioButton("Tea");

		checkPanel.add(Box.createRigidArea(new Dimension(1 , 5)));
		
		for(int i = 0; i < 9; i++)
		{
			radioButtons[i].addActionListener (cListener);
			radioButtons[i].setBackground(Color.getHSBColor(0.55f,0.3f,0.99f));
			checkPanel.setBackground(Color.getHSBColor(0.55f,0.3f,0.99f));
			checkPanel.add(Box.createRigidArea(new Dimension(27 , 5)));
			checkPanel.add(Box.createHorizontalGlue());
			checkPanel.add(radioButtons[i]);
			checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.LINE_AXIS));
		}
		
		checkPanel.add(Box.createRigidArea(new Dimension(34 , 5)));
		checkPanel.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));
		
		//-------------------------------------------------------------------
		//Description: Creates a new textArea
		//-------------------------------------------------------------------
		textArea = new JTextArea(15, 55);
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);

		//-------------------------------------------------------------------
		//Description: Creates the imagePane and sets it position
		//-------------------------------------------------------------------
		ImageIcon startIcon = new ImageIcon("images/ponies/rareSearch.png");
		image = new JLabel(startIcon);//Sets the image JLabel
		imagePane.setLayout(new BoxLayout(imagePane, BoxLayout.LINE_AXIS));	
		imagePane.setBackground (Color.getHSBColor(0.55f,0.3f,0.99f));
		imagePane.add(Box.createHorizontalGlue());
		imagePane.add(image);	

		//-------------------------------------------------------------------
		//Description: Sets the background for the search label
		//-------------------------------------------------------------------
		searchLabel.setBackground(Color.getHSBColor(0.55f,0.3f,0.99f));		

		//-------------------------------------------------------------------
		//Description: Sets the labels for the buttons
		//-------------------------------------------------------------------
		actionButtons[0] = new JButton("EDIT THE ITEM");
		actionButtons[1] = new JButton("BACK TO MENU");
		actionButtons[2] = new JButton("EXIT");

		//-------------------------------------------------------------------
		//Description: For loop to instantiate all the buttons
		//-------------------------------------------------------------------
		buttonPane.add(Box.createRigidArea(new Dimension(180, 5)));
		buttonPane.add(searchLabel);
		
		for(int i = 0; i < 3; i++)
		{	
			actionButtons[i].addActionListener(bListener);
			add(actionButtons[i]);
			buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
			buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			buttonPane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
			buttonPane.add(Box.createRigidArea(new Dimension(37 , 5)));
			buttonPane.add(Box.createHorizontalGlue());
			buttonPane.add(actionButtons[i]);
		}

		//-------------------------------------------------------------------
		//Description: Add to the buttonPane the border
		//-------------------------------------------------------------------
		buttonPane.add(Box.createRigidArea(new Dimension(179, 5)));
		buttonPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		enterButton.addActionListener(bListener);

		rItem.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));		
		rItem.setLayout(new BoxLayout(rItem, BoxLayout.LINE_AXIS));	
		rItem.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));		
		rItem.add(Box.createHorizontalGlue());	
		rItem.add(Box.createRigidArea(new Dimension(17,5)));	
		rItem.add(enterButton);
		rItem.add(Box.createRigidArea(new Dimension(198,5)));

		//-------------------------------------------------------------------
		//Description: Sets up the EditPanel and adds all the panes
		//-------------------------------------------------------------------

		add(heading, BorderLayout.NORTH);
		add(imagePane, BorderLayout.CENTER);
		add(rItem, BorderLayout.CENTER);
		add(checkPanel, BorderLayout.CENTER);
		add(menuPanel, BorderLayout.WEST);
		add(scrollPane, BorderLayout.EAST);
		add(buttonPane, BorderLayout.SOUTH);

		checkPanel.setVisible(false);
		menuPanel.setVisible(false);
	}

	public void setVisible(boolean v)
	{
		super.setVisible(v);
		this.textArea.setText("");
		this.searchField.setText("");
		for(int i = 0; i < pTextFields.length; i++)
		{
			this.pTextFields[i].setText("");
		}
		image.setIcon( new ImageIcon("images/ponies/rareSearch.png"));	
		imagePane.add(image);	
	}
	//-------------------------------------------------------------------
	//Description: Adds the Item data
	//-------------------------------------------------------------------
	public String addEntryData()
	{
		try 
		{
			rItem.RemoveSearch();
		} 
		catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) 
		{
			e.printStackTrace();
		}
		String temp = menuPanel.getCurrentData();
		String[] delim = temp.split(",");
		System.out.println( "Deleting: " + delim[1]);
		appLogic.AddMenuItem(temp);

		return temp;
	}

	//-------------------------------------------------------------------
	//Description: Retrieves the needed Item data
	//-------------------------------------------------------------------
	public String retrieveItemData(String searchTerm) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		return appLogic.FindMenuItem(searchTerm, true);
	}

	//-------------------------------------------------------------------
	//Description: Loads the needed search data
	//-------------------------------------------------------------------
	public void loadSearchData(String data)
	{
		menuPanel.loadSavedData(data);
	}

	//-------------------------------------------------------------------
	//Description: TextListener that responds when the user hits the enter
	//             key
	//-------------------------------------------------------------------
	public class TextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent mEvent) 
		{	
			try 
			{
				rItem.SearchForTerm();
				rItem.setVisible(true);
				menuPanel.setVisible(true);
				checkPanel.setVisible(true);
			} 
			catch (UnsupportedAudioFileException | IOException
					| LineUnavailableException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//-------------------------------------------------------------------
	//Description: Button listeners that calls the needed appLogic
	//-------------------------------------------------------------------
	private class ButtonActionListener implements ActionListener
	{
		EditPanel mainPanel;

		private ButtonActionListener(EditPanel editPanel)
		{
			this.mainPanel = editPanel;
		}

		public void actionPerformed(ActionEvent mEvent) 
		{
			Object source = mEvent.getSource();	

			if(source == enterButton)
			{
				try 
				{
					rItem.SearchForTerm();
					rItem.setVisible(true);
					menuPanel.setVisible(true);
					checkPanel.setVisible(true);

				} 
				catch (UnsupportedAudioFileException | IOException
						| LineUnavailableException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if(source == actionButtons[0])
			{			
				String temp = mainPanel.addEntryData();

				if(temp != null)
				{
					image.setIcon( new ImageIcon("images/ponies/rareSuccess.png"));	
					imagePane.add(image);
					textArea.append(temp + "\n");
				}	

			}

			if(source == actionButtons[1])
			{			
				appLogic.OpenWindow("question");	
			}

			if(source == actionButtons[2])
			{			
				appLogic.Exit();
			}
		}
	}

	//-------------------------------------------------------------------
	//Description: Listens to the corresponding checkbox
	//-------------------------------------------------------------------
	private class CheckListener implements ActionListener
	{
		String APPETIZER_MENU = "Appetizer,Name,Cost,Price,Cold Dish (Type True or False)                ,Prep Time in Minutes,Country of Origin";
		String MEAL_MENU =      "Meal,Name,Cost,Price,Salad Dish (Type True or False)              ,Cook Time in Minutes,Organic (Type True or False)";
		String DESSERT_MENU =   "Dessert,Name,Cost,Price,Cake Dish (Type True or False)               ,Servings,Special Dish (Type True or False)";																			
		String SODA_MENU =      "Soda,Name,Cost,Price,Flavor,Ice Cream Flavor,Whippedcream (Type True or False)     ";
		String MILKSHAKE_MENU = "Milkshake,Name,Cost,Price,Flavor,Ice Cream Flavor,Number of Malt Scoops                            ";
		String WINE_MENU =      "Wine,Name,Cost,Price,Red Wine(Type True or False)                 ,Year Vintage,Country of Origin";
		String BEER_MENU =      "Beer,Name,Cost,Price,Has Foam (Type True or False)               ,Is Ale (Type True or False) ,Flavor   ";
		String IRKENBOOZE_MENU ="IrkenBooze,Name,Cost,Price,Toxic Scale (0-10)                                      ,Chilled (Type True or False),Planet Of Origin ";																			
		String TEA_MENU =       "Tea,Name,Cost,Price,Is it Herbal(Type True or False)               ,Is it Loose Leaf (Type True or False),Is it Hot (Type True or False)      ";
		
		public void actionPerformed(ActionEvent mEvent) 
		{
			Object source = mEvent.getSource();	

			if(source == radioButtons[0])
			{		
				menuPanel.resetLabels(APPETIZER_MENU);
				radioButtons[0].setSelected(true);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(false);
				radioButtons[5].setSelected(false);
				radioButtons[6].setSelected(false);
				radioButtons[7].setSelected(false);
				radioButtons[8].setSelected(false);
			}

			else if(source == radioButtons[1])
			{			
				menuPanel.resetLabels(MEAL_MENU);
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(true);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(false);
				radioButtons[5].setSelected(false);
				radioButtons[6].setSelected(false);
				radioButtons[7].setSelected(false);
				radioButtons[8].setSelected(false);
			}

			else if(source == radioButtons[2])
			{			
				menuPanel.resetLabels(DESSERT_MENU);
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(true);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(false);
				radioButtons[5].setSelected(false);
				radioButtons[6].setSelected(false);
				radioButtons[7].setSelected(false);
				radioButtons[8].setSelected(false);
			}
			else if(source == radioButtons[3])
			{		
				menuPanel.resetLabels(SODA_MENU);
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(true);
				radioButtons[4].setSelected(false);
				radioButtons[5].setSelected(false);
				radioButtons[6].setSelected(false);
				radioButtons[7].setSelected(false);
				radioButtons[8].setSelected(false);

			}

			else if(source == radioButtons[4])
			{	
				menuPanel.resetLabels(MILKSHAKE_MENU);
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(true);
				radioButtons[5].setSelected(false);
				radioButtons[6].setSelected(false);
				radioButtons[7].setSelected(false);
				radioButtons[8].setSelected(false);
			}
			
			else if(source == radioButtons[5])
			{		
				menuPanel.resetLabels(WINE_MENU);
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(false);
				radioButtons[5].setSelected(true);
				radioButtons[6].setSelected(false);
				radioButtons[7].setSelected(false);
				radioButtons[8].setSelected(false);

			}

			else if(source == radioButtons[6])
			{			
				menuPanel.resetLabels(BEER_MENU);	
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(false);
				radioButtons[5].setSelected(false);
				radioButtons[6].setSelected(true);
				radioButtons[7].setSelected(false);
				radioButtons[8].setSelected(false);

			}

			else if(source == radioButtons[7])
			{			
				menuPanel.resetLabels(IRKENBOOZE_MENU);
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(false);
				radioButtons[5].setSelected(false);
				radioButtons[6].setSelected(false);
				radioButtons[7].setSelected(true);
				radioButtons[8].setSelected(false);

			}
			else if(source == radioButtons[8])
			{		
				menuPanel.resetLabels(TEA_MENU);
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(false);
				radioButtons[5].setSelected(false);
				radioButtons[6].setSelected(false);
				radioButtons[7].setSelected(false);
				radioButtons[8].setSelected(true);
			}
		}
	}

	//-------------------------------------------------------------------
	//Description: Creates new Item panels and resets the values and labels
	//-------------------------------------------------------------------
	private class MenuItemEntryPanel extends JPanel
	{
		//JTextField[] pTextFields;
		JLabel[] pLabelList;
		String currentType = "Appetizer";

		public MenuItemEntryPanel(String fieldNames)
		{

			String[] delim = fieldNames.split(",");
			currentType = delim[0];
			pTextFields = new JTextField[delim.length - 1];
			pLabelList = new JLabel[delim.length - 1];

			for(int i = 0; i < delim.length - 1; i++)
			{
				pLabelList[i] = new JLabel(delim[i + 1]);
				pTextFields[i] = new JTextField(8);

				pTextFields[i].addActionListener(tListener);
				pTextFields[i].setEditable(true);

				add(pLabelList[i]);
				add(pTextFields[i]);
			}

			setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));		
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	
			setBackground (Color.getHSBColor(0.55f,0.3f,0.99f));		
			add(Box.createHorizontalGlue());	
			add(Box.createRigidArea(new Dimension(10,0)));	

		}

		//-------------------------------------------------------------------
		//Description: Resets the text labels
		//-------------------------------------------------------------------
		public void resetLabels(String newLabels)
		{
			String[] delim = newLabels.split(",");
			currentType = delim[0];

			for(int i = 0; i < delim.length - 1; i++)
			{
				pLabelList[i].setText(delim[i + 1]);
			}
		}

		//-------------------------------------------------------------------
		//Description: Loads the needed saved data into the corresponding
		//             text fields
		//-------------------------------------------------------------------
		public void loadSavedData(String data)
		{
			String[] delim = data.split(",");

			setLabels(delim[0]);

			for(int i = 0; i < pTextFields.length; i++)
			{
				if(data != null)
				{
					image.setIcon( new ImageIcon("images/ponies/foundRare.png"));	
					imagePane.add(image);
					pTextFields[i].setText(delim[i + 1]);
				}
				
				else if(data == null)
				{
					image.setIcon( new ImageIcon("images/ponies/sadRare.png"));	
					imagePane.add(image);
					pTextFields[i].setText("");
				}
			}
		}

		//-------------------------------------------------------------------
		//Description: Sets the labels
		//-------------------------------------------------------------------
		private void setLabels(String label)
		{
			String item = label.toUpperCase();
			switch (item)
			{
			case "APPETIZER":
			{
				resetLabels(APPETIZER_MENU);
				radioButtons[0].doClick();
				break;
			}
			case "MEAL":
			{
				resetLabels(MEAL_MENU);
				radioButtons[1].doClick();
				break;
			}
			case "DESSERT":
			{
				resetLabels(DESSERT_MENU);
				radioButtons[2].doClick();
				break;
			}
			case "SODA":
			{
				resetLabels(SODA_MENU);
				radioButtons[3].doClick();
				break;
			}
			case "MILKSHAKE":
			{
				resetLabels(MILKSHAKE_MENU);
				radioButtons[4].doClick();
				break;
			}
			case "WINE":
			{
				resetLabels(WINE_MENU);
				radioButtons[5].doClick();
				break;
			}
			case "BEER":
			{
				resetLabels(BEER_MENU);
				radioButtons[6].doClick();
				break;
			}
			case "IRKENBOOZE":
			{
				resetLabels(IRKENBOOZE_MENU);
				radioButtons[7].doClick();
				break;
			}
			case "TEA":
			{
				resetLabels(TEA_MENU);
				radioButtons[8].doClick();
				break;
			}
			}
		}

		//-------------------------------------------------------------------
		//Description: Gets the current text field data return a string
		//-------------------------------------------------------------------
		public String getCurrentData()
		{
			String rString = "" + currentType;
			for(int i = 0; i < pTextFields.length; i++)
			{
				rString += "," + pTextFields[i].getText();
			}
			return rString;
		}
	}

	//-------------------------------------------------------------------
	//Description: Method to retrieve a panel Item and display it
	//-------------------------------------------------------------------
	private class RetrieveItemPanel extends JPanel
	{
		JLabel searchLabel = new JLabel("Enter An Item to Search For   ");

		public RetrieveItemPanel()
		{
			searchField.setEditable(true);
			add(Box.createRigidArea(new Dimension(110,5)));
			add(searchLabel);
			add(searchField);

			setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));	
			add(Box.createHorizontalGlue());	

		}

		//-------------------------------------------------------------------
		//Description: Method to Search for the text needed to be parsed
		//-------------------------------------------------------------------
		public void SearchForTerm() throws UnsupportedAudioFileException, IOException, LineUnavailableException
		{
			String text = retrieveItemData(searchField.getText());
			String[] delim = text.split(",");

			if(delim.length > 1)
			{
				loadSearchData(text);
			}
			else
			{
				image.setIcon( new ImageIcon("images/ponies/sadRare.png"));	
				imagePane.add(image);
				
				for(int i = 0; i < pTextFields.length; i++)
				{
					pTextFields[i].setText("");
				}
			}
		}

		public void RemoveSearch() throws UnsupportedAudioFileException, IOException, LineUnavailableException
		{
			String textDelete = retrieveItemData(searchField.getText());
			String[] delim = textDelete.split(",");	
			appLogic.RemoveMenuItem(delim[1]);	
		}
	}
}