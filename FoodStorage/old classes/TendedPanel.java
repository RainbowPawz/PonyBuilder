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

import OrderClasses.OrderContext;
import Panels.TemplatePanel;

import foodStorage.ApplicationLogic;

public class TendedPanel extends TemplatePanel {

	//------------------------------------------------------------------
	//Description: Variables instantiations
	//------------------------------------------------------------------

	private static JButton[] actionButtons = new JButton[11];

	//-------------------------------------------------------------------
	//Description:Description: Constructor For the QuestionPanel
	//-------------------------------------------------------------------
	public TendedPanel(ApplicationLogic appLogic)  throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.appLogic = appLogic;
	}

	void specialFeatures() 
	{
		ButtonActionListener bListener = new ButtonActionListener();

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


		actionButtons[0] = new JButton("ADD MORE ITEMS");
		actionButtons[1] = new JButton("VIEW CURRENT ORDER!");
		actionButtons[2] = new JButton("PAY FOR ORDER");


		//buttonPane.add(Box.createRigidArea(new Dimension(0, 5)));

		for(int i = 0; i < 3; i++)
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
				appLogic.OpenWindow("newOrder");
			}

			if(source == actionButtons[1])
			{
				//textArea.setText();
			}

			if(source == actionButtons[2])
			{
				appLogic.OpenWindow("paid");				
			}
		}
	}
}
