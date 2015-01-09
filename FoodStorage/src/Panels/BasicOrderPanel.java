//------------------------------------BasicOrderPanel.java--------------------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 11/29/13
//Last Modified: 12/02/13
//--------------------------------------------------------------------------------------
//Purpose - Panel the uses the state pattern to modify it's appearance and progress an order
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//All Panels will send their requests to and form this class
//--------------------------------------------------------------------------------------
package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import OrderClasses.NewOrderState;
import OrderClasses.Order;
import OrderClasses.OrderItem;


import foodStorage.ApplicationLogic;

public class BasicOrderPanel extends TemplatePanel
{
	//------------------------------------------------------------------
	//Description: Variables instantiations
	//------------------------------------------------------------------
	private static JButton[] actionButtons = new JButton[11];
	int orderNum = 0;
	DecimalFormat df = new DecimalFormat("$" + "0.00");
	//------------------------------------------------------------------
	//Description: Constructor for the AddPanel
	//------------------------------------------------------------------
	public BasicOrderPanel(ApplicationLogic appLogic) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.appLogic = appLogic;
	}

	@Override
	void specialFeatures() 
	{
		orderState = new NewOrderState();
		ButtonActionListener bListener = new ButtonActionListener(this);
		ComboActionListener cListener = new ComboActionListener();

		ImageIcon startIcon = new ImageIcon("images/ponies/orderMainApple.png");
		image = new JLabel(startIcon);//Sets the image JLabel
		imagePane.setLayout(new BoxLayout(imagePane, BoxLayout.LINE_AXIS));	
		imagePane.setBackground (Color.getHSBColor(0.55f,0.3f,0.99f));
		imagePane.add(Box.createHorizontalGlue());
		imagePane.add(image);

		//-------------------------------------------------------------------
		//Description: Adds the initial textArea and actionButtons
		//-------------------------------------------------------------------
		textArea = new JTextArea(17, 78);
		textArea.setEditable(false);

		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(860,300));

		//Order Panel Basic Buttons
		actionButtons[0] = new JButton("VIEW");
		actionButtons[1] = new JButton("NEW ORDER");
		actionButtons[2] = new JButton("RETURN TO MENU BUILDER MAIN");

		//New Order Panel Buttons/ In Process buttons
		actionButtons[3] = new JButton("ADD ITEM!");
		actionButtons[4] = new JButton("VIEW MENU");
		actionButtons[5] = new JButton("TENDER ORDER");

		//Tender Panel Buttons
		actionButtons[6] = new JButton("ADD MORE ITEMS");
		actionButtons[7] = new JButton("VIEW CURRENT ORDER!");
		actionButtons[8] = new JButton("PROCEED TO CHECKOUT");

		//Paid Panel Buttons
		actionButtons[9] = new JButton("PAY FOR ORDER");
		actionButtons[10] = new JButton("RETURN TO ORDER MENU");

		//Order Panel Basic 
		textField0 = new JTextField(5);
		textField0.setEditable(true);

		fileLabel2 = new JLabel("TO VIEW A PAST ORDER, TYPE IN THE ORDER # (EX: 0, 1, 2...)");	
		fileLabel2.setBackground(Color.getHSBColor(0.53f,0.2f,0.99f));
		fileLabel2.setLabelFor(textField0);

		basicOrderButtonPane.add(Box.createRigidArea(new Dimension(8, 5)));
		basicOrderButtonPane.add(fileLabel2);
		basicOrderButtonPane.add(Box.createRigidArea(new Dimension(10, 5)));
		basicOrderButtonPane.add(textField0);
		basicOrderButtonPane.add(Box.createRigidArea(new Dimension(10, 5)));

		actionButtons[0].addActionListener(bListener);
		add(actionButtons[0]);
		basicOrderButtonPane.add(actionButtons[0]);

		for(int i = 1; i < 3; i++)
		{	
			actionButtons[i].addActionListener(bListener);
			add(actionButtons[i]);
			basicOrderButtonPane.setLayout(new BoxLayout(basicOrderButtonPane, BoxLayout.LINE_AXIS));
			basicOrderButtonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			basicOrderButtonPane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
			basicOrderButtonPane.add(Box.createRigidArea(new Dimension(15, 5)));
			basicOrderButtonPane.add(Box.createHorizontalGlue());
			basicOrderButtonPane.add(actionButtons[i]);
		}
		//-------------------------------------------------------------------
		//Description: Add to the buttonPane the border
		//-------------------------------------------------------------------
		basicOrderButtonPane.add(Box.createRigidArea(new Dimension(8, 5)));
		basicOrderButtonPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		//-------------------------------------------------------------------
		//Description: Instantiates all text/scoll panes used
		//-------------------------------------------------------------------
		textArea = new JTextArea(25, 78);
		textArea.setEditable(false);

		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(860,300));

		textArea1 = new JTextArea(17, 78);
		textArea1.setEditable(false);

		scrollPane1 = new JScrollPane(textArea1);
		scrollPane1.setPreferredSize(new Dimension(860,160));

		textArea2 = new JTextArea(17, 78);
		textArea2.setEditable(false);

		scrollPane2 = new JScrollPane(textArea2);
		scrollPane2.setPreferredSize(new Dimension(860,160));

		textArea3 = new JTextArea(25, 78);
		textArea3.setEditable(false);

		scrollPane3 = new JScrollPane(textArea3);
		scrollPane3.setPreferredSize(new Dimension(860,300));

		textArea4 = new JTextArea(25, 78);
		textArea4.setEditable(false);

		scrollPane4 = new JScrollPane(textArea4);
		scrollPane4.setPreferredSize(new Dimension(860,300));

		//-------------------------------------------------------------------
		//Description: Creates the label and text field for the file saver
		//-----------------------------------------------------------------n--
		textField = new JTextField(15);
		textField.addActionListener(bListener);
		textField.setEditable(true);
		fileLabel = new JLabel("Enter Item Name");
		fileLabel.setBackground(Color.getHSBColor(0.53f,0.2f,0.99f));		
		fileLabel.setLabelFor(textField);

		//-----------------------------------------------------------------------
		//Description: creates the combo box for the items selection
		//-----------------------------------------------------------------------

		String[] compareStrings = { "1", "2", "3", "4", "5", "6", "7", "8","9", "10", 
				"11", "12", "13", "14", "15","16", "17", "18", "19", "20", 
				"21", "22", "23","24", "25", "26", "27", "28", "29", "30",
				"31", "32", "33", "34", "35", "36", "37", "38","39", "40",
				"41", "42", "43", "44", "45", "46", "47", "48","49", "50",
				"11", "52", "53", "54", "55", "56", "57", "58","59", "60"};

		compareList = new JComboBox(compareStrings);
		compareList.setSelectedIndex(0);
		compareList.addActionListener(cListener);

		fileLabel2 = new JLabel("Number of Items");
		fileLabel2.setBackground(Color.getHSBColor(0.53f,0.2f,0.99f));
		fileLabel2.setLabelFor(compareList);

		//-------------------------------------------------------------------
		//Description: Sets a new label
		//------------------------------------------------------------------
		fileLabel3 = new JLabel("                      Add the item to your order!            ");
		labelPane2.add(Box.createRigidArea(new Dimension(276, 5))); 
		labelPane2.setBackground (Color.getHSBColor(0.55f,0.3f,0.99f));
		labelPane2.add(fileLabel3);
		labelPane2.add(Box.createRigidArea(new Dimension(201, 5)));
		labelPane2.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		newFilePane.add(Box.createRigidArea(new Dimension(10, 5)));

		newFilePane.add(fileLabel);
		newFilePane.add(Box.createRigidArea(new Dimension(5, 5)));
		newFilePane.add(textField);
		newFilePane.add(Box.createRigidArea(new Dimension(20, 5)));
		newFilePane.add(fileLabel2);
		newFilePane.add(Box.createRigidArea(new Dimension(5, 5)));
		newFilePane.add(compareList);

		actionButtons[3].addActionListener(bListener);
		add(actionButtons[3]);
		newFilePane.setLayout(new BoxLayout(newFilePane, BoxLayout.X_AXIS));
		newFilePane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		newFilePane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
		newFilePane.add(Box.createRigidArea(new Dimension(30, 5)));
		newFilePane.add(Box.createHorizontalGlue());		
		newFilePane.add(actionButtons[3]);

		//-------------------------------------------------------------------
		//Description: Adds the "View Order" button to the newFilePanel
		//------------------------------------------------------------------
		actionButtons[4].addActionListener(bListener);
		add(actionButtons[4]);
		newFilePane.setLayout(new BoxLayout(newFilePane, BoxLayout.X_AXIS));
		newFilePane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		newFilePane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
		newFilePane.add(Box.createRigidArea(new Dimension(30, 5)));
		newFilePane.add(Box.createHorizontalGlue());		
		newFilePane.add(actionButtons[4]);

		//-------------------------------------------------------------------
		//Description: Adds the "Tender order" button to the newFilePanel
		//------------------------------------------------------------------
		actionButtons[5].addActionListener(bListener);
		add(actionButtons[5]);
		newFilePane.setLayout(new BoxLayout(newFilePane, BoxLayout.X_AXIS));
		newFilePane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		newFilePane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
		newFilePane.add(Box.createRigidArea(new Dimension(30, 5)));
		newFilePane.add(Box.createHorizontalGlue());		
		newFilePane.add(actionButtons[5]);

		newFilePane.add(Box.createRigidArea(new Dimension(5, 5)));
		newFilePane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));


		//-------------------------------------------------------------------
		//Description: Sets up the buttons for the Tended state
		//-------------------------------------------------------------------
		tendedButtonPane.add(Box.createRigidArea(new Dimension(93, 5)));
		tendedButtonPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		for(int i = 6; i < 9; i++)
		{	
			actionButtons[i].addActionListener(bListener);
			add(actionButtons[i]);
			tendedButtonPane.setLayout(new BoxLayout(tendedButtonPane, BoxLayout.LINE_AXIS));
			tendedButtonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			tendedButtonPane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
			tendedButtonPane.add(Box.createRigidArea(new Dimension(45, 5)));
			tendedButtonPane.add(Box.createHorizontalGlue());
			tendedButtonPane.add(actionButtons[i]);
		}

		tendedButtonPane.add(Box.createRigidArea(new Dimension(143, 5)));
		tendedButtonPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		//-------------------------------------------------------------------
		//Description: Adds the buttons to the paidButtonPane 
		//-------------------------------------------------------------------
		paidButtonPane.add(Box.createRigidArea(new Dimension(185, 5)));
		paidButtonPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		for(int i = 9; i < 11; i++)
		{	
			actionButtons[i].addActionListener(bListener);
			add(actionButtons[i]);
			paidButtonPane.setLayout(new BoxLayout(paidButtonPane, BoxLayout.LINE_AXIS));
			paidButtonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			paidButtonPane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
			paidButtonPane.add(Box.createRigidArea(new Dimension(50, 5)));
			paidButtonPane.add(Box.createHorizontalGlue());
			paidButtonPane.add(actionButtons[i]);
		}

		paidButtonPane.add(Box.createRigidArea(new Dimension(235, 5)));
		paidButtonPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));


		//-------------------------------------------------------------------
		//Description: Sets up the QuestionPAnel
		//-------------------------------------------------------------------

		add(heading, BorderLayout.NORTH);
		add(imagePane, BorderLayout.CENTER);
		add(basicOrderButtonPane, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.SOUTH);

	}

	//-------------------------------------------------------------------
	//Description: Resets visibility and text areas
	//-------------------------------------------------------------------
	public void setVisible(boolean v)
	{
		super.setVisible(v);
		this.textArea1.setText("");
		this.textArea2.setText("");
		this.textArea3.setText("");
		this.textArea4.setText("");
	}

	//-------------------------------------------------------------------
	//Description: Check to assert that the user enters a value
	//-------------------------------------------------------------------
	public boolean textCheck()
	{
		boolean success = false;

		if(textField0.getText() != "")
		{
			success = true;
		}
		
		image.setIcon( new ImageIcon("images/ponies/orderNAApple.png"));	
		imagePane.add(image);

		return success;
	}
	//------------------------------------------------------------------
	//Description: Updates the panel based on
	//which button is selected.
	//------------------------------------------------------------------
	private class ButtonActionListener implements ActionListener
	{
		BasicOrderPanel mainPanel;

		private ButtonActionListener(BasicOrderPanel mainPanel)
		{
			this.mainPanel = mainPanel;
		}


		public void actionPerformed(ActionEvent mEvent) 
		{
			Object source = mEvent.getSource();			

			//-------------------------------------------------------------------
			//Description: View a past order
			//-------------------------------------------------------------------
			if(source == actionButtons[0])
			{		

				if(textCheck() != false)
				{
					String stringA = textField0.getText();
					int userChoice = Integer.parseInt(stringA);

					if(appLogic.emptyCheck() == true)
					{
						image.setIcon( new ImageIcon("images/ponies/noOrdersApple.png"));	
						imagePane.add(image);
					}

					else if(appLogic.orderCheck(userChoice) == true)
					{
						textArea.setText(appLogic.printUserOrders(userChoice));
						image.setIcon( new ImageIcon("images/ponies/foundApple1.png"));	
						imagePane.add(image);
					}

				}


			}

			//-------------------------------------------------------------------
			//Description: Make a new order
			//-------------------------------------------------------------------
			else if(source == actionButtons[1])
			{	
				makeNewOrder();
				appLogic.makeNewOrder();
				orderState = new NewOrderState();

				loadStateInfo();
			}

			//-------------------------------------------------------------------
			//Description: Return to the main menu
			//-------------------------------------------------------------------
			else if(source == actionButtons[2])
			{
				appLogic.OpenWindow("question");			
			}

			//-------------------------------------------------------------------
			//Description: Add an order item to the order
			//-------------------------------------------------------------------
			else if(source == actionButtons[3])
			{
				String name = textField.getText();
				String stringA = (String) compareList.getSelectedItem();
				int amount = Integer.parseInt(stringA);

				if(name.length() != 0 & amount != 0)
				{
					try 
					{
						String temp = mainPanel.addOrderItem();

						System.out.println(temp);
						textArea2.append(temp + "\n");
						appLogic.getPreOrder();
						imagePane.add(image);
					} 
					catch (UnsupportedAudioFileException | IOException
							| LineUnavailableException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					image.setIcon( new ImageIcon("images/ponies/itemNAApple.png"));	
					imagePane.add(image);
				}
			}

			//-------------------------------------------------------------------
			//Description: Add an item to the item array
			//-------------------------------------------------------------------
			else if(source == actionButtons[4])
			{
				textArea1.setText(appLogic.PrintMenu());
			}

			//------------------------------------------------------------------------------------------
			//Description: Progress to the tended state if and only if there are items added to the list
			//------------------------------------------------------------------------------------------
			else if(source == actionButtons[5])
			{
				String orderData = textArea2.getText();

				if(orderData.length() != 0)
				{
					tended();
					orderState = orderState.progressOrder();
					loadStateInfo();
				}
				else
				{
					image.setIcon( new ImageIcon("images/ponies/ItemAddFailApple.png"));	
					imagePane.add(image);
				}

			}

			//-------------------------------------------------------------------
			//Description: Revises to the In process Order
			//-------------------------------------------------------------------
			else if(source == actionButtons[6])
			{
				inProcess();
				orderState = orderState.reviseOrder();
				loadStateInfo();
			}

			//-------------------------------------------------------------------
			//Description: Prints the initial order
			//-------------------------------------------------------------------
			else if(source == actionButtons[7])
			{
				textArea3.setText("Order Number: "+ orderNum + "\n"
						+ "--------------------------------------------------------------------------------------------------------" + "\n" 
						+  appLogic.printPOrders());
			}

			//-------------------------------------------------------------------
			//Description: Progress to the Order state
			//-------------------------------------------------------------------
			else if(source == actionButtons[8])
			{
				paid();
				orderState = orderState.progressOrder();
				loadStateInfo();

			}

			//--------------------------------------------------------------------------
			//Description: Adds the order to the order list and completes the paid state
			//--------------------------------------------------------------------------
			else if(source == actionButtons[9])
			{
				image.setIcon( new ImageIcon("images/ponies/paidApple.png"));	
				imagePane.add(image);
				addOrderToList();
				orderNum++;

			}
			
			//-------------------------------------------------------------------
			//Description: Returns to the Main order Section
			//-------------------------------------------------------------------
			else if(source == actionButtons[10])
			{
				orderMain();			
				textArea1.setText("");
				textArea2.setText("");
				textArea3.setText("");
				textArea4.setText("");
				image.setIcon(new ImageIcon("images/ponies/orderMainApple.png"));

			}

		}
	}

	//-------------------------------------------------------------------
	//The following methods use the State methods
	//-------------------------------------------------------------------
	public void orderMain()
	{
		basicOrderButtonPane.setVisible(true);
		newOrderButtonPane.setVisible(false);
		tendedButtonPane.setVisible(false);
		paidButtonPane.setVisible(false);

		scrollPane.setVisible(true);
		scrollPane2.setVisible(false);
		scrollPane3.setVisible(false);
		scrollPane4.setVisible(false);

		labelPane2.setVisible(false);
		newFilePane.setVisible(false);

		add(basicOrderButtonPane, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.SOUTH);

		orderState = new NewOrderState();
	}

	//-------------------------------------------------------------------
	//Description: Generates the new order state of the panel
	//-------------------------------------------------------------------
	public void makeNewOrder()
	{
		basicOrderButtonPane.setVisible(false);
		newOrderButtonPane.setVisible(true);
		tendedButtonPane.setVisible(false);
		paidButtonPane.setVisible(false);

		scrollPane.setVisible(false);
		scrollPane1.setVisible(true);
		scrollPane2.setVisible(true);
		scrollPane3.setVisible(false);
		scrollPane4.setVisible(false);

		labelPane2.setVisible(true);
		newFilePane.setVisible(true);

		add(newFilePane, BorderLayout.SOUTH);
		add(scrollPane1, BorderLayout.SOUTH);	
		add(labelPane2, BorderLayout.SOUTH);
		add(scrollPane2, BorderLayout.SOUTH);
	}

	//-------------------------------------------------------------------
	//Description: Generates the in process state of the panel
	//-------------------------------------------------------------------
	public void inProcess()
	{
		basicOrderButtonPane.setVisible(false);
		tendedButtonPane.setVisible(false);
		newOrderButtonPane.setVisible(true);
		paidButtonPane.setVisible(false);

		scrollPane.setVisible(false);
		scrollPane1.setVisible(true);
		scrollPane2.setVisible(true);
		scrollPane3.setVisible(false);
		scrollPane4.setVisible(false);

		labelPane2.setVisible(true);
		newFilePane.setVisible(true);

		add(newFilePane, BorderLayout.SOUTH);
		add(scrollPane1, BorderLayout.SOUTH);	
		add(labelPane2, BorderLayout.SOUTH);
		add(scrollPane2, BorderLayout.SOUTH);
	}

	//-------------------------------------------------------------------
	//Description: Generates the tended state of the panel
	//-------------------------------------------------------------------
	public void tended()
	{
		basicOrderButtonPane.setVisible(false);
		newOrderButtonPane.setVisible(false);
		tendedButtonPane.setVisible(true);
		paidButtonPane.setVisible(false);

		scrollPane.setVisible(false);
		scrollPane1.setVisible(false);
		scrollPane2.setVisible(false);
		scrollPane3.setVisible(true);
		scrollPane4.setVisible(false);

		labelPane2.setVisible(false);
		newFilePane.setVisible(false);

		add(tendedButtonPane, BorderLayout.NORTH);
		add(scrollPane3, BorderLayout.CENTER);
	}

	//-------------------------------------------------------------------
	//Description: Generates the paid state of the panel
	//-------------------------------------------------------------------
	public void paid()
	{
		basicOrderButtonPane.setVisible(false);
		newOrderButtonPane.setVisible(false);
		tendedButtonPane.setVisible(false);
		paidButtonPane.setVisible(true);

		scrollPane.setVisible(false);
		scrollPane1.setVisible(false);
		scrollPane2.setVisible(false);
		scrollPane3.setVisible(false);
		scrollPane4.setVisible(true);

		textArea4.setText(("Order Number: "+ orderNum + "\n" 
				+ "--------------------------------------------------------------------------------------------------------" + "\n" 
				+  appLogic.printPOrders()));

		labelPane2.setVisible(false);
		newFilePane.setVisible(false);

		add(paidButtonPane, BorderLayout.CENTER);
		add(scrollPane4, BorderLayout.SOUTH);
	}

	//-------------------------------------------------------------------
	//Description: Loads the state image
	//-------------------------------------------------------------------
	public void loadStateInfo()
	{
		image.setIcon(new ImageIcon(orderState.imagePath));
	}

	//-------------------------------------------------------------------
	//Description: Retrieves the needed Item data
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
	//Description: Retrieves the needed Item data
	//-------------------------------------------------------------------
	public String retrieveItemData(String searchTerm) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		if (appLogic.FindMenuItemCheck(searchTerm) == true)
		{
			image.setIcon( new ImageIcon("images/ponies/addSucApple.png"));
			imagePane.add(image);
		}
		else
		{
			image.setIcon( new ImageIcon("images/ponies/itemNAApple.png"));	
			imagePane.add(image);
		}
		return appLogic.FindMenuItem(searchTerm, true);
	}

	//-------------------------------------------------------------------
	//Description: Adds the order item to the order item array
	//-------------------------------------------------------------------
	public String addOrderItem() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		String text = retrieveItemData(textField.getText());	
		String stringA = (String) compareList.getSelectedItem();
		int amount = Integer.parseInt(stringA);

		String[] delim = text.split(",");
		String name = delim[1];
		float price = Float.parseFloat(delim[3]);

		OrderItem item = null;

		double itemSub = 0;

		itemSub += amount * price;

		item = appLogic.createOrderItem(name, price, amount);

		appLogic.AddOrderItem(item);



		return "\nOrder Item" + "\n" 
		+ "--------------------------------------------------------------------------------------------------------" + "\n" 
		+ "Name: " + name 
		+ "    Price: " + df.format(price) 
		+ "    Amount: " + amount 
		+ "    SubTotal: " + df.format(itemSub) + "\n";
	}

	//-------------------------------------------------------------------
	//Description: Gets the order information and creates an order object
	//-------------------------------------------------------------------
	public Order getOrder() 
	{	
		String orderlist = "";

		Order orderobj = null;

		orderlist = "Order Status: " + orderState.getStateName()+ "\n\n" + textArea4.getText();

		orderobj = appLogic.createOrder(orderlist);

		return orderobj;

	}

	//-------------------------------------------------------------------
	//Description: Adds the order information to the order array
	//-------------------------------------------------------------------
	public void addOrderToList()
	{
		getOrder();
		appLogic.AddOrder(getOrder());

	}

	//-------------------------------------------------------------------
	//Description: Gets the initial order information
	//-------------------------------------------------------------------
	public String orderInfo()
	{
		String orderlist = "";

		orderlist = "Order Number: "+ orderNum + "\n" 
				+ "--------------------------------------------------------------------------------------------------------" + "\n" 
				+ textArea2.getText();

		return orderlist;	
	}
}

