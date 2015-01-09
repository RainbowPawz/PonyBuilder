//------------------------------------AddPanel.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/12/13
//Last Modified: 11/12/13
//--------------------------------------------------------------------------------------
//Purpose - Creates the initial AddPanel, will request user input to generate user items.
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
import foodStorage.FoodStorage;

public class AddPanel extends TemplatePanel
{
	//------------------------------------------------------------------
	//Description: Variables instantiations
	//------------------------------------------------------------------
	private JRadioButton[] radioButtons = new JRadioButton[5];// appetizer, meal, dessert, soda, milkshake
	private static JButton[] actionButtons = new JButton[5];
	JTextField pTextFields[];

	//------------------------------------------------------------------
	//Description: Menu variables instantiations
	//------------------------------------------------------------------
	String APPETIZER_MENU = "Appetizer,Name,Cost,Price,Cold Dish (Type True or False)                 ,Prep Time in Minutes,Country of Origin";

	private TextListener tListener = new TextListener();

	MenuItemEntryPanel menuPanel = new MenuItemEntryPanel(APPETIZER_MENU);

	//------------------------------------------------------------------
	//Description: Constructor for the AddPanel
	//------------------------------------------------------------------
	public AddPanel(ApplicationLogic appLogic) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.appLogic = appLogic;
	}
	
	@Override
	void specialFeatures() 
	{	
		searchLabel = new JLabel("Add a Menu Item! ");
		tListener = new TextListener();
		ButtonActionListener bListener = new ButtonActionListener(this);
		CheckListener cListener = new CheckListener();

		//-------------------------------------------------------------------
		//Description: Creates the Checkboxes and instantiates each
		//-------------------------------------------------------------------
		radioButtons[0] = new JRadioButton("Appetizer");
		radioButtons[0].setSelected(true);
		radioButtons[1] = new JRadioButton("Meal");
		radioButtons[2] = new JRadioButton("Dessert");
		radioButtons[3] = new JRadioButton("Soda");
		radioButtons[4] = new JRadioButton("Milkshake");

		checkPanel.add(Box.createRigidArea(new Dimension(50 , 5)));
		for(int i = 0; i < 5; i++)
		{
			radioButtons[i].addActionListener (cListener);
			radioButtons[i].setBackground(Color.getHSBColor(0.55f,0.3f,0.99f));
			checkPanel.setBackground(Color.getHSBColor(0.55f,0.3f,0.99f));
			checkPanel.add(Box.createRigidArea(new Dimension(70 , 5)));
			checkPanel.add(Box.createHorizontalGlue());
			checkPanel.add(radioButtons[i]);
			checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.LINE_AXIS));
		}

		checkPanel.add(Box.createRigidArea(new Dimension(115 , 5)));
		checkPanel.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));
		//-------------------------------------------------------------------
		//Description: Creates a new textArea
		//-------------------------------------------------------------------
		textArea = new JTextArea(15, 53);
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);

		//-------------------------------------------------------------------
		//Description: Creates the imagePane and sets it position
		//-------------------------------------------------------------------
		ImageIcon startIcon = new ImageIcon("images/ponies/pinkAdd.png");
		image = new JLabel(startIcon);//Sets the image JLabel
		imagePane.setLayout(new BoxLayout(imagePane, BoxLayout.LINE_AXIS));	
		imagePane.setBackground (Color.getHSBColor(0.55f,0.3f,0.99f));
		imagePane.add(Box.createHorizontalGlue());
		imagePane.add(image);	

		searchLabel.setBackground(Color.getHSBColor(0.53f,0.2f,0.99f));		

		//-------------------------------------------------------------------
		//Description: Sets the labels for the buttons
		//-------------------------------------------------------------------
		actionButtons[0] = new JButton("ADD A MENU ITEM");
		actionButtons[1] = new JButton("GO TO ADD A DRINK ITEM");
		actionButtons[2] = new JButton("BACK TO MENU");
		actionButtons[3] = new JButton("SAVE FILE!");

		//-------------------------------------------------------------------
		//Description: Creates the label and text field for the file saver
		//-------------------------------------------------------------------
		textField = new JTextField(15);
		textField.addActionListener(bListener);
		textField.setEditable(true);
		fileLabel = new JLabel("Enter a File Name");
		fileLabel.setBackground(Color.getHSBColor(0.53f,0.2f,0.99f));		
		fileLabel.setLabelFor(textField);

		//-----------------------------------------------------------------------
		//Description: creates the combo box for the comparator
		//-----------------------------------------------------------------------

		String[] compareStrings = { "COST", "PRICE", "PROFIT", "NAME" };

		//Create the combo box, select the item at index 4.
		compareList = new JComboBox(compareStrings);
		compareList.setSelectedIndex(3);
		compareList.addActionListener(cListener);
		getType(compareStrings[compareList.getSelectedIndex()]);

		fileLabel2 = new JLabel("Choose a Compare Type");
		fileLabel2.setBackground(Color.getHSBColor(0.53f,0.2f,0.99f));
		fileLabel2.setLabelFor(compareList);
		//-------------------------------------------------------------------
		//Description: Sets a new label
		//------------------------------------------------------------------
		fileLabel3 = new JLabel("                 Create your very own Menu File!");
		labelPane2.add(Box.createRigidArea(new Dimension(285, 5)));
		labelPane2.setBackground (Color.getHSBColor(0.55f,0.3f,0.99f));
		labelPane2.add(fileLabel3);
		labelPane2.add(Box.createRigidArea(new Dimension(210, 5)));
		labelPane2.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));
		
		//-------------------------------------------------------------------
		//Description: Sets all the file panel data
		//------------------------------------------------------------------
		filePane.add(Box.createRigidArea(new Dimension(95, 5)));

		filePane.add(fileLabel);
		filePane.add(Box.createRigidArea(new Dimension(5, 5)));
		filePane.add(textField);
		filePane.add(Box.createRigidArea(new Dimension(22, 5)));
		filePane.add(fileLabel2);
		filePane.add(Box.createRigidArea(new Dimension(5, 5)));
		filePane.add(compareList);

		actionButtons[3].addActionListener(bListener);
		add(actionButtons[3]);
		filePane.setLayout(new BoxLayout(filePane, BoxLayout.X_AXIS));
		filePane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		filePane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
		filePane.add(Box.createRigidArea(new Dimension(35, 5)));
		filePane.add(Box.createHorizontalGlue());		
		filePane.add(actionButtons[3]);

		filePane.add(Box.createRigidArea(new Dimension(125, 5)));
		filePane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		//-------------------------------------------------------------------
		//Description: Sets all the action button data
		//-------------------------------------------------------------------
		buttonPane.add(Box.createRigidArea(new Dimension(130, 5)));
		buttonPane.add(searchLabel);
		for(int i = 0; i < 3; i++)
		{	
			actionButtons[i].addActionListener(bListener);
			add(actionButtons[i]);
			buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
			buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			buttonPane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
			buttonPane.add(Box.createRigidArea(new Dimension(20 , 5)));
			buttonPane.add(Box.createHorizontalGlue());
			buttonPane.add(actionButtons[i]);
		}

		//-------------------------------------------------------------------
		//Description: Add to the buttonPane the border
		//-------------------------------------------------------------------
		buttonPane.add(Box.createRigidArea(new Dimension(130, 5)));
		buttonPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		//-------------------------------------------------------------------
		//Description: Sets up the EditPanel and adds all the panes
		//-------------------------------------------------------------------
		add(heading, BorderLayout.NORTH);
		add(imagePane, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.CENTER);
		add(checkPanel, BorderLayout.CENTER);
		add(menuPanel, BorderLayout.WEST);
		add(scrollPane, BorderLayout.EAST);
		add(labelPane2, BorderLayout.SOUTH);
		add(filePane, BorderLayout.SOUTH);
		
	}
	
	//-------------------------------------------------------------------
	//Description: Clears all fields
	//-------------------------------------------------------------------
	public void setVisible(boolean v)
	{
		super.setVisible(v);
		this.textArea.setText("");
		//this.searchField.setText("");
		for(int i = 0; i < pTextFields.length; i++)
		{
			this.pTextFields[i].setText("");
		}
		image.setIcon( new ImageIcon("images/ponies/pinkAdd.png"));	
		imagePane.add(image);	
	}
	
	//-------------------------------------------------------------------
	//Description: Adds all the data to create a new menu Item
	//-------------------------------------------------------------------
	public String addEntryData()
	{
		String temp = menuPanel.getCurrentData();

		if(temp == null)
		{
			temp = null;
		}
		else
		{
			appLogic.AddMenuItem(temp);	
		}

		return temp;

	}

	//-------------------------------------------------------------------
	//Description: ComboListener
	//-------------------------------------------------------------------
	private class ComboActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			JComboBox cb = (JComboBox)e.getSource();
			
			String compareType = (String)cb.getSelectedItem();

		}
	}

	//-------------------------------------------------------------------
	//Description: Gets the type for the combo listener
	//-------------------------------------------------------------------
	protected String getType(String type) 
	{
		String comp = "";

		switch (type)
		{
		case "COST":
		{
			comp = "COST";
			break;
		}
		case "PRICE":
		{
			comp = "COST";
			break;
		}
		case "PROFIT":
		{
			comp = "COST";
			break;
		}
		case "NAME":
		{
			comp = "COST";
			break;
		}

		}
		return comp;
	}
	//-------------------------------------------------------------------
	//Description: TextListener that responds when the user hits the enter
	//             key
	//-------------------------------------------------------------------
	public class TextListener implements ActionListener
	{
		AddPanel mainPanel;

		public void actionPerformed(ActionEvent mEvent) 
		{	
			String temp = mainPanel.addEntryData();
			if(temp != null)
			{
				image.setIcon( new ImageIcon("images/ponies/pinkyAdd2.png"));	
				imagePane.add(image);
				textArea.append(temp + "\n");
			}	

			if(temp == null)
			{
				image.setIcon( new ImageIcon("images/ponies/pinkyFail.png"));	
				imagePane.add(image);
				textArea.append("Please Fill All Fields!\n");
			}
		}
	}

	//-------------------------------------------------------------------
	//Description: Button listeners that calls the needed appLogic
	//-------------------------------------------------------------------
	private class ButtonActionListener implements ActionListener
	{
		AddPanel mainPanel;

		private ButtonActionListener(AddPanel mainPanel)
		{
			this.mainPanel = mainPanel;
		}

		public void actionPerformed(ActionEvent mEvent) 
		{
			Object source = mEvent.getSource();	


			if(source == actionButtons[0])
			{			
				String temp = mainPanel.addEntryData();
				
				if(temp != null)
				{
					image.setIcon( new ImageIcon("images/ponies/pinkyAdd2.png"));	
					imagePane.add(image);
					textArea.append(temp + "\n");
				}	

				if(temp == null)
				{
					image.setIcon( new ImageIcon("images/ponies/pinkyFail.png"));	
					imagePane.add(image);
					textArea.append("Please Fill All Fields!\n");
				}	
			}
			
			if(source == actionButtons[1])
			{			
				appLogic.OpenWindow("addDrink");	
			}

			if(source == actionButtons[2])
			{			
				appLogic.OpenWindow("question");	
			}

			if(source == actionButtons[3])
			{
				String data = textArea.getText();
				String type = (String) compareList.getSelectedItem();
				String fileName = textField.getText();

				//appLogic.WriteToFile(data, fileName, type);
				
				if(data.length() != 0 & type.length() != 0 &fileName.length() != 0)
				{
					image.setIcon( new ImageIcon("images/ponies/fileCreated.png"));	
					imagePane.add(image);
				}
				else
				{
					image.setIcon( new ImageIcon("images/ponies/zecoraFail.png"));	
					imagePane.add(image);
				}
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
			}

			if(source == radioButtons[1])
			{			
				menuPanel.resetLabels(MEAL_MENU);		
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(true);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(false);
			}

			if(source == radioButtons[2])
			{			
				menuPanel.resetLabels(DESSERT_MENU);
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(true);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(false);
			}
			if(source == radioButtons[3])
			{		
				menuPanel.resetLabels(SODA_MENU);
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(true);
				radioButtons[4].setSelected(false);

			}

			if(source == radioButtons[4])
			{	
				menuPanel.resetLabels(MILKSHAKE_MENU);
				radioButtons[0].setSelected(false);
				radioButtons[1].setSelected(false);
				radioButtons[2].setSelected(false);
				radioButtons[3].setSelected(false);
				radioButtons[4].setSelected(true);

			}
		}
	}

	//-------------------------------------------------------------------
	//Description: Creates the new MenuPanels and resets their text labels
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
				pTextFields[i] = new JTextField(10);

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
		//Description: Resets the labels
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
		//Description: Gets the current String data
		//-------------------------------------------------------------------
		public String getCurrentData()
		{
			String rString = "" + currentType;;

			for(int i = 0; i < pTextFields.length; i++)
			{	
				if(pTextFields[i].getText().length() != 0)
				{	
					rString += "," + pTextFields[i].getText();	
				}
				else
				{
					rString = null;
				}

			}
			return rString;
		}
	}
}