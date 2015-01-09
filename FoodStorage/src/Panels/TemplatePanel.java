package Panels;
//------------------------------------TemplatePanel.java----------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 11/09/13
//Last Modified: 11/27/13
//--------------------------------------------------------------------------------------
//Purpose - Template class that will be used by all panel classes
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//buildPanel.java: template method that creates a very simple algorithm to generate panels
//--------------------------------------------------------------------------------------
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


import OrderClasses.OrderState;

import foodStorage.ApplicationLogic;

public abstract class TemplatePanel extends JPanel 
{
	//-------------------------------------------------------------------
	//Description: Creates the variables
	//-------------------------------------------------------------------
	protected int WIDTH, HEIGHT, FONT_SIZE;
	protected JLabel heading, searchLabel, image, fileLabel, fileLabel2, fileLabel3, imageHolder;;	
	protected JPanel scrollPanel,imagePane, labelPane, labelPane2, textPane, checkPanel, buttonPane, filePane, newFilePane, searchPane,
					 basicOrderButtonPane, newOrderButtonPane, inProcessButtonPane, tendedButtonPane, paidButtonPane;	
	protected Border compound, compound2, raisedBevel, lowerBevel, border1, border2;	
	public JTextArea textArea, textArea1, textArea2,  textArea3, textArea4;	
	protected JTextField textField0 ,textField, textField2;	
	protected JScrollPane scrollPane, scrollPane1, scrollPane2, scrollPane3, scrollPane4;
    protected JComboBox compareList, compareList1;
    
	public OrderState orderState;

	String[] menuStrings = null;

	ApplicationLogic appLogic;

	//-------------------------------------------------------------------
	//Description: Template method, made final so it cannot be overridden
	//-------------------------------------------------------------------
	public final void buildPanel()
	{
		setBasicPanel();
		specialFeatures();
	}

	//-------------------------------------------------------------------
	//Description: Method to create basic panel elements used by all panels
	//-------------------------------------------------------------------
	public void setBasicPanel()
	{	
		WIDTH = 885;
		HEIGHT = 975;
		FONT_SIZE = 45;

		//-------------------------------------------------------------------
		//Description: Creates the border elements used by all panels
		//-------------------------------------------------------------------
		raisedBevel = BorderFactory.createRaisedBevelBorder();
		lowerBevel =BorderFactory.createLoweredBevelBorder();
		border1 = BorderFactory.createLineBorder(Color.WHITE, 0);	
		border2 = BorderFactory.createLineBorder(Color.getHSBColor(0.53f,0.2f,0.99f), 5);
		compound = BorderFactory.createCompoundBorder(border1, border2);
		compound2 = BorderFactory.createCompoundBorder(raisedBevel, lowerBevel);

		//-------------------------------------------------------------------
		//Description: Creates all the Panes used by all panels
		//-------------------------------------------------------------------
		scrollPanel = new JPanel(new GridLayout(1,0));
		imagePane = new JPanel(new GridLayout(1,0));
		labelPane = new JPanel(new GridLayout(1,0));
		labelPane2 = new JPanel(new GridLayout(1,0));
		textPane = new JPanel(new GridLayout(1,0));
		checkPanel = new JPanel(new GridLayout(0,1));
		buttonPane = new JPanel(new GridLayout(0,1));
		basicOrderButtonPane = new JPanel(new GridLayout(0,1));
		newOrderButtonPane = new JPanel(new GridLayout(0,1));
		tendedButtonPane = new JPanel(new GridLayout(0,1));
		paidButtonPane = new JPanel(new GridLayout(0,1));
		filePane = new JPanel(new GridLayout(1,1));
		newFilePane = new JPanel(new GridLayout(1,1));

		//-------------------------------------------------------------------
		//Description: Creates the heading and sets it position
		//-------------------------------------------------------------------
		ImageIcon sprite = new ImageIcon("images/ponies/header4.png");	
		heading = new JLabel("",sprite, JLabel.CENTER);
		heading.setFont (new Font ("Helvetica", Font.BOLD, FONT_SIZE));
		heading.setVerticalTextPosition(JLabel.TOP);
		heading.setHorizontalTextPosition(JLabel.CENTER);
		heading.setBorder(BorderFactory.createCompoundBorder(raisedBevel, compound));

		setBackground (Color.getHSBColor(0.55f,0.3f,0.99f));
		setPreferredSize (new Dimension (WIDTH, HEIGHT));
		setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
	}

	//-------------------------------------------------------------------
	//Description: Hook method used by all panels 
	//-------------------------------------------------------------------
	abstract void specialFeatures();

}
