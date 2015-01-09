//------------------------------------QuestionPanel.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/12/13
//Last Modified: 11/27/13
//--------------------------------------------------------------------------------------
//Purpose - Creates the initial DQuestionPAnel that holds the main menus for the GUI
//			this will also include the ablitly to print the main menu and display here.
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//--------------------------------------------------------------------------------------
package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import foodStorage.ApplicationLogic;


public class QuestionPanel extends TemplatePanel {

	//------------------------------------------------------------------
	//Description: Variables instantiations
	//------------------------------------------------------------------

	private static JButton[] actionButtons = new JButton[11];

	//-------------------------------------------------------------------
	//Description:Description: Constructor For the QuestionPanel
	//-------------------------------------------------------------------
	public QuestionPanel(ApplicationLogic appLogic)  throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.appLogic = appLogic;
	}

	void specialFeatures() 
	{
		ButtonActionListener bListener = new ButtonActionListener();
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
		scrollPane.setPreferredSize(new Dimension(860,300));

		
		actionButtons[0] = new JButton("SAVE CURRENT MENU!");
		actionButtons[1] = new JButton("MAKE AN ORDER");
		actionButtons[2] = new JButton("SEARCH FOR ITEMS");
		actionButtons[3] = new JButton("ADD MENU ITEMS");
		actionButtons[4] = new JButton("DELETE MENU ITEMS");
		actionButtons[5] = new JButton("EDIT MENU ITEMS");
		actionButtons[6] = new JButton("PRINT MENU");

		//buttonPane.add(Box.createRigidArea(new Dimension(0, 5)));

		for(int i = 1; i < 7; i++)
		{	
			actionButtons[i].addActionListener(bListener);
			add(actionButtons[i]);
			buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
			actionButtons[i].setFont (new Font ("Helvetica", Font.BOLD, 12));
			//buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			buttonPane.setBackground (Color.getHSBColor(0.53f,0.2f,0.99f));
			buttonPane.add(Box.createRigidArea(new Dimension(7, 5)));
			buttonPane.add(Box.createHorizontalGlue());
			buttonPane.add(actionButtons[i]);
		}
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
		fileLabel = new JLabel("Enter a File Name");
		fileLabel.setBackground(Color.getHSBColor(0.53f,0.2f,0.99f));		
		fileLabel.setLabelFor(textField);

		//-----------------------------------------------------------------------
		//Description: creates the combo box for the comparator
		//-----------------------------------------------------------------------

		String[] compareStrings = { "COST", "PRICE", "PROFIT", "NAME" };

		//Create the combo box, select the item at index 4.
		//Indices start at 0, so 4 specifies the pig.
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
		fileLabel3 = new JLabel("                      Create your very own Menu File!            ");
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

		//-------------------------------------------------------------------
		//Description: Sets up the QuestionPAnel
		//-------------------------------------------------------------------
		add(heading, BorderLayout.NORTH);
		add(imagePane, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.NORTH);
		add(filePane, BorderLayout.SOUTH);
		add(scrollPane, BorderLayout.CENTER);
		add(labelPane2, BorderLayout.SOUTH);
		add(newFilePane, BorderLayout.SOUTH);

	}

	public void setVisible(boolean v)
	{
		super.setVisible(v);
		image.setIcon( new ImageIcon("images/ponies/question2.png"));	
		imagePane.add(image);	
	}
	
	private class ComboActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			JComboBox cb = (JComboBox)e.getSource();

			String compareType = (String)cb.getSelectedItem();

		}
	}

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
	//------------------------------------------------------------------
	//Description: Updates the panel based on
	//which button is selected.
	//------------------------------------------------------------------
	private class ButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent mEvent) 
		{
			Object source = mEvent.getSource();			
			
			if(source == actionButtons[0])
			{
				String data = appLogic.getRawMenu();
				String type = (String) compareList.getSelectedItem();
				String fileName = textField.getText();

				appLogic.WriteToFile(data, fileName, type);

				if(data.length() != 0 & fileName.length() != 0)
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
			
			if(source == actionButtons[1])
			{
				
				appLogic.OpenWindow("order");
			}

			if(source == actionButtons[2])
			{
				appLogic.OpenWindow("search");				
			}

			if(source == actionButtons[3])
			{
				appLogic.OpenWindow("add");
			}

			if(source == actionButtons[4])
			{
				appLogic.OpenWindow("delete");
			}

			if(source == actionButtons[5])
			{
				appLogic.OpenWindow("edit");
			}

			if(source == actionButtons[6])
			{			
				textArea.setText(appLogic.PrintMenu());
			}

		}
	}
}


