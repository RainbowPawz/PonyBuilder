//------------------------------------SearchPanel.java-----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/12/13
//Last Modified: 10/03/13
//--------------------------------------------------------------------------------------
//Purpose - Creates the initial SearchPanel that will request for the user input
//          and then send the request to Application logic to Find the Users item if
//			it exits in the main menu list.
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import foodStorage.ApplicationLogic;


public class SearchPanel extends TemplatePanel
{
	private static JButton[] actionButtons = new JButton[3];

	//-------------------------------------------------------------------
	//Description: Constructor For the SearchPanel
	//-------------------------------------------------------------------
	public SearchPanel(ApplicationLogic appLogic) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.appLogic = appLogic;
	}
	void specialFeatures() 
	{
		searchLabel = new JLabel("Search for an item by Name  ");

		TextListener tListener = new TextListener();
		ButtonActionListener bListener = new ButtonActionListener();

		//------------------------------------------------------------------
		//Description: Creates the textField and instantiates it
		//------------------------------------------------------------------
		textField = new JTextField(26);
		textField.addActionListener(tListener);
		textField.setEditable(true);

		textArea = new JTextArea(20, 73);
		textArea.setEditable(false);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(862,350));

		//------------------------------------------------------------------
		//Description: Adds the initial image to the imagePane
		//------------------------------------------------------------------
		ImageIcon startIcon = new ImageIcon("images/ponies/searchDash.png");
		image = new JLabel(startIcon);//Sets the image JLabel
		imagePane.setLayout(new BoxLayout(imagePane, BoxLayout.LINE_AXIS));	
		imagePane.setBackground (Color.getHSBColor(0.55f,0.3f,0.99f));
		imagePane.add(Box.createHorizontalGlue());
		imagePane.add(image);	

		//-------------------------------------------------------------------
		//Description: Sets the background
		//-------------------------------------------------------------------
		searchLabel.setBackground(Color.getHSBColor(0.53f,0.2f,0.99f));		

		//-------------------------------------------------------------------
		//Description: Sets up and instantiates all the buttons
		//-------------------------------------------------------------------
		actionButtons[0] = new JButton("ENTER");
		actionButtons[1] = new JButton("BACK TO MENU");
		actionButtons[2] = new JButton("EXIT");

		labelPane.add(Box.createRigidArea(new Dimension(55, 5)));
		labelPane.add(searchLabel);	
		labelPane.add(textField);
	
		for(int i = 0; i < 3; i++)
		{	
			actionButtons[i].addActionListener(bListener);
			add(actionButtons[i]);
			labelPane.setLayout(new BoxLayout(labelPane, BoxLayout.LINE_AXIS));
			labelPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			labelPane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
			labelPane.add(Box.createRigidArea(new Dimension(10 , 5)));
			labelPane.add(Box.createHorizontalGlue());
			labelPane.add(actionButtons[i]);
		}
		
		//-------------------------------------------------------------------
		//Description: Add to the buttonPane the border
		//-------------------------------------------------------------------
		labelPane.add(Box.createRigidArea(new Dimension(60, 5)));
		labelPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		//------------------------------------------------------------------
		//Description: Sets up the SearchPanel and adds all the panes
		//------------------------------------------------------------------
		add(heading, BorderLayout.NORTH);
		add(imagePane, BorderLayout.CENTER);
		add(labelPane, BorderLayout.SOUTH);
		add(scrollPane, BorderLayout.SOUTH);

	}
	
	public void setVisible(boolean v)
	{
		super.setVisible(v);
		this.textArea.setText("");
		this.textField.setText("");
		image.setIcon( new ImageIcon("images/ponies/searchDash.png"));	
		imagePane.add(image);	
	}

	//-------------------------------------------------------------------
	//Description: The main listener for the text option, by pressing 
	//             the enter key it will call the data in the text fields
	//             and call the appropriate application logic.
	//-------------------------------------------------------------------
	public class TextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent mEvent) 
		{	

			String searchTerm = textField.getText();

			if(appLogic.FindMenuItemCheck(searchTerm) == true)
			{		
				String result = "";

				result = appLogic.FindMenuItemString(searchTerm);
				textArea.append(result);

				image.setIcon( new ImageIcon("images/ponies/dashFound.png"));	
				imagePane.add(image);
			}
			else if(appLogic.FindMenuItemCheck(searchTerm) == false)
			{		
				String result = "Item not found";

				textArea.append(result);

				image.setIcon( new ImageIcon("images/ponies/sadDash.png"));	
				imagePane.add(image);
			}

		}
	}

	//-------------------------------------------------------------------
	//Description: The main listener for the buttons, once pressed each
	//             will call the data in the text fields and call the 
	//             appropriate application logic.
	//-------------------------------------------------------------------
	private class ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent mEvent) 
		{
			Object source = mEvent.getSource();	

			//Source will be from the "ENTER" button
			if(source == actionButtons[0])
			{			
				String searchTerm = textField.getText();

				if(appLogic.FindMenuItemCheck(searchTerm) == true)
				{		
					String result = "";

					result = appLogic.FindMenuItemString(searchTerm);
					textArea.append(result);

					image.setIcon( new ImageIcon("images/ponies/dashFound.png"));	
					imagePane.add(image);
				}

				else if(appLogic.FindMenuItemCheck(searchTerm) == false)
				{		
					String result = "Item not found";

					textArea.append(result);

					image.setIcon( new ImageIcon("images/ponies/sadDash.png"));	
					imagePane.add(image);
				}
			}

			//Source will be from the "BACK TO MENU" button
			if(source == actionButtons[1])
			{			
				appLogic.OpenWindow("question");	
			}

			//Source will be from the "EXIT" button
			if(source == actionButtons[2])
			{			
				appLogic.Exit();
			}
		}
	}
}
