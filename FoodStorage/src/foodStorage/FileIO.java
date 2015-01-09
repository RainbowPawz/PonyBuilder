//******************************************************************************
//
//
//
//
//
//
//******************************************************************************

package foodStorage;

//******************************************************************************
//Heather Shadoan CSCI 426
//Created: 09/12/13
//FileName: FileIO.java
//******************************************************************************
//Purpose: The FileIO class to read in a file
//******************************************************************************

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class FileIO 
{
	String file = new String();

	//******************************************************************************
	//Description: Setter and getter for the file name
	//******************************************************************************
	
	public void setFile(String userFile)
	{		
		file = userFile;	
	}	

	public String getFile()
	{
		return file;
	}
	
	public String[] readFile()
	{
		File fileToRead = new File(getFile());
		LinkedList<String> list = new LinkedList<String>();
		Iterator<String> it;
		int counter = 0;

		try
		{	//******************************************************************
			// Open the file that is the first 
			// command line parameter
			//******************************************************************

			FileInputStream fileStream = new FileInputStream(fileToRead);

			//******************************************************************
			// Get the object of DataInputStream 
			//******************************************************************

			DataInputStream dataIn = new DataInputStream(fileStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(dataIn));
			String stringLine;

			//******************************************************************
			//Read File Line By Line
			//Add each line to a list
			//******************************************************************

			while ((stringLine = br.readLine()) != null)   
			{
				list.add(stringLine);
			}

			//******************************************************************
			//Close the input stream
			//******************************************************************

			dataIn.close();

			//******************************************************************
			//Create an Array the size of the list and an iterator
			//******************************************************************

			String[] aList = new String[list.size()];
			it = list.iterator();

			//******************************************************************
			//Iterate through the list and increment the counter
			//******************************************************************

			while(it.hasNext()){
				aList[counter] = list.removeFirst();
				counter++;
			}

			return aList;
		}

		//******************************************************************
		//Catch exception if any
		//******************************************************************

		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
		return null;	
	}
}

