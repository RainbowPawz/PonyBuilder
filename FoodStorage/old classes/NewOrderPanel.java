package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import OrderClasses.OrderItem;
import foodStorage.ApplicationLogic;

public class NewOrderPanel extends TemplatePanel
{
	//------------------------------------------------------------------
	//Description: Variables instantiations
	//------------------------------------------------------------------
	private static JButton[] actionButtons = new JButton[4];

	//------------------------------------------------------------------
	//Description: Constructor for the AddPanel
	//------------------------------------------------------------------
	public NewOrderPanel(ApplicationLogic appLogic) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.appLogic = appLogic;
	}

	@Override
	void specialFeatures() 
	{
		ButtonActionListener bListener = new ButtonActionListener(this);
		ComboActionListener cListener = new ComboActionListener();

		ImageIcon startIcon = new ImageIcon("images/ponies/question2.png");
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
		scrollPane.setPreferredSize(new Dimension(860,160));

		textArea2 = new JTextArea(17, 78);
		textArea2.setEditable(false);

		scrollPane2 = new JScrollPane(textArea2);
		scrollPane2.setPreferredSize(new Dimension(860,160));

		actionButtons[0] = new JButton("ADD ITEM!");
		actionButtons[1] = new JButton("VIEW MENU");
		actionButtons[2] = new JButton("TENDER ORDER");

		//-------------------------------------------------------------------
		//Description: Add to the buttonPane the border
		//-------------------------------------------------------------------
		buttonPane.add(Box.createRigidArea(new Dimension(10, 5)));
		buttonPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

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
		//Description: creates the combo box for the comparator
		//-----------------------------------------------------------------------

		String[] compareStrings = { "1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12", "13", "14", "15"  };

		//Create the combo box, select the item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		compareList = new JComboBox(compareStrings);
		compareList.setSelectedIndex(3);
		compareList.addActionListener(cListener);
		getType(compareStrings[compareList.getSelectedIndex()]);

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

		//-------------------------------------------------------------------
		//Description: Sets all the file panel data
		//------------------------------------------------------------------
		newFilePane.add(Box.createRigidArea(new Dimension(70, 5)));

		newFilePane.add(fileLabel);
		newFilePane.add(Box.createRigidArea(new Dimension(5, 5)));
		newFilePane.add(textField);
		newFilePane.add(Box.createRigidArea(new Dimension(22, 5)));
		newFilePane.add(fileLabel2);
		newFilePane.add(Box.createRigidArea(new Dimension(5, 5)));
		newFilePane.add(compareList);

		actionButtons[0].addActionListener(bListener);
		add(actionButtons[0]);
		newFilePane.setLayout(new BoxLayout(newFilePane, BoxLayout.X_AXIS));
		newFilePane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		newFilePane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
		newFilePane.add(Box.createRigidArea(new Dimension(35, 5)));
		newFilePane.add(Box.createHorizontalGlue());		
		newFilePane.add(actionButtons[0]);

		newFilePane.add(Box.createRigidArea(new Dimension(70, 5)));
		newFilePane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));


		for(int i = 1; i < 3; i++)
		{	
			actionButtons[i].addActionListener(bListener);
			add(actionButtons[i]);
			buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
			buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			buttonPane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
			buttonPane.add(Box.createRigidArea(new Dimension(26, 5)));
			buttonPane.add(Box.createHorizontalGlue());
			buttonPane.add(actionButtons[i]);
		}
		//-------------------------------------------------------------------
		//Description: Add to the buttonPane the border
		//-------------------------------------------------------------------
		buttonPane.add(Box.createRigidArea(new Dimension(40, 5)));
		buttonPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));


		//-------------------------------------------------------------------
		//Description: Sets up the QuestionPAnel
		//-------------------------------------------------------------------

		add(heading, BorderLayout.NORTH);
		add(imagePane, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.SOUTH);
		add(newFilePane, BorderLayout.SOUTH);
		add(scrollPane2, BorderLayout.SOUTH);


	}
	//-------------------------------------------------------------------
	//Description: The main listener for the text option, by pressing 
	//             the enter key it will call the data in the text fields
	//             and call the appropriate application logic.
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
		
		item = appLogic.createOrderItem(name, price, amount);

		appLogic.AddOrderItem(item);
		
		return name + "  " + price + "  " + amount;
	}


	//------------------------------------------------------------------
	//Description: Updates the panel based on
	//which button is selected.
	//------------------------------------------------------------------
	private class ButtonActionListener implements ActionListener
	{	
		NewOrderPanel mainPanel;

		private ButtonActionListener(NewOrderPanel mainPanel)
		{
			this.mainPanel = mainPanel;
		}

		public void actionPerformed(ActionEvent mEvent) 
		{
			Object source = mEvent.getSource();			

			if(source == actionButtons[0])
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
						appLogic.getOrder();
						image.setIcon( new ImageIcon("images/ponies/fileCreated.png"));	
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
					image.setIcon( new ImageIcon("images/ponies/zecoraFail.png"));	
					imagePane.add(image);
				}

			}

			if(source == actionButtons[1])
			{			
				textArea.setText(appLogic.PrintMenu());
			}

			if(source == actionButtons[2])
			{

				appLogic.OpenWindow("tended");			
			}

		}
	}

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
		return appLogic.FindMenuItem(searchTerm, true);
	}

	protected String getType(String type) 
	{
		String comp = "";

		return comp;
	}
}
