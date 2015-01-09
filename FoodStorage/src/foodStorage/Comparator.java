//******************************************************************************
// Heather Shadoan CSCI 426
// Created: 09/12/13
// FileName: Comparator.java
//******************************************************************************
// Purpose: Comparator abstract class for creating Comparators
//******************************************************************************

package foodStorage;

public abstract class Comparator 
{
	 abstract int CompareItem(MenuItem left, MenuItem right);
	 abstract public String getCompareType();

}
