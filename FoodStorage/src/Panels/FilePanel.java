//------------------------------------FilePanel.java--------------------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/12/13
//Last Modified: 
//--------------------------------------------------------------------------------------
//Purpose - Creates the initial File Panel that will request for the user input
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//The file that must be entered will be in the format of "costlist.txt" 
//Capitalization will not matter.
//--------------------------------------------------------------------------------------
package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import foodStorage.ApplicationLogic;



public class FilePanel extends TemplatePanel {

	private static JButton[] actionButtons = new JButton[2];

	//-------------------------------------------------------------------
	//Description: Constructor For the FilePanel
	//-------------------------------------------------------------------
	public FilePanel(ApplicationLogic appLogic) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.appLogic = appLogic;	
	}
	
	void specialFeatures() 
	{
		fileLabel = new JLabel("Please choose a Menu File from the list     ");
		ButtonActionListener bListener = new ButtonActionListener();
		TextListener tListener = new TextListener();

		//------------------------------------------------------------------
		//Description: Adds the initial image with to the imagePane
		//------------------------------------------------------------------
		ImageIcon startIcon = new ImageIcon("images/ponies/file.png");
		image = new JLabel(startIcon);//Sets the image JLabel
		imagePane.setLayout(new BoxLayout(imagePane, BoxLayout.LINE_AXIS));	
		imagePane.setBackground (Color.getHSBColor(0.55f,0.3f,0.99f));
		imagePane.add(Box.createHorizontalGlue());
		imagePane.add(image);	

		//------------------------------------------------------------------
		//Description: Set the textField size and editable status
		//------------------------------------------------------------------
		textField = new JTextField(36);
		textField.addActionListener(tListener);
		textField.setEditable(true);

		//------------------------------------------------------------------
		//Description: Set background and textField to the label fileLabel
		//------------------------------------------------------------------
		fileLabel.setBackground(Color.getHSBColor(0.53f,0.2f,0.99f));		
		fileLabel.setLabelFor(textField);

		//------------------------------------------------------------------
		//Description: Add the buttons and text fields to labelPane
		//------------------------------------------------------------------
		actionButtons[0] = new JButton("ENTER");
		actionButtons[1] = new JButton("EXIT");
	
		labelPane.add(Box.createRigidArea(new Dimension(15,5)));	
		labelPane.add(fileLabel);	
		labelPane.add(textField);

		for(int i = 0; i < 2; i++)
		{	
			actionButtons[i].addActionListener(bListener);
			add(actionButtons[i]);
			labelPane.setLayout(new BoxLayout(labelPane, BoxLayout.LINE_AXIS));
			labelPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			labelPane.setBackground (Color.getHSBColor (0.53f,0.2f,0.99f));
			labelPane.add(Box.createRigidArea(new Dimension(30, 5)));
			labelPane.add(Box.createHorizontalGlue());		
			labelPane.add(actionButtons[i]);
		}
		
		labelPane.add(Box.createRigidArea(new Dimension(15, 5)));
		labelPane.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		//------------------------------------------------------------------
		//Description: Sets up the FilePanel and adds all the panes
		//------------------------------------------------------------------
		add(heading, BorderLayout.NORTH);
		add(imagePane, BorderLayout.CENTER);
		add(labelPane, BorderLayout.SOUTH);
	}

	//------------------------------------------------------------------
	//Description: Listener that allows the user to simply press the 
	//             enter key to read in the file of choice
	//------------------------------------------------------------------
	public class TextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent mEvent) 
		{	
			LoadMenu();
		}
	}

	//------------------------------------------------------------------
	//Description: Listener for the main Enter button to read in the file
	//------------------------------------------------------------------
	private class ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent mEvent) 
		{
			Object source = mEvent.getSource();			

			if(source == actionButtons[0])
			{			
				LoadMenu();
			}
			if(source == actionButtons[1])
			{
				appLogic.Exit();
			}
		}
	}

	//------------------------------------------------------------------
	//Description: Loads the Menu of unsorted items
	//------------------------------------------------------------------
	private void LoadMenu()
	{
		String fileName = textField.getText();
		try 
		{
			appLogic.LoadMenu(fileName);
		} 
		catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
