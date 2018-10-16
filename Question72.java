package com.capgemini.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;

public class Question72
{
	public static void main (String [] args)
    {
		String input = Keyboard.readString ("Enter product names (separated by <space>) : ");	// Get product names
		String strArr [] = input.split (" ");
		
		ArrayList <String> strList = new ArrayList <String> (Arrays.asList (strArr));
		Collections.sort (strList);
		
		for (String str : strList) Logging.LOG.info (str);
    }
}
