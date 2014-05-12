package org.thread.timerImplementation;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException 
	{
		String path = "/home/valuelabs/Desktop/alert.properties";
		File file = new File(path);

		TimerImplementation main = new TimerImplementation();
		List<BirthdayRemainder> list = main.readFile(file);

		Collections.sort(list,new Sort());

		main.remainder();	
	}
}
