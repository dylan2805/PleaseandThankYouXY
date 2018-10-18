package com.capgemini.other;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;

public class HashMapExercise
{
	public static void main (String [] args)
    {
		HashMap <Integer, String> map = new HashMap <> ();
		
		for (int i = 0; i < 3; ++ i)
		{
		    int id = Keyboard.readInt ("Enter employee id : ");
		    String name = Keyboard.readString ("Enter employee name : ");
		    
		    map.put (id, name);
		}
		
		for (Map.Entry <Integer, String> entry : map.entrySet ())
		
			Logging.LOG.info ("Employee " + entry.getKey () + " name is " + entry.getValue ());
    }
}