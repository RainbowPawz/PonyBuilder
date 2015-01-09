//------------------------------------Driver.java---------------------------------------
//Heather Shadoan, CSCI 426 Theory and Practice Advanced Programming
//Creation Date: 09/27/13
//Last Modified: 10/03/13
//--------------------------------------------------------------------------------------
//Purpose - Initial driver for the Menu Builder Panels
//--------------------------------------------------------------------------------------
//Notes on specifications, special algorithms, and assumptions
//--------------------------------------------------------------------------------------
package Panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;

import foodStorage.ApplicationLogic;


public class Driver {

	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException 
	{
		JFrame myFrame = new JFrame();
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ApplicationLogic appLogic = new ApplicationLogic();
		
		myFrame.setJMenuBar(appLogic.createMenuBar());
		
		myFrame.getContentPane().add(appLogic);	
			
		myFrame.pack();
		
		myFrame.setVisible(true);
	}
}
