package com.capgemini.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public final class Logging
{
	/*
	 * Class used for logging purposes
	 * Stores log files based on current date/time
	 * */
	static
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd-MM-yyyy-hh-mm-ss");
		System.setProperty ("current.date.time", dateFormat.format (new Date ()));
	}

	public static final Logger LOG = Logger.getLogger (Logging.class);
}