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
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import foodStorage.ApplicationLogic;

public class PaidPanel extends TemplatePanel
{
	//------------------------------------------------------------------
	//Description: Variables instantiations
	//------------------------------------------------------------------
	private static JButton[] actionButtons = new JButton[4];
	
	//------------------------------------------------------------------
	//Description: Constructor for the AddPanel
	//------------------------------------------------------------------
	public PaidPanel(ApplicationLogic appLogic) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		this.appLogic = appLogic;
	}
	
	@Override
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

		actionButtons[0] = new JButton("VIEW YOUR ORDER");
		actionButtons[1] = new JButton("RETURN TO ORDER MENU");
		actionButtons[2] = new JButton("RETURN TO MENU BUILDER MAIN");
		

		for(int i = 0; i < 3; i++)
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
		add(newFilePane, BorderLayout.SOUTH);
		add(scrollPane, BorderLayout.SOUTH);

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
				
			}

			if(source == actionButtons[1])
			{			
				appLogic.OpenWindow("order");
			}

			if(source == actionButtons[2])
			{
				appLogic.OpenWindow("question");			
			}

		}
	}
}
