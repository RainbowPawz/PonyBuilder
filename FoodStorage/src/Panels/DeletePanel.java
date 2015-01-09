//------------------------------------DeletePanel.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/12/13
//Last Modified: 10/03/13
//--------------------------------------------------------------------------------------
//Purpose - Creates the initial DeletePanel and then requests user input to search for the
//          item by name. If found it will remove the item.
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


public class DeletePanel extends TemplatePanel
{
	private static JButton[] actionButtons = new JButton[3];

	//-------------------------------------------------------------------
	//Description:Description: Constructor For the DeletePanel
	//-------------------------------------------------------------------
	public DeletePanel(ApplicationLogic appLogic) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.appLogic = appLogic;
	}
	void specialFeatures() 
	{
		//-------------------------------------------------------------------
		//Description:Creates variables and sets up the borders
		//-------------------------------------------------------------------

		searchLabel = new JLabel("Delete an item by Name  ");
		TextListener tListener = new TextListener();
		ButtonActionListener bListener = new ButtonActionListener();
		
		//-------------------------------------------------------------------
		//Description: Sets up the textField and textArea 
		//-------------------------------------------------------------------
		textField = new JTextField(33);
		textField.addActionListener(tListener);
		textField.setEditable(true);
		
		textArea = new JTextArea(22, 78);
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);

		//-------------------------------------------------------------------
		//Description: Adds the initial image to the imagePane
		//-------------------------------------------------------------------
		ImageIcon startIcon = new ImageIcon("images/ponies/flutterDel.png");
		image = new JLabel(startIcon);//Sets the image JLabel
		imagePane.setLayout(new BoxLayout(imagePane, BoxLayout.LINE_AXIS));	
		imagePane.setBackground (Color.getHSBColor(0.55f,0.3f,0.99f));
		imagePane.add(Box.createHorizontalGlue());
		imagePane.add(image);
		
		//-------------------------------------------------------------------
		//Description: Sets the Background
		//-------------------------------------------------------------------
		searchLabel.setBackground(Color.getHSBColor(0.53f,0.2f,0.99f));		

		//-------------------------------------------------------------------
		//Description: Sets up the DeletePanel and adds all the panes
		//-------------------------------------------------------------------
		actionButtons[0] = new JButton("ENTER");
		actionButtons[1] = new JButton("BACK TO MENU");
		
		labelPane.add(Box.createRigidArea(new Dimension(49, 5)));
		labelPane.add(searchLabel);	
		labelPane.add(textField);
		
		for(int i = 0; i < 2; i++)
		{	
			actionButtons[i].addActionListener(bListener);
			add(actionButtons[i]);
			labelPane.setLayout(new BoxLayout(labelPane, BoxLayout.LINE_AXIS));
			labelPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			labelPane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
			labelPane.add(Box.createRigidArea(new Dimension(25 , 5)));
			labelPane.add(Box.createHorizontalGlue());
			labelPane.add(actionButtons[i]);
		}
		
		//-------------------------------------------------------------------
		//Description: Add to the buttonPane the border
		//-------------------------------------------------------------------
		labelPane.add(Box.createRigidArea(new Dimension(49, 5)));
		labelPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		//-------------------------------------------------------------------
		//Description: Sets up the DeletePanel and adds all the panes
		//-------------------------------------------------------------------
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
		image.setIcon( new ImageIcon("images/ponies/flutterDel.png"));	
		imagePane.add(image);	
	}
	
	//-------------------------------------------------------------------
	//Description: TextListener for the main textFields
	//-------------------------------------------------------------------
	public class TextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent mEvent) 
		{	
			String searchTerm = textField.getText();

			if(appLogic.RemoveMenuItemCheck(searchTerm) == true)
			{		
				String result = "";

				result = appLogic.RemoveMenuItem(searchTerm);
				textArea.append(result);

				image.setIcon( new ImageIcon("images/ponies/successDel.png"));	
				imagePane.add(image);
			}
			else if(appLogic.RemoveMenuItemCheck(searchTerm) == false)
			{		
				String result = "Item not found";
				
				textArea.append(result);
				
				image.setIcon( new ImageIcon("images/ponies/sadFlutter.png"));	
				imagePane.add(image);

			}
		}
	}

	//-------------------------------------------------------------------
	//Description: Button listener that calls the appropriate appLogic
	//-------------------------------------------------------------------
	private class ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent mEvent) 
		{
			Object source = mEvent.getSource();	

			if(source == actionButtons[0])
			{	
				String searchTerm = textField.getText();

				if(appLogic.RemoveMenuItemCheck(searchTerm) == true)
				{		
					String result = "";

					result = appLogic.RemoveMenuItem(searchTerm);
					textArea.append(result);

					image.setIcon( new ImageIcon("images/ponies/successDel.png"));	
					imagePane.add(image);
				}
				else if(appLogic.RemoveMenuItemCheck(searchTerm) == false)
				{		
					String result = "Item not found";

					textArea.append(result);

					image.setIcon( new ImageIcon("images/ponies/sadFlutter.png"));	
					imagePane.add(image);
				}
			}
			
			if(source == actionButtons[1])
			{			
				appLogic.OpenWindow("question");	
			}
		}
	}
}